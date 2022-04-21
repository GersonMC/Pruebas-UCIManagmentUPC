package pe.edu.upc.daointerfaces;

import java.util.List;

import pe.edu.upc.entities.Admin;

public interface AdminDao {
public void insert(Admin a);
public List<Admin> list();	

public void delete (int id);
}
