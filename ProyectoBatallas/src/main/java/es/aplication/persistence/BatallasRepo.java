package es.aplication.persistence;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import es.aplication.entities.Batalla;

public interface BatallasRepo extends JpaRepository<Batalla, Integer> {

	public Optional<Batalla> findByNombre(String nombre);

}
