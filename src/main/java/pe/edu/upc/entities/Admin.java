package pe.edu.upc.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Administrador")
public class Admin {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idAdmin;
	
	
	@Column(name = "fullnameAdmin",nullable=false,length=47)
	private String fullnameAdmin;
	
	@Column(name = "passwordAdmin",nullable=false,length=40)
	private String passwordAdmin;

	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Admin(int idAdmin, String fullnameAdmin,  String passwordAdmin) {
		super();
		this.idAdmin = idAdmin;
		this.fullnameAdmin = fullnameAdmin;
		this.passwordAdmin = passwordAdmin;
	
	}

	public int getidAdmin() {
		return idAdmin;
	}

	public void setidAdmin(int idAdmin) {
		this.idAdmin = idAdmin;
	}

	public String getfullnameAdmin() {
		return fullnameAdmin;
	}

	public void setfullnameAdmin(String fullnameAdmin) {
		this.fullnameAdmin = fullnameAdmin;
	}

	public String getFullnamePaciente() {
		return passwordAdmin;
	}

	public void setFullnamePaciente(String passwordAdmin) {
		this.passwordAdmin = passwordAdmin;
	}

	
}
