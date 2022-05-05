package pe.edu.upc.serviceimpls;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.daointerfaces.IAdministradorDao;
import pe.edu.upc.entities.Administrador;
import pe.edu.upc.serviceinterfaces.IAdministradorService;

@Named
public class AdministradorServiceImpl implements IAdministradorService{
	
	@Inject
	private IAdministradorDao pDao;
	@Override
	public void insert(Administrador a) {
		pDao.insert(a);
	}

	@Override
	public List<Administrador> list() {
		// TODO Auto-generated method stub
		return pDao.list();
	}

	@Override
	public void delete(int idAdministrador) {
		// TODO Auto-generated method stub
		pDao.delete(idAdministrador);
	}

	@Override
	public void update(Administrador a) {
		// TODO Auto-generated method stub
		pDao.update(a);
	}

	@Override
	public List<Administrador> findbyNameAdministrador(Administrador a) {
		// TODO Auto-generated method stub
		return pDao.findByNameAdministrador(a);
	}

}
