package pe.edu.upc.serviceimpls;

import java.util.List;

import javax.inject.Inject;

import pe.edu.upc.daointerfaces.IEstadoReservaDao;
import pe.edu.upc.entities.EstadoReserva;
import pe.edu.upc.serviceinterfaces.IEstadoReservaService;

public class EstadoReservaServiceImpl implements IEstadoReservaService{

	@Inject
	private IEstadoReservaDao esDao;
	
	@Override
	public void insert(EstadoReserva es) {
		// TODO Auto-generated method stub
		esDao.insert(es);
	}

	@Override
	public List<EstadoReserva> list() {
		// TODO Auto-generated method stub
		return esDao.list();
	}

	@Override
	public void update(EstadoReserva es) {
		// TODO Auto-generated method stub
		esDao.update(es);
	}

	@Override
	public void delete(int idEstado) {
		// TODO Auto-generated method stub
		esDao.delete(idEstado);
	}

	@Override
	public List<EstadoReserva> findbyNameEstadoReserva(EstadoReserva es) {
		// TODO Auto-generated method stub
		return esDao.findbyNameEstadoReserva(es);
	}

}
