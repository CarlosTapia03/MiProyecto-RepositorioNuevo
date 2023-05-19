package aplication.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aplication.model.Batalla;
import aplication.persistence.BatallasRepo;
import aplication.service.interfaces.BatallaService;

@Service
public class BatallaServiceImpl implements BatallaService {

	@Autowired
	private BatallasRepo batallaRepo;
	
	public Batalla insertarBatalla(Batalla b) {
		batallaRepo.save(b);
		return null;
	}

	public void modificarBatalla(Batalla b) {
		
		batallaRepo.save(b);
		
	}

	public void eliminarBatalla(Batalla b) {
		
		batallaRepo.delete(b);
		
	}

	public List<Batalla> listarBatallas() {
		
		return batallaRepo.findAll();
	}

	public Batalla buscarBatallaPorIdJPA(Integer id) {
		
		return batallaRepo.findById(id).orElse(null);
	}

	public void eliminaBatallaPorId(Integer id) {
		
		batallaRepo.deleteById(id);
		
	}
	
	

}
