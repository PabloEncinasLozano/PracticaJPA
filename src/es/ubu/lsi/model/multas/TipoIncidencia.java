package es.ubu.lsi.model.multas;

import es.ubu.lsi.model.multas.IncidenciaId;
import es.ubu.lsi.model.multas.Incidencia;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
public class TipoIncidencia{
	
	@Id
	private int id;
	
	private String descripcion;
	
	private int valor;
	
    @OneToMany
    @JoinColumn(name = "ID")
    private Set<Incidencia> incidencias = new HashSet<>();

	//----==Constructor==----	
	
	public TipoIncidencia(int id, String descripcion, int valor) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.valor = valor;
	}
	
	public TipoIncidencia() {}
	
	//----==Metodos==----

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	

	

}
