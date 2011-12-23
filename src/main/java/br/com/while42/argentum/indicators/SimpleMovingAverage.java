package br.com.while42.argentum.indicators;

import br.com.while42.argentum.model.TimeSeries;

public class SimpleMovingAverage implements Indicator {

	private int sizeWindow = 3;

	@Override
	public double calcule(int position, TimeSeries serie) {
		double sum = 0.0;
		for (int i = position; i > position - sizeWindow; i--) {
			sum += serie.getCandle(i).getLast();
		}

		return sum / sizeWindow;
	}

}
