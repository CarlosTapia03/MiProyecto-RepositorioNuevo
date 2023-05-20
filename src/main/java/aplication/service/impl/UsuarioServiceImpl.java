package aplication.service.impl;

import java.util.Arrays;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import aplication.model.Rol;
import aplication.model.Usuario;
import aplication.model.dto.UsuarioDto;
import aplication.persistence.UsuarioRepo;
import aplication.service.interfaces.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService{

	private UsuarioRepo usuarioRepo;
	
	public UsuarioServiceImpl(UsuarioRepo usuarioRepo) {
		super();
		this.usuarioRepo = usuarioRepo;
	}


	public Usuario guardarUsuario(UsuarioDto registroDto) {
		// TODO Auto-generated method stub
		Usuario usuario = new Usuario(registroDto.getNombre(), 
				registroDto.getApellido(),
				registroDto.getEmail(),
				registroDto.getPassword(),
				Arrays.asList(new Rol("ROLE_USER")));
		return usuarioRepo.save(usuario);
	}


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

}
