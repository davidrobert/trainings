package br.com.caelum.spring.action;

import java.util.Scanner;

import br.com.caelum.spring.dao.Produtos;
import br.com.caelum.spring.modelo.Produto;

public class NovoProdutoAction {
	
	private Produtos produtos;

	public void setProdutos(Produtos produtos) {
		this.produtos = produtos;
	}
	
	public void lerDados(){
		Scanner produtoReader = new Scanner(System.in);
		System.out.print("Digite o nome:");
		String nome = produtoReader.next();
		System.out.print("Digite o preco:");
		double preco = produtoReader.nextDouble();
		produtos.cadastra(new Produto(nome, preco));
	}

}
