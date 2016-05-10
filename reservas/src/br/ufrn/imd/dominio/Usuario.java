package br.ufrn.imd.dominio;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Usuario {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, 
	generator="SEQ_USUARIO")
	@SequenceGenerator(name="SEQ_USUARIO",
	sequenceName="seq_usuario", allocationSize=1)
	private int id;
	
	private String login;
	
	private String senha;
	
	private String nome;

	@OneToMany(mappedBy="usuarioAssociado")
	private List<Reserva> reservas;
	
	public Usuario() { }
	
	public Usuario(String login, String senha) {
		this.login = login;
		this.senha = senha;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
}
