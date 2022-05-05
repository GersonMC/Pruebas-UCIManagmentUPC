package pe.edu.upc.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entities.Hospital;
import pe.edu.upc.entities.Medico;
import pe.edu.upc.serviceinterfaces.IHospitalService;
import pe.edu.upc.serviceinterfaces.IMedicoService;

@Named
@RequestScoped
public class HospitalController {
	@Inject
	private IHospitalService pService;
	
	@Inject
	private IMedicoService mService;

	// atributos
	private Hospital h;
	private List<Hospital> listaHospitales;
	private List<Medico> listaMedicos;

	// inicializar
	@PostConstruct
	public void init() {
		this.h = new Hospital();
		this.listaHospitales = new ArrayList<Hospital>();
		this.listaMedicos = new ArrayList<Medico>();
		this.list();
		this.listMedicos();
	}

	// Métodos para atender peticiones

	public void insert() {
		try {
			pService.insert(h);

		} catch (Exception e) {

			System.out.println("Error al insertar en el controller" + e.getStackTrace());
		}

	}

	public void list() {
		try {
			listaHospitales = pService.list();
		} catch (Exception e) {
			System.out.println("Error al listar hospital en el controller");
		}
	}
	
	public void listMedicos() {
		try {
			listaMedicos = mService.list();
		} catch (Exception e) {
			System.out.println("Error al listar medicos en el controlador hospital");
		}
	}

	public void delete(Hospital hos) {
		try {
			pService.delete(hos.getIdHospital());
			this.list();
		} catch (Exception e) {
			System.out.println("Error al eliminar en el controller hospital");
		}
	}
	
	//buscar
	public void findByNameHospital() {
		try {
			listaHospitales=pService.findbyNameHospital(this.getH());
		} catch (Exception e) {
			System.out.println("Error al buscar hospital en controller");
		}
	}
	
	public String preUpdate(Hospital h) {
		this.setH(h);
		return "modificacionHospital.xhtml";
	}
	
	public void update() {
		try {
			pService.update(this.h);
		} catch (Exception e) {
			System.out.println("Error al modificar hospital en el controller");
		}
	}

	
	// getter and setter
	public Hospital getH() {
		return h;
	}

	public void setH(Hospital h) {
		this.h = h;
	}

	public List<Hospital> getListaHospitales() {
		return listaHospitales;
	}

	public void setListaHospitales(List<Hospital> listaHospitales) {
		this.listaHospitales = listaHospitales;
	}

	public List<Medico> getListaMedicos() {
		return listaMedicos;
	}

	public void setListaMedicos(List<Medico> listaMedicos) {
		this.listaMedicos = listaMedicos;
	}


}
