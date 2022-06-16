package co.edu.ufps.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="servicio")
public class Servicio {
	
	@Id
	private Integer id;
	private String nombre;
	private Boolean ocupado;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name="servicio_horario",
	joinColumns=@JoinColumn(name="servicio_id"),
	inverseJoinColumns=@JoinColumn(name="horario_id"))
	private List<Horario>horarios;

	public Servicio() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Boolean getOcupado() {
		return ocupado;
	}

	public void setOcupado(Boolean ocupado) {
		this.ocupado = ocupado;
	}

	public List<Horario> getHorarios() {
		return horarios;
	}

	public void setHorarios(List<Horario> horarios) {
		this.horarios = horarios;
	}
	
	
}
