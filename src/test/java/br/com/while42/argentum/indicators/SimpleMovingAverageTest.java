package br.com.while42.argentum.indicators;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

import br.com.while42.argentum.model.Candlestick;
import br.com.while42.argentum.model.TimeSeries;

public class SimpleMovingAverageTest {
		
	private TimeSeries buildTimeSerie(double ... values) {
		List<Candlestick>  candles = new ArrayList<Candlestick>();
		for (double d: values) {
			candles.add(new Candlestick(d, d, d, d, 1000, Calendar.getInstance()));
		}
		return new TimeSeries(candles);
	}
	
	@Test
	public void SimpleMovingAverage() {
		TimeSeries serie = buildTimeSerie(1, 2, 3, 4, 3, 4, 5, 4, 3);
		SimpleMovingAverage sma = new SimpleMovingAverage();
				
		Assert.assertEquals(2.0, sma.calcule(2, serie), 0.00001);		
		Assert.assertEquals(3.0, sma.calcule(3, serie), 0.00001);
		Assert.assertEquals(10.0 / 3, sma.calcule(4, serie), 0.00001);
		Assert.assertEquals(11.0 / 3, sma.calcule(5, serie), 0.00001);
		Assert.assertEquals(4.0, sma.calcule(6, serie), 0.00001);
		Assert.assertEquals(13.0 / 3, sma.calcule(7, serie), 0.00001);
		Assert.assertEquals(4.0, sma.calcule(8, serie), 0.00001);		
	}		
}
