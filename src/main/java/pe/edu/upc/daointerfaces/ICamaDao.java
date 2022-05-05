package pe.edu.upc.daointerfaces;

import java.util.List;

import pe.edu.upc.entities.Cama;

public interface ICamaDao {

	public void insert(Cama ca);

	public List<Cama> list();

	public void update(Cama ca);

	public void delete(int idCama);
	
	public List<Cama> findbyNameCama(Cama ca);
}
