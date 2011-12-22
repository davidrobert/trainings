package br.com.while42.argentum.ui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;

import br.com.while42.argentum.model.Trade;

public class ArgentumUI {

	private JFrame window;
	private JPanel mainPanel;
	private JTable table;

	public static void main(String[] args) {
		new ArgentumUI().showWindow();
	}
	
	private void showWindow() {
		buildWindow();
		buildMainPanel();		
		buildLoadButton();
		buildExitButton();
		buildTable();
		showScreen();		
	}

	private void buildWindow() {
		window = new JFrame("Argentum");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private void buildMainPanel() {
		mainPanel = new JPanel();
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
		
		mainPanel.add(scroll);
	}

	private void buildLoadButton() {
		JButton bLoad = new JButton("Load XML");
		
		bLoad.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				List<Trade> trades = new ChooseXML().selectFile();
				TradeTableModel tradeTable = new TradeTableModel(trades);
				table.setModel(tradeTable);
			}
		});
		
		mainPanel.add(bLoad);
	}
	
	private void buildExitButton() {
		JButton bExit = new JButton("Exit");
		
		bExit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		mainPanel.add(bExit);
	}
	
	private void showScreen() {
		window.pack();				
		window.setVisible(true);
		window.setSize(540, 540);
	}

}
