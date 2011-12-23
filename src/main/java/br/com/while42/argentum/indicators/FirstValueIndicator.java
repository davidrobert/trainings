package br.com.while42.argentum.indicators;

import br.com.while42.argentum.model.TimeSerie;

public class FirstValueIndicator implements Indicator {

	@Override
	public double calcule(int position, TimeSerie serie) {
		return serie.getCandle(position).getFirst();
	}
	
	@Override
	public String toString() {
		return "First Value Indicator";
	}
}
