package co.edu.ufps.service.interfac;

import java.util.List;


import co.edu.ufps.model.Domicilio;

public interface IDomicilioService {

	public List<Domicilio> findAll();
	public void insertar(Domicilio domicilio);
	public Domicilio findDomicilio(Integer id);
	public void delete(Integer id);
}
