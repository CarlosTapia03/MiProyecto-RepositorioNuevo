package aplication.service.interfaces;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import aplication.model.Usuario;
import aplication.model.dto.UsuarioDto;

public interface UsuarioService extends UserDetailsService{

	
	public Usuario guardarUsuario(UsuarioDto registroDto);
	
	public List<Usuario> listarUsuarios();
}
