package br.com.caelum.guice.dao;

import java.util.List;

import br.com.caelum.guice.modelo.Produto;

public interface Produtos {

	void cadastra(Produto produto);

	List<Produto> todos();

}