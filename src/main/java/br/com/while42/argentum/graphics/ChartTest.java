package br.com.while42.argentum.graphics;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.swing.JFrame;

import br.com.while42.argentum.indicators.FirstValueIndicator;
import br.com.while42.argentum.indicators.LastValueIndicator;
import br.com.while42.argentum.indicators.SimpleMovingAverage;
import br.com.while42.argentum.indicators.WeightedMovingAverage;
import br.com.while42.argentum.model.Candle;
import br.com.while42.argentum.model.TimeSerie;

public class ChartTest {

	private static TimeSerie buildTimeSerie(double... values) {
		List<Candle> candles = new ArrayList<Candle>();
		for (double d : values) {
			candles.add(new Candle(d, d, d, d, 1000, Calendar.getInstance()));
		}
		return new TimeSerie(candles);
	}

	public static void main(String[] args) {
		TimeSerie serie = buildTimeSerie(1, 2, 3, 4, 5, 6, 7, 8, 8, 9, 9, 4, 3, 2, 1, 2, 2, 4, 5, 6, 7, 8, 9,
				10, 11, 10, 6, 3, 2, 6, 7, 8, 9);

		Chart g = new Chart().title("Start graph").start(3).end(32).withTimeSerie(serie)
				.withIndicator(new SimpleMovingAverage(new LastValueIndicator()))
				.withIndicator(new WeightedMovingAverage(new LastValueIndicator()))
				.withIndicator(new LastValueIndicator())
				.withIndicator(new SimpleMovingAverage(new FirstValueIndicator()))
				.withIndicator(new WeightedMovingAverage(new FirstValueIndicator()))
				.withIndicator(new FirstValueIndicator());

		JFrame frame = new JFrame("Minha Janela");
		frame.add(g.getPanel());

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
}
