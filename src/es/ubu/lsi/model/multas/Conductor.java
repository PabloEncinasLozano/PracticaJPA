package es.ubu.lsi.model.multas;

import es.ubu.lsi.model.multas.Vehiculo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
public class Conductor {
	
	@Id
	private String nif;
	
	private String nombre;
	
	private String apellido;
	
	private Direccion direccion;
	
	private BigDecimal puntos;
	
	@OneToOne
	@JoinColumn(name="NIF")
	private Conductor conductor;
	
	@OneToMany(mappedBy="conductor")
	private Set<Vehiculo> vehiculos = new HashSet<>();

	//----==Constructor==----
	public Conductor(String nif, String nombre, String apellido, Direccion direccion, BigDecimal puntos, Set<Vehiculo> vehiculos) {
		super();
		this.nif = nif;
		this.nombre = nombre;
		this.apellido = apellido;
		this.direccion = direccion;
		this.puntos = puntos;
		this.vehiculos = vehiculos;
	}
	
	
	public Conductor() {}


	//----==Metodos==----

	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	public BigDecimal getPuntos() {
		return puntos;
	}

	public void setPuntos(BigDecimal puntos) {
		this.puntos = puntos;
	}


	public Set<Vehiculo> getVehiculo() {
		return vehiculos;
	}


	public void setVehiculo(Set<Vehiculo> vehiculos) {
		this.vehiculos = vehiculos;
	}
	
	

}
