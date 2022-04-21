package pe.edu.upc.daoimpls;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.daointerfaces.AdminDao;
import pe.edu.upc.entities.Admin;


public class AdminImpl implements AdminDao {
	@PersistenceContext(unitName = "demofi19")
	private EntityManager em;
	@Transactional
	@Override
	public void insert(Admin a) {
		try {
			em.persist(a);
		} catch (Exception e) {
			System.out.println("Error al listar el administrador");

		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Admin> list() {
		List<Admin> listaAdmin = new ArrayList<Admin>();

		try {
			Query jpql = em.createQuery("from Admin a");
			listaAdmin = (List<Admin>) jpql.getResultList();

		} catch (Exception e) {
			System.out.println("Error al listar paciente en DAO");
		}

		return listaAdmin;
	}

	@Transactional
	@Override
	public void delete(int id) {
		try {
			Admin ad = em.find(Admin.class, id);

			em.remove(ad);
		} catch (Exception e) {
			System.out.println("Error al eliminar en el DAO");
		}

	}

}
