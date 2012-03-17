package br.com.caelum.fj91.banco.tributacao;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.hamcrest.CoreMatchers.*;

import java.math.BigDecimal;

import org.junit.Test;

import br.com.caelum.fj91.banco.modelo.Conta;

public class TributaUsoDoChequeEspecialTest {

	private final Conta conta = mock(Conta.class);
	
	private static final BigDecimal MENOS_CINQUENTA_REAIS = new BigDecimal(-50);
	private static final BigDecimal CINQUENTA_REAIS = new BigDecimal(50);
	private static final BigDecimal ZERO = new BigDecimal(0);
	
	@Test
	public void testaContasNegativasSaoTributadas() {
		when(conta.estaNegativa()).thenReturn(true);
		when(conta.getSaldo()).thenReturn(MENOS_CINQUENTA_REAIS);
		when(conta.getLimite()).thenReturn(CINQUENTA_REAIS);
		
		TributaUsoDoChequeEspecial tributo = new TributaUsoDoChequeEspecial();
		
		assertThat(tributo.calculaDesconto(conta), is(equalTo(CINQUENTA_REAIS)));
	}

	@Test
	public void testaContasPositivasNaoSaoTributadas() {
		when(conta.estaNegativa()).thenReturn(false);
		when(conta.getSaldo()).thenReturn(CINQUENTA_REAIS);
		when(conta.getLimite()).thenReturn(ZERO);
		
		TributaUsoDoChequeEspecial tributo = new TributaUsoDoChequeEspecial();
		
		assertThat(tributo.calculaDesconto(conta), is(equalTo(ZERO)));
	}

	
}
