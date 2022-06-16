package co.edu.ufps.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.ufps.model.Gasto;
import co.edu.ufps.repository.GastoRepo;
import co.edu.ufps.service.interfac.IGastoService;

@Service
public class GastoService implements IGastoService{
	
	@Autowired
	private GastoRepo gastoRepo;

	@Override
	public List<Gasto> findAll() {
		// TODO Auto-generated method stub
		return (List<Gasto>)gastoRepo.findAll();
	}

	@Override
	public void insertar(Gasto gasto) {
		// TODO Auto-generated method stub
		gastoRepo.save(gasto);
	}

	@Override
	public Gasto findGasto(Integer id) {
		// TODO Auto-generated method stub
		return gastoRepo.findById(id).orElse(null);
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		gastoRepo.deleteById(id);
	}

}
