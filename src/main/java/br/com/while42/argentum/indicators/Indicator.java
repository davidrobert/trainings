package br.com.while42.argentum.indicators;

import br.com.while42.argentum.model.TimeSerie;

public interface Indicator {
	public abstract double calcule(int position, TimeSerie serie);
}