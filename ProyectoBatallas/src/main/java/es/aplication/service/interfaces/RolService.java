package es.aplication.service.interfaces;



import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import es.aplication.entities.Rol;

@Service
public interface RolService extends UserDetailsService {
	
	public Rol obtenerRolPorNombre (String nombre);

	
}
