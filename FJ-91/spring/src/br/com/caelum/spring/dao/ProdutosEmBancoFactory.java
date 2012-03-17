package br.com.caelum.spring.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.beans.factory.FactoryBean;

public class ProdutosEmBancoFactory implements FactoryBean<Produtos> {

	@Override
	public Produtos getObject() throws Exception {
		return new ProdutosEmBanco(DriverManager.getConnection("jdbc:hsqldb:mem:produtos", "SA", ""));
	}

	@Override
	public Class<Produtos> getObjectType() {
		return Produtos.class;
	}

	@Override
	public boolean isSingleton() {
		return false;
	}
	
	public void init() throws SQLException{
		Connection connection = DriverManager.getConnection("jdbc:hsqldb:mem:produtos", "SA", "");
		PreparedStatement statement = connection.prepareStatement("create table Produto(id BIGINT IDENTITY NOT NULL PRIMARY KEY, nome VARCHAR(255),preco DOUBLE)");
		statement.execute();
	}

}
