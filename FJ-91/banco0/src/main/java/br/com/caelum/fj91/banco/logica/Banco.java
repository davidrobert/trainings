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
	public Cliente registraCliente(String campoNome, String campoCpf)  throws SQLException {
		// recebe os dados de um formulário, cria um cliente e guarda no banco de dados
		Cliente cliente = new Cliente();
		cliente.setCpf(campoCpf);
		cliente.setNome(campoNome);
		
		Dao<Cliente> dao = new Dao<Cliente>();
		dao.adiciona(cliente);
		
		return cliente;
	}
	
	private static int geradorDeNumeros = 10000;
	
	/**
	 * Gera números para novas contas no banco
	 * @return Número da próxima conta
	 */
	public int geraNumeroConta() {
		geradorDeNumeros += new Random(42).nextInt(1000);
		return geradorDeNumeros++;
	}
	
	/**
	 * Registra nova conta no sistema
	 * @param titular Cliente titular da conta. Já deve ter sido aprovado na consulta ao Serasa.
	 * @param numero  Número da conta
	 * @return Nova Conta, aberta e registrada
	 */
	public Conta registraConta(Cliente titular, int numero) throws SQLException {
		Calendar hoje = Calendar.getInstance();
		
		Conta novaConta = new Conta();
		novaConta.setNumero(numero);
		novaConta.setDataAbertura(hoje);

		// TODO vamos precisar usar o construtor de Conta
		// Conta novaConta = new Conta(numero, hoje);
		
		novaConta.setTitular(titular);
		
		Dao<Conta> dao = new Dao<Conta>();
		dao.adiciona(novaConta);
		
		return novaConta;
	}
}
