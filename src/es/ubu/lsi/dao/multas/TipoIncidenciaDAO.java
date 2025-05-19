package es.ubu.lsi.dao.multas;

import javax.persistence.EntityManager;

import es.ubu.lsi.dao.JpaDAO;
import es.ubu.lsi.model.multas.TipoIncidencia;

public class TipoIncidenciaDAO extends JpaDAO<TipoIncidencia, String>{

	public TipoIncidenciaDAO(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

}
