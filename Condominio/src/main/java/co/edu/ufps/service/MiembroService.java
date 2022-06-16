package co.edu.ufps.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import co.edu.ufps.model.Miembro;
import co.edu.ufps.repository.MiembroRepo;
import co.edu.ufps.service.interfac.IMiembroService;

@Service
public class MiembroService implements IMiembroService{

	@Autowired
	private MiembroRepo miembroRepo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public List<Miembro> findAll() {
		// TODO Auto-generated method stub
		return (List<Miembro>)miembroRepo.findAll();
	}

	@Override
	public void insertar(Miembro miembro) {
		// TODO Auto-generated method stub
		miembro.setPassword(passwordEncoder.encode(miembro.getPassword()));
		miembroRepo.save(miembro);
		
	}

	@Override
	public Miembro findMiembro(Integer id) {
		// TODO Auto-generated method stub
		return miembroRepo.findById(id).orElse(null);
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		miembroRepo.deleteById(id);
	}

	@Override
	public Optional<Miembro> findByCorreo(String correo) {
		// TODO Auto-generated method stub
		return miembroRepo.findByCorreo(correo);
	}

}
