package br.com.while42.argentum.model;

import java.util.Calendar;

public class CandleBuilder {
	private double first;
	private double last;
	private double min;
	private double max;
	private double volume;
	private Calendar date;
	
	public CandleBuilder first(double first) {
		this.first = first;
		return this;
	}
	
	public CandleBuilder last(double last) {
		this.last = last;
		return this;
	}
	
	public CandleBuilder min(double min) {
		this.min = min;
		return this;
	}
	
	public CandleBuilder max(double max) {
		this.max = max;
		return this;
	}
	
	public CandleBuilder volume(double volume) {
		this.volume = volume;
		return this;
	}
	
	public CandleBuilder date(Calendar date) {
		this.date = date;
		return this;
	}
	
	public Candle builCandle() {
		return new Candle(first, last, min, max, volume, date);
	}
}
