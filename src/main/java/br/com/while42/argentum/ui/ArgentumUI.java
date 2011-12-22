package br.com.while42.argentum.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ArgentumUI {

	private JFrame window;
	private JPanel mainPanel;

	public static void main(String[] args) {
		new ArgentumUI().showWindow();
	}
	
	private void showWindow() {
		buildWindow();
		buildMainPanel();
		buildLoadButton();
		buildExitButton();
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

	private void buildLoadButton() {
		JButton bLoad = new JButton("Load XML");
		
		bLoad.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new ChooseXML().selectFile();
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
