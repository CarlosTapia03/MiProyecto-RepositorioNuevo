package aplication.service.interfaces;

import java.util.List;

import org.springframework.stereotype.Service;

import aplication.model.Juez;

@Service
public interface JuezService {

	public Juez insertarJuez(Juez j);
	public void modificarJuez(Juez j);
	public void eliminarJuez(Juez j);
	public List<Juez> listarJuezs();
	public Juez buscarJuezPorIdJPA(Integer id);
	
}
