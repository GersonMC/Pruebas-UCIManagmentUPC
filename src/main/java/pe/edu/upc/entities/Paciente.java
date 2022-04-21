package pe.edu.upc.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Paciente")
public class Paciente {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idPaciente;
	
	
	@Column(name = "fullnamePaciente",nullable=false,length=47)
	private String fullnamePaciente;

	@Column(name = "fechaNacimiento",nullable=false)
	private Date fechaNacimiento;
	
	@Column(name = "correoPaciente",nullable=false,length=47)
	private String correoPaciente;
	
	@Column(name = "direccionPaciente",nullable=false,length=47)
	private String direccionPaciente;
	
	@Column(name = "numCelularPaciente",nullable=false,length=47)
	private String numCelularPaciente;

	public Paciente() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Paciente(int idPaciente, String fullnamePaciente, Date fechaNacimiento, String correoPaciente,
			String direccionPaciente, String numCelularPaciente) {
		super();
		this.idPaciente = idPaciente;
		this.fullnamePaciente = fullnamePaciente;
		this.fechaNacimiento = fechaNacimiento;
		this.correoPaciente = correoPaciente;
		this.direccionPaciente = direccionPaciente;
		this.numCelularPaciente = numCelularPaciente;
	}

	public int getIdPaciente() {
		return idPaciente;
	}

	public void setIdPaciente(int idPaciente) {
		this.idPaciente = idPaciente;
	}

	public String getFullnamePaciente() {
		return fullnamePaciente;
	}

	public void setFullnamePaciente(String fullnamePaciente) {
		this.fullnamePaciente = fullnamePaciente;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getCorreoPaciente() {
		return correoPaciente;
	}

	public void setCorreoPaciente(String correoPaciente) {
		this.correoPaciente = correoPaciente;
	}

	public String getDireccionPaciente() {
		return direccionPaciente;
	}

	public void setDireccionPaciente(String direccionPaciente) {
		this.direccionPaciente = direccionPaciente;
	}

	public String getNumCelularPaciente() {
		return numCelularPaciente;
	}

	public void setNumCelularPaciente(String numCelularPaciente) {
		this.numCelularPaciente = numCelularPaciente;
	}

}
