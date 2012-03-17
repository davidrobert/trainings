package br.com.caelum.fj91.banco.persistencia;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.GregorianCalendar;
import java.util.List;

import br.com.caelum.fj91.banco.modelo.Cliente;
import br.com.caelum.fj91.banco.modelo.Conta;

public class ContaDao extends Dao<Conta> {

	public List<Conta> listaContasAbertasEm(int ano) {
		System.out.println("Listando contas abertas em " + ano);
		
		// TODO escrever ArrayList do lado esquerdo está errado?
		ArrayList<Conta> lista = new ArrayList<Conta>();
		
		// insere 3 objetos de mentira; imagine um banco de dados aqui
		lista.add(new Conta(765675, new GregorianCalendar(ano, 10, 4)));
		lista.add(new Conta(875687, new GregorianCalendar(ano, 7, 13)));
		lista.add(new Conta(91273, new GregorianCalendar(ano, 4, 27)));
		
		return lista;
	}
	
	public List<Conta> contasDo(Cliente titular) {
		// imagine um banco de dados aqui
		System.out.println("Listando contas do " + titular);
		
		Conta conta = new Conta(7823143, new GregorianCalendar(2007, 10, 4));
		conta.setTitular(titular);
		
		return Arrays.asList(conta);
	}
}
