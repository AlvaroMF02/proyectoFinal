package entidades;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tatuajes database table.
 * 
 */
@Entity
@Table(name="tatuajes")
@NamedQuery(name="Tatuaje.findAll", query="SELECT t FROM Tatuaje t")
public class Tatuaje implements Serializable {
	private static final long serialVersionUID = 1L;

	private String estilo;

	private int precio;

	private String tiempo;

	//bi-directional many-to-one association to Centro
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="codcen")
	private Centro centro;

	public Tatuaje() {
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

	public Centro getCentro() {
		return this.centro;
	}

	public void setCentro(Centro centro) {
		this.centro = centro;
	}

}