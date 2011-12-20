package br.com.while42.argentum.model;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

public class TestCandlestickFactoryNoOperation {

	public static void main(String[] args) {
		Calendar hoje = Calendar.getInstance();
		
		List<Operation> list = Arrays.asList();
		
		CandleStickFactory factory = new CandleStickFactory();
		Candlestick candlestick = factory.buidCandleToDate(hoje, list);
		
		System.out.println(candlestick);
	}

}
