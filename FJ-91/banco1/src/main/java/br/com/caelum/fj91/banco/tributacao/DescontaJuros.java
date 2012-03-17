package br.com.caelum.fj91.banco.tributacao;

import java.math.BigDecimal;

import br.com.caelum.fj91.banco.modelo.Conta;

/**
 * Aplica uma certa taxa de juros ao valor negativo do saldo da Conta. 
 */
public class DescontaJuros {

	private final BigDecimal taxaDeJuros;
	public DescontaJuros(BigDecimal taxaDeJuros) {
		this.taxaDeJuros = taxaDeJuros;
	}
	
	public BigDecimal calculaDesconto(Conta conta) {
		BigDecimal desconto = BigDecimal.ZERO;
		
		if (conta.estaNegativa()) {
			BigDecimal valorEmprestado = conta.getSaldo().abs();
			desconto = valorEmprestado.multiply(taxaDeJuros);
		}
		
		return desconto;
	}
}
