package br.com.caelum.fj91.banco.persistencia;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

public class Dao<T> {

	public void adiciona(T t) throws SQLException {
		// imagine um banco de dados aqui
		System.out.println("Adicionando novo objeto " + t.getClass().getName());
	}
	
	public void remove(T t) throws SQLException {
		// imagine um banco de dados aqui
		System.out.println("Removendo objeto " + t.getClass().getName());
	}
	
	public void atualiza(T t) throws SQLException {
		// imagine um banco de dados aqui
		System.out.println("Atualizando objeto " + t.getClass().getName());
	}
	
	public List<T> listaTodos() throws SQLException {
		// imagine um banco de dados aqui
		System.out.println("Listando tudo");
		return Collections.emptyList();
	}
}
