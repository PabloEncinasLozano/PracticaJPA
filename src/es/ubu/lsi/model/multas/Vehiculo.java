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

	@Embedded
	private DireccionPostal direccion;
	
    
    @OneToMany(mappedBy="vehiculo", fetch = FetchType.LAZY)
    private Set<Conductor> conductores = new HashSet<>();

	
	//----==Constructor==----
	public Vehiculo(String idauto, String nombre, DireccionPostal direccion) {
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

	public DireccionPostal getDireccionPostal() {
		return direccion;
	}

	public void setDireccionPostal(DireccionPostal direccion) {
		this.direccion = direccion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Set<Conductor> getConductores() {
        return conductores;
    }

    public void setConductores(Set<Conductor> conductores) {
        this.conductores = conductores;
    }
    
    @Override
    public String toString() {
        return "Vehiculo [idauto=" + idauto + ", nombre=" + nombre + ", direccionPostal=" + direccion + "]";
    }


}

