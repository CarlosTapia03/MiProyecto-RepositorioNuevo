package aplication.persistence;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import aplication.model.Juez;

public interface JuezRepo extends JpaRepository<Juez, Integer> {
	
	public Optional<Juez> findByNombre(String nombre);

}
