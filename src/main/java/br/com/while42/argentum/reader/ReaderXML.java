package br.com.while42.argentum.reader;

import java.io.Reader;
import java.util.List;

import br.com.while42.argentum.model.Trade;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class ReaderXML {
	
	public List<Trade> load(Reader source) {		
		XStream stream = new XStream(new DomDriver());
		stream.alias("trade", Trade.class);
		return (List<Trade>) stream.fromXML(source);
	}
}
