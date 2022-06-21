package co.edu.ufps.service.interfac;

import java.util.List;
import java.util.Optional;

import co.edu.ufps.model.Gasto;
import co.edu.ufps.model.Miembro;

public interface IMiembroService {
	public List<Miembro> findAll();
	public void insertar(Miembro miembro);
	public Miembro findMiembro(Integer id);
	public void delete(Integer id);
	public Optional<Miembro> findByCorreo(String correo);
	public void Update(Miembro miembro);

}
