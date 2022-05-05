package pe.edu.upc.daointerfaces;

import java.util.List;

import pe.edu.upc.entities.Medico;

public interface IMedicoDao {
	
	public void insert(Medico m);

	public List<Medico> list();

	public void delete(int id);

	public void update(Medico m);

	public List<Medico> findByName(Medico m);
	
	public List<Medico> findByLocation(Medico m);
}
