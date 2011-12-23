package br.com.while42.argentum.graphics;

import java.io.IOException;
import java.io.OutputStream;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import br.com.while42.argentum.indicators.Indicator;
import br.com.while42.argentum.model.TimeSeries;

public class GraphGenerator {

	private TimeSeries serie;
	private int start;
	private int end;
	
	private DefaultCategoryDataset dataset;
	private JFreeChart graph;	
	
	public GraphGenerator(TimeSeries serie, int start, int end) {
		this.serie = serie;
		this.start = start;
		this.end = end;
	}
		
	public void buildGraph(String title) {
		dataset = new DefaultCategoryDataset();
		graph = ChartFactory.createLineChart(title, "Dias", "Valores", dataset, PlotOrientation.VERTICAL, true, true, false);
	}
	
	public void plotIndicator(Indicator indicator) {
		for (int i = start; i <= end; i++) {
			double value = indicator.calcule(i, serie);
			dataset.addValue(value, indicator.toString(), new Integer(i));
		}
	}
	
	public void save(OutputStream out) throws IOException {
		ChartUtilities.writeChartAsPNG(out, graph, 500, 350);
	}
	
	public JPanel getPanel() {
		return new ChartPanel(graph);
	}
	
}
