package co.edu.ufps.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import co.edu.ufps.model.Domicilio;
import co.edu.ufps.model.Miembro;
import co.edu.ufps.model.Servicio;
import co.edu.ufps.service.interfac.IDomicilioService;
import co.edu.ufps.service.interfac.IMiembroService;
import co.edu.ufps.service.interfac.IServicioService;

@Controller
@RequestMapping
public class VistaController {
	
	@Autowired
	private IMiembroService miembroService;
	
	@Autowired
	private IServicioService servicioService;
	
	@Autowired
	private IDomicilioService domicilioService;

	@GetMapping({"/","/home"})
	public String home() {
		return "index";
	}
	
	@GetMapping("/welcome")
	public String welcome() {
		return "welcome";
	}
	
	@GetMapping("/servicio")
	public String servicio(Model model) {
		List<Servicio> servicios= servicioService.findAll();
		model.addAttribute("servicios", servicios);
		return "servicio";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/deuda")
	public String deuda() {
		return "deudas";
	}
	//cambiar direccion
	@GetMapping("/register")
	public String registrarMiembro(Model model) {
		Miembro miembro= new Miembro();
		List<Domicilio> domicilios = domicilioService.findAll();
		domicilios.toString();
		model.addAttribute("miembro", miembro);
		model.addAttribute("ldomicilios", domicilios);
		return "registrarMiembro";
	}
	
	@GetMapping("/adminMiembro")
	public String adminMiembro(Model model) {
		List<Miembro> miembros= miembroService.findAll();
		model.addAttribute("miembros", miembros);
		return "adminMiembros";
	}
	
}
