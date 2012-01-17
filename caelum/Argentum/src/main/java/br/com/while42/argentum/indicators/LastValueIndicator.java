package br.com.while42.argentum.indicators;

import br.com.while42.argentum.model.TimeSerie;

public class LastValueIndicator implements Indicator {

	@Override
	public double calcule(int position, TimeSerie serie) {
		return serie.getCandle(position).getLast();
	}
	
	@Override
	public String toString() {
		return "Last Value Indicator";
	}
}
