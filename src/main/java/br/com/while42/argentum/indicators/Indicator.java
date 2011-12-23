package br.com.while42.argentum.indicators;

import br.com.while42.argentum.model.TimeSeries;

public interface Indicator {
	public abstract double calcule(int position, TimeSeries serie); 
}