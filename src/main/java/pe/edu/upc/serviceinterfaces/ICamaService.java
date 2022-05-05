package pe.edu.upc.serviceinterfaces;

import java.util.List;
import pe.edu.upc.entities.Cama;


public interface ICamaService {
	public void insert(Cama c);

	public List<Cama> list();

	public void delete(int idCama);
	
	public void update(Cama c);
	
	public List<Cama> findbyNameCama(Cama ca);
}
