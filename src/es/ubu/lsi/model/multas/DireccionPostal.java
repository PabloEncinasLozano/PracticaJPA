package es.ubu.lsi.model.multas;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.*;


@Embeddable
public class DireccionPostal implements Serializable{
	
	private String direccion;
	
	private String cp;
	
	private String ciudad;

	
	//----==Constructor==----
	public DireccionPostal() {}

	
	//----==Metodos==----

	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	public String getCp() {
		return cp;
	}


	public void setCp(String cp) {
		this.cp = cp;
	}


	public String getCiudad() {
		return ciudad;
	}


	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}


	@Override
	public int hashCode() {
		return Objects.hash(ciudad, cp, direccion);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DireccionPostal other = (DireccionPostal) obj;
		return Objects.equals(ciudad, other.ciudad) && Objects.equals(cp, other.cp)
				&& Objects.equals(direccion, other.direccion);
	}
	

}
