package co.edu.ufps.controller;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import co.edu.ufps.model.Authority;
import co.edu.ufps.model.Domicilio;
import co.edu.ufps.model.Gasto;
import co.edu.ufps.model.Miembro;
import co.edu.ufps.model.Servicio;
import co.edu.ufps.service.interfac.IAuthorityService;
import co.edu.ufps.service.interfac.IGastoService;
import co.edu.ufps.service.interfac.IMiembroService;

@Controller
@RequestMapping
public class MiembroController {
	
	@Autowired
	private IMiembroService miembroService;
	
	@Autowired
	private IAuthorityService authorityService;
	
	@Autowired
	private IGastoService gastoService;
	
	
	
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
	
	@GetMapping("/generarRecibo/{id}")
	public String generarRecibo(@PathVariable("id") String id ) {
		System.err.println("Sirvo mi id es " + id);
		return"redirect:/deuda";
	}
	
	@GetMapping("/registrarMulta/{doc}")
	public String registrarMulta(@PathVariable String doc, @ModelAttribute Gasto gasto) {
		System.err.println(doc + "= DOC AND ID =" + gasto.getId());
		Miembro miembro= miembroService.findMiembro(Integer.valueOf(doc));
		miembro.getGastos().add(gasto);
		miembroService.Update(miembro);
		return "redirect:/adminMiembro";
	}

}
