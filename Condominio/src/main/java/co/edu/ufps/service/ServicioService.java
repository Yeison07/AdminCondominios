package co.edu.ufps.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.ufps.model.Servicio;
import co.edu.ufps.repository.ServicioRepo;
import co.edu.ufps.service.interfac.IServicioService;

@Service
public class ServicioService implements IServicioService{
	
	@Autowired
	private ServicioRepo servicioRepo;

	@Override
	public List<Servicio> findAll() {
		// TODO Auto-generated method stub
		return (List<Servicio>)servicioRepo.findAll();
	}

	@Override
	public void insertar(Servicio servicio) {
		// TODO Auto-generated method stub
		servicioRepo.save(servicio);
		
	}

	@Override
	public Servicio findServico(Integer id) {
		// TODO Auto-generated method stub
		return servicioRepo.findById(id).orElse(null);
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		servicioRepo.deleteById(id);
	}

	
}
