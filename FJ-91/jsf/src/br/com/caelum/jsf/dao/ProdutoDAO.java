package br.com.caelum.jsf.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.caelum.jsf.modelo.Produto;

/**
 * Acesso ao banco de dados.
 */
public class ProdutoDAO {

	private static final List<Produto> produtos = new ArrayList<Produto>();

	public void adiciona(Produto produto) {
		produtos.add(produto);
	}

	public List<Produto> getLista() {
		return produtos;
	}

}
