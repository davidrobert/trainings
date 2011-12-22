package br.com.while42.argentum.model;

import java.util.Collections;
import java.util.List;

public class TimeSeries {

	private final List<Candlestick> candles;

	public TimeSeries(List<Candlestick> candles) {
		if (candles == null) {
			this.candles = Collections.emptyList();
		} else {
			this.candles = candles;
		}
	}
	
	public Candlestick getCandle(int i) {
		return candles.get(i);
	}
	
	public int getTotal() {
		return candles.size();
	}	
}
