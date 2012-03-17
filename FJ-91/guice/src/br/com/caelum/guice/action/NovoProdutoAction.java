package br.com.caelum.guice.action;

import java.util.Scanner;

import javax.inject.Inject;

import br.com.caelum.guice.dao.Produtos;
import br.com.caelum.guice.modelo.Produto;

public class NovoProdutoAction {
	
	private final Produtos dao;

	@Inject
	public NovoProdutoAction(Produtos dao){
		this.dao = dao;
	}
	
	public void lerDados(){
		Scanner produtoReader = new Scanner(System.in);
		
		System.out.print("Digite o nome:");
		String nome = produtoReader.next();
		
		System.out.print("Digite o preco:");
		double preco = produtoReader.nextDouble();
		
		dao.cadastra(new Produto(nome, preco));
	}

}
