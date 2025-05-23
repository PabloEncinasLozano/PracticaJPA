package es.ubu.lsi.model.multas;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.*;

@Embeddable
public class IncidenciaPK implements Serializable{
	
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date fecha;
	
	
	private String nif;
	
	//----==Constructor==----
	public IncidenciaPK() {}

	//----==Metodos==----
	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	@Override
	public int hashCode() {
		return Objects.hash(fecha, nif);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		IncidenciaPK other = (IncidenciaPK) obj;
		return Objects.equals(fecha, other.fecha) && Objects.equals(nif, other.nif);
	}
	

	@Override
	public String toString() {
	    return "IncidenciaPK [fecha=" + fecha + ", nif=" + nif + "]";
	}

}
