
package co.edu.ufps.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "gasto")
public class Gasto {
	
	@Id
	private Integer id;
	private String descripcio;
	private Double valor;
	private Date pago_oportuno;
	
	@ManyToOne
	@JoinColumn(name = "tipo_gasto")
	private TipoGasto tipoGasto;

	public Gasto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescripcio() {
		return descripcio;
	}

	public void setDescripcio(String descripcio) {
		this.descripcio = descripcio;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Date getPago_oportuno() {
		return pago_oportuno;
	}

	public void setPago_oportuno(Date pago_oportuno) {
		this.pago_oportuno = pago_oportuno;
	}

	public TipoGasto getTipoGasto() {
		return tipoGasto;
	}

	public void setTipoGasto(TipoGasto tipoGasto) {
		this.tipoGasto = tipoGasto;
	}
	
	
}
