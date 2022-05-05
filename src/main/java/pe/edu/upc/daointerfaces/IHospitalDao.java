package pe.edu.upc.daointerfaces;

import java.util.List;

import pe.edu.upc.entities.Hospital;

public interface IHospitalDao {
	
	public void insert(Hospital h);
	
	public List<Hospital> list();
	
	public void delete(int idHospital);
	
	public List<Hospital> findbyNameHospital(Hospital h);
	
	public void update(Hospital h);
	
}
