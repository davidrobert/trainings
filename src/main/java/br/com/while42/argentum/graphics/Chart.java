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
import br.com.while42.argentum.model.TimeSerie;

public class Chart {

	private TimeSerie serie;
	private int start;
	private int end;

	private DefaultCategoryDataset dataset;
	private JFreeChart chart;

	private String title;

	public Chart title(String title) {
		this.title = title;
		return this;
	}

	public Chart withTimeSerie(TimeSerie serie) {
		this.serie = serie;
		return this;
	}

	public Chart start(int start) {
		this.start = start;
		return this;
	}

	public Chart end(int end) {
		this.end = end;
		return this;
	}

	public Chart withIndicator(Indicator indicator) {
		makeGraph();

		for (int i = start; i <= end; i++) {
			double value = indicator.calcule(i, serie);
			dataset.addValue(value, indicator.toString(), new Integer(i));
		}
		return this;
	}

	public Chart save(OutputStream out) throws IOException {
		makeGraph();
		ChartUtilities.writeChartAsPNG(out, chart, 500, 350);
		return this;
	}

	public JPanel getPanel() {
		makeGraph();
		return new ChartPanel(chart);
	}

	private Chart makeGraph() {
		if (dataset == null || chart == null) {
			dataset = new DefaultCategoryDataset();
			chart = ChartFactory.createLineChart(title, "Dias", "Valores", dataset, PlotOrientation.VERTICAL,
					true, true, false);
		}
		return this;
	}

}
