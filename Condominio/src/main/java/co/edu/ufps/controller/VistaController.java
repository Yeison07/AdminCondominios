package co.edu.ufps.controller;


import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import co.edu.ufps.model.Authority;
import co.edu.ufps.model.Domicilio;
import co.edu.ufps.model.Gasto;
import co.edu.ufps.model.Miembro;
import co.edu.ufps.model.Servicio;
import co.edu.ufps.service.interfac.IDomicilioService;
import co.edu.ufps.service.interfac.IGastoService;
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

	@Autowired
	private IGastoService gastoService;
	
	@GetMapping({"/","/home"})
	public String home() {
		return "index";
	}
	
	@GetMapping("/welcome")
	public String welcome(HttpServletRequest request) {
		String user= request.getUserPrincipal().getName();
		Set<Authority>auth=miembroService.findByCorreo(user).get().getAuthority();
		for (Authority authority : auth) {
			if (authority.getId().equals(1L)) {
				return "redirect:/adminMiembro";
			}
		}
		
		return "welcome";
	}
	
	@GetMapping("/servicio")
	public String servicio(Model model) {
		Servicio servicio= new Servicio();
		List<Servicio> servicios= servicioService.findAll();
		model.addAttribute("servicios", servicios);
		model.addAttribute("servicio", servicio);
		return "servicio";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/deuda")
	public String deuda(Model model,HttpServletRequest request) {
		Miembro miembro=miembroService.findByCorreo(request.getUserPrincipal().getName()).orElse(null);
		List<Gasto>gastos=miembro.getGastos();
		System.err.println(miembro.getNombre() + " a"  + miembro.getGastos().toString());
		System.err.println(gastos.toString());
		model.addAttribute("gastos", gastos);
		return "deudas";
	}
	//cambiar direccion
	@GetMapping("/register")
	public String registrarMiembro(Model model) {
		Miembro miembro= new Miembro();
		List<Domicilio> domicilios = domicilioService.findAll();
		model.addAttribute("miembro", miembro);
		model.addAttribute("ldomicilios", domicilios);
		return "registrarMiembro";
	}
	
	@GetMapping("/adminMiembro")
	public String adminMiembro(Model model) {
		List<Miembro> miembros= miembroService.findAll();
		for (Miembro miembro : miembros) {
			if(miembro.getDocumento().equals(1)) {
				miembros.remove(miembro);
			}
		}
		List<Gasto>gastos=gastoService.findAll();
		Gasto gasto= new Gasto();
		Miembro miembro= new Miembro();
		model.addAttribute("gastos", gastos);
		model.addAttribute("miembros", miembros);
		model.addAttribute("gasto", gasto);
		
		return "adminMiembros";
	}
	
}
