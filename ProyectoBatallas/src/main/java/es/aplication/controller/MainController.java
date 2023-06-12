package es.aplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import es.aplication.entities.Batalla;
import es.aplication.entities.Juez;
import es.aplication.persistence.BatallasRepo;
import es.aplication.service.impl.BatallaServiceImpl;
import es.aplication.service.impl.JuezServiceImpl;

@Controller
public class MainController {
	
	@GetMapping("/")
	String home() {
		
		//crearTablas();
		return "index";
	}
	
	@Autowired
	private BatallasRepo batallaRepo;

	@GetMapping("/freestylers")
	String freestylers() {
		
		return "freestylers";
	}
	
	
	@Autowired
	private JuezServiceImpl juezService;
	
	@Autowired
	private BatallaServiceImpl batallaService;
	
public void crearTablas() {
		
		Juez j1 = new Juez("Kapo");
		Juez j2 = new Juez("Piezas");
		Juez j3 = new Juez("Aczino");
		
		Batalla b1 = new Batalla();
		Batalla b2 = new Batalla();
		
		j3.getbatallas().add(b2);
		j1.getbatallas().add(b1);
		b2.setJuez(j1);
		b1.setJuez(j3);
		
		juezService.insertarJuez(j1);
		juezService.insertarJuez(j2);
		juezService.insertarJuez(j3);
		
		batallaService.insertarBatalla(b1);
		batallaService.insertarBatalla(b2);
		
		
		batallaRepo.save(b1);
		
		}
}
