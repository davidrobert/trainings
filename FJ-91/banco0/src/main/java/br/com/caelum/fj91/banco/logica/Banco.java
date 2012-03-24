package br.com.caelum.fj91.banco.logica;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.Random;

import br.com.caelum.fj91.banco.modelo.Cliente;
import br.com.caelum.fj91.banco.modelo.Conta;
import br.com.caelum.fj91.banco.persistencia.Dao;

public class Banco {

	/**
	 * Consulta se o CPF tem pendencias no Serasa
	 * @param cpf
	 * @return true se estiver tudo ok; false se algo estiver errado
	 */
	public boolean consultaSerasa(String cpf) {
		// faz uma consulta ao web service do serasa
		return true;
	}
	
	/**
	 * Registra um novo cliente no sistema
	 * @param campoNome Recebe valor digitado no formulário com o nome.
	 * @param campoCpf  Recebe valor digitado no formulário com o cpf.
	 * @return Novo cliente persistido no sistema
	 */
	private Cliente registraCliente(String campoNome, String campoCpf)  throws SQLException {
		// recebe os dados de um formulário, cria um cliente e guarda no banco de dados
		Cliente cliente = new Cliente(campoNome, campoCpf);
		
		Dao<Cliente> dao = new Dao<Cliente>();
		dao.adiciona(cliente);
		
		return cliente;
	}
	
	private static int geradorDeNumeros = 10000;
	
	/**
	 * Gera números para novas contas no banco
	 * @return Número da próxima conta
	 */
	private int geraNumeroConta() {
		geradorDeNumeros += new Random(42).nextInt(1000);
		return geradorDeNumeros++;
	}
	
	/**
	 * Registra nova conta no sistema
	 * @param titular Cliente titular da conta. Já deve ter sido aprovado na consulta ao Serasa.
	 * @param numero  Número da conta
	 * @return Nova Conta, aberta e registrada
	 */
	private Conta registraConta(Cliente titular, int numero) throws SQLException {
		Calendar hoje = Calendar.getInstance();
		
		Conta novaConta = new Conta(numero, hoje);
		
		novaConta.setTitular(titular);
		
		Dao<Conta> dao = new Dao<Conta>();
		dao.adiciona(novaConta);
		
		return novaConta;
	}

	public void criaNovaConta(String campoNome, String campoCpf) {
		if (consultaSerasa(campoCpf)) {
			try {
				
				Cliente titular = registraCliente(campoNome, campoCpf);
				int numeroDaConta = geraNumeroConta();
				Conta novaConta = registraConta(titular, numeroDaConta);
				System.out.println("Nova conta registrada com sucesso: " + novaConta);
				
			} catch (SQLException e) {
				System.err.println("Problemas ao persistir no banco de dados");
			}
		} else {
			System.err.println("Cliente não passou na consulta ao Serasa");
		}
	}
}
