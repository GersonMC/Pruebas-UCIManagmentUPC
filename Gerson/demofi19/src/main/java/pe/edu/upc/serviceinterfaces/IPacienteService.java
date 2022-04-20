package pe.edu.upc.serviceinterfaces;

import java.util.List;

import pe.edu.upc.entities.Paciente;

public interface IPacienteService {
public void insert(Paciente p);
public List<Paciente>list();
public void delete(int id);
}
