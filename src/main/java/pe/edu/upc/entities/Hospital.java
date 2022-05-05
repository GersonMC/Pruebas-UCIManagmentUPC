package pe.edu.upc.entities;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Hospital")
public class Hospital {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idHospital;
	
	@ManyToOne
	@JoinColumn(name="idMedico")
	private Medico medico;
	
	@Column(name = "nombreHospital", nullable = false, length = 47)
	private String nombreHospital;
	
	@Column(name = "direccionHospital", nullable = false, length = 46)
	private String direccionHospital;

	public Hospital() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Hospital(int idHospital, Medico medico, String nombreHospital, String direccionHospital) {
		super();
		this.idHospital = idHospital;
		this.medico = medico;
		this.nombreHospital = nombreHospital;
		this.direccionHospital = direccionHospital;
	}


	public int getIdHospital() {
		return idHospital;
	}


	public void setIdHospital(int idHospital) {
		this.idHospital = idHospital;
	}


	public Medico getMedico() {
		return medico;
	}


	public void setMedico(Medico medico) {
		this.medico = medico;
	}


	public String getNombreHospital() {
		return nombreHospital;
	}


	public void setNombreHospital(String nombreHospital) {
		this.nombreHospital = nombreHospital;
	}


	public String getDireccionHospital() {
		return direccionHospital;
	}


	public void setDireccionHospital(String direccionHospital) {
		this.direccionHospital = direccionHospital;
	}


	@Override
	public int hashCode() {
		return Objects.hash(idHospital);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Hospital other = (Hospital) obj;
		return idHospital == other.idHospital;
	}

	
}
