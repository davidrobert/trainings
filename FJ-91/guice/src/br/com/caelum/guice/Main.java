package br.com.caelum.guice;

import br.com.caelum.guice.dao.Produtos;
import br.com.caelum.guice.dao.ProdutosEmBancoFactory;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;

public class Main {
	public static void main(String[] args) {
		// configuração programática
		Injector injector = Guice.createInjector(new AbstractModule() {
			protected void configure() {
				bind(Produtos.class).toProvider(ProdutosEmBancoFactory.class);
				// bind(Produtos.class).to(ProdutosEmMemoria.class);
			}
		});
		
		// aplicação
		Menu menu = injector.getInstance(Menu.class);
		menu.showMenu();
	}
}
