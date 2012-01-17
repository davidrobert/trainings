package br.com.while42.argentum.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

public class CandleFactory {
	public Candle buidCandleToDate(Calendar date, List<Trade> trades) {
		if (date == null) {
			throw new IllegalArgumentException();
		}

		double min = trades.isEmpty() ? 0 : Double.MAX_VALUE;
		double max = 0;

		double volume = 0.0;

		for (Trade op : trades) {
			volume += op.getVolume();

			if (op.getValue() > max) {
				max = op.getValue();
			}

			if (op.getValue() < min) {
				min = op.getValue();
			}
		}

		double first = trades.isEmpty() ? 0 : trades.get(0).getValue();
		double close = trades.isEmpty() ? 0 : trades.get(trades.size() - 1).getValue();

		return new Candle(first, close, min, max, volume, date);
	}

	public List<Candle> buildCandle(List<Trade> trades) {
		List<Candle> candles = new ArrayList<Candle>();

		if (trades.isEmpty()) {
			return candles;
		}

		Collections.sort(trades);

		List<Trade> currentTrades = new ArrayList<Trade>();

		Calendar today = trades.get(0).getDate();
		for (Trade t : trades) {
			if (today.before(t)) {
				throw new IllegalStateException("fora de ordem [d1:" + today.toString() + " d2:" 
						+ t.getDate().toString());
			}

			if (t.isSameDay(today)) {
				currentTrades.add(t);
			} else {
				makeCandle(candles, currentTrades, today);
				
				today = t.getDate();
				currentTrades.clear();
				currentTrades.add(t);
			}
		}

		makeCandle(candles, currentTrades, today);

		return candles;
	}

	private void makeCandle(List<Candle> candles, List<Trade> currentTrades, Calendar today) {
		Candle candle = buidCandleToDate(today, currentTrades);
		candles.add(candle);
	}

}
