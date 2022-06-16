package co.edu.ufps.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.ufps.model.Domicilio;
import co.edu.ufps.repository.DomicilioRepo;
import co.edu.ufps.service.interfac.IDomicilioService;

@Service
public class DomicilioService implements IDomicilioService{
	
	@Autowired
	private DomicilioRepo domicilioRepo;

	@Override
	public List<Domicilio> findAll() {
		// TODO Auto-generated method stub
		return (List<Domicilio>)domicilioRepo.findAll();
	}

	@Override
	public void insertar(Domicilio domicilio) {
		// TODO Auto-generated method stub
		domicilioRepo.save(domicilio);
	}

	@Override
	public Domicilio findDomicilio(Integer id) {
		// TODO Auto-generated method stub
		return domicilioRepo.findById(id).orElse(null);
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		domicilioRepo.deleteById(id);
	}

}
