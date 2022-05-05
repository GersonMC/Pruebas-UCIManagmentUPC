package pe.edu.upc.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entities.Administrador;
import pe.edu.upc.entities.Cama;
import pe.edu.upc.entities.Hospital;
import pe.edu.upc.serviceinterfaces.IAdministradorService;
import pe.edu.upc.serviceinterfaces.ICamaService;
import pe.edu.upc.serviceinterfaces.IHospitalService;

@Named
@RequestScoped
public class CamaController {
	@Inject
	private ICamaService caService;

	@Inject
	private IHospitalService hService;

	@Inject
	private IAdministradorService aService;

	// atributos
	private Cama ca;
	List<Cama> listaCamas;
	List<Hospital> listaHospitales;
	List<Administrador> listaAdministradores;

	@PostConstruct
	public void init() {
		this.ca = new Cama();
		this.listaCamas = new ArrayList<Cama>();
		this.listaHospitales = new ArrayList<Hospital>();
		this.listaAdministradores = new ArrayList<Administrador>();
		this.list();
		this.listHospitales();
		this.listAdministradores();
	}

	public void insert() {
		try {
			caService.insert(ca);
		} catch (Exception e) {
			System.out.println("Error al insertar cama en el controlador");
		}
	}

	public void list() {
		try {
			listaCamas = caService.list();
		} catch (Exception e) {
			System.out.println("Error al listar camas en el controlador");
		}
	}

	public void listHospitales() {
		try {
			listaHospitales = hService.list();
		} catch (Exception e) {
			System.out.println("Error a l listar hospitales en el controlador cama");
		}
	}

	public void listAdministradores() {
		try {
			listaAdministradores = aService.list();
		} catch (Exception e) {
			System.out.println("Error a listar administrador en el controlador cama");
		}
	}

	public void delete(Cama cam) {
		try {
			caService.delete(cam.getIdCama());
			this.list();
		} catch (Exception e) {
			System.out.println("Error al eliminar en el controller cama");
		}
	}

	public String preUpdate(Cama ca) {
		this.setCa(ca);
		return "modificacionCama.xhtml";
	}

	public void update() {
		try {
			caService.update(this.ca);
		} catch (Exception e) {
			System.out.println("Error al modficar cama en el controller");
		}
	}
	
	public void findByNameCama() {
		try {
			listaCamas = caService.findbyNameCama(this.getCa());
		} catch (Exception e) {
			System.out.println("Error al buscar cama en el controlador");
		}
	}
	
	// getter and setters
	public Cama getCa() {
		return ca;
	}

	public void setCa(Cama ca) {
		this.ca = ca;
	}

	public List<Cama> getListaCamas() {
		return listaCamas;
	}

	public void setListaCamas(List<Cama> listaCamas) {
		this.listaCamas = listaCamas;
	}

	public List<Hospital> getListaHospitales() {
		return listaHospitales;
	}

	public void setListaHospitales(List<Hospital> listaHospitales) {
		this.listaHospitales = listaHospitales;
	}

	public List<Administrador> getListaAdministradores() {
		return listaAdministradores;
	}

	public void setListaAdministradores(List<Administrador> listaAdministradores) {
		this.listaAdministradores = listaAdministradores;
	}

}
