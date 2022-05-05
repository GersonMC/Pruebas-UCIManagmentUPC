package pe.edu.upc.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entities.Medico;
import pe.edu.upc.serviceinterfaces.IMedicoService;

@Named
@RequestScoped
public class MedicoController {

	@Inject
	private IMedicoService mService;
	
	private Medico m;
	private List<Medico> listaMedico;
	
	@PostConstruct
	public void init() {
		this.listaMedico = new ArrayList<Medico>();
		this.m = new Medico();
		this.list();
	}
	
	public String newMedico() {
		this.setM(new Medico());
		return "medico.xhtml";
	}
	
	public void insert() {
		try {
			mService.insert(m);
		} catch (Exception e) {
			System.out.println("Error al insertar en el service" + e.getStackTrace());
		}

	}
	
	public void list() {
		try {
			listaMedico = mService.list();
		} catch (Exception e) {
			System.out.println("Error al insertar en el controller");
		}

	}
	
	public void delete(Medico me) {
		try {
			mService.delete(me.getIdMedico());
			this.list();
		} catch (Exception e) {
			System.out.println("Error al eliminar en el controller");
		}

	}
	
	public void findByName() {

		try {
			listaMedico = mService.findByName(this.getM());
		} catch (Exception e) {
			System.out.println("Error al buscar en el controller");
		}
	}

	public void findByNameLocation() {

		try {
			listaMedico = mService.findByLocation(this.getM());
		} catch (Exception e) {
			System.out.println("Error al buscar en el controller");
		}
	}
	
	public String preUpdate(Medico me) {

		this.setM(me);
		return "modificacionMedico.xhtml";

	}

	public void update() {
		try {
			mService.update(this.m);
		} catch (Exception e) {
			System.out.println("Error al modificar en el controller");
		}
	}

	public Medico getM() {
		return m;
	}

	public void setM(Medico m) {
		this.m = m;
	}

	public List<Medico> getListaMedico() {
		return listaMedico;
	}

	public void setListaMedico(List<Medico> listaMedico) {
		this.listaMedico = listaMedico;
	}
	
}
