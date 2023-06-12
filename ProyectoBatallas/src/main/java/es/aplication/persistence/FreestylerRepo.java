package es.aplication.persistence;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import es.aplication.entities.Freestyler;

public interface FreestylerRepo extends JpaRepository<Freestyler, Integer>{

	public Optional<Freestyler> findByNombre(String nombre);

}
