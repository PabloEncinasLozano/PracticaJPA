package es.ubu.lsi.model.multas;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.*;

@Embeddable
public class IncidenciaId implements Serializable{
	
	
	@Temporal(TemporalType.DATE)
	private Date fecha;
	
	@OneToOne(mappedBy="conductor")
	private Conductor conductor;
	
	//----==Constructor==----
	public IncidenciaId() {}

	
	//----==Metodos==----
	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Conductor getConductor() {
		return conductor;
	}

	public void setConductor(Conductor conductor) {
		this.conductor = conductor;
	}


	@Override
	public int hashCode() {
		return Objects.hash(conductor, fecha);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		IncidenciaId other = (IncidenciaId) obj;
		return Objects.equals(conductor, other.conductor) && Objects.equals(fecha, other.fecha);
	}



	
	

}
