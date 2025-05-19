package es.ubu.lsi.dao.multas;

import java.util.List;

import javax.persistence.EntityManager;

import es.ubu.lsi.dao.JpaDAO;
import es.ubu.lsi.model.multas.Conductor;
import es.ubu.lsi.model.multas.TipoIncidencia;

public class TipoIncidenciaDAO extends JpaDAO<TipoIncidencia, Long>{

	public TipoIncidenciaDAO(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<TipoIncidencia> findAll() {
		return entityManager.createQuery("Select c From TipoIncidencia c",TipoIncidencia.class).getResultList();
	}
	
	@Override
	public TipoIncidencia findById(Long id) {
		// TODO Auto-generated method stub
		return super.findById(id);
	}

}
