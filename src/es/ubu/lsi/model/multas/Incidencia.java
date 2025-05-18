package es.ubu.lsi.model.multas;

import javax.persistence.*;

@Entity
public class Incidencia {
	
	@EmbeddedId
	private IncidenciaId id;
	
	@Lob
	private String anotacion;
	
	@ManyToOne 
	@JoinColumn(name="idtipo")
	private TipoIncidencia tipoIncidencia;
	
	
	//----==Constructor==----
	public Incidencia(IncidenciaId id, String anotacion, TipoIncidencia tipoIncidencia) {
		super();
		this.id = id;
		this.anotacion = anotacion;
		this.tipoIncidencia = tipoIncidencia;
	}
	//----==Metodos==----


	public IncidenciaId getId() {
		return id;
	}


	public void setId(IncidenciaId id) {
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
	
	

}
