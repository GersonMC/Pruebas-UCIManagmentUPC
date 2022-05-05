package pe.edu.upc.serviceimpls;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.daointerfaces.IReservaDao;
import pe.edu.upc.entities.Reserva;
import pe.edu.upc.serviceinterfaces.IReservaService;

@Named
public class ReservaServiceImpl implements IReservaService{

	@Inject
	private IReservaDao resDao;

	@Override
	public void insert(Reserva r) {
		resDao.insert(r);;
	}

	@Override
	public List<Reserva> list() {
		return resDao.list();
	}

	@Override
	public void delete(int idReserva) {
	resDao.delete(idReserva);
	}

	@Override
	public void update(Reserva r) {
		resDao.update(r);
		
	}

	@Override
	public List<Reserva> fBPaciente(Reserva r) {
		return resDao.fBPaciente(r);
	}
}
