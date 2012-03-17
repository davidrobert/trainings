package br.com.caelum.fj91.banco.persistencia;

import java.util.Collections;
import java.util.List;

import br.com.caelum.fj91.banco.agendamento.TransferenciaSimplesAgendada;

public class TransferenciaSimplesAgendadaDao extends Dao<TransferenciaSimplesAgendada> {

	public List<TransferenciaSimplesAgendada> transferenciasDeHoje() {
		System.out.println("Buscando as tranferencias agendadas de hoje");
		return Collections.emptyList();
	}
}
