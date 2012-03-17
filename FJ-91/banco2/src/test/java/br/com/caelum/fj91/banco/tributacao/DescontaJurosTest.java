package br.com.caelum.fj91.banco.tributacao;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.hamcrest.CoreMatchers.*;

import java.math.BigDecimal;

import org.junit.Test;

import br.com.caelum.fj91.banco.modelo.Conta;

public class DescontaJurosTest {

	private final Conta conta = mock(Conta.class);
	
	private static final BigDecimal MENOS_CINQUENTA_REAIS = new BigDecimal("-50.0");
	private static final BigDecimal CINQUENTA_REAIS = new BigDecimal("50.0");
	private static final BigDecimal ZERO = new BigDecimal(0);
	private static final BigDecimal DEZ_PORCENTO = new BigDecimal("0.10");
	private static final BigDecimal CINCO_REAIS = new BigDecimal("5.0");
	
	@Test
	public void testaQueTributaContaNegativa() {
		when(conta.estaNegativa()).thenReturn(true);
		when(conta.getSaldo()).thenReturn(MENOS_CINQUENTA_REAIS);
		when(conta.getLimite()).thenReturn(CINQUENTA_REAIS);
		
		DescontaJuros tributo = new DescontaJuros(DEZ_PORCENTO);
		assertTrue(tributo.calculaDesconto(conta).compareTo(CINCO_REAIS) == 0);
	}
	
	@Test
	public void testaQueNaoTributaContaPositiva() {
		when(conta.estaNegativa()).thenReturn(false);
		when(conta.getSaldo()).thenReturn(CINQUENTA_REAIS);
		when(conta.getLimite()).thenReturn(ZERO);
		
		DescontaJuros tributo = new DescontaJuros(DEZ_PORCENTO);
		assertThat(tributo.calculaDesconto(conta), is(equalTo(ZERO)));
	}

}
