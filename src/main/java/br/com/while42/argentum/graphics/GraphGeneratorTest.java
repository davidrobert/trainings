package br.com.while42.argentum.graphics;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.KeyStore.Builder;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.while42.argentum.indicators.SimpleMovingAverage;
import br.com.while42.argentum.model.Candle;
import br.com.while42.argentum.model.TimeSeries;

public class GraphGeneratorTest {

	private static TimeSeries buildTimeSerie(double... values) {
		List<Candle> candles = new ArrayList<Candle>();
		for (double d : values) {
			candles.add(new Candle(d, d, d, d, 1000, Calendar.getInstance()));
		}
		return new TimeSeries(candles);
	}

	public static void main(String[] args) {
		TimeSeries serie = buildTimeSerie(1, 2, 3, 4, 5, 6, 7, 8, 8, 9, 9, 4, 3, 2, 2, 2, 2);
		
		GraphGenerator g = new GraphGenerator(serie, 2, 15);
		g.buildGraph("Start graph");
		g.plotIndicator(new SimpleMovingAverage());
		
		try {
			g.save(new FileOutputStream("output.png"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
}
