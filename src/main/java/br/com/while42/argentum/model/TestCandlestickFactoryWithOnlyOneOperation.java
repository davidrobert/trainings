package br.com.while42.argentum.model;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

public class TestCandlestickFactoryWithOnlyOneOperation {

	public static void main(String[] args) {
		Calendar hoje = Calendar.getInstance();
		
		Operation op = new Operation(40.5, 100, hoje);
		List<Operation> operations = Arrays.asList(op);
		
		CandleStickFactory factory = new CandleStickFactory();
		Candlestick candlestick = factory.buidCandleToDate(hoje, operations);
		
		System.out.println(candlestick);
	}

}
