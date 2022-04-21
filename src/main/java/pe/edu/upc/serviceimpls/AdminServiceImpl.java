package pe.edu.upc.serviceimpls;

import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.daointerfaces.AdminDao;
import pe.edu.upc.entities.Admin;
import pe.edu.upc.serviceinterfaces.AdminService;

@Named
public class AdminServiceImpl implements AdminService {

	@Inject
	private AdminDao aDao;

	@Override
	public void insert(Admin a) {

		aDao.insert(a);
	}

	@Override
	public List<Admin> list() {
		// TODO Auto-generated method stub
		return aDao.list();
	}
    
    
    @Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		aDao.delete(id);
	}



}
