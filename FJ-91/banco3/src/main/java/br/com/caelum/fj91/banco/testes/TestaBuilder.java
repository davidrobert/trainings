package br.com.caelum.fj91.banco.testes;

import java.math.BigDecimal;

import br.com.caelum.fj91.banco.modelo.Conta;
import br.com.caelum.fj91.banco.modelo.ContaBuilder;

public class TestaBuilder {

	public static void main(String[] args) {
		
		Conta conta = ContaBuilder.novaConta()
					.comNumero(456)
					.comDataDeAbertura(2011, 10, 29)
					.eDepositoInicial("100")
					.toConta();

		conta.saca(new BigDecimal("50"));
		
		System.out.println(conta.getSaldo());
	}
}
