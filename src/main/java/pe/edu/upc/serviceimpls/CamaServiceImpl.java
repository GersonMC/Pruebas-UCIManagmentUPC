package pe.edu.upc.serviceimpls;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.daointerfaces.ICamaDao;
import pe.edu.upc.entities.Cama;
import pe.edu.upc.serviceinterfaces.ICamaService;

@Named
public class CamaServiceImpl implements ICamaService{

	@Inject
	private ICamaDao caDao;
	
	@Override
	public void insert(Cama c) {
		// TODO Auto-generated method stub
		caDao.insert(c);
	}

	@Override
	public List<Cama> list() {
		// TODO Auto-generated method stub
		return caDao.list();
	}

	@Override
	public void delete(int idCama) {
		// TODO Auto-generated method stub
		caDao.delete(idCama);
	}

	@Override
	public void update(Cama c) {
		caDao.update(c);
	}

	@Override
	public List<Cama> findbyNameCama(Cama ca) {
		// TODO Auto-generated method stub
		return caDao.findbyNameCama(ca);
	}

}
