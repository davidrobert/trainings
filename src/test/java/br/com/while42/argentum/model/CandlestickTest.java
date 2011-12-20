package br.com.while42.argentum.model;

import java.util.Calendar;

import org.junit.Test;


public class CandlestickTest {
	@Test(expected=IllegalArgumentException.class)
	public void maxValue() {
		Calendar hoje = Calendar.getInstance();
		new Candlestick(1000000, 1000000, 1000000, 1000000, 1000000, hoje);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void minValue() {
		Calendar hoje = Calendar.getInstance();
		new Candlestick(-1, -1, -1, -1, -1, hoje);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void dateNull() {		
		new Candlestick(1, 1, 1, 1, 1, null);
	}
}
