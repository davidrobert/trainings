package br.com.while42.argentum.graphics;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.swing.JFrame;

import br.com.while42.argentum.indicators.LastValueIndicator;
import br.com.while42.argentum.indicators.SimpleMovingAverage;
import br.com.while42.argentum.indicators.WeightedMovingAverage;
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
		TimeSeries serie = buildTimeSerie(1, 2, 3, 4, 5, 6, 7, 8, 8, 9, 9, 4, 3, 2, 1, 2, 2, 4, 5, 6, 7, 8,
				9, 10, 11, 10, 6, 3, 2, 6, 7, 8, 9);

		GraphGenerator g = new GraphGenerator(serie, 3, 32);
		g.buildGraph("Start graph");
		g.plotIndicator(new SimpleMovingAverage());
		g.plotIndicator(new LastValueIndicator());
		g.plotIndicator(new WeightedMovingAverage());
		
		JFrame frame = new JFrame("Minha Janela");
		frame.add(g.getPanel());
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
}
