package es.ubu.lsi.dao.multas;

import java.util.List;


import javax.persistence.EntityManager;

import es.ubu.lsi.dao.JpaDAO;
import es.ubu.lsi.model.multas.Incidencia;

public class IncidenciaDAO extends JpaDAO<Incidencia, String>{

	public IncidenciaDAO(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Incidencia> findAll() {
		return entityManager.createQuery("Select c From Incidencia c",Incidencia.class).getResultList();
	}

}
