package br.com.caelum.fj91.banco.testes;

import java.util.Calendar;
import java.util.GregorianCalendar;

import br.com.caelum.fj91.banco.modelo.Periodo;

public class TestaPeriodo {

	public static void main(String[] args) {
		
		Calendar hoje = Calendar.getInstance();
		Calendar olimpiadas = new GregorianCalendar(2016, 6, 1);
		
		// monta período e mostra
		Periodo periodo = new Periodo(hoje, olimpiadas);
		System.out.println("Período normal: " + periodo);
		
		// antecipa um mês antes
		Calendar umMesAntes = periodo.getFim();
		umMesAntes.add(Calendar.MONTH, -1);
		
		// e só começa amanhã
		Calendar amanha = hoje;
		amanha.add(Calendar.DAY_OF_MONTH, 1);
		
		// mostra valores
		Periodo novo = new Periodo(amanha, umMesAntes);
		System.out.println("Período normal: " + periodo);
		System.out.println("Período antecipado: " + novo);
		
	}
	
}
