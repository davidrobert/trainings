package br.com.caelum.fj91.banco.action;

import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.Calendar;

import br.com.caelum.fj91.banco.agendamento.TransferenciaSimplesAgendada;
import br.com.caelum.fj91.banco.modelo.Conta;
import br.com.caelum.fj91.banco.persistencia.ContaDao;
import br.com.caelum.fj91.banco.persistencia.TransferenciaSimplesAgendadaDao;

// imagine um framework web onde minhas Actions tem um método execute
// que recebe valores digitados no formulário e um objeto para escrever
// a resposta HTML.

public class AgendaNovaTransferenciaAction {

	public void execute(int numeroOrigem, int numeroDestino, BigDecimal valor, PrintWriter resposta) {
		ContaDao dao = new ContaDao();
		Conta c1 = dao.doNumero(numeroOrigem);
		Conta c2 = dao.doNumero(numeroDestino);
		
		// Instanciação do objeto passando muitos parâmetros, algo errado?
		TransferenciaSimplesAgendada transferencia = new TransferenciaSimplesAgendada(c2, c1, valor, Calendar.getInstance());
		
		new TransferenciaSimplesAgendadaDao().adiciona(transferencia);
	}
	
}
