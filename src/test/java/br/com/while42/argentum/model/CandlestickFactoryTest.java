package br.com.while42.argentum.model;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class CandlestickFactoryTest {

	@Test
	public void basicSimpleSequenceOfTrades() {

		Calendar hoje = Calendar.getInstance();

		Trade op1 = new Trade(40.5, 100, hoje);
		Trade op2 = new Trade(45.0, 100, hoje);
		Trade op3 = new Trade(39.8, 100, hoje);
		Trade op4 = new Trade(42.3, 100, hoje);

		List<Trade> operations = Arrays.asList(op1, op2, op3, op4);

		CandleStickFactory factory = new CandleStickFactory();
		Candlestick candle = factory.buidCandleToDate(hoje, operations);

		// [Open 40.5, Close 42.3, Min 39.8, Max 45.0, Volume 16760.0, Date Tue
		// Dec 20 19:27:06 BRST 2011]

		Assert.assertEquals(40.5, candle.getFirst(), 0.00001);
		Assert.assertEquals(42.3, candle.getLast(), 0.00001);
		Assert.assertEquals(39.8, candle.getMin(), 0.00001);
		Assert.assertEquals(45.0, candle.getMax(), 0.00001);
		Assert.assertEquals(16760.0, candle.getVolume(), 0.00001);
	}

	@Test
	public void onlyOneOperation() {
		Calendar hoje = Calendar.getInstance();

		Trade op = new Trade(40.5, 100, hoje);
		List<Trade> operations = Arrays.asList(op);

		CandleStickFactory factory = new CandleStickFactory();
		Candlestick candle = factory.buidCandleToDate(hoje, operations);

		Assert.assertEquals(40.5, candle.getFirst(), 0.00001);
		Assert.assertEquals(40.5, candle.getLast(), 0.00001);
		Assert.assertEquals(40.5, candle.getMin(), 0.00001);
		Assert.assertEquals(40.5, candle.getMax(), 0.00001);
		Assert.assertEquals(4050.0, candle.getVolume(), 0.00001);
	}

	@Test
	public void outOfOrder() {
		Calendar hoje = Calendar.getInstance();

		Trade op1 = new Trade(40.5, 100, hoje);
		Trade op2 = new Trade(40.0, 100, hoje);
		Trade op3 = new Trade(49.8, 100, hoje);
		Trade op4 = new Trade(53.3, 100, hoje);

		List<Trade> list = Arrays.asList(op1, op2, op3, op4);

		CandleStickFactory factory = new CandleStickFactory();
		Candlestick candle = factory.buidCandleToDate(hoje, list);

		Assert.assertEquals(40.5, candle.getFirst(), 0.00001);
		Assert.assertEquals(53.3, candle.getLast(), 0.00001);
		Assert.assertEquals(40.0, candle.getMin(), 0.00001);
		Assert.assertEquals(53.3, candle.getMax(), 0.00001);
		Assert.assertEquals(18360.0, candle.getVolume(), 0.00001);
	}

	@Test
	public void noTrade() {
		Calendar hoje = Calendar.getInstance();

		List<Trade> list = Arrays.asList();

		CandleStickFactory factory = new CandleStickFactory();
		Candlestick candle = factory.buidCandleToDate(hoje, list);

		Assert.assertEquals(0.0, candle.getFirst(), 0.00001);
		Assert.assertEquals(0.0, candle.getLast(), 0.00001);
		Assert.assertEquals(0.0, candle.getMin(), 0.00001);
		Assert.assertEquals(0.0, candle.getMax(), 0.00001);
		Assert.assertEquals(0.0, candle.getVolume(), 0.00001);
	}

	@Test(expected=IllegalArgumentException.class)
	public void dateNull() {
		List<Trade> list = Arrays.asList();

		CandleStickFactory factory = new CandleStickFactory();
		factory.buidCandleToDate(null, list);
	}

}
