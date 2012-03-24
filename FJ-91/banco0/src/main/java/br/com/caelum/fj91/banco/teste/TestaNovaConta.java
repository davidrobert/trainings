package br.com.caelum.fj91.banco.teste;


import br.com.caelum.fj91.banco.logica.Banco;

public class TestaNovaConta {

	public void executa() {
		// dados do cliente pegos no formulário de cadastro
		String campoNome = "Joaquim Manoel";
		String campoCpf  = "123.456.789-10";
		
		// cria conta para o Joaquim
		Banco banco = new Banco();
		
		banco.criaNovaConta(campoNome, campoCpf);
	}

	public static void main(String[] args) {
		new TestaNovaConta().executa();
	}
}
