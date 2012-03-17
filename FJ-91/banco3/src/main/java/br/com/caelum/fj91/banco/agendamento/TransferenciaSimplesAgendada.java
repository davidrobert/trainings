package br.com.caelum.fj91.banco.agendamento;

import java.math.BigDecimal;
import java.util.Calendar;

import br.com.caelum.fj91.banco.modelo.Conta;

public class TransferenciaSimplesAgendada {

	private Conta origem;
	private Conta destino;
	private BigDecimal valor;
	private Calendar horaEfetivacao;

	public TransferenciaSimplesAgendada(Conta origem, Conta destino, BigDecimal valor, Calendar horaEfetivacao) {
		this.origem = origem;
		this.destino = destino;
		this.valor = valor;
		this.horaEfetivacao = horaEfetivacao;
	}

	public Conta getOrigem() {
		return origem;
	}

	public Conta getDestino() {
		return destino;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public Calendar getHoraEfetivacao() {
		return horaEfetivacao;
	}

	public void efetiva() {
		origem.transferePara(destino, valor);
	}

}
