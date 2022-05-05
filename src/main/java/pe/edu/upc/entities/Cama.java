package pe.edu.upc.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name ="Cama")
public class Cama {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idCama;
	
	@ManyToOne
	@JoinColumn(name="idHospital", nullable = false)
	private Hospital hospital;
	
	@ManyToOne
	@JoinColumn(name="idAdministrador", nullable = false)
	private Administrador administrador;
	
	@Column(name="pisoCama")
	private String pisoCama;
	
	@Column(name="disponibilidadCama")
	private String disponibilidadCama;
	
	public Cama() {
		super();
		//TODO Auto-generated constructor stub
	}

	public Cama(int idCama, Hospital hospital, Administrador administrador, String pisoCama,
			String disponibilidadCama) {
		super();
		this.idCama = idCama;
		this.hospital = hospital;
		this.administrador = administrador;
		this.pisoCama = pisoCama;
		this.disponibilidadCama = disponibilidadCama;
	}

	public int getIdCama() {
		return idCama;
	}

	public void setIdCama(int idCama) {
		this.idCama = idCama;
	}

	public Hospital getHospital() {
		return hospital;
	}

	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}

	public Administrador getAdministrador() {
		return administrador;
	}

	public void setAdministrador(Administrador administrador) {
		this.administrador = administrador;
	}

	public String getPisoCama() {
		return pisoCama;
	}

	public void setPisoCama(String pisoCama) {
		this.pisoCama = pisoCama;
	}

	public String getDisponibilidadCama() {
		return disponibilidadCama;
	}

	public void setDisponibilidadCama(String disponibilidadCama) {
		this.disponibilidadCama = disponibilidadCama;
	}
	
}
