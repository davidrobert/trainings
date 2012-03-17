package br.com.caelum.guice;

import java.util.Scanner;

import javax.inject.Inject;

import br.com.caelum.guice.action.ListaProdutosAction;
import br.com.caelum.guice.action.NovoProdutoAction;

public class Menu {

	private final NovoProdutoAction novoProdutoAction;
	private final ListaProdutosAction listaProdutosAction;

	@Inject
	public Menu(NovoProdutoAction novoProdutoAction, ListaProdutosAction listaProdutosAction) {
		this.novoProdutoAction = novoProdutoAction;
		this.listaProdutosAction = listaProdutosAction;
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
