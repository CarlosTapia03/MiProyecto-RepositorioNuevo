package es.aplication.persistence;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import es.aplication.entities.Usuario;

public interface UsuarioRepo extends JpaRepository<Usuario, Integer> {

	public Optional<Usuario> findByUsername(String username);
}
