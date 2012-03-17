package br.com.caelum.fj91.rest.modelo;

public class User {

	private Integer id;
	private String nome,login;
	
	public User(Integer id, String nome, String login) {
		super();
		this.nome = nome;
		this.login = login;
		this.id = id;
	}

	public User() {
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
