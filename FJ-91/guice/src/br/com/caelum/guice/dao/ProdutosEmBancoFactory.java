package br.com.caelum.guice.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.inject.Provider;

public class ProdutosEmBancoFactory implements Provider<Produtos>{
	
	public ProdutosEmBancoFactory() throws SQLException {
		Connection connection = DriverManager.getConnection("jdbc:hsqldb:mem:produtos", "SA", "");
		connection.prepareStatement("drop table if exists Produto").execute();
		connection.prepareStatement("create table Produto(id BIGINT IDENTITY NOT NULL PRIMARY KEY, nome VARCHAR(255),preco DOUBLE)").execute();
	}

	@Override
	public Produtos get() {
		try {
			return new ProdutosEmBanco(DriverManager.getConnection("jdbc:hsqldb:mem:produtos", "SA", ""));
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
