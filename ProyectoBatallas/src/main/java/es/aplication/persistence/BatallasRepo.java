package es.aplication.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import es.aplication.entities.Batalla;

public interface BatallasRepo extends JpaRepository<Batalla, Integer> {

	

}
