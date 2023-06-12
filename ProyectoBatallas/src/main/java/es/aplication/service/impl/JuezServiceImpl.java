package es.aplication.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.aplication.entities.Juez;
import es.aplication.persistence.JuezRepo;
import es.aplication.service.interfaces.JuezService;

@Service
public class JuezServiceImpl implements JuezService {

	@Autowired
	private JuezRepo juezRepo;
	
	public Juez insertarJuez(Juez j) {
		juezRepo.save(j);
		return null;
	}

	public void modificarJuez(Juez j) {
		
		juezRepo.save(j);
		
	}

	public void eliminarJuez(Juez j) {
		
		juezRepo.delete(j);
		
	}

	public List<Juez> listarJuezs() {
		
		return juezRepo.findAll();
	}

	public Juez buscarJuezPorIdJPA(Integer id) {
		
		return juezRepo.findById(id).orElse(null);
	}

}
