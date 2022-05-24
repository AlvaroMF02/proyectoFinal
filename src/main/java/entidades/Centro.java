package entidades;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the centros database table.
 * 
 */
@Entity
@Table(name="centros")
@NamedQuery(name="Centro.findAll", query="SELECT c FROM Centro c")
public class Centro implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Object codcen;

	private String codemp;

	private String cp;

	private int financiacion;

	private String ubicacion;

	//bi-directional one-to-one association to Empleado
	@OneToOne
	@JoinColumns({
		})
	private Empleado empleado;

	//bi-directional many-to-one association to Tatuaje
	@ManyToOne
	@JoinColumns({
		})
	private Tatuaje tatuaje;

	public Centro() {
	}

	public Object getCodcen() {
		return this.codcen;
	}

	public void setCodcen(Object codcen) {
		this.codcen = codcen;
	}

	public String getCodemp() {
		return this.codemp;
	}

	public void setCodemp(String codemp) {
		this.codemp = codemp;
	}

	public String getCp() {
		return this.cp;
	}

	public void setCp(String cp) {
		this.cp = cp;
	}

	public int getFinanciacion() {
		return this.financiacion;
	}

	public void setFinanciacion(int financiacion) {
		this.financiacion = financiacion;
	}

	public String getUbicacion() {
		return this.ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public Empleado getEmpleado() {
		return this.empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public Tatuaje getTatuaje() {
		return this.tatuaje;
	}

	public void setTatuaje(Tatuaje tatuaje) {
		this.tatuaje = tatuaje;
	}

}