package br.com.while42.argentum;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import br.com.while42.argentum.indicators.SimpleMovingAverageTest;
import br.com.while42.argentum.indicators.WeightedMovingAverageTest;
import br.com.while42.argentum.model.CandleFactoryTest;
import br.com.while42.argentum.model.CandleTest;
import br.com.while42.argentum.model.TimeSeriesTest;
import br.com.while42.argentum.model.TradeTest;
import br.com.while42.argentum.reader.ReaderXMLTest;

import junit.framework.Test;
import junit.framework.TestSuite;

@RunWith(Suite.class)
@Suite.SuiteClasses({ SimpleMovingAverageTest.class, WeightedMovingAverageTest.class,
		CandleFactoryTest.class, CandleTest.class, TimeSeriesTest.class, TradeTest.class, ReaderXMLTest.class })
public class AllTests {

	public static Test suite() {
		TestSuite suite = new TestSuite(AllTests.class.getName());
		// $JUnit-BEGIN$

		// $JUnit-END$
		return suite;
	}

}
