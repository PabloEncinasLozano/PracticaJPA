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
	
	private DireccionPostal direccion;
	
	private BigDecimal puntos;
	
	@OneToOne
	@JoinColumn(name="NIF")
	private Conductor conductor;
	
	@ManyToOne
    @JoinColumn(name = "idauto")
    private Vehiculo vehiculo;
	
	@OneToMany(mappedBy = "conductor")
	private Set<Incidencia> incidencias = new HashSet<>();

	//----==Constructor==----
	public Conductor(String nif, String nombre, String apellido, DireccionPostal direccion, BigDecimal puntos, Vehiculo vehiculos) {
		super();
		this.nif = nif;
		this.nombre = nombre;
		this.apellido = apellido;
		this.direccion = direccion;
		this.puntos = puntos;
		this.vehiculo = vehiculos;
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

	public DireccionPostal getDireccionPostal() {
		return direccion;
	}

	public void setDireccionPostal(DireccionPostal direccion) {
		this.direccion = direccion;
	}

	public BigDecimal getPuntos() {
		return puntos;
	}

	public void setPuntos(BigDecimal puntos) {
		this.puntos = puntos;
	}


	public Vehiculo getVehiculo() {
		return vehiculo;
	}


	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}


	public Set<Incidencia> getIncidencias() {
		return incidencias;
	}


	public void setIncidencias(Set<Incidencia> incidencias) {
		this.incidencias = incidencias;
	}
	

}
