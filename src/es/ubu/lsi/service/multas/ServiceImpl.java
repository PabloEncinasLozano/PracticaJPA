package es.ubu.lsi.service.multas;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import es.ubu.lsi.service.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import es.ubu.lsi.model.multas.Vehiculo;
import es.ubu.lsi.service.PersistenceException;

public class ServiceImpl implements Service{
	
	/** Logger. */
	private static final Logger logger = LoggerFactory
			.getLogger(ServiceImpl.class);

	@Override
	public void insertarIncidencia(Date fecha, String nif, long tipo) throws PersistenceException {
		// TODO Auto-generated method stub
		
		EntityManager em;
		em.createSession();
		
	}

	@Override
	public void indultar(String nif) throws PersistenceException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Vehiculo> consultarVehiculos() throws PersistenceException {
		// TODO Auto-generated method stub
		return null;
	}

}
