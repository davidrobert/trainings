package br.com.while42.argentum.model;

import java.util.Calendar;

public final class Trade {
	
	private final double value; // TODO: Change to BigDecimal
	private final int ammount;
	private final Calendar date; 
		
	public Trade(double value, int ammount, Calendar date) {
		if (date == null) {
			throw new IllegalArgumentException();
		}
		
		this.value = value;
		this.ammount = ammount;
		this.date = date;
	}

	public double getValue() {
		return value;
	}
	
	public int getAmmount() {
		return ammount;
	}
	 
	public double getVolume() {
		return value * ammount;
	}
	 
	public Calendar getDate() {
		return (Calendar) date.clone();
	}
	
	public boolean isSameDay(Calendar d) {
		return date.get(Calendar.DAY_OF_MONTH) == d.get(Calendar.DAY_OF_MONTH)
				&& date.get(Calendar.MONTH) == d.get(Calendar.MONTH)
				&& date.get(Calendar.YEAR) == d.get(Calendar.YEAR);
	}
}
