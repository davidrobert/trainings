package br.com.caelum.fj91.banco.teste;

import java.math.BigDecimal;
import java.util.Calendar;

import br.com.caelum.fj91.banco.logica.OperacoesBancarias;
import br.com.caelum.fj91.banco.modelo.Conta;

public class Programa {

	public static void main(String[] args) {
		
		Conta conta = new Conta(123, Calendar.getInstance());
		
		conta.setLimite(new BigDecimal(100));

		OperacoesBancarias op = new OperacoesBancarias();
		op.deposita(conta, new BigDecimal(250));
		
		System.out.println("Saldo resultante: R$ " + conta.getSaldo());
		
		op.saca(conta, new BigDecimal(99));
		
		System.out.println("Saldo resultante: R$ " + conta.getSaldo());
	}
}
