package pe.edu.upc.serviceinterfaces;

import java.util.List;

import pe.edu.upc.entities.Hospital;

public interface IHospitalService {

	public void insert(Hospital h);

	public List<Hospital> list();

	public void delete(int idHospital);
	
	public void update(Hospital h);
	
	public List<Hospital> findbyNameHospital(Hospital h);
}
