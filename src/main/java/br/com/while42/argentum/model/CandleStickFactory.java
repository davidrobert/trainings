package br.com.while42.argentum.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
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
		
		Collections.sort(trades);
		
		List<Trade> currentTrades = new ArrayList<Trade>();
		
		Calendar today = trades.get(0).getDate();		
		for (Trade t: trades) {
			if (today.before(t)) {
				throw new IllegalStateException("fora de ordem [d1:" + today.toString() + " d2:" + t.getDate().toString());
			}
			
			if (t.isSameDay(today)) {
				currentTrades.add(t);
			} else {
				candles.add(buidCandleToDate(today, currentTrades));
				today = t.getDate(); 
				currentTrades.clear();
				currentTrades.add(t);
			}
		}
		
		candles.add(buidCandleToDate(today, currentTrades));
		
		return candles;
	}

}
