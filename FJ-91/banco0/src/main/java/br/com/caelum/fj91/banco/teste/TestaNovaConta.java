package br.com.caelum.fj91.banco.teste;

import java.sql.SQLException;

import br.com.caelum.fj91.banco.logica.Banco;
import br.com.caelum.fj91.banco.modelo.Cliente;
import br.com.caelum.fj91.banco.modelo.Conta;

public class TestaNovaConta {

	public void executa() {
		// dados do cliente pegos no formulário de cadastro
		String campoNome = "Joaquim Manoel";
		String campoCpf  = "123.456.789-10";
		
		// cria conta para o Joaquim
		Banco banco = new Banco();
		
		if (banco.consultaSerasa(campoCpf)) {
			try {
				
				Cliente titular = banco.registraCliente(campoNome, campoCpf);
				int numeroDaConta = banco.geraNumeroConta();
				Conta novaConta = banco.registraConta(titular, numeroDaConta);
				System.out.println("Nova conta registrada com sucesso: " + novaConta);
				
			} catch (SQLException e) {
				System.err.println("Problemas ao persistir no banco de dados");
			}
		} else {
			System.err.println("Cliente não passou na consulta ao Serasa");
		}
	}
	
	public static void main(String[] args) {
		new TestaNovaConta().executa();
	}
}
