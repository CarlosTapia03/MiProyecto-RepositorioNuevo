package aplication.controller;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import aplication.model.Freestyler;
import aplication.persistence.BatallaDAO;
import aplication.persistence.FreestylerDAO;

@RequestMapping("/freestylers")
public class FreestylerController {

	private BatallaDAO crudBatalla = new BatallaDAO();
	private FreestylerDAO crudFreestyler = new FreestylerDAO();
	
	@GetMapping(value = { "", "/" })
	String jueces(Model model) {

		model.addAttribute("freestylers", crudFreestyler.listarFreestylerJPA());
		model.addAttribute("batallas", crudBatalla.listarBatallaJPA());

		model.addAttribute("freestylerNuevo", new Freestyler());

		return "freestylers";
	}
	
	@PostMapping("/add")
	public String addFreestyler(@ModelAttribute("freestylerNuevo") Freestyler freestylerNuevo, BindingResult bindingResult) {

		crudFreestyler.insertarFreestylerJPA(freestylerNuevo);

		return "redirect:/freestylers";
	}
	
	@GetMapping({"/{id}"})
	public String obtenerFreestyler(Model model, @PathVariable Integer id) {
	 
		model.addAttribute("freestyler", crudFreestyler.buscarFreestylerPorIdJPA(id));
		
		return "freestyler";
	}
	
	@GetMapping({"/buscar/{nombre}"})
	public String obtenerFreestyler(@PathVariable String nombre) {
		return "freestyler";
	}
	
	@GetMapping({"/delete/{id}"})
	public String borrarFreestyler(@PathVariable Integer id) {
		
		crudFreestyler.eliminarFreestylerJPA(crudFreestyler.buscarFreestylerPorIdJPA(id));
		
		return "redirect:/freestylers";
		 
	}
	
}
