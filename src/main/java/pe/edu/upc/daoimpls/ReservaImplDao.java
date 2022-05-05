package pe.edu.upc.daoimpls;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.daointerfaces.IReservaDao;
import pe.edu.upc.entities.Reserva;

public class ReservaImplDao implements IReservaDao {

	@PersistenceContext(unitName = "TrabajoProgramacionWeb")
	private EntityManager em;

	// INSERTAR
	@Transactional
	@Override
	public void insert(Reserva r) {
		try {
			em.persist(r);

		} catch (Exception e) {
			System.out.println("Error al imsertar en DAO reserva");
		}

	}

	// LISTAR
	@SuppressWarnings("unchecked")
	@Override
	public List<Reserva> list() {
		List<Reserva> Listareservas = new ArrayList<Reserva>();
		try {
			Query jpql = em.createQuery("from Reserva r");
			Listareservas = (List<Reserva>) jpql.getResultList();

		} catch (Exception e) {
			System.out.println("Error al listar en DAO de reserva");
		}
		return Listareservas;
	}

	// ELIMINAR
	@Transactional
	@Override
	public void delete(int idReserva) {
		try {
			Reserva r = em.find(Reserva.class, idReserva);
			em.remove(r);
		} catch (Exception e) {
			System.out.println("Error al eliminar en DAO de reserva");
		}
	}

	// MODIFICAR
	@Transactional
	@Override
	public void update(Reserva r) {
		try {
			em.merge(r);
		} catch (Exception e) {
			System.out.println("Error al actualizar en DAO de reserva");
		}
	}

	
	
	// BUSCAR
	@SuppressWarnings("unchecked")
	@Override
	public List<Reserva> fBPaciente(Reserva r) {
		List<Reserva> listaFBPaciente = new ArrayList<Reserva>();
		try {
			Query q = em.createQuery("from Reserva r where r.idPaciente.fullnamePaciente like ?1");
			q.setParameter(1, "%" + r.getPaciente() + "%");
			listaFBPaciente=(List<Reserva>) q.getResultList();
		} catch (Exception e) {
			System.out.println("Error al buscar en DAO de reserva");
		}
		return listaFBPaciente;
	}

}
