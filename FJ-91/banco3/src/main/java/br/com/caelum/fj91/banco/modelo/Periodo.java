package br.com.caelum.fj91.banco.modelo;

import java.util.Calendar;

/**
 * Representa um período de tempo, com início e fim 
 */
public class Periodo {

	private Calendar inicio;
	private Calendar fim;

	public Periodo(Calendar inicio, Calendar fim) {
		this.inicio = inicio;
		this.fim = fim;
	}

	public Calendar getInicio() {
		return inicio;
	}

	public Calendar getFim() {
		return fim;
	}
	
	public String toString() {
		return String.format("{início: %1$Td/%1$Tm/%1$TY, fim: %2$Td/%2$Tm/%2$TY}", inicio, fim);
	}
}