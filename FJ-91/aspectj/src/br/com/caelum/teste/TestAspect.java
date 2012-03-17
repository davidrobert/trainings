package br.com.caelum.teste;

import br.com.caelum.modelo.Produto;

public class TestAspect {

	/**
	 * Use VM Arguments -javaagent:aspectjweaver.jar quando rodar
	 */
	public static void main(String[] args) {
		Produto p = new Produto();
		p.setNome("luiz");
	}

}
