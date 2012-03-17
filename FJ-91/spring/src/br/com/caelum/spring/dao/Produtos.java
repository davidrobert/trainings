package br.com.caelum.spring.dao;

import java.util.List;

import br.com.caelum.spring.modelo.Produto;

public interface Produtos {

	void cadastra(Produto produto);

	List<Produto> todos();

}