package br.com.caelum.fj91.banco.action;

import java.io.PrintWriter;
import java.util.List;

import br.com.caelum.fj91.banco.modelo.Conta;
import br.com.caelum.fj91.banco.persistencia.ContaDao;

public class RemoveContaAction {

	public void execute(Conta conta, PrintWriter resposta) {
		ContaDao dao = new ContaDao();
		dao.remove(conta);
		
		List<Conta> outrasContas = dao.contasDo(conta.getTitular());
		
		resposta.println("<html>");
		resposta.println("Conta removida com sucesso!");
		resposta.println("O cliente ainda possui as seguintes contas: " + outrasContas);
		resposta.println("</html>");
	}
	
}
