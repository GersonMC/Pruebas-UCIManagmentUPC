package pe.edu.upc.daoimpls;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.daointerfaces.IPacienteDao;
import pe.edu.upc.entities.Paciente;

public class PacienteImplDao implements IPacienteDao{

	@PersistenceContext(unitName = "TrabajoProgramacionWeb")
	private EntityManager em;

	@Transactional
	@Override
	public void insert(Paciente p) {
		try {
			em.persist(p);
		} catch (Exception e) {
			System.out.println("Errorrrr al insertar paciente en DAO");

		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Paciente> list() {
		List<Paciente> listaPacientes = new ArrayList<Paciente>();

		try {
			Query jpql = em.createQuery("from Paciente p");
			listaPacientes = (List<Paciente>) jpql.getResultList();

		} catch (Exception e) {
			System.out.println("Error al listar paciente en DAO");
		}

		return listaPacientes;
	}

	@Transactional
	@Override
	public void delete(int id) {
		try {
			Paciente pac = em.find(Paciente.class, id);

			em.remove(pac);
		} catch (Exception e) {
			System.out.println("Error al eliminar en el DAO");
		}

	}

	@Transactional
	@Override
	public void update(Paciente p) {
		try {
			em.merge(p);
		} catch (Exception e) {
			System.out.println("Error al modificar en el DAO");
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Paciente> findByName(Paciente p) {
		List<Paciente> lista = new ArrayList<Paciente>();
		try {
			Query q = em.createQuery("from Paciente p where p.fullnamePaciente like ?1");
			q.setParameter(1, "%" + p.getFullnamePaciente() + "%");
			lista = (List<Paciente>) q.getResultList();
		} catch (Exception e) {
			System.out.println("Error al buscar en el DAO");
		}
		return lista;
	}
	
}
