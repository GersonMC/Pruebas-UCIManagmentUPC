package pe.edu.upc.controllers;

import pe.edu.upc.entities.Reserva;
import pe.edu.upc.entities.Paciente;
import pe.edu.upc.entities.Hospital;

import pe.edu.upc.serviceinterfaces.IReservaService;
import pe.edu.upc.serviceinterfaces.IHospitalService;
import pe.edu.upc.serviceinterfaces.IPacienteService;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class ReservaController {
	@Inject
	private IReservaService reService;

	@Inject
	private IHospitalService hosService;

	@Inject
	private IPacienteService pasService;

	// ATRIBUTOS
	private Reserva r;
	List<Hospital> listaHospitales;
	List<Paciente> listaPacientes;
	List<Reserva> listaReservas;

	// INICIAR
	@PostConstruct
	public void init() {
		this.r = new Reserva();
		this.listaReservas = new ArrayList<Reserva>();
		this.listaPacientes = new ArrayList<Paciente>();
		this.listaHospitales = new ArrayList<Hospital>();
		this.list();
		this.listPacientes();
		this.listHospitales();

	}

	public void insert() {
		try {
			reService.insert(r);
		} catch (Exception e) {
			System.out.println("Error al insertar reserva en el controlador");
		}
	}

	public void list() {
		try {
			listaReservas = reService.list();
		} catch (Exception e) {
			System.out.println("Error al listar reservas en el controlador");
		}
	}

	public void listHospitales() {
		try {
			listaHospitales = hosService.list();
		} catch (Exception e) {
			System.out.println("Error al listar hospitales en controlador reserva");
		}
	}

	public void listPacientes() {
		try {
			listaPacientes = pasService.list();
		} catch (Exception e) {
			System.out.println("Error a listar pacientes en el controlador reservas");
		}
	}

	public void delete(Reserva r) {
		try {
			reService.delete(r.getIdReserva());
			this.list();
		} catch (Exception e) {
			System.out.println("Error al eliminar en controlador reserva :(");
		}
	}

	public String preUpdate(Reserva r) {
		this.setR(r);
		return "modificarReserva.xhtml";
	}

	public void update() {
		try {
			reService.update(this.r);
		} catch (Exception e) {
			System.out.println("Error al modficar reserva en el controller");
		}
	}

	public void FBPaciente() {
		try {
			listaReservas = reService.fBPaciente(getR());
		} catch (Exception e) {
			System.out.println("Error al buscar reserva en el controlador");
		}
	}

	// GETTER AND SETTERS
	public Reserva getR() {
		return r;
	}

	public void setR(Reserva r) {
		this.r = r;
	}

	public List<Hospital> getListaHospitales() {
		return listaHospitales;
	}

	public void setListaHospitales(List<Hospital> listaHospitales) {
		this.listaHospitales = listaHospitales;
	}

	public List<Paciente> getListaPacientes() {
		return listaPacientes;
	}

	public void setListaPacientes(List<Paciente> listaPacientes) {
		this.listaPacientes = listaPacientes;
	}

	public List<Reserva> getListaReservas() {
		return listaReservas;
	}

	public void setListaReservas(List<Reserva> listaReservas) {
		this.listaReservas = listaReservas;
	}

}
