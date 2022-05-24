package entidades;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the empleados database table.
 * 
 */
@Entity
@Table(name="empleados")
@NamedQuery(name="Empleado.findAll", query="SELECT e FROM Empleado e")
public class Empleado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String codemp;

	private int aniosExp;

	private String apellido;

	private String nomem;

	//bi-directional one-to-one association to Centro
	@OneToOne(mappedBy="empleado", fetch=FetchType.LAZY)
	private Centro centro;

	public Empleado() {
	}

	public String getCodemp() {
		return this.codemp;
	}

	public void setCodemp(String codemp) {
		this.codemp = codemp;
	}

	public int getAniosExp() {
		return this.aniosExp;
	}

	public void setAniosExp(int aniosExp) {
		this.aniosExp = aniosExp;
	}

	public String getApellido() {
		return this.apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getNomem() {
		return this.nomem;
	}

	public void setNomem(String nomem) {
		this.nomem = nomem;
	}

	public Centro getCentro() {
		return this.centro;
	}

	public void setCentro(Centro centro) {
		this.centro = centro;
	}

}