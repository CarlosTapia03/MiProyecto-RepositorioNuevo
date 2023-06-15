package es.aplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import es.aplication.entities.Batalla;
import es.aplication.entities.Ronda;
import es.aplication.persistence.BatallasRepo;
import es.aplication.persistence.RondaRepo;
import es.aplication.service.interfaces.AlmacenServicio;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private BatallasRepo batallasRepo;

	@Autowired
	private RondaRepo rondaRepo;

	@Autowired
	private AlmacenServicio servicio;
	
	

	@GetMapping("/")
	public ModelAndView verPaginaDeInicio(@PageableDefault(sort = "nombre", size = 5) Pageable pageable) {
	    Page<Batalla> batallas = batallasRepo.findAll(pageable);

	    return new ModelAndView("/admin/index").addObject("batallas", batallas);
	}


	@GetMapping("/batallas/nuevo")
	public ModelAndView mostrarFormularioDeNuevaBatalla() {
		List<Ronda> rondas = rondaRepo.findAll(Sort.by("titulo"));
		return new ModelAndView("admin/nueva-batalla").addObject("batalla", new Batalla()).addObject("rondas", rondas);
	}

	@PostMapping("/batallas/nuevo")
	public ModelAndView registrarBatalla(@Validated Batalla batalla, BindingResult bindingResult) {
		if (bindingResult.hasErrors() || batalla.getPortada() == null || batalla.getPortada().isEmpty()) {
		    if (batalla.getPortada() == null || batalla.getPortada().isEmpty()) {
		        bindingResult.rejectValue("portada", "MultipartNotEmpty");
		    }
			List<Ronda> rondas = rondaRepo.findAll(Sort.by("titulo"));
			return new ModelAndView("admin/nueva-batalla")
					.addObject("batalla", batalla)
					.addObject("rondas", rondas);
		}
		String rutaPortada = servicio.almacenarArchivo(batalla.getPortada());
		batalla.setRutaPortada(rutaPortada);

		batallasRepo.save(batalla);
		return new ModelAndView("redirect:/");
	}
	
	@GetMapping("/batallas/{id}/editar")
	public ModelAndView mostrarFormularioDeEditarBatalla(@PathVariable Integer id) {
		Batalla batalla = batallasRepo.getOne(id);
		List<Ronda> rondas = rondaRepo.findAll(Sort.by("titulo"));
		
		return new ModelAndView("admin/editar-batalla")
				.addObject("batalla", batalla)
				.addObject("rondas", rondas);
	}
	
	@PostMapping("/batallas/{id}/editar")
	public ModelAndView actualizarBatalla(@PathVariable Integer id,@Validated Batalla batalla, BindingResult bindingResult) {
		List<Ronda> rondas = rondaRepo.findAll(Sort.by("titulo"));
		
		if (bindingResult.hasErrors()) {
			return new ModelAndView("admin/editar-batalla")
					.addObject("batalla", batalla)
					.addObject("rondas", rondas);
		}
		
		Batalla batallaDB = batallasRepo.getOne(id);
		batallaDB.setNombre(batalla.getNombre());
		batallaDB.setDescripcion(batalla.getDescripcion());
		batallaDB.setFechaBatalla(batalla.getFechaBatalla());
		batallaDB.setYoutubeVideo(batalla.getYoutubeVideo());
		batallaDB.setRondas(batalla.getRondas());
		
		if (!batalla.getPortada().isEmpty()) {
			servicio.eliminarArchivo(batallaDB.getRutaPortada());
			String rutaPortada = servicio.almacenarArchivo(batalla.getPortada());
			batallaDB.setRutaPortada(rutaPortada);
		}
		batallasRepo.save(batallaDB);
		return new ModelAndView("redirect:/admin");
	}
	
	@PostMapping("/batallas/{id}/eliminar")
	public String eliminarBatalla(@PathVariable Integer id) {
		Batalla batalla = batallasRepo.getOne(id);
		batallasRepo.delete(batalla);
		servicio.eliminarArchivo(batalla.getRutaPortada());

		return "redirect:/admin";
	}
}
