package br.com.while42.argentum.indicators;

import br.com.while42.argentum.model.TimeSeries;

public class WeightedMovingAverage {
	private int sizeWindow = 2;
	

	public double calcule(int position, TimeSeries serie) {
		double sum = 0.0;
		int weight = 1;
		
		for (int i = position - sizeWindow; i <= position; i++) {
			sum += serie.getCandle(i).getLast() * weight;
			weight++;
		}

		// 6 = soma dos pesos no intervalo de 3 dias (3 + 2 + 1)
		return sum / 6;
	}

}
