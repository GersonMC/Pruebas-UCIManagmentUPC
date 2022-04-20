package pe.edu.upc.serviceimpls;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.daointerfaces.IPacienteDao;
import pe.edu.upc.entities.Paciente;
import pe.edu.upc.serviceinterfaces.IPacienteService;

@Named
public class PacienteServiceImpl implements IPacienteService {
//anotacion inject
	@Inject
	private IPacienteDao pDao;

	@Override
	public void insert(Paciente p) {
		pDao.insert(p);

	}

	@Override
	public List<Paciente> list() {

		return pDao.list();
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		pDao.delete(id);
	}

}
