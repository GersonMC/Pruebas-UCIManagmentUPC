package pe.edu.upc.daoimpls;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.daointerfaces.IMedicoDao;
import pe.edu.upc.entities.Medico;

public class MedicoImplDao implements IMedicoDao{

	@PersistenceContext(unitName = "TrabajoProgramacionWeb")
	private EntityManager em;
	
	@Transactional
	@Override
	public void insert(Medico m) {
		try {
			em.persist(m);
		} catch (Exception e) {
			System.out.println("Error al insertar medico en DAO");

		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Medico> list() {
		List<Medico> listaMedicos = new ArrayList<Medico>();

		try {
			Query jpql = em.createQuery("from Medico p");
			listaMedicos = (List<Medico>) jpql.getResultList();

		} catch (Exception e) {
			System.out.println("Error al listar paciente en DAO medico");
		}

		return listaMedicos;
	}

	@Transactional
	@Override
	public void delete(int id) {
		try {
			Medico mec = em.find(Medico.class, id);

			em.remove(mec);
		} catch (Exception e) {
			System.out.println("Error al eliminar en el DAO medico");
		}
	}

	@Transactional
	@Override
	public void update(Medico m) {
		try {
			em.merge(m);
		} catch (Exception e) {
			System.out.println("Error al modificar en el DAO update");
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Medico> findByName(Medico m) {
		List<Medico> lista = new ArrayList<Medico>();
		try {
			Query q = em.createQuery("from Medico m where m.fullnameMedico like ?1");
			q.setParameter(1, "%" + m.getFullnameMedico() + "%");
			lista = (List<Medico>) q.getResultList();
		} catch (Exception e) {
			System.out.println("Error al buscar en el DAO");
		}
		return lista;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Medico> findByLocation(Medico m) {
		List<Medico> lista = new ArrayList<Medico>();
		try {
			Query q = em.createQuery("from Medico m where m.direccionMedico like ?1");
			q.setParameter(1, "%" + m.getDireccionMedico() + "%");
			lista = (List<Medico>) q.getResultList();
		} catch (Exception e) {
			System.out.println("Error al buscar en el DAO");
		}
		return lista;
	}

}
