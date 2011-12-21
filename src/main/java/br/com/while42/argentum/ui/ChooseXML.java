package br.com.while42.argentum.ui;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import br.com.while42.argentum.model.Trade;
import br.com.while42.argentum.reader.ReaderXML;

public class ChooseXML {

	public void selectFile() {

		try {
			JFileChooser fileChooser = new JFileChooser();
			int r = fileChooser.showOpenDialog(null);

			if (r == JFileChooser.APPROVE_OPTION) {
				FileReader reader = new FileReader(fileChooser.getSelectedFile());
				List<Trade> trades = new ReaderXML().load(reader);
				
				Trade firstTrade = trades.get(0);
				String msg = "First trade of day: " + firstTrade.getValue();
				JOptionPane.showMessageDialog(null, msg);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new ChooseXML().selectFile();
	}

}
