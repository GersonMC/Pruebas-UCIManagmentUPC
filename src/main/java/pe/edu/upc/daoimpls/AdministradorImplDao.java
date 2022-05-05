package pe.edu.upc.daoimpls;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.daointerfaces.IAdministradorDao;
import pe.edu.upc.entities.Administrador;

public class AdministradorImplDao implements IAdministradorDao {
	@PersistenceContext(unitName = "TrabajoProgramacionWeb")
	private EntityManager ad;

	@Transactional
	@Override
	public void insert(Administrador a) {
		try {
			ad.persist(a);
		} catch (Exception e) {
			System.out.println("Error al insertar Administrador en el DAO");
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Administrador> list() {
		List<Administrador> listaAdministradores = new ArrayList<Administrador>();
		try {
			Query jpql = ad.createQuery("from Administrador a");
			listaAdministradores = (List<Administrador>) jpql.getResultList();
		} catch (Exception e) {
			System.out.println("Error al listar Administrador en DAO");
		}
		return listaAdministradores;
	}

	@Transactional
	@Override
	public void delete(int idAdministrador) {
		try {
			Administrador adm = ad.find(Administrador.class, idAdministrador);
			ad.remove(adm);
		} catch (Exception e) {
			System.out.println("Error al eliminar en el DAO");
		}
	}
	
	@Transactional
	@Override
	public void update(Administrador a) {
		try {
			ad.merge(a);
		} catch (Exception e) {
			System.out.println("Erro al modificar administrador en el dao");
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Administrador> findByNameAdministrador(Administrador a) {
		List<Administrador> listaFindAdministrador = new ArrayList<Administrador>();
		try {
			Query q=ad.createQuery("from Administrador a where a.userAdmin like ?1");
			q.setParameter(1, "%" + a.getUserAdmin() + "%");
			listaFindAdministrador = (List<Administrador>)q.getResultList();
		} catch (Exception e) {
			System.out.println("Error al buscar asdministrador en el dao");
		}
		return listaFindAdministrador;
	}

}
