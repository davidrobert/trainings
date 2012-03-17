package br.com.caelum.fj91.banco.modelo;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.math.BigDecimal;
import java.util.Calendar;

import org.junit.Before;
import org.junit.Test;

import br.com.caelum.fj91.banco.tributacao.Tributo;

public class ContaTest {

	private static final BigDecimal CEM_REAIS = new BigDecimal(100);
	private static final BigDecimal DUZENTOS_REAIS = new BigDecimal(200);
	private static final BigDecimal TREZENTOS_REAIS = new BigDecimal(300);
	private static final BigDecimal MENOS_CEM_REAIS = new BigDecimal(-100);
	
	private Conta conta;

	@Before
	public void setup() {
		conta = new Conta(123, Calendar.getInstance());
	}
	
	@Test
	public void testSacaEmContaSimplesComSaldoSuficiente() {
		conta.deposita(DUZENTOS_REAIS);
		conta.saca(CEM_REAIS);
		assertThat(conta.getSaldo(), is(equalTo(CEM_REAIS)));
	}
	
	@Test(expected=RuntimeException.class)
	public void testSaqueInvalidoEstourandoSaldo() {
		conta.deposita(DUZENTOS_REAIS);
		conta.saca(TREZENTOS_REAIS);
	}
	
	@Test
	public void testSacaEntrandoNoChequeEspecial() {
		conta.setLimite(CEM_REAIS);
		conta.deposita(DUZENTOS_REAIS);
		conta.saca(TREZENTOS_REAIS);
		assertThat(conta.getSaldo(), is(equalTo(MENOS_CEM_REAIS)));
	}
	
	@Test(expected=RuntimeException.class)
	public void testSaqueInvalidoEstourandoLimite() {
		conta.setLimite(CEM_REAIS);
		conta.deposita(CEM_REAIS);
		conta.saca(TREZENTOS_REAIS);
	}

	@Test
	public void testDeposita() {
		conta.deposita(CEM_REAIS);
		assertThat(conta.getSaldo(), is(equalTo(CEM_REAIS)));
		
		conta.deposita(CEM_REAIS);
		assertThat(conta.getSaldo(), is(equalTo(DUZENTOS_REAIS)));
	}

	@Test
	public void testTransferePara() {
		conta.deposita(DUZENTOS_REAIS);
		
		Conta outraConta = new Conta(456, Calendar.getInstance());
		conta.transferePara(outraConta, CEM_REAIS);
		
		assertThat(conta.getSaldo(), is(equalTo(CEM_REAIS)));
		assertThat(outraConta.getSaldo(), is(equalTo(CEM_REAIS)));
	}

	@Test
	public void testEstaNegativa() {
		conta.setLimite(DUZENTOS_REAIS);
		conta.saca(CEM_REAIS);
		assertThat(conta.estaNegativa(), is(equalTo(true)));
	}
	
	@Test
	public void testNaoEstaNegativa() {
		conta.deposita(DUZENTOS_REAIS);
		conta.saca(CEM_REAIS);
		assertThat(conta.estaNegativa(), is(equalTo(false)));
	}

	@Test
	public void testAplicacaoDeTributo() {
		Tributo tributo = new Tributo() {
			public BigDecimal calculaDesconto(Conta conta) {
				return CEM_REAIS;
			}
		};
		
		conta.deposita(TREZENTOS_REAIS);
		conta.aplica(tributo);
		
		assertThat(conta.getSaldo(), is(equalTo(DUZENTOS_REAIS)));
	}
	
	@Test
	public void testAplicacaoDeTributoMesmoSemLimite() {
		Tributo tributo = new Tributo() {
			public BigDecimal calculaDesconto(Conta conta) {
				return DUZENTOS_REAIS;
			}
		};
		
		conta.setLimite(BigDecimal.ZERO);
		conta.deposita(CEM_REAIS);
		conta.aplica(tributo);
		
		assertThat(conta.getSaldo(), is(equalTo(MENOS_CEM_REAIS)));
	}

}
