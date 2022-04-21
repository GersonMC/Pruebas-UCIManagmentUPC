package pe.edu.upc.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;


import pe.edu.upc.entities.Admin;
import pe.edu.upc.serviceinterfaces.AdminService;
import pe.edu.upc.serviceinterfaces.IPacienteService;

@Named
@RequestScoped
public class AdminController {
	@Inject
	private AdminService aService;

	//Atributos del admin
	private Admin a;
	private List<Admin> listaAdmin;

	// inicializamos
	@PostConstruct
	public void init() {
		this.listaAdmin = new ArrayList<Admin>();
		this.a = new Admin();
		this.list();
	}

	public String newAdmin() {
		this.setP(new Admin());
		return "paciente.xhtml";
	}

	public void insert() {
		try {
			pService.insert(a);
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

	// Los geterr y setters
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