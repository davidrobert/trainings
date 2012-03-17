package br.com.caelum.fj91.banco.tributacao;

import java.math.BigDecimal;

import br.com.caelum.fj91.banco.modelo.Conta;

/**
 * Todas as contas com saldo negativo devem pagar uma taxa mensal
 * de 50 reais pelo uso do Cheque Especial. 
 */
public class TributaUsoDoChequeEspecial implements Tributo {
	
	/* (non-Javadoc)
	 * @see br.com.caelum.fj91.banco.tributacao.Tributo#calculaDesconto(br.com.caelum.fj91.banco.modelo.Conta)
	 */
	@Override
	public BigDecimal calculaDesconto(Conta conta) {
		if (conta.estaNegativa()) {
			return new BigDecimal("50");
		} else {
			return BigDecimal.ZERO;
		}
	}
}
