package pe.edu.upc.serviceinterfaces;

import java.util.List;

import pe.edu.upc.entities.Admin;

public interface AdminService {
	public void insert(Admin a);
	public List<Admin>list();
	public void delete(int id);
}
