package es.aplication.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import es.aplication.entities.Rol;

public interface RolRepo extends JpaRepository<Rol, Integer> {

	public Rol findByNombre(String nombre);

}
