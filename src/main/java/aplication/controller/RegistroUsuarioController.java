package aplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import aplication.model.dto.UsuarioDto;
import aplication.service.interfaces.UsuarioService;

@Controller
@RequestMapping("registro")
public class RegistroUsuarioController {

	@Autowired
	UsuarioService usuarioService;

	public RegistroUsuarioController(UsuarioService usuarioService) {
		super();
		this.usuarioService = usuarioService;
	}
	
	@ModelAttribute("usuario")
	public UsuarioDto retornarNuevoUsuarioDto() {
		
		return new UsuarioDto();
	}
	
	@GetMapping
	public String mostrarFormularioDeRegistro() {
		return "registro";
	}
	
	@PostMapping
	public String registrarCuentaDeUsuario(@ModelAttribute("usuario") UsuarioDto usuaripDto) {
		usuarioService.guardarUsuario(usuaripDto);
		return "redirect:/registro?exito";
	}
}
