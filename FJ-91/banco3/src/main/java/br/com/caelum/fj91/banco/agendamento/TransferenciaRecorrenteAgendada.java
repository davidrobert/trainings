package br.com.caelum.fj91.banco.agendamento;

import java.math.BigDecimal;

import br.com.caelum.fj91.banco.modelo.Conta;
import br.com.caelum.fj91.banco.modelo.Periodo;

public class TransferenciaRecorrenteAgendada {

	private Conta origem;
	private Conta destino;
	private Periodo periodo;
	private BigDecimal valor;
	
	// Dia em que a transferência deve acontecer
	private Integer dia;

	public Conta getOrigem() {
		return origem;
	}

	public void setOrigem(Conta origem) {
		this.origem = origem;
	}

	public Conta getDestino() {
		return destino;
	}

	public void setDestino(Conta destino) {
		this.destino = destino;
	}

	public Periodo getPeriodo() {
		return periodo;
	}

	public void setPeriodo(Periodo periodo) {
		this.periodo = periodo;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public Integer getDia() {
		return dia;
	}

	public void setDia(Integer dia) {
		this.dia = dia;
	}

	public void efetiva() {
		// Tem que pagar 8 reais por transferencia agendada
		origem.saca(new BigDecimal(8));
		origem.transferePara(destino, valor);
	}
}
