package es.aplication.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import es.aplication.entities.Ronda;

public interface RondaRepo extends JpaRepository<Ronda, Long>{

}
