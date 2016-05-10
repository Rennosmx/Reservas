package br.ufrn.imd.dominio;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
public class Reserva {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_RESERVA")
	@SequenceGenerator(name="SEQ_RESERVA",sequenceName="seq_reserva", allocationSize=1)
	private int id;
	
	@ManyToOne
	@JoinColumn(name="id_usuario_associado")
	private Usuario usuarioAssociado;

	@ManyToOne
	@JoinColumn(name="id_sala_reservada")	
	private Sala salaReservada;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataDeReserva;

	private String alunoCadastrado;
	
	public Reserva(){
		salaReservada = new Sala();
	}

	public String getAlunoCadastrado() {
		return alunoCadastrado;
	}

	public void setAlunoCadastrado(String alunoCadastrado) {
		this.alunoCadastrado = alunoCadastrado;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Usuario getUsuarioAssociado() {
		return usuarioAssociado;
	}

	public void setUsuarioAssociado(Usuario usarioAssociado) {
		this.usuarioAssociado = usarioAssociado;
	}

	public Sala getSalaReservada() {
		return salaReservada;
	}

	public void setSalaReservada(Sala salaReservada) {
		this.salaReservada = salaReservada;
	}

	public Date getDataDeReserva() {
		return dataDeReserva;
	}

	public void setDataDeReserva(Date dataDeReserva) {
		this.dataDeReserva = dataDeReserva;
	}
	
	

}
