package pe.edu.upc.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entities.EstadoReserva;
import pe.edu.upc.entities.Reserva;
import pe.edu.upc.serviceinterfaces.IEstadoReservaService;
import pe.edu.upc.serviceinterfaces.IReservaService;

@Named
@RequestScoped
public class EstadoReservaController {
	@Inject
	private IEstadoReservaService esService;
	@Inject
	private IReservaService reService;
	
	//atributos
	private EstadoReserva es;
	List<EstadoReserva> listaEstadoReservas;
	List<Reserva> listaReservas;
	
	@PostConstruct
	public void init() {
		this.es =new EstadoReserva();
		this.listaEstadoReservas = new ArrayList<EstadoReserva>();
		this.listaReservas = new ArrayList<Reserva>();
		
	}
	
	public void insert() {
		try {
			esService.insert(es);
		} catch (Exception e) {
			System.out.println("Error al insertar Estado de reserva en el controlador");
		}
	}

	public void list() {
		try {
			listaEstadoReservas = esService.list();
		} catch (Exception e) {
			System.out.println("Error al listar Estado de reserva en el controlador");
		}
	}
	
	public void listReserva() {
		try {
			listaReservas = reService.list();
		} catch (Exception e) {
			System.out.println("Error a listar Reserva en el controlador Estado de reserva");
		}
	}
	
	public void delete(EstadoReserva ess) {
		try {
			esService.delete(ess.getIdEstadoReserva());
			this.list();;
		} catch (Exception e) {
			System.out.println("Error al eliminar en el controller cama");
		}
	}

	public String preUpdate(EstadoReserva ess) {
		this.setEs(ess);
		return "modificacionEstadoReserva.xhtml";
	}
	
	public void update() {
		try {
			esService.update(es);
		} catch (Exception e) {
			System.out.println("Error al modficar Estado de reserva en el controller");
		}
	}
	
	public void findByNameEstadoReserva() {
		try {
			listaEstadoReservas = esService.findbyNameEstadoReserva(this.getEs());
		} catch (Exception e) {
			System.out.println("Error al buscar Estado Reserva en el controlador");
		}
	}
	
	//getter an d setters
	public EstadoReserva getEs() {
		return es;
	}

	public void setEs(EstadoReserva es) {
		this.es = es;
	}

	public List<EstadoReserva> getListaEstadoReservas() {
		return listaEstadoReservas;
	}

	public void setListaEstadoReservas(List<EstadoReserva> listaEstadoReservas) {
		this.listaEstadoReservas = listaEstadoReservas;
	}

	public List<Reserva> getListaReservas() {
		return listaReservas;
	}

	public void setListaReservas(List<Reserva> listaReservas) {
		this.listaReservas = listaReservas;
	}
	
	
}
