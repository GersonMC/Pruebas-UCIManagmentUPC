package pe.edu.upc.serviceinterfaces;

import java.util.List;

import pe.edu.upc.entities.Administrador;

public interface IAdministradorService {
	
	public void insert(Administrador a);

	public List<Administrador> list();

	public void delete(int idAdministrador);
	
	public void update(Administrador a);
	
	public List<Administrador> findbyNameAdministrador(Administrador a);
	
}
