package pe.edu.upc.entities;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Medico")
public class Medico {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idMedico;
	@Column(name = "fullnameMedico",nullable=false,length=47)
	private String fullnameMedico;
	@Column(name = "fechaNacimiento",nullable=false)
	private Date fechaNacimiento;
	@Column(name = "correoMedico",nullable=false,length=47)
	private String correoMedico;
	@Column(name = "direccionMedico",nullable=false,length=47)
	private String direccionMedico;
	@Column(name = "numCelularMedico",nullable=false,length=47)
	private String numCelularMedico;
	
	public Medico() {
		super();
		//TODO Auto-generated constructor stub
	}

	public Medico(int idMedico, String fullnameMedico, Date fechaNacimiento, String correoMedico,
			String direccionMedico, String numCelularMedico) {
		super();
		this.idMedico = idMedico;
		this.fullnameMedico = fullnameMedico;
		this.fechaNacimiento = fechaNacimiento;
		this.correoMedico = correoMedico;
		this.direccionMedico = direccionMedico;
		this.numCelularMedico = numCelularMedico;
	}

	public int getIdMedico() {
		return idMedico;
	}

	public void setIdMedico(int idMedico) {
		this.idMedico = idMedico;
	}

	public String getFullnameMedico() {
		return fullnameMedico;
	}

	public void setFullnameMedico(String fullnameMedico) {
		this.fullnameMedico = fullnameMedico;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getCorreoMedico() {
		return correoMedico;
	}

	public void setCorreoMedico(String correoMedico) {
		this.correoMedico = correoMedico;
	}

	public String getDireccionMedico() {
		return direccionMedico;
	}

	public void setDireccionMedico(String direccionMedico) {
		this.direccionMedico = direccionMedico;
	}

	public String getNumCelularMedico() {
		return numCelularMedico;
	}

	public void setNumCelularMedico(String numCelularMedico) {
		this.numCelularMedico = numCelularMedico;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idMedico);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Medico other = (Medico) obj;
		return idMedico == other.idMedico;
	}
	
	
}
