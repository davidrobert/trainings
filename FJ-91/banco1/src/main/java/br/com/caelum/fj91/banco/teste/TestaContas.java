package br.com.caelum.fj91.banco.teste;

import java.util.Arrays;
import java.util.GregorianCalendar;

import br.com.caelum.fj91.banco.modelo.Conta;
import br.com.caelum.fj91.banco.modelo.Contas;

public class TestaContas {

	public static void main(String[] args) {
		
		// gera diversas contas diferentes
		Conta c1 = new Conta(123, new GregorianCalendar(2009, 1, 5));
		Conta c2 = new Conta(250, new GregorianCalendar(2009, 3, 10));
		Conta c3 = new Conta(327, new GregorianCalendar(2010, 5, 15));
		Conta c4 = new Conta(443, new GregorianCalendar(2010, 7, 17));
		Conta c5 = new Conta(533, new GregorianCalendar(2011, 9, 19));
		Conta c6 = new Conta(620, new GregorianCalendar(2011, 10, 22));
		Conta c7 = new Conta(793, new GregorianCalendar(2011, 11, 27));
		
		// armazena as contas
		Contas contas = new Contas();
		contas.addAll(Arrays.asList(c1, c2, c3, c4, c5, c6, c7));
		
		// testes
		System.out.println("Total de contas: " + contas.size());
		System.out.println("Contas do 1o semestre: " + contas.getTotalContasPrimeiroSemestre());
		System.out.println("Contas do 2o semestre: " + contas.getTotalContasSegundoSemestre());
	}
}
