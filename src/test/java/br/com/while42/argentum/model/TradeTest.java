package br.com.while42.argentum.model;

import java.util.Calendar;

import junit.framework.Assert;

import org.junit.Test;


public class TradeTest {

	@Test
	public void imutableDate() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_MONTH, 15);
		
		Trade trade = new Trade(10, 5, calendar);
		trade.getDate().set(Calendar.DAY_OF_MONTH, 20);
		
		Assert.assertEquals(15, trade.getDate().get(Calendar.DAY_OF_MONTH));
	}
}
