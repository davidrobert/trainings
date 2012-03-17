package br.com.caelum.spring;

import java.util.Scanner;

import br.com.caelum.spring.action.ListaProdutosAction;
import br.com.caelum.spring.action.NovoProdutoAction;

public class Menu {

	private NovoProdutoAction novoProdutoAction;
	private ListaProdutosAction listaProdutosAction;
	
	public void setListaProdutosAction(ListaProdutosAction listaProdutosAction) {
		this.listaProdutosAction = listaProdutosAction;
	}
	
	public void setNovoProdutoAction(NovoProdutoAction novoProdutoAction) {
		this.novoProdutoAction = novoProdutoAction;
	}

	public void showMenu() {
		System.out.println("1) Cadastrar produto novo");
		System.out.println("2) Listar todos os produtos");
		System.out.println("3) Sair");
		Scanner scanner = new Scanner(System.in);
		int opcao = 0;
		if (scanner.hasNextInt()) {
			opcao = scanner.nextInt();
		}
		switch (opcao) {
		case 1:
			novoProdutoAction.lerDados();
			break;
		case 2:
			listaProdutosAction.listar();
			break;
		case 3:
			System.exit(0);
		default:
			System.out.println("Opcao invalida");
		}
		this.showMenu();
	}

}
