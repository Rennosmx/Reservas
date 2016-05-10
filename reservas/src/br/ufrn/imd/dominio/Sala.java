package br.ufrn.imd.dominio;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Sala {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_SALA")
	@SequenceGenerator(name="SEQ_SALA",sequenceName="seq_sala", allocationSize=1)
	private int id;
	
	private String nome;

	@OneToMany(mappedBy="salaReservada", cascade=CascadeType.ALL)
	private List<Reserva> reservas;
	
	public Sala() {
		
	}
	
	public Sala(String nome, List<Reserva> reservas) {
		this.nome = nome;
		this.reservas = reservas;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	
}
