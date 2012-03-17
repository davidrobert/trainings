package br.com.caelum.fj91.banco.action;

import java.io.PrintWriter;

import br.com.caelum.fj91.banco.modelo.Conta;
import br.com.caelum.fj91.banco.persistencia.ContaDao;

public class NovaContaAction {

	public void execute(Conta novaConta, PrintWriter resposta) {
		ContaDao dao = new ContaDao();
		dao.adiciona(novaConta);
		
		resposta.println("<html>");
		resposta.println("Conta adicionada com sucesso!");
		resposta.println("</html>");
	}
	
}
