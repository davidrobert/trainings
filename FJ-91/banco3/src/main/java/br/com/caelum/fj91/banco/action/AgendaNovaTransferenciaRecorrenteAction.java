package br.com.caelum.fj91.banco.action;

import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.Calendar;

import br.com.caelum.fj91.banco.agendamento.TransferenciaRecorrenteAgendada;
import br.com.caelum.fj91.banco.modelo.Conta;
import br.com.caelum.fj91.banco.modelo.Periodo;
import br.com.caelum.fj91.banco.persistencia.ContaDao;
import br.com.caelum.fj91.banco.persistencia.TransferenciaRecorrenteAgendadaDao;

// imagine um framework web onde minhas Actions tem um método execute
// que recebe valores digitados no formulário e um objeto para escrever
// a resposta HTML.

public class AgendaNovaTransferenciaRecorrenteAction {

	public void execute(int numeroOrigem, int numeroDestino, BigDecimal valor,
			Calendar inicio, Calendar fim, int diaParaExecutar,
			PrintWriter resposta) {
		ContaDao dao = new ContaDao();
		Conta c1 = dao.doNumero(numeroOrigem);
		Conta c2 = dao.doNumero(numeroDestino);

		// Instanciação do objeto passando muitos parâmetros, a leitura é
		// natural?
		TransferenciaRecorrenteAgendada transferencia = new TransferenciaRecorrenteAgendada();
		transferencia.setOrigem(c1);
		transferencia.setDestino(c2);
		transferencia.setDia(diaParaExecutar);
		transferencia.setPeriodo(new Periodo(inicio, fim));
		transferencia.setValor(valor);

		new TransferenciaRecorrenteAgendadaDao().adiciona(transferencia);
	}

}
