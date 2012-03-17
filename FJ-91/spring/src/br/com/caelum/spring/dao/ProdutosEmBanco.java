package br.com.caelum.spring.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.caelum.spring.modelo.Produto;

public class ProdutosEmBanco implements Produtos {

	private final Connection connection;

	public ProdutosEmBanco(Connection connection) {
		this.connection = connection;
	}

	@Override
	public void cadastra(Produto produto) {
		try {
			PreparedStatement statement = connection
					.prepareStatement("insert into Produto (nome,preco) values (?,?)");
			statement.setString(1, produto.getNome());
			statement.setDouble(2, produto.getPreco());
			statement.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	@Override
	public List<Produto> todos() {
		List<Produto> produtos = new ArrayList<Produto>();
		try {
			PreparedStatement statement = connection.prepareStatement("select * from Produto");
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				produtos.add(new Produto(rs.getString(2), rs.getDouble(3)));
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return produtos;
	}

}
