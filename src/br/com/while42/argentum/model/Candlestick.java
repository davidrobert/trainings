package br.com.while42.argentum.model;

import java.util.Calendar;

public class Candlestick {
	private final double first;
	private final double close;
	private final double min;
	private final double max;
	private final double volume;
	private final Calendar date;
	
	public Candlestick(double first, double close, double min, double max,
			double volume, Calendar date) {
		super();
		this.first = first;
		this.close = close;
		this.min = min;
		this.max = max;
		this.volume = volume;
		this.date = date;
	}

	public double getFirst() {
		return first;
	}

	public double getClose() {
		return close;
	}

	public double getMin() {
		return min;
	}

	public double getMax() {
		return max;
	}

	public double getVolume() {
		return volume;
	}

	public Calendar getDate() {
		return date;
	}
	
	public boolean isHigh() {
		return first < close;
	}
	
	public boolean isLow() {
		return first > close;
	}
}
