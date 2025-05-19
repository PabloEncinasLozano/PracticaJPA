package es.ubu.lsi.service.multas;

import java.math.BigDecimal;
import java.util.Date;

import java.util.List;

import javax.persistence.EntityManager;
import es.ubu.lsi.service.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import es.ubu.lsi.dao.multas.ConductorDAO;
import es.ubu.lsi.dao.multas.IncidenciaDAO;
import es.ubu.lsi.dao.multas.TipoIncidenciaDAO;
import es.ubu.lsi.model.multas.Conductor;
import es.ubu.lsi.model.multas.Incidencia;
import es.ubu.lsi.model.multas.IncidenciaId;
import es.ubu.lsi.model.multas.TipoIncidencia;
import es.ubu.lsi.model.multas.Vehiculo;
import es.ubu.lsi.service.PersistenceException;
import es.ubu.lsi.service.multas.IncidentError;

public class ServiceImpl extends PersistenceService implements Service{
	
	/** Logger. */
	private static final Logger logger = LoggerFactory
			.getLogger(ServiceImpl.class);

	@Override
	public void insertarIncidencia(Date fecha, String nif, long tipo) throws PersistenceException {
		// TODO Auto-generated method stub
		
		EntityManager em = this.createSession();
		
		try {
			beginTransaction(em);
			
			//Instanciar los DAO
			ConductorDAO conductorDao = new ConductorDAO(em);
			IncidenciaDAO incidenciaDao = new IncidenciaDAO(em);
			TipoIncidenciaDAO tipoIncidenciaDao = new TipoIncidenciaDAO(em);
			
			//Tomar el nif del conductor a ver si existe
			Conductor conductor = conductorDao.findById(nif);
			
			//Lanzar excepcion si es null
			if (conductor==null) {
				rollbackTransaction(em);
				throw new IncidentException(IncidentError.NOT_EXIST_DRIVER);
				
			}
			
			
			//Crear id para la nueva incidencia
			IncidenciaId nuevaIncidenciaId = new IncidenciaId();
			
			nuevaIncidenciaId.setFecha(fecha);
			nuevaIncidenciaId.setConductor(conductor);
			
			//Tomar el tipo de incidencia para la nueva incidencia
			TipoIncidencia tipoNuevaIncidencia = tipoIncidenciaDao.findById(tipo);
			
			
			if (tipoNuevaIncidencia == null) {
				rollbackTransaction(em);
				throw new IncidentException(IncidentError.NOT_EXIST_INCIDENT_TYPE);
			}
			
			//Variables para controlar los puntos
			BigDecimal puntoActuales = conductor.getPuntos();
			int puntosIncidencia = tipoNuevaIncidencia.getValor();
			
			//Crear la nueva incidencia
			Incidencia nuevaIncidencia = new Incidencia();
			
			nuevaIncidencia.setTipoIncidencia(tipoNuevaIncidencia);
			nuevaIncidencia.setId(nuevaIncidenciaId);
			
			
			commitTransaction(em);
			
			
		} catch (PersistenceException e){
			rollbackTransaction(em);
			System.out.println(e.getMessage());
			
		} finally {
			// close resources
			em.close();
		}
		
	}

	/*
	@Override
	public void indultar(String nif) throws PersistenceException {
		// TODO Auto-generated method stub
		
	}
	*/


	@Override
	public List<Vehiculo> consultarVehiculos() throws PersistenceException {
		// TODO Auto-generated method stub
		return null;
	}

}
