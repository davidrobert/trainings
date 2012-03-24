package br.com.caelum.fj91.banco.modelo;

public class Cliente {

	private String nome;
	private String cpf;
	
	public Cliente(String nome, String cpf) {
		setNome(nome);
		setCpf(cpf);
	}
	
	public String getNome() {
		return nome;
	}
	
	private void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	private void setCpf(String cpf) {
		this.cpf = cpf;
	}
}
