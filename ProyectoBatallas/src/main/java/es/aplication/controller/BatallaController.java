package es.aplication.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import es.aplication.entities.Batalla;
import es.aplication.entities.Juez;
import es.aplication.service.impl.BatallaServiceImpl;
import es.aplication.service.impl.JuezServiceImpl;



@RequestMapping("/batallas")
@Controller
public class BatallaController {

	@Autowired
	private JuezServiceImpl juezService;
	
	@Autowired
	private BatallaServiceImpl batallaService;

	@GetMapping(value= {"","/"})
	String homebatallas(Model model) {
		
		// Salir a buscar a la BBDD
		
		ArrayList<Batalla> misbatallas = (ArrayList<Batalla>) batallaService.listarBatallas();
		ArrayList<Juez> misJueces = (ArrayList<Juez>) juezService.listarJuezs();
	
		model.addAttribute("listabatallas", misbatallas);
		model.addAttribute("listaJueces", misJueces);
		model.addAttribute("batallaaEditar", new Batalla());
		model.addAttribute("batallaNueva", new Batalla());
		
		
		//
		
		return "batallas";
	}
	
	@PostMapping("/edit/{id}")
	public String editarBatalla(@PathVariable Integer id, @ModelAttribute("batallaaEditar") Batalla batallaEditada, BindingResult bindingresult) {
	
		return "redirect:/batallas";
	}
	
	@PostMapping("/add")
	public String addBatalla(@ModelAttribute("batallaNueva") Batalla batallaNew, BindingResult bindingresult) {
		
		return "redirect:/batallas";
	}
	
	@GetMapping({"/{id}"})
	String idBatalla(Model model, @PathVariable Integer id) {
		
		Batalla batallaMostrar = batallaService.buscarBatallaPorIdJPA(id);
		model.addAttribute("batallaMostrar",batallaMostrar);
		
		ArrayList<Juez> misJueces = (ArrayList<Juez>) juezService.listarJuezs();
		model.addAttribute("listaJueces", misJueces);
		model.addAttribute("batallaaEditar", new Batalla());
		model.addAttribute("batallaNueva", new Batalla());
		
		return "batalla";
	}
	
	@GetMapping("/delete/{id}")
	String deleteBatalla(Model model, @PathVariable Integer id) {
		
		batallaService.eliminaBatallaPorId(id);
		
		return "redirect:/batallas";
	}
}
