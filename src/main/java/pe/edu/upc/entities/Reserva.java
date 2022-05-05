package pe.edu.upc.entities;
import java.util.Date;
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
@Table(name = "Reserva")
public class Reserva {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idReserva;

	@ManyToOne
	@JoinColumn(name="idPaciente", nullable = false)
	private Paciente paciente;
	
	@ManyToOne
	@JoinColumn(name="idHospital", nullable = false)
	private Hospital hospital;
			
	@Column(name = "FechaReserva", nullable = false)
	private Date FechaReserva;
	
	public Reserva() {
		super();
		//TODO Auto-generated constructor stub
	}

	public Reserva(int idReserva, Hospital hospital, Paciente paciente, Date fechaReserva) {
		super();
		this.idReserva = idReserva;
		this.hospital = hospital;
		this.paciente = paciente;
		this.FechaReserva = fechaReserva;
	}

	public int getIdReserva() {
		return idReserva;
	}

	public void setIdReserva(int idReserva) {
		this.idReserva = idReserva;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Hospital getHospital() {
		return hospital;
	}

	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}

	public Date getFechaReserva() {
		return FechaReserva;
	}

	public void setFechaReserva(Date fechaReserva) {
		FechaReserva = fechaReserva;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idReserva);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reserva other = (Reserva) obj;
		return idReserva == other.idReserva;
	}


	

}
