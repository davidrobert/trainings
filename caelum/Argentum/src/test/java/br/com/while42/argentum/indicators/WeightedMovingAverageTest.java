package br.com.while42.argentum.indicators;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

import br.com.while42.argentum.model.Candle;
import br.com.while42.argentum.model.TimeSerie;

public class WeightedMovingAverageTest {

	private TimeSerie buildTimeSerie(double... values) {
		List<Candle> candles = new ArrayList<Candle>();
		for (double d : values) {
			candles.add(new Candle(d, d, d, d, 1000, Calendar.getInstance()));
		}
		return new TimeSerie(candles);
	}

	@Test
	public void weightedAverage() {
		TimeSerie serie = buildTimeSerie(1, 2, 3, 4, 5, 6);
		WeightedMovingAverage wma = new WeightedMovingAverage(new LastValueIndicator());

		// Example: calcule(2) = 1*1 + 2*2 + 3*3 = 14. --> 14/6
		Assert.assertEquals(14d / 6, wma.calcule(2, serie), 0.00001);
		Assert.assertEquals(20d / 6, wma.calcule(3, serie), 0.00001);
		Assert.assertEquals(26d / 6, wma.calcule(4, serie), 0.00001);
		Assert.assertEquals(32d / 6, wma.calcule(5, serie), 0.00001);
	}
}
