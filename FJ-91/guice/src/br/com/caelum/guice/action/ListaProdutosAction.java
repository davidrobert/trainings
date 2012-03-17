package br.com.caelum.guice.action;

import javax.inject.Inject;

import br.com.caelum.guice.dao.Produtos;
import br.com.caelum.guice.modelo.Produto;

public class ListaProdutosAction {

	private final Produtos produtos;

	@Inject
	public ListaProdutosAction(Produtos produtos) {
		this.produtos = produtos;
	}

	public void listar() {
		for (Produto p : produtos.todos()) {
			System.out.printf("Produto: %s - %.2f%n", p.getNome(), p.getPreco());
		}

	}
}
