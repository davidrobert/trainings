package br.com.while42.argentum.ui;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import br.com.while42.argentum.model.Trade;
import br.com.while42.argentum.reader.ReaderXML;

public class ChooseXML {

	public List<Trade> selectFile() {

		List<Trade> trades = new ArrayList<Trade>();
		
		try {
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setFileFilter(new FileNameExtensionFilter("Only XML", "xml"));
			
			int r = fileChooser.showOpenDialog(null);			
			
			if (r == JFileChooser.APPROVE_OPTION) {
				FileReader reader = new FileReader(fileChooser.getSelectedFile());
				trades = new ReaderXML().load(reader);
				
				// Trade firstTrade = trades.get(0);
				// String msg = "First trade of day: " + firstTrade.getValue();
				// JOptionPane.showMessageDialog(null, msg);
			}
				
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return trades;
	}

	public static void main(String[] args) {
		new ChooseXML().selectFile();
	}

}
