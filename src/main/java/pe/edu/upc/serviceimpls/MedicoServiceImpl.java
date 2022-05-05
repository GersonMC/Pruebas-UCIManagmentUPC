package pe.edu.upc.serviceimpls;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.daointerfaces.IMedicoDao;
import pe.edu.upc.entities.Medico;
import pe.edu.upc.serviceinterfaces.IMedicoService;

@Named
public class MedicoServiceImpl implements IMedicoService {

	@Inject
	private IMedicoDao mDao;

	@Override
	public void insert(Medico m) {
		// TODO Auto-generated method stub
		mDao.insert(m);
	}

	@Override
	public List<Medico> list() {
		// TODO Auto-generated method stub
		return mDao.list();
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		mDao.delete(id);
	}

	@Override
	public void update(Medico m) {
		// TODO Auto-generated method stub
		mDao.update(m);
	}

	@Override
	public List<Medico> findByName(Medico p) {
		// TODO Auto-generated method stub
		return mDao.findByName(p);
	}

	@Override
	public List<Medico> findByLocation(Medico p) {
		// TODO Auto-generated method stub
		return mDao.findByLocation(p);
	}

}
