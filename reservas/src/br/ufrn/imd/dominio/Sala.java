package br.ufrn.imd.dominio;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Sala {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_SALA")
	@SequenceGenerator(name="SEQ_SALA",sequenceName="seq_sala", allocationSize=1)
	private int id;
	
	private String nome;

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
