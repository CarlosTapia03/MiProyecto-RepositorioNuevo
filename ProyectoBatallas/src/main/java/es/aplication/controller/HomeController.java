package es.aplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import es.aplication.entities.Batalla;
import es.aplication.persistence.BatallasRepo;

@Controller
public class HomeController {

	@GetMapping("/")
	String home() {

		return "index";
	}

	@GetMapping("/freestylers")
	String freestylers() {

		return "freestylers";
	}

	@Autowired
	private BatallasRepo batallasRepo;

	@GetMapping("")
	public ModelAndView verPaginaDeInicio() {
		List<Batalla> batallasMasVistas = batallasRepo.findAll();
		return new ModelAndView("index").addObject("batallasMasVistas", batallasMasVistas);
	}

	@GetMapping("/batallas-list")
	public ModelAndView listarBatallas() {
	    List<Batalla> batallas = batallasRepo.findAll();
	    return new ModelAndView("batallas").addObject("batallas", batallas);
	}


	@GetMapping("/detalles-pelicula/{id}")
	public ModelAndView mostrarDetallesDePelicula(@PathVariable Integer id) {
		Batalla batalla = batallasRepo.getOne(id);
		return new ModelAndView("batalla").addObject("batalla", batalla);
	}

}
