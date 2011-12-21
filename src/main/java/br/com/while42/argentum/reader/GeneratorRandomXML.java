package br.com.while42.argentum.reader;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;

import br.com.while42.argentum.model.Trade;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class GeneratorRandomXML {
	
	public static void main(String[] args) {
		Calendar date = Calendar.getInstance();
		Random random = new Random(123);
		ArrayList<Trade> trades = new ArrayList<Trade>();
		
		double value = 40;
		int qtd = 1000;
		
		// 30 days
		for (int i = 0; i < 30; i++) {
			
			// 0 to 19 trades per day
			for (int x = 0; x < random.nextInt(20); x++) {
				
				// adds or subtracts 1.00
				value += (random.nextInt(200) - 100) / 100.0;
				
				// adds 100 ou subtracts 100
				value += (random.nextInt(200) - 100);
				
				Trade trade = new Trade(value, qtd, date);
				trades.add(trade);												
			}
			
			date = (Calendar) date.clone();
			date.add(Calendar.DAY_OF_YEAR, 1);
		}
		
		XStream stream = new XStream(new DomDriver());
		stream.alias("trade", Trade.class);
		System.out.println(stream.toXML(trades));
	}
}
