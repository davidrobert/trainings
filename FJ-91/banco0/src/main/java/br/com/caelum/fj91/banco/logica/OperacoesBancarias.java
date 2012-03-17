package br.com.caelum.fj91.banco.logica;

import java.math.BigDecimal;

import br.com.caelum.fj91.banco.modelo.Conta;

/**
 * Operações necessárias para nosso Banco
 * 
 *  TODO será que esses métodos estão em um bom lugar?
 *       aqui, parecem funções estáticas!
 */
public class OperacoesBancarias {

	/**
	 * Saca dinheiro de uma conta bancária
	 * 
	 * @param conta Conta onde sacar
	 * @param valor Valor a ser sacado
	 */
	public void saca(Conta conta, BigDecimal valor) {
		BigDecimal novoSaldo = conta.getSaldo().subtract(valor);
		
		if (novoSaldo.compareTo(conta.getLimite().negate()) >= 0) {
			conta.setSaldo(novoSaldo);
		} else {
			throw new RuntimeException("Saldo insuficiente");
		}
	}
	
	/**
	 * Deposita dinheiro em uma conta bancária
	 * 
	 * @param conta Conta onde depositar
	 * @param valor Valor a ser sacado
	 */
	public void deposita(Conta conta, BigDecimal valor) {
		BigDecimal novoSaldo = conta.getSaldo().add(valor);
		conta.setSaldo(novoSaldo);
	}
	
}
