package es.aplication.persistence;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import es.aplication.entities.Juez;

public interface JuezRepo extends JpaRepository<Juez, Integer> {
	
	public Optional<Juez> findByNombre(String nombre);

}
