package es.aplication.service.interfaces;


import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import es.aplication.controller.dto.UsuarioRegistroDTO;
import es.aplication.entities.Usuario;


public interface UsuarioServicio extends UserDetailsService{

	public Usuario guardar(UsuarioRegistroDTO registroDTO);
	
	public List<Usuario> listarUsuarios();
	
}