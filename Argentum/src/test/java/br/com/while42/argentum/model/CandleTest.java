package br.com.while42.argentum.model;

import java.util.Calendar;

import org.junit.Test;

public class CandleTest {
	@Test(expected = IllegalArgumentException.class)
	public void maxValue() {
		Calendar hoje = Calendar.getInstance();
		new Candle(1000000, 1000000, 1000000, 1000000, 1000000, hoje);
	}

	@Test(expected = IllegalArgumentException.class)
	public void minValue() {
		Calendar hoje = Calendar.getInstance();
		new Candle(-1, -1, -1, -1, -1, hoje);
	}

	@Test(expected = IllegalArgumentException.class)
	public void dateNull() {
		new Candle(1, 1, 1, 1, 1, null);
	}
}
