package br.com.while42.argentum.model;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

public class TestCandlestickFactory {

	public static void main(String[] args) {

		Calendar hoje = Calendar.getInstance();

		Trade op1 = new Trade(40.5, 100, hoje);
		Trade op2 = new Trade(45.0, 100, hoje);
		Trade op3 = new Trade(39.8, 100, hoje);
		Trade op4 = new Trade(42.3, 100, hoje);

		List<Trade> operations = Arrays.asList(op1, op2, op3, op4);
		
		CandleStickFactory factory = new CandleStickFactory();
		Candlestick candle = factory.buidCandleToDate(hoje, operations);
		
		System.out.println(candle);
	}
}
