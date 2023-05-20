package aplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import aplication.service.interfaces.UsuarioService;

@Controller
public class RegistroControlador {

	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping("/login")
	public String iniciarSesion() {
		return "login";
	}
	
	@GetMapping("/usuarios")
	public String verPaginaInicio(Model modelo) {
		modelo.addAttribute("usuarios", usuarioService.listarUsuarios());
		return "usuarios";
	}
	
	
}
