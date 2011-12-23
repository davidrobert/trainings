package br.com.while42.argentum.indicators;

import br.com.while42.argentum.model.TimeSerie;

public class WeightedMovingAverage implements Indicator {
	private int totalDays = 2;
	private Indicator indicator;
	
	public WeightedMovingAverage(Indicator indicator) {
		this.indicator = indicator;
	}
		
	@Override
	public double calcule(int position, TimeSerie serie) {
		double sum = 0.0;
		int weight = 1;

		for (int i = position - totalDays; i <= position; i++) {
			sum += indicator.calcule(i, serie) * weight;
			weight++;
		}

		// Exemplo: 6 = soma dos pesos no intervalo de 3 dias (3 + 2 + 1)
		
		int pa = 6; // TODO: pa = (Ai + An) * n / 2
		return sum / pa;
	}

	@Override
	public String toString() {
		return "Weighted Moving Average (" + indicator + ")";
	}
}
