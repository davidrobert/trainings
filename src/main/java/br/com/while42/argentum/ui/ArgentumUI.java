package br.com.while42.argentum.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Locale;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.LineBorder;

import br.com.while42.argentum.graphics.Chart;
import br.com.while42.argentum.indicators.FirstValueIndicator;
import br.com.while42.argentum.indicators.LastValueIndicator;
import br.com.while42.argentum.indicators.SimpleMovingAverage;
import br.com.while42.argentum.indicators.WeightedMovingAverage;
import br.com.while42.argentum.model.Candle;
import br.com.while42.argentum.model.CandleFactory;
import br.com.while42.argentum.model.TimeSerie;
import br.com.while42.argentum.model.Trade;

public class ArgentumUI {

	private JFrame window;
	private JPanel mainPanel;
	private JTable table;
	private JTabbedPane tabs;
	private JPanel panelButtons;
	

	public static void main(String[] args) {

		Locale.setDefault(new Locale("pt", "BR"));

		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		
		new ArgentumUI().showWindow();
	}

	private void showWindow() {
		buildWindow();
		buildMainPanel();
		builTitle();
		buildTabs();
		buildPainelButtons();
		buildLoadButton();
		buildExitButton();
		buildTable();
		showScreen();
	}

	private void builTitle() {
		JLabel title = new JLabel("List of Trades");
		title.setFont(new Font("Verdana", Font.BOLD, 25));
		title.setForeground(new Color(50, 50, 100));
		title.setHorizontalAlignment(SwingConstants.CENTER);
		mainPanel.add(title, BorderLayout.NORTH);
	}

	private void buildWindow() {
		window = new JFrame("Argentum");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void buildMainPanel() {
		mainPanel = new JPanel();

		// mainPanel.setLayout(new FlowLayout());
		// mainPanel.setLayout(new GridLayout());
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		// mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.X_AXIS));

		window.add(mainPanel);
	}

	private void buildTable() {
		table = new JTable();

		table.setBorder(new LineBorder(Color.black));
		table.setGridColor(Color.black);
		table.setShowGrid(true);

		JScrollPane scroll = new JScrollPane();
		scroll.getViewport().setBorder(null);
		scroll.getViewport().add(table);
		scroll.setSize(200, 200);

		tabs.setComponentAt(0, scroll);
		// mainPanel.add(scroll);
	}

	private void buildPainelButtons() {
		panelButtons = new JPanel(new GridLayout());
		mainPanel.add(panelButtons);
	}

	private void buildLoadButton() {
		JButton bLoad = new JButton("Load XML");

		bLoad.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				loadData();				
			}
		});

		panelButtons.add(bLoad);
	}

	private void buildExitButton() {
		JButton bExit = new JButton("Exit");

		bExit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		panelButtons.add(bExit);
	}

	private void showScreen() {
		window.pack();
		window.setVisible(true);
		window.setSize(700, 600);
	}

	private void buildTabs() {
		tabs = new JTabbedPane();
		tabs.addTab("Tabela de Negocios", null);
		tabs.addTab("Gráfico", null);

		mainPanel.add(tabs);
	}

	private void loadData() {
		List<Trade> trades = new ChooseXML().selectFile();

		TradeTableModel tableModel = new TradeTableModel(trades);
		this.table.setModel(tableModel);

		CandleFactory factory = new CandleFactory();
		List<Candle> candles = factory.buildCandle(trades);
		TimeSerie serie = new TimeSerie(candles);

		Chart chart = new Chart().withTimeSerie(serie).start(2).end(serie.getTotal() - 1)
				.title("Média Móvel Simples")
				.withIndicator(new WeightedMovingAverage(new FirstValueIndicator()))
				.withIndicator(new SimpleMovingAverage(new FirstValueIndicator()))
				.withIndicator(new WeightedMovingAverage(new LastValueIndicator()))
				.withIndicator(new SimpleMovingAverage(new LastValueIndicator()));
		
		JPanel panel = chart.getPanel();
		this.tabs.setComponentAt(1, panel);
	}

}
