package pe.edu.upc.daoimpls;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.daointerfaces.ICamaDao;
import pe.edu.upc.entities.Cama;

public class CamaImplDao implements ICamaDao {

	@PersistenceContext(unitName = "TrabajoProgramacionWeb")
	private EntityManager em;

	@Transactional
	@Override
	public void insert(Cama ca) {
		try {
			em.persist(ca);
		} catch (Exception e) {
			System.out.println("Error al insertar en el registro Cama");
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Cama> list() {
		List<Cama> listaCamas = new ArrayList<Cama>();
		try {
			Query jpql = em.createQuery("from Cama ca");
			listaCamas = (List<Cama>) jpql.getResultList();
		} catch (Exception e) {
			System.out.println("Erorr al listar en el DAO de camas");
		}
		return listaCamas;
	}

	@Transactional
	@Override
	public void delete(int idCama) {
		try {
			Cama cam = em.find(Cama.class, idCama);
			em.remove(cam);
		} catch (Exception e) {
			System.out.println("Error al eliminar en el DAO");
		}
	}

	@Transactional
	@Override
	public void update(Cama ca) {
		try {
			em.merge(ca);
		} catch (Exception e) {
			System.out.println("Error al modificar en el DAO");
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Cama> findbyNameCama(Cama ca) {
		List<Cama> listaFindCama = new ArrayList<Cama>();
		try {
			Query q = em.createQuery("from Cama ca where ca.disponibilidadCama like ?1");
			q.setParameter(1, "%" + ca.getDisponibilidadCama() + "%");
			listaFindCama=(List<Cama>) q.getResultList();
		} catch (Exception e) {
			System.out.println("Erro al buscar en el DAO");
		}
		return listaFindCama;
	}

}
