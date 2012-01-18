package br.com.while42.argentum.model;

import java.util.Collections;
import java.util.List;

public class TimeSerie {

	private final List<Candle> candles;

	public TimeSerie(List<Candle> candles) {
		if (candles == null) {
			this.candles = Collections.emptyList();
		} else {
			this.candles = candles;
		}
	}
	
	public Candle getCandle(int i) {
		return candles.get(i);
	}
	
	public int getTotal() {
		return candles.size();
	}	
}
