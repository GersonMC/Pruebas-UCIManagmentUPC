package pe.edu.upc.serviceimpls;

import java.util.List;

import javax.inject.Inject;

import pe.edu.upc.daointerfaces.IPacienteDao;
import pe.edu.upc.entities.Paciente;
import pe.edu.upc.serviceinterfaces.IPacienteService;

public class PacienteServiceImpl implements IPacienteService {

	@Inject
	private IPacienteDao pDao;

	@Override
	public void insert(Paciente p) {
		// TODO Auto-generated method stub
		pDao.insert(p);
	}

	@Override
	public List<Paciente> list() {
		// TODO Auto-generated method stub
		return pDao.list();
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		pDao.delete(id);
	}

	@Override
	public void update(Paciente p) {
		// TODO Auto-generated method stub
		pDao.update(p);
	}

	@Override
	public List<Paciente> findByName(Paciente p) {
		// TODO Auto-generated method stub
		return pDao.findByName(p);
	}

}
