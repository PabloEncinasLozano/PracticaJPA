package es.ubu.lsi.model.multas;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the VEHICULO database table.
 * 
 */
@Entity
@NamedQuery(name="Vehiculo.findAll", query="SELECT v FROM Vehiculo v")
public class Vehiculo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String idauto;

	@Embedded
	private DireccionPostal direccionPostal;

	private String nombre;
	
	public String getIdauto() {
		return idauto;
	}

	public void setIdauto(String idauto) {
		this.idauto = idauto;
	}

	public DireccionPostal getDireccionPostal() {
		return direccionPostal;
	}

	public void setDireccionPostal(DireccionPostal direccionPostal) {
		this.direccionPostal = direccionPostal;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	

}

