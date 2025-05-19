package es.ubu.lsi.model.multas;


import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

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


	private String nombre;


	private Direccion direccion;
	
    @ManyToOne
    @JoinColumn(name="IDAUTO")
    private Conductor conductor;
	
	//----==Constructor==----
	public Vehiculo(String idauto, String nombre, Direccion direccion) {
		super();
		this.idauto = idauto;
		this.nombre = nombre;
		this.direccion = direccion;
	}
	
	public Vehiculo() {}
	
	
	//----==Metodos==----
	
	public String getIdauto() {
		return idauto;
	}

	public void setIdauto(String idauto) {
		this.idauto = idauto;
	}

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	

}

