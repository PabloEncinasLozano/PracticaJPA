package es.ubu.lsi.model.multas;

import javax.persistence.*;

@Entity
public class Incidencia {
	
	@EmbeddedId
	private IncidenciaPK id;
	
	@Lob
	private String anotacion;
	
	@ManyToOne 
	@JoinColumn(name="idtipo")
	private TipoIncidencia tipoIncidencia;
	
	@ManyToOne
	@MapsId("nif")
	@JoinColumn(name="nif")
	private Conductor conductor;
	
	
	//----==Constructor==----
	public Incidencia(IncidenciaPK id, String anotacion, TipoIncidencia tipoIncidencia) {
		super();
		this.id = id;
		this.anotacion = anotacion;
		this.tipoIncidencia = tipoIncidencia;
	}
	
	
	public Incidencia() {}
	
	
	//----==Metodos==----


	public IncidenciaPK getId() {
		return id;
	}


	public void setId(IncidenciaPK id) {
		this.id = id;
	}


	public String getAnotacion() {
		return anotacion;
	}


	public void setAnotacion(String anotacion) {
		this.anotacion = anotacion;
	}


	public TipoIncidencia getTipoIncidencia() {
		return tipoIncidencia;
	}


	public void setTipoIncidencia(TipoIncidencia tipoIncidencia) {
		this.tipoIncidencia = tipoIncidencia;
	}


	public Conductor getConductor() {
		return conductor;
	}


	public void setConductor(Conductor conductor) {
		this.conductor = conductor;
	}
	
	@Override
	public String toString() {
	    return "Incidencia [id=" + id + ", anotacion=" + anotacion
	            + ", conductor=" + conductor + ", tipoIncidencia=" + tipoIncidencia + "]";
	}


}
