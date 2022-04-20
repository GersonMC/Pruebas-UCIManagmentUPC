package pe.edu.upc.daoimpls;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.daointerfaces.IPacienteDao;
import pe.edu.upc.entities.Paciente;

public class PacienteImpl implements IPacienteDao {
	@PersistenceContext(unitName = "demofi19")
	private EntityManager em;

	@Transactional
	@Override
	public void insert(Paciente p) {
		try {
			em.persist(p);
		} catch (Exception e) {
			System.out.println("Errorrrr al listar paciente en DAO");

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

}
