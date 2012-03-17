package br.com.caelum.fj91.scala;

public class AtualizadorDePreco {

	private final Double taxa;

	public AtualizadorDePreco(Double taxa) {
		this.taxa = taxa;
	}
	
	public void atualiza(Produto produto) {
		Double precoAntigo = produto.preco();
		produto.preco_$eq(precoAntigo * taxa);
	}
	
}
