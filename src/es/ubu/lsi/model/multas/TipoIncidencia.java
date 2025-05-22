package es.ubu.lsi.model.multas;

import es.ubu.lsi.model.multas.IncidenciaPK;
import es.ubu.lsi.model.multas.Incidencia;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
public class TipoIncidencia{
	
	@Id
	private long id;
	
	private String descripcion;
	
	private int valor;
	
    @OneToMany(mappedBy = "tipoIncidencia")
    private Set<Incidencia> incidencias = new HashSet<>();

	//----==Constructor==----	
	
	public TipoIncidencia(long id, String descripcion, int valor) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.valor = valor;
	}
	
	public TipoIncidencia() {}
	
	//----==Metodos==----

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}
	
	@Override
	public String toString() {
	    return "TipoIncidencia [id=" + id + ", descripcion=" + descripcion + ", valor=" + valor + "]";
	}


}
