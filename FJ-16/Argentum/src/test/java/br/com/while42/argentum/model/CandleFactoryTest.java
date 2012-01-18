package br.com.while42.argentum.model;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class CandleFactoryTest {

	@Test
	public void basicSimpleSequenceOfTrades() {

		Calendar hoje = Calendar.getInstance();

		Trade op1 = new Trade(40.5, 100, hoje);
		Trade op2 = new Trade(45.0, 100, hoje);
		Trade op3 = new Trade(39.8, 100, hoje);
		Trade op4 = new Trade(42.3, 100, hoje);

		List<Trade> operations = Arrays.asList(op1, op2, op3, op4);

		CandleFactory factory = new CandleFactory();
		Candle candle = factory.buidCandleToDate(hoje, operations);

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

		CandleFactory factory = new CandleFactory();
		Candle candle = factory.buidCandleToDate(hoje, operations);

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

		CandleFactory factory = new CandleFactory();
		Candle candle = factory.buidCandleToDate(hoje, list);

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

		CandleFactory factory = new CandleFactory();
		Candle candle = factory.buidCandleToDate(hoje, list);

		Assert.assertEquals(0.0, candle.getFirst(), 0.00001);
		Assert.assertEquals(0.0, candle.getLast(), 0.00001);
		Assert.assertEquals(0.0, candle.getMin(), 0.00001);
		Assert.assertEquals(0.0, candle.getMax(), 0.00001);
		Assert.assertEquals(0.0, candle.getVolume(), 0.00001);
	}

	@Test(expected = IllegalArgumentException.class)
	public void dateNull() {
		List<Trade> list = Arrays.asList();

		CandleFactory factory = new CandleFactory();
		factory.buidCandleToDate(null, list);
	}

	@Test
	public void buildCandlesticks() {
		Calendar hoje = Calendar.getInstance();

		Trade t1 = new Trade(40.5, 100, hoje);
		Trade t2 = new Trade(45.0, 100, hoje);
		Trade t3 = new Trade(39.8, 100, hoje);
		Trade t4 = new Trade(42.3, 100, hoje);

		Calendar amanha = (Calendar) hoje.clone();
		amanha.add(Calendar.DAY_OF_MONTH, 1);

		Trade t5 = new Trade(48.8, 100, amanha);
		Trade t6 = new Trade(49.3, 100, amanha);

		Calendar depois = (Calendar) amanha.clone();
		depois.add(Calendar.DAY_OF_MONTH, 1);

		Trade t7 = new Trade(51.8, 100, depois);
		Trade t8 = new Trade(52.3, 100, depois);

		List<Trade> trades = Arrays.asList(t1, t2, t3, t4, t5, t6, t7, t8);

		CandleFactory factory = new CandleFactory();

		List<Candle> candlesticks = factory.buildCandle(trades);

		Assert.assertEquals(3, candlesticks.size());
		Assert.assertEquals(40.5, candlesticks.get(0).getFirst(), 0.00001);
		Assert.assertEquals(42.3, candlesticks.get(0).getLast(), 0.00001);
		Assert.assertEquals(48.8, candlesticks.get(1).getFirst(), 0.00001);
		Assert.assertEquals(49.3, candlesticks.get(1).getLast(), 0.00001);
		Assert.assertEquals(51.8, candlesticks.get(2).getFirst(), 0.00001);
		Assert.assertEquals(52.3, candlesticks.get(2).getLast(), 0.00001);
	}

	@Test
	public void buildCandlesWithTradesOutOfOrder() {
		// TODO: ...
	}
}
