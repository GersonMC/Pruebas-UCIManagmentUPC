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
@Table(name ="EstadoReserva")
public class EstadoReserva {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idEstadoReserva;
	
	@ManyToOne
	@JoinColumn(name="idReserva", nullable = false)
	private Reserva reserva;
	
	@Column(name="estado")
	private String estado;

	public EstadoReserva() {
		super();
		//TODO Auto-generated constructor stub
	}

	public EstadoReserva(int idEstadoReserva, Reserva reserva, String estado) {
		super();
		this.idEstadoReserva = idEstadoReserva;
		this.reserva = reserva;
		this.estado = estado;
	}

	public int getIdEstadoReserva() {
		return idEstadoReserva;
	}

	public void setIdEstadoReserva(int idEstadoReserva) {
		this.idEstadoReserva = idEstadoReserva;
	}

	public Reserva getReserva() {
		return reserva;
	}

	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
}
