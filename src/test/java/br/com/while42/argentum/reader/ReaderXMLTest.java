package br.com.while42.argentum.reader;

import java.io.StringReader;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

import br.com.while42.argentum.model.Trade;


public class ReaderXMLTest {
	
	@Test
	public void ReaderFromXMLToLoadTradeList() {
		StringBuilder sb = new StringBuilder();
		sb.append("<list>");
		sb.append("<trade>");
		sb.append("<value>43.5</value>");
		sb.append("<ammount>100</ammount>");
		sb.append("<date><time>555454646</time></date>");
		sb.append("</trade>");
		sb.append("</list>");
		
		ReaderXML reader = new ReaderXML();
		
		List<Trade> list = reader.load(new StringReader(sb.toString()));
		
		Trade t = list.get(0);
		Assert.assertEquals(43.5, t.getValue(), 0.00001);
		Assert.assertEquals(100, t.getAmmount());
		Assert.assertEquals(555454646, t.getDate().getTimeInMillis());
	}
}
