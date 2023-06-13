package es.aplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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
	
	public ModelAndView verPaginaDeInicio(@PageableDefault(sort = "nombre", size = 5)Pageable pageable) {
		Page<Batalla> batallas = batallasRepo.findAll(pageable);
		
		return new ModelAndView("index").addObject("batallas",batallas);
	}
		
	@GetMapping("/batallas/nuevo")
	public ModelAndView mostrarFormularioDeNuevaBatalla() {
		List<Ronda> rondas = rondaRepo.findAll(Sort.by("titulo"));
		return new ModelAndView("admin/nueva-batalla")
						.addObject("batalla", new Batalla())
						.addObject("rondas",rondas);
	}
	
}
