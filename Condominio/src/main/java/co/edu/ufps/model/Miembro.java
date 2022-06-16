package co.edu.ufps.model;

import java.sql.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "miembro")
public class Miembro {

	@Id
	private Integer documento;
	private String nombre,apellido,user,tipoMiembro,password;
	private Date fechaNac;
	
	@ManyToMany
	@JoinTable(name="miembro_sancion",
	joinColumns=@JoinColumn(name="documento_miembro"),
	inverseJoinColumns=@JoinColumn(name="sancion_id"))
	private List<Sancion>sanciones;
	
	@ManyToMany
	@JoinTable(name="miembro_servicio",
	joinColumns=@JoinColumn(name="documento_miembro"),
	inverseJoinColumns=@JoinColumn(name="servicio_id"))
	private List<Servicio>servicios;
	
	@ManyToMany
	@JoinTable(name="miembro_gasto",
	joinColumns=@JoinColumn(name="documento_miembro"),
	inverseJoinColumns=@JoinColumn(name="gasto_id"))
	private List<Gasto>gastos;
	
	@OneToMany(mappedBy = "miembro")
	private List<Domicilio> domicilios;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name="authorities_users",
	joinColumns=@JoinColumn(name="documento_miembro"),
	inverseJoinColumns=@JoinColumn(name="authority_id"))
	private Set<Authority> authority;

	public Miembro() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getDocumento() {
		return documento;
	}

	public void setDocumento(Integer documento) {
		this.documento = documento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getTipoMiembro() {
		return tipoMiembro;
	}

	public void setTipoMiembro(String tipoMiembro) {
		this.tipoMiembro = tipoMiembro;
	}

	public List<Sancion> getSanciones() {
		return sanciones;
	}

	public void setSanciones(List<Sancion> sanciones) {
		this.sanciones = sanciones;
	}

	public List<Servicio> getServicios() {
		return servicios;
	}

	public void setServicios(List<Servicio> servicios) {
		this.servicios = servicios;
	}

	public List<Gasto> getGastos() {
		return gastos;
	}

	public void setGastos(List<Gasto> gastos) {
		this.gastos = gastos;
	}

	public List<Domicilio> getDomicilios() {
		return domicilios;
	}

	public void setDomicilios(List<Domicilio> domicilios) {
		this.domicilios = domicilios;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Authority> getAuthority() {
		return authority;
	}

	public void setAuthority(Set<Authority> authority) {
		this.authority = authority;
	}

	public Date getFechaNac() {
		return fechaNac;
	}

	public void setFechaNac(Date fechaNac) {
		this.fechaNac = fechaNac;
	}
	
	
	
	
}
