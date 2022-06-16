package co.edu.ufps.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="condominio")
public class Condominio {

	@Id
	private Integer id;
	private String nombre,direccion;
	private Integer habitantes;
	public Condominio() {
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
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public Integer getHabitantes() {
		return habitantes;
	}
	public void setHabitantes(Integer habitantes) {
		this.habitantes = habitantes;
	}
	
	
}
