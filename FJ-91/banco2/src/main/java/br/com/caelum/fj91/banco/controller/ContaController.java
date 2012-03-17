package br.com.caelum.fj91.banco.controller;

import java.math.BigDecimal;
import java.util.Calendar;

import br.com.caelum.fj91.banco.logica.Banco;
import br.com.caelum.fj91.banco.modelo.Conta;
import br.com.caelum.fj91.banco.persistencia.ContaDao;
import br.com.caelum.vraptor.Resource;

@Resource
public class ContaController {
	
	public void formulario() {
	}
	
	public Conta envia(String cliente, String cpf) {
		Banco banco = new Banco();
		Conta novaConta = banco.novaConta(cliente, cpf);
		
		return novaConta;
	}
	
	public Conta visualiza(int numero) {
		ContaDao dao = new ContaDao();
		return dao.contaComNumero(numero);
	}
	
	public String saca(int numero, BigDecimal valor) {
		Conta conta = visualiza(numero);
		
		try {
			conta.saca(valor);
			return "Saque efetuado!";
		} catch (RuntimeException e) {
			return e.getMessage();
		}
	}

	public void deposita(int numero, BigDecimal valor) {
		Conta conta = visualiza(numero);
		conta.deposita(valor);
	}
	
	public Iterable<Conta> lista(Integer ano) {
		if (ano == null)
			ano = Calendar.getInstance().get(Calendar.YEAR);
		
		ContaDao dao = new ContaDao();
		return dao.listaContasAbertasEm(ano);
	}
}
