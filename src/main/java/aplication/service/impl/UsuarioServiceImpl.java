package aplication.service.impl;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import aplication.model.Rol;
import aplication.model.Usuario;
import aplication.model.dto.UsuarioDto;
import aplication.persistence.UsuarioRepo;
import aplication.service.interfaces.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService{

	@Autowired
	@Lazy
	private BCryptPasswordEncoder passwordEncoder;
	
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
				passwordEncoder.encode(registroDto.getPassword()),
				Arrays.asList(new Rol("ROLE_USER")));
		return usuarioRepo.save(usuario);
	}


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Usuario usuario = usuarioRepo.findByEmail(username);
		
		if (usuario == null) {
			throw new UsernameNotFoundException("Usuario o password invalidos");	
		}
		return new User(usuario.getEmail(),usuario.getPassword(), mapearAutoridadesRoles(usuario.getRoles()));
	}
	
	private Collection<? extends GrantedAuthority> mapearAutoridadesRoles(Collection<Rol> roles) {
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getNombre())).collect(Collectors.toList());
	}


	@Override
	public List<Usuario> listarUsuarios() {
		// TODO Auto-generated method stub
		return usuarioRepo.findAll();
	}

}
