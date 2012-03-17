package br.com.caelum.fj91.banco.persistencia;

import java.util.Collections;
import java.util.List;

public class Dao<T> {

	public void adiciona(T t) {
		// imagine um banco de dados aqui
		System.out.println("Adicionando novo objeto " + t.getClass().getName());
	}
	
	public void remove(T t) {
		// imagine um banco de dados aqui
		System.out.println("Removendo objeto " + t.getClass().getName());
	}
	
	public void atualiza(T t) {
		// imagine um banco de dados aqui
		System.out.println("Atualizando objeto " + t.getClass().getName());
	}
	
	public List<T> listaTodos() {
		// imagine um banco de dados aqui
		System.out.println("Listando tudo");
		return Collections.emptyList();
	}
}
