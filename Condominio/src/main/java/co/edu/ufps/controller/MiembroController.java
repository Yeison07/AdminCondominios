package co.edu.ufps.controller;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import co.edu.ufps.model.Authority;
import co.edu.ufps.model.Domicilio;
import co.edu.ufps.model.Miembro;
import co.edu.ufps.model.Servicio;
import co.edu.ufps.service.interfac.IAuthorityService;
import co.edu.ufps.service.interfac.IMiembroService;

@Controller
@RequestMapping
public class MiembroController {
	
	@Autowired
	private IMiembroService miembroService;
	
	@Autowired
	private IAuthorityService authorityService;
	
	
	
	@PostMapping("/registroMiembro/insertar")
	public String insertarMiembro(@ModelAttribute Miembro miembro,@ModelAttribute Domicilio domicilio) {
		miembro.getDomicilios().add(domicilio);
		System.err.println("Si sirvo");
		Set<Authority>authoritys=new HashSet();
		Authority authority= authorityService.findAuthority(2l);
		authoritys.add(authority);
		miembro.setAuthority(authoritys);
		miembroService.insertar(miembro);
		
		
		return "redirect:/";
	}
	
	@PostMapping("/SolicitarServicio")
	public String solicitarServi(@ModelAttribute Servicio servicio,HttpServletRequest request) {
		String user=request.getUserPrincipal().getName();
		Miembro miembro=miembroService.findByCorreo(user).orElse(null);
		miembro.getServicios().add(servicio);
		miembroService.insertar(miembro);
		return "redirect:/welcome";
	}

}
