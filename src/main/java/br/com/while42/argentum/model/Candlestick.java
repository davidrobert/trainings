package br.com.while42.argentum.model;

import java.util.Calendar;

public class Candlestick {
	private final double first;
	private final double last;
	private final double min;
	private final double max;
	private final double volume;
	private final Calendar date;

	public Candlestick(double first, double close, double min, double max,
			double volume, Calendar date) {
		super();
		this.first = first;
		this.last = close;
		this.min = min;
		this.max = max;
		this.volume = volume;
		this.date = date;
	}

	public double getFirst() {
		return first;
	}

	public double getLast() {
		return last;
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
		return first < last;
	}

	public boolean isLow() {
		return first > last;
	}
	
	@Override
	public String toString() {
		StringBuilder b = new StringBuilder();
		b.append("[");
		b.append("Open ").append(first).append(", ");
		b.append("Close ").append(last).append(", ");
		b.append("Min ").append(min).append(", ");
		b.append("Max ").append(max).append(", ");
		b.append("Volume ").append(volume).append(", ");
		b.append("Date ").append(date);
		b.append("]");
		return b.toString();
	}
}
