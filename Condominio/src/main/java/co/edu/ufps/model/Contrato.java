package co.edu.ufps.model;

import java.sql.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "contrato")
public class Contrato {

	@Id
	private Integer id;
	private Date fechaInic,fechaFin;
	private String descripcion;
	
	@OneToMany(mappedBy = "contrato")
	private List<Personal>personal;

	public Contrato() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getFechaInic() {
		return fechaInic;
	}

	public void setFechaInic(Date fechaInic) {
		this.fechaInic = fechaInic;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<Personal> getPersonal() {
		return personal;
	}

	public void setPersonal(List<Personal> personal) {
		this.personal = personal;
	}
	
	
	
}
