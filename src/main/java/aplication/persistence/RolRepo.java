package aplication.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import aplication.model.Rol;

public interface RolRepo extends JpaRepository<Rol, Integer> {

	public Rol findByNombre(String nombre);

}
