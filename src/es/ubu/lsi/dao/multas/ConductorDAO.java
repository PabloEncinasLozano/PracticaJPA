package es.ubu.lsi.dao.multas;

import javax.persistence.EntityManager;

import es.ubu.lsi.dao.DAO;

import es.ubu.lsi.dao.JpaDAO;
import es.ubu.lsi.model.multas.Conductor;

public class ConductorDAO extends JpaDAO<Conductor, String>{

	public ConductorDAO(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public Conductor findById(String id) {
		
	}
	

}
