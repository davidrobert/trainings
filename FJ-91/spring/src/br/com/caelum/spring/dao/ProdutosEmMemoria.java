package br.com.caelum.spring.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.caelum.spring.modelo.Produto;

public class ProdutosEmMemoria implements Produtos {
	
	List<Produto> produtos = new ArrayList<Produto>();

	public void cadastra(Produto produto) {
		System.out.println("salvando produto:"+produto.getNome());
		produtos.add(produto);
	}

	public List<Produto> todos() {
		return Collections.unmodifiableList(produtos);
	}

}
