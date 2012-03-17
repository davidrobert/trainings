package br.com.caelum.fj91.banco.persistencia;

import java.util.GregorianCalendar;

import br.com.caelum.fj91.banco.modelo.Conta;

public class ContaDao extends Dao<Conta> {

	public Conta doNumero(int numero) {
		// imagine um banco de dados aqui
		System.out.println("Buscando conta: " + numero);
		
		Conta conta = new Conta(numero, new GregorianCalendar(2007, 10, 4));
		
		return conta;
	}

}
