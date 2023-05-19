package aplication.persistence;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import aplication.model.Freestyler;

public interface FreestylerRepo extends JpaRepository<Freestyler, Integer>{

	public Optional<Freestyler> findByNombre(String nombre);

}
