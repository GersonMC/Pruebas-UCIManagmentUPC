package pe.edu.upc.daoimpls;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.daointerfaces.IEstadoReservaDao;
import pe.edu.upc.entities.EstadoReserva;

public class EstadoReservaImplDao implements IEstadoReservaDao{

	@PersistenceContext(unitName = "TrabajoProgramacionWeb")
	private EntityManager em;
	
	@Transactional
	@Override
	public void insert(EstadoReserva es) {
		try {
			em.persist(es);
		} catch (Exception e) {
			System.out.println("Error al insertar en el registro estadoReserva");
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<EstadoReserva> list() {
		List<EstadoReserva> listaEstadoReserva = new ArrayList<EstadoReserva>();
		try {
			Query jpql = em.createQuery("from EstadoReserva es");
			listaEstadoReserva = (List<EstadoReserva>)jpql.getResultList();
		} catch (Exception e) {
			System.out.println("Erorr al listar en el DAO de estadoReserva");
		}
		return listaEstadoReserva;
	}

	@Transactional
	@Override
	public void update(EstadoReserva es) {
		try {
			em.merge(es);
		} catch (Exception e) {
			System.out.println("Error al modificar estadoReserva en el DAO");
		}
	}

	@Transactional
	@Override
	public void delete(int idEstado) {
		try {
			EstadoReserva est = em.find(EstadoReserva.class, idEstado);
			em.remove(est);
		} catch (Exception e) {
			System.out.println("Error al eliminar estadoReserva en el DAO");
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<EstadoReserva> findbyNameEstadoReserva(EstadoReserva es) {
		List<EstadoReserva> listarFindEstado = new ArrayList<EstadoReserva>();
		try {
			Query q = em.createQuery("from EstadoReserva es where es.estado like ?1");
			q.setParameter(1, "%" + es.getEstado() + "%" );
			listarFindEstado = (List<EstadoReserva>)q.getResultList();
		} catch (Exception e) {
			System.out.println("Erro al buscar en el DAO");
		}
		return listarFindEstado;
	}

}
