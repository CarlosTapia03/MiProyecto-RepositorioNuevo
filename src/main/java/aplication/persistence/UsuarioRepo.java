package aplication.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import aplication.model.Usuario;

@Repository
public interface UsuarioRepo extends JpaRepository<Usuario, Long>{

}
