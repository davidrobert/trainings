package br.com.while42.argentum.model;

import java.util.GregorianCalendar;

public class TestCandleBuilder {
	public static void main(String[] args) {
		CandleBuilder builder = new CandleBuilder();
		builder.first(40.5);
		builder.last(42.3);
		builder.min(39.8);
		builder.max(45);
		builder.volume(145234.20);
		builder.date(new GregorianCalendar(2011, 8, 12, 0, 0, 0));
		
		Candlestick c = builder.builCandle();
	}
}
