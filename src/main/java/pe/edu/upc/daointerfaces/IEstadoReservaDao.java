package pe.edu.upc.daointerfaces;

import java.util.List;

import pe.edu.upc.entities.EstadoReserva;

public interface IEstadoReservaDao {

	public void insert(EstadoReserva es);
	
	public List<EstadoReserva> list();
	
	public void update(EstadoReserva es);
	
	public void delete(int idEstado);
	
	public List<EstadoReserva> findbyNameEstadoReserva(EstadoReserva es);
}
