package br.com.caelum.fj91.banco.action;

import java.io.PrintWriter;

import br.com.caelum.fj91.banco.modelo.Conta;
import br.com.caelum.fj91.banco.persistencia.ContaDao;

// imagine um framework web onde minhas Actions tem um método execute
// que recebe valores digitados no formulário e um objeto para escrever
// a resposta HTML.

public class ListaContasPorAnoAction {

	public void execute(int ano, PrintWriter resposta) {
		ContaDao dao = new ContaDao();
		
		resposta.println("<html>");
		resposta.println("Lista de contas abertas em " + ano);
		resposta.println("<table>");
		
		// percorre as contas e monta tabela
		for (Conta conta : dao.listaContasAbertasEm(ano)) {
			resposta.println("<tr>");
			resposta.println("<td>" + conta.getNumero() + "</td>");
			resposta.println("<td>" + conta.getTitular().getNome() + "</td>");
			resposta.println("</tr>");
		}
		
		resposta.println("</table>");
		resposta.println("</html>");
	}
	
}
