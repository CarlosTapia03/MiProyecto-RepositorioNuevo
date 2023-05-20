package aplication.service.interfaces;

import org.springframework.security.core.userdetails.UserDetailsService;

import aplication.model.Usuario;
import aplication.model.dto.UsuarioDto;

public interface UsuarioService extends UserDetailsService{

	
	public Usuario guardarUsuario(UsuarioDto registroDto);
	
	
}
