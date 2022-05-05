package pe.edu.upc.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entities.Paciente;
import pe.edu.upc.serviceinterfaces.IPacienteService;

@Named
@RequestScoped
public class PacienteController {

	@Inject
	private IPacienteService pService;

	private Paciente p;
	private List<Paciente> listaPaciente;
	
	@PostConstruct
	public void init() {
		this.listaPaciente = new ArrayList<Paciente>();
		this.p = new Paciente();
		this.list();
	}
	
	public String newPaciente() {
		this.setP(new Paciente());
		return "paciente.xhtml";
	}

	public void insert() {
		try {
			pService.insert(p);
		} catch (Exception e) {
			System.out.println("Error al insertar en el service" + e.getStackTrace());
		}

	}
	
	public void list() {
		try {
			listaPaciente = pService.list();
		} catch (Exception e) {
			System.out.println("Error al insertar en el controller");
		}

	}
	
	public void delete(Paciente pa) {
		try {
			pService.delete(pa.getIdPaciente());
			this.list();
		} catch (Exception e) {
			System.out.println("Error al eliminar en el controller");
		}

	}
	
	public void findByName() {

		try {
			listaPaciente = pService.findByName(this.getP());
		} catch (Exception e) {
			System.out.println("Error al buscar en el controller");
		}
	}

	/// Modificar
	public String preUpdate(Paciente pa) {

		this.setP(pa);
		return "modificacionPaciente.xhtml";

	}

	public void update() {
		try {
			pService.update(this.p);
		} catch (Exception e) {
			System.out.println("Error al modificar en el controller");
		}
	}

	public Paciente getP() {
		return p;
	}

	public void setP(Paciente p) {
		this.p = p;
	}

	public List<Paciente> getListaPaciente() {
		return listaPaciente;
	}

	public void setListaPaciente(List<Paciente> listaPaciente) {
		this.listaPaciente = listaPaciente;
	}
	
	
}
