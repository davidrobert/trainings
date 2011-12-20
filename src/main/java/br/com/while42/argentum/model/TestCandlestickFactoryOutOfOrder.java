package br.com.while42.argentum.model;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

public class TestCandlestickFactoryOutOfOrder {
	public static void main(String[] args) {
		Calendar hoje = Calendar.getInstance();

		Operation op1 = new Operation(40.5, 100, hoje);
		Operation op2 = new Operation(40.0, 100, hoje);
		Operation op3 = new Operation(49.8, 100, hoje);
		Operation op4 = new Operation(53.3, 100, hoje);

		List<Operation> list = Arrays.asList(op1, op2, op3, op4);

		CandleStickFactory factory = new CandleStickFactory();
		Candlestick candlestick = factory.buidCandleToDate(hoje, list);

		System.out.println(candlestick);
	}
}
