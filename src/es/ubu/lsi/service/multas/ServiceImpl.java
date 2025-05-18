package es.ubu.lsi.service.multas;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import es.ubu.lsi.service.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import es.ubu.lsi.dao.invoice.FacturaDAO;
import es.ubu.lsi.dao.invoice.LineaFacturaDAO;
import es.ubu.lsi.model.invoice.LineasfacturaId;
import es.ubu.lsi.model.multas.Incidencia;
import es.ubu.lsi.model.multas.IncidenciaId;
import es.ubu.lsi.model.multas.TipoIncidencia;
import es.ubu.lsi.model.multas.Vehiculo;
import es.ubu.lsi.service.PersistenceException;

public class ServiceImpl implements Service{
	
	/** Logger. */
	private static final Logger logger = LoggerFactory
			.getLogger(ServiceImpl.class);

	@Override
	public void insertarIncidencia(Date fecha, String nif, long tipo) throws PersistenceException {
		// TODO Auto-generated method stub
		
		EntityManager em = this.createSession();
		
		try {
			em.beginTransaction();
			
			//Instanciar los DAO
			ConductorDAO conductorDao = new ConductorDAO(em);
			IncidenciaDAO incidenciaDao = new IncidenciaDAO(em);
			
			//Tomar el nif del conductor a ver si existe
			String nifDB = conductorDao.findById(nif);
			
			//Lanzar excepcion si es null
			if (nifDB==null) {
				rollbackTransaction(em);
				throw new NOT_EXIST_DRIVER;
				
			}
			
			
			//Crear id para la nueva incidencia
			IncidenciaId nuevaIncidenciaId = new IncidenciaId();
			
			nuevaIncidenciaId.setFecha(fecha);
			nuevaIncidenciaId.setConductor(nif);
			
			//Tomar el tipo de incidencia para la nueva incidencia
			TipoIncidencia tipoNuevaIncidencia = TipoIncidenciaDao.findById(tipo);
			
			if (tipoNuevaIncidencia == null) {
				rollbackTransaction(em);
				throw new NOT_EXIST_INCIDENT_TYPE;
			}
			
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
