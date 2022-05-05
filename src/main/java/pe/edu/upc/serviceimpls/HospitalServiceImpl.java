package pe.edu.upc.serviceimpls;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.daointerfaces.IHospitalDao;
import pe.edu.upc.entities.Hospital;
import pe.edu.upc.serviceinterfaces.IHospitalService;

@Named
public class HospitalServiceImpl implements IHospitalService {

	@Inject
	private IHospitalDao pDao;
	
	@Override
	public void insert(Hospital h) {
		// TODO Auto-generated method stub
		pDao.insert(h);
		
	}

	@Override
	public List<Hospital> list() {
		// TODO Auto-generated method stub
		return pDao.list();
	}

	@Override
	public void delete(int idHospital) {
		// TODO Auto-generated method stub
		pDao.delete(idHospital);
	}

	@Override
	public List<Hospital> findbyNameHospital(Hospital h) {
		// TODO Auto-generated method stub
		return pDao.findbyNameHospital(h);
	}

	@Override
	public void update(Hospital h) {
		// TODO Auto-generated method stub
		pDao.update(h);
	}
	
}
