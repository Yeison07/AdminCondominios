package co.edu.ufps.service.interfac;

import java.util.List;


import co.edu.ufps.model.Servicio;

public interface IServicioService {
	public List<Servicio> findAll();
	public void insertar(Servicio servicio);
	public Servicio findServico(Integer id);
	public void delete(Integer id);
}
