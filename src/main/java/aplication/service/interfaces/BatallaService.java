package aplication.service.interfaces;

import java.util.List;

import org.springframework.stereotype.Service;

import aplication.model.Batalla;

@Service
public interface BatallaService {

	public Batalla insertarBatalla(Batalla b);
	public void modificarBatalla(Batalla b);
	public void eliminarBatalla(Batalla b);
	public List<Batalla> listarBatallas();
	public Batalla buscarBatallaPorIdJPA(Integer id);
	public void eliminaBatallaPorId(Integer id);
	
}
