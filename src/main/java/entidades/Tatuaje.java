package entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tatuajes database table.
 * 
 */
@Entity
@Table(name="tatuajes")
@NamedQuery(name="Tatuaje.findAll", query="SELECT t FROM Tatuaje t")
public class Tatuaje implements Serializable {
	private static final long serialVersionUID = 1L;

	private String codcen;

	private String estilo;

	private int precio;

	private String tiempo;

	//bi-directional many-to-one association to Centro
	@OneToMany(mappedBy="tatuaje")
	private List<Centro> centros;

	public Tatuaje() {
	}

	public String getCodcen() {
		return this.codcen;
	}

	public void setCodcen(String codcen) {
		this.codcen = codcen;
	}

	public String getEstilo() {
		return this.estilo;
	}

	public void setEstilo(String estilo) {
		this.estilo = estilo;
	}

	public int getPrecio() {
		return this.precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public String getTiempo() {
		return this.tiempo;
	}

	public void setTiempo(String tiempo) {
		this.tiempo = tiempo;
	}

	public List<Centro> getCentros() {
		return this.centros;
	}

	public void setCentros(List<Centro> centros) {
		this.centros = centros;
	}

	public Centro addCentro(Centro centro) {
		getCentros().add(centro);
		centro.setTatuaje(this);

		return centro;
	}

	public Centro removeCentro(Centro centro) {
		getCentros().remove(centro);
		centro.setTatuaje(null);

		return centro;
	}

}