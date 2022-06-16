package co.edu.ufps.service.interfac;

import java.util.List;

import co.edu.ufps.model.Authority;
import co.edu.ufps.model.Gasto;

public interface IGastoService {
	public List<Gasto> findAll();
	public void insertar(Gasto gasto);
	public Gasto findGasto(Integer id);
	public void delete(Integer id);

}
