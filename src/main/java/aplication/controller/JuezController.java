package aplication.controller;
 
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import aplication.model.Juez;
import aplication.persistence.JuezDAO;

@RequestMapping("/jueces")
@Controller
public class JuezController {
	
	 
	JuezDAO juezDAO = new JuezDAO();
	
	@GetMapping(value= {"","/"})
	String homeJueces(Model model) {
		
		// Salir a buscar a la BBDD
		
		ArrayList<Juez> misjueces = juezDAO.listarJuezsJPA();
		model.addAttribute("listaJueces", misjueces);
		model.addAttribute("juezaEditar", new Juez());
		model.addAttribute("juezNuevo", new Juez());
		
		
		//
		
		return "jueces";
	}
	
	@PostMapping("/edit/{id}")
	public String editarJuez(@PathVariable Integer id, @ModelAttribute("juezaEditar") Juez juezEditado, BindingResult bindingresult) {
		
		Juez juezaeditar= juezDAO.buscarPorIdJPA(id);
		
		juezaeditar.setNombre(juezEditado.getNombre());
		
		juezDAO.modificarJuezJPA(juezaeditar);
		
		return "redirect:/jueces";
	}
	
	@PostMapping("/add")
	public String addJuez(@ModelAttribute("juezNuevo") Juez juezNew, BindingResult bindingresult) {
		
		juezDAO.insertarJuezJPA(juezNew);
		
		return "redirect:/jueces";
	}
	
	@GetMapping({"/{id}"})
	String idJuez(Model model, @PathVariable Integer id) {
		
		Juez juezMostrar = juezDAO.buscarPorIdJPA(id);
		model.addAttribute("juezMostrar",juezMostrar);
		
		return "juez";
	}
	
	@GetMapping("/delete/{id}")
	String deleteJuez(Model model, @PathVariable Integer id) {
		
		Juez jeliminar = juezDAO.buscarPorIdJPA(id);
		juezDAO.eliminarJuezJPA(jeliminar);
		
		return "redirect:/jueces";
	}
	
	
	
}
