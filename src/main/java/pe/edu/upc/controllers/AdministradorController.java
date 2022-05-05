package pe.edu.upc.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entities.Administrador;
import pe.edu.upc.serviceinterfaces.IAdministradorService;

@Named
@RequestScoped
public class AdministradorController {
	@Inject
	private IAdministradorService pService;

	// atributos
	private Administrador a;
	private List<Administrador> listaAdministradores;

	// inicializar
	@PostConstruct
	public void init() {
		this.a= new Administrador();
		this.listaAdministradores = new ArrayList<Administrador>();
		this.list();
	}

	public String newAdministrador() {
		this.setA(new Administrador());
		return "Administrador.xhtml";
	}

	public void insert() {
		try {
			pService.insert(a);
		} catch (Exception e) {
			System.out.println("Error al insertar en el controller" + e.getStackTrace());
		}
	}

	public void list() {
		try {
			listaAdministradores = pService.list();
		} catch (Exception e) {
			System.out.println("Error al listar en el controller");
		}
	}

	
	public void delete(Administrador adm) {
		try {
			pService.delete(adm.getIdAdministrador());
			this.list();
		} catch (Exception e) {
			System.out.println("Error al eliminar en el controller administrador");
		}
	}

	public void findByNameAdministrador() {
		try {
			listaAdministradores = pService.findbyNameAdministrador(this.getA());
		} catch (Exception e) {
			System.out.println("Error al buscar administrador en el controller");
		}
	}
	
	public String preUpdate(Administrador a) {
		this.setA(a);
		return "modificacionAdministrador";
	}
	
	public void update() {
		try {
			pService.update(this.a);
		} catch (Exception e) {
			System.out.println("Error al modficar Administrador en el controller");
		}
	}
	
	// getter and setter
	public Administrador getA() {
		return a;
	}

	public void setA(Administrador a) {
		this.a = a;
	}

	public List<Administrador> getListaAdministradores() {
		return listaAdministradores;
	}

	public void setListaAdministradores(List<Administrador> listaAdministradores) {
		this.listaAdministradores = listaAdministradores;
	}

}
