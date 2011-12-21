package br.com.while42.argentum.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class CandleStickFactory {
	public Candlestick buidCandleToDate(Calendar date, List<Trade> trades) {
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

		return new Candlestick(first, close, min, max, volume, date);
	}	
		
	public List<Candlestick> buildCandlesticks(List<Trade> trades) {
		List<Candlestick> candles = new ArrayList<Candlestick>();
		
		if (trades.isEmpty()) {
			return candles;
		}
		
		List<Trade> currentTrades = new ArrayList<Trade>();
		
		Calendar data = trades.get(0).getDate();		
		for (Trade t: trades) {
			if (t.isSameDay(data)) {
				currentTrades.add(t);
			} else {
				candles.add(buidCandleToDate(data, currentTrades));
				data = t.getDate(); 
				currentTrades.clear();
				currentTrades.add(t);
			}
		}
		
		candles.add(buidCandleToDate(data, currentTrades));
		
		return candles;
	}

}
