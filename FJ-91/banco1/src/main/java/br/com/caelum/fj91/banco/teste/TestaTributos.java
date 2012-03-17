package br.com.caelum.fj91.banco.teste;

import java.math.BigDecimal;
import java.util.Calendar;

import br.com.caelum.fj91.banco.modelo.Conta;
import br.com.caelum.fj91.banco.tributacao.DescontaJuros;
import br.com.caelum.fj91.banco.tributacao.TributaUsoDoChequeEspecial;

public class TestaTributos {
	public static void main(String[] args) {
		
		Conta conta = new Conta(45345, Calendar.getInstance());
		conta.setLimite(new BigDecimal("1000"));
		
		// efetua operações
		conta.deposita(new BigDecimal("200"));
		conta.saca(new BigDecimal("345"));
		System.out.println("Saldo atual: " + conta.getSaldo());
		
		// aplica tributos no final do mês
		conta.aplica(new TributaUsoDoChequeEspecial());
		conta.aplica(new DescontaJuros(new BigDecimal("0.10")));
		
		System.out.println("Saldo final após descontos: " + conta.getSaldo());
	}
}
