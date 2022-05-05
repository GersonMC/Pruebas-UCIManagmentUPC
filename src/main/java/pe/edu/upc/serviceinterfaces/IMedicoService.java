package pe.edu.upc.serviceinterfaces;

import java.util.List;

import pe.edu.upc.entities.Medico;

public interface IMedicoService {
	
	public void insert(Medico m);

	public List<Medico> list();

	public void delete(int id);

	public void update(Medico m);

	public List<Medico> findByName(Medico p);

	public List<Medico> findByLocation(Medico p);
}
