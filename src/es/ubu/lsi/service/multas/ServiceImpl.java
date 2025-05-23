package es.ubu.lsi.service.multas;

import java.math.BigDecimal;

import java.util.Date;

import java.util.List;

import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.persistence.Subgraph;
import javax.persistence.TypedQuery;


import es.ubu.lsi.service.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import es.ubu.lsi.dao.multas.ConductorDAO;
import es.ubu.lsi.dao.multas.IncidenciaDAO;
import es.ubu.lsi.dao.multas.TipoIncidenciaDAO;
import es.ubu.lsi.model.multas.Conductor;
import es.ubu.lsi.model.multas.Incidencia;
import es.ubu.lsi.model.multas.IncidenciaPK;
import es.ubu.lsi.model.multas.TipoIncidencia;
import es.ubu.lsi.model.multas.Vehiculo;
import es.ubu.lsi.service.PersistenceException;

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
			
			//Tomar el tipo de incidencia para la nueva incidencia
			TipoIncidencia tipoNuevaIncidencia = tipoIncidenciaDao.findById(tipo);
			
			if (tipoNuevaIncidencia == null) {
				rollbackTransaction(em);
				throw new IncidentException(IncidentError.NOT_EXIST_INCIDENT_TYPE);
			}
			
			
			//Crear id para la nueva incidencia
			IncidenciaPK nuevaIncidenciaId = new IncidenciaPK();
			
			nuevaIncidenciaId.setFecha(fecha);
			nuevaIncidenciaId.setNif(nif);
			
			//Variables para controlar los puntos
			BigDecimal puntosActuales = conductor.getPuntos();
			int puntosIncidencia = tipoNuevaIncidencia.getValor();
			
			//Si no tiene puntos suficientes, salta excepcion
			if (puntosActuales.intValue() < puntosIncidencia) {
				rollbackTransaction(em);
				throw new IncidentException(IncidentError.NOT_AVAILABLE_POINTS);
			}
			//Se registran los nuevos puntos
			conductor.setPuntos(puntosActuales.subtract(BigDecimal.valueOf(puntosIncidencia)));
			
			//Crear la nueva incidencia
			Incidencia nuevaIncidencia = new Incidencia();
			
			nuevaIncidencia.setTipoIncidencia(tipoNuevaIncidencia);
			nuevaIncidencia.setId(nuevaIncidenciaId);
			nuevaIncidencia.setConductor(conductor);
			
			incidenciaDao.persist(nuevaIncidencia);
			
			
			commitTransaction(em);
			
			
		} catch (PersistenceException e){
			rollbackTransaction(em);
			System.out.println(e.getMessage());
			throw e;
			
		} finally {
			// close resources
			em.close();
		}
		
	}


	@Override
	public List<Vehiculo> consultarVehiculos() throws PersistenceException {
		EntityManager em = this.createSession();
	    try {
	        
	      //Grafo más simple
	        EntityGraph<Vehiculo> grafo = em.createEntityGraph(Vehiculo.class);
	        grafo.addAttributeNodes("conductores");
	        
	        //Se crea un subgrafo para los conductores, para seguir navegando desde ellos
	        Subgraph<Conductor> subGrafoConductores = grafo.addSubgraph("conductores");
	        subGrafoConductores.addAttributeNodes("incidencias");
	        
	        //Se crea un subgrafo adicional para las incidencias de cada conductor
	        Subgraph<Incidencia> subGrafoIncidencias = subGrafoConductores.addSubgraph("incidencias");
	        subGrafoIncidencias.addAttributeNodes("tipoIncidencia");
	        
	        //Se crea una consulta JPQL que selecciona todos los vehículos
	        TypedQuery<Vehiculo> consulta = em.createQuery("select v from Vehiculo v", Vehiculo.class);
	        
	        //Le pasamos el grafo como pista de carga para que JPA sepa qué relaciones debe traer ya cargadas
	        consulta.setHint("jakarta.persistence.loadgraph", grafo);
	        //Se ejecuta la consulta y se obtienen todos los vehículos
	        List<Vehiculo> resultado = consulta.getResultList();

	        // Forzar carga antes de cerrar
	        for (Vehiculo vehiculo : resultado) {
	            vehiculo.getConductores().size();
	            for (Conductor conductor : vehiculo.getConductores()) {
	                conductor.getIncidencias().size();
	                for (Incidencia incidencia : conductor.getIncidencias()) {
	                    incidencia.getTipoIncidencia();
	                }
	            }
	        }

	        return resultado;

	        
	    } finally {
	        em.close();
	    }
	}
}
