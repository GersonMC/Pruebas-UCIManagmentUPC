package pe.edu.upc.daointerfaces;

import java.util.List;

import pe.edu.upc.entities.Administrador;

public interface IAdministradorDao {
	
	public void insert(Administrador a);
	public List<Administrador> list();
	public void delete(int idAdministrador);
	public void update(Administrador a);
	public List<Administrador> findByNameAdministrador(Administrador a);

}
