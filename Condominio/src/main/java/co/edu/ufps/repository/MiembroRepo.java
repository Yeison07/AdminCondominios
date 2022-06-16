package co.edu.ufps.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import co.edu.ufps.model.Miembro;

public interface MiembroRepo extends CrudRepository<Miembro, Integer>{

	public Optional <Miembro> findByUser(String correo); 
}
