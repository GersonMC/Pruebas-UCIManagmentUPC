package pe.edu.upc.daoimpls;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.daointerfaces.IHospitalDao;
import pe.edu.upc.entities.Hospital;

public class HospitalImplDao implements IHospitalDao {
	@PersistenceContext(unitName = "TrabajoProgramacionWeb")
	private EntityManager em;

	@Transactional
	@Override
	public void insert(Hospital h) {
		try {
			em.persist(h);
		} catch (Exception e) {
			System.out.println("Error al insertar hospital en el DAO");
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Hospital> list() {
		List<Hospital> listaHospitales = new ArrayList<Hospital>();
		try {
			Query jpql = em.createQuery("from Hospital h");
			listaHospitales = (List<Hospital>) jpql.getResultList();
		} catch (Exception e) {
			System.out.println("Error al listar hospital en DAO");
		}

		return listaHospitales;
	}
	
	@Transactional
	@Override
	public void delete(int idHospital) {
		try {
			Hospital hos = em.find(Hospital.class, idHospital);
			em.remove(hos);
		} catch (Exception e) {
			System.out.println("Error al eliminar en el DAO");
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Hospital> findbyNameHospital(Hospital h) {
		List<Hospital> listaFindHospital=new ArrayList<Hospital>();
		try {
			Query q=em.createQuery("from Hospital h where h.nombreHospital like ?1");
			q.setParameter(1, "%" + h.getNombreHospital() + "%");
			listaFindHospital = (List<Hospital>)q.getResultList();
		} catch (Exception e) {
			System.out.println("Error al buscar hospital en el DAOimpl");
		}
		return listaFindHospital;
	}
	@Transactional
	@Override
	public void update(Hospital h) {
		try {
			em.merge(h);
		} catch (Exception e) {
			System.out.println("Error al modifcar hospital en el dao");
		}
		
	}

}
