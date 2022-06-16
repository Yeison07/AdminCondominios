package co.edu.ufps.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="domicilio")
public class Domicilio {

	@Id
	private Integer id;
	private Integer nro_habitantes;
	
	@ManyToOne
	@JoinColumn(name = "miembro_documento")
	private Miembro miembro;

	public Domicilio() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getNro_habitantes() {
		return nro_habitantes;
	}

	public void setNro_habitantes(Integer nro_habitantes) {
		this.nro_habitantes = nro_habitantes;
	}

	public Miembro getMiembro() {
		return miembro;
	}

	public void setMiembro(Miembro miembro) {
		this.miembro = miembro;
	}

	@Override
	public String toString() {
		return "Domicilio [id=" + id + ", nro_habitantes=" + nro_habitantes + ", miembro=" + miembro + "]";
	}
	
	
}
