package entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


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
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String codcen;

	private String codemp;

	private String cp;

	private int financiacion;

	private String ubicacion;

	//bi-directional one-to-one association to Empleado
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumns({
		})
	private Empleado empleado; 

	//bi-directional many-to-one association to Tatuaje
	@OneToMany(mappedBy="centro")
	private List<Tatuaje> tatuajes;

	public Centro() {
	}

	public String getCodcen() {
		return this.codcen;
	}

	public void setCodcen(String codcen) {
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

	public List<Tatuaje> getTatuajes() {
		return this.tatuajes;
	}

	public void setTatuajes(List<Tatuaje> tatuajes) {
		this.tatuajes = tatuajes;
	}

	public Tatuaje addTatuaje(Tatuaje tatuaje) {
		getTatuajes().add(tatuaje);
		tatuaje.setCentro(this);

		return tatuaje;
	}

	public Tatuaje removeTatuaje(Tatuaje tatuaje) {
		getTatuajes().remove(tatuaje);
		tatuaje.setCentro(null);

		return tatuaje;
	}

}