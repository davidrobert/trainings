package br.com.caelum.spring.action;

import br.com.caelum.spring.dao.Produtos;
import br.com.caelum.spring.modelo.Produto;

public class ListaProdutosAction {
	
	private Produtos produtos;
	
	public void setProdutos(Produtos produtos) {
		this.produtos = produtos;
	}

	public void listar() {
		for (Produto p : produtos.todos()) {
			System.out.printf("Produto: %s - %.2f%n", p.getNome(), p.getPreco());
		}
		
	}
}
