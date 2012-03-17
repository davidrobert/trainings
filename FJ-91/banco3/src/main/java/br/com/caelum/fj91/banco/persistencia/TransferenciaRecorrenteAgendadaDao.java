package br.com.caelum.fj91.banco.persistencia;

import java.util.Collections;
import java.util.List;

import br.com.caelum.fj91.banco.agendamento.TransferenciaRecorrenteAgendada;

public class TransferenciaRecorrenteAgendadaDao extends Dao<TransferenciaRecorrenteAgendada> {

	public List<TransferenciaRecorrenteAgendada> transferenciasDeHoje() {
		System.out.println("Buscando as tranferencias recorrentes agendadas de hoje");
		return Collections.emptyList();
	}
	
}
