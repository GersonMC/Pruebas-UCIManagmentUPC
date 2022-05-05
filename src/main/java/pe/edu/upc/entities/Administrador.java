package pe.edu.upc.entities;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Administrador")
public class Administrador {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idAdministrador;
	@Column(name = "userAdmin", nullable = false, length = 47)
	private String userAdmin;
	@Column(name = "userPassword", nullable = false, length = 46)
	private String userPassword;

	public Administrador() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Administrador(int idAdministrador, String userAdmin, String userPassword) {
		super();
		this.idAdministrador = idAdministrador;
		this.userAdmin = userAdmin;
		this.userPassword = userPassword;
	}

	public int getIdAdministrador() {
		return idAdministrador;
	}

	public void setIdAdministrador(int idAdministrador) {
		this.idAdministrador = idAdministrador;
	}

	public String getUserAdmin() {
		return userAdmin;
	}

	public void setUserAdmin(String userAdmin) {
		this.userAdmin = userAdmin;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idAdministrador);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Administrador other = (Administrador) obj;
		return idAdministrador == other.idAdministrador;
	}

	
	
}
