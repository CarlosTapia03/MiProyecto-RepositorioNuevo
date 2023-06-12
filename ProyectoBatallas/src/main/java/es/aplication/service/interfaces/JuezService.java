package es.aplication.service.interfaces;

import java.util.List;

import org.springframework.stereotype.Service;

import es.aplication.entities.Juez;

@Service
public interface JuezService {

	public Juez insertarJuez(Juez j);
	public void modificarJuez(Juez j);
	public void eliminarJuez(Juez j);
	public List<Juez> listarJuezs();
	public Juez buscarJuezPorIdJPA(Integer id);
	
}
