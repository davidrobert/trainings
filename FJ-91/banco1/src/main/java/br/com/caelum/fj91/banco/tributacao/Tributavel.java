package br.com.caelum.fj91.banco.tributacao;

import java.math.BigDecimal;

import br.com.caelum.fj91.banco.modelo.Conta;

public interface Tributavel {
	public BigDecimal calculaDesconto(Conta conta);
}
