package br.com.while42.argentum.model;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

public class TestCandlestickFactory {

	public static void main(String[] args) {

		Calendar hoje = Calendar.getInstance();

		Operation op1 = new Operation(40.5, 100, hoje);
		Operation op2 = new Operation(45.0, 100, hoje);
		Operation op3 = new Operation(39.8, 100, hoje);
		Operation op4 = new Operation(42.3, 100, hoje);

		List<Operation> operations = Arrays.asList(op1, op2, op3, op4);
		
		CandleStickFactory factory = new CandleStickFactory();
		Candlestick candle = factory.buidCandleToDate(hoje, operations);
		
		System.out.println(candle);
	}
}
