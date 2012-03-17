package br.com.caelum.hibernate.controller;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.caelum.hibernate.modelo.Transacao;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;

@Resource
@Path("/aumentarValorTransacoes")
public class AumentarValoresDasTransacoes {
	
	private final Session session;
	private final Result result;

	public AumentarValoresDasTransacoes(Session session, Result result) {
		this.session = session;
		this.result = result;
	}
	
	@Path("/batch")
	public void aumentar(){
		long antes = System.currentTimeMillis();
		session.createQuery("update Transacao t set t.valor = t.valor*1.1").executeUpdate();
		System.out.printf("Tempo gasto %dms%n", System.currentTimeMillis()-antes);
		result.include("mensagem", "Atualizacao realizada com sucesso");
		result.forwardTo(IndexController.class).index();
	}
	
	@Path("/puro")
	public void aumentar2(){
		long antes = System.currentTimeMillis();
		List<Transacao> list = session.createCriteria(Transacao.class).list();
		Transaction transaction = session.beginTransaction();
		for (Transacao transacao : list) {
			transacao.setValor(transacao.getValor().multiply(new BigDecimal("1.1")));
		}
		transaction.commit();
		System.out.printf("Tempo gasto %dms%n", System.currentTimeMillis()-antes);
		result.include("mensagem", "Atualizacao realizada com sucesso");
		result.forwardTo(IndexController.class).index();
	}

}
