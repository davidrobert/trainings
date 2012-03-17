package br.com.caelum.fj91.banco.logica;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.Random;

import br.com.caelum.fj91.banco.modelo.Cliente;
import br.com.caelum.fj91.banco.modelo.Conta;
import br.com.caelum.fj91.banco.persistencia.Dao;

public class Banco {

	/**
	 * Abre uma nova Conta para o cliente.
	 * @param campoNome Nome digitado no campo do formulário.
	 * @param campoCpf CPF digitado no campo do formulário.
	 * @return Nova Conta aberta no sistema
	 */
	public Conta novaConta(String campoNome, String campoCpf) {
		if (this.consultaSerasa(campoCpf)) {
			try {
				
				Cliente titular = this.registraCliente(campoNome, campoCpf);
				int numeroDaConta = this.geraNumeroConta();
				Conta novaConta = this.registraConta(titular, numeroDaConta);
				
				return novaConta;
			} catch (SQLException e) {
				throw new RuntimeException("Problemas de infraestrutura", e);
			}
		} else {
			throw new RuntimeException("Cliente não passou na consulta ao Serasa");
		}
	}
	
	// métodos auxiliares, não expostos na interface pública
	
	private boolean consultaSerasa(String cpf) {
		// faz uma consulta ao web service do serasa
		return true;
	}
	
	private Cliente registraCliente(String campoNome, String campoCpf)  throws SQLException {
		// recebe os dados de um formulário, cria um cliente e guarda no banco de dados
		Cliente cliente = new Cliente();
		cliente.setCpf(campoCpf);
		cliente.setNome(campoNome);
		
		Dao<Cliente> dao = new Dao<Cliente>();
		dao.adiciona(cliente);
		
		return cliente;
	}
	
	private static int geradorDeNumeros = 10000;
	private int geraNumeroConta() {
		geradorDeNumeros += new Random(42).nextInt(1000);
		return geradorDeNumeros++;
	}
	
	private Conta registraConta(Cliente titular, int numero) throws SQLException {
		Calendar hoje = Calendar.getInstance();
		
		Conta novaConta = new Conta(numero, hoje);
		novaConta.setTitular(titular);
		
		Dao<Conta> dao = new Dao<Conta>();
		dao.adiciona(novaConta);
		
		return novaConta;
	}
}
