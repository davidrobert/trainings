package br.com.while42.argentum.model;

import java.util.Calendar;

public class Candle {
	private final double first;
	private final double last;
	private final double min;
	private final double max;
	private final double volume;
	private final Calendar date;

	public Candle(double first, double close, double min, double max, double volume, Calendar date) {
		validate(first, close, min, max, date);

		this.first = first;
		this.last = close;
		this.min = min;
		this.max = max;
		this.volume = volume;
		this.date = date;
	}

	private void validate(double first, double close, double min, double max, Calendar date) {
		if (date == null) {
			throw new IllegalArgumentException("Date is null");
		}

		if (first < 0 || close < 0 || min < 0 || max < 0) {
			throw new IllegalArgumentException("Value < 0");
		}

		if (first > 100000 || close > 100000 || min > 100000 || max > 100000) {
			throw new IllegalArgumentException("Value > 100000");
		}
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
		b.append("Date ").append(date.getTime());
		b.append("]");
		return b.toString();
	}
}
