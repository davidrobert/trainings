package br.com.while42.argentum.ui;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import br.com.while42.argentum.model.Trade;

public class TradeTableModel extends AbstractTableModel {

	private static final long serialVersionUID = 1L;
	private final List<Trade> trades;
	private final DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
	private final NumberFormat nf = NumberFormat.getCurrencyInstance();

	public TradeTableModel(List<Trade> trades) {
		this.trades = trades;
	}

	@Override
	public int getRowCount() {
		return trades.size();
	}

	@Override
	public int getColumnCount() {
		return 3;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {

		Trade t = trades.get(rowIndex);

		switch (columnIndex) {
		case 0:			
			return nf.format(t.getValue());
		case 1:
			return t.getAmmount();
		case 2:			
			return df.format(t.getDate().getTime());
		}

		return null;
	}
	
	@Override
	public String getColumnName(int column) {
		switch (column) {
		case 0:			
			return "Preço";
		case 1:
			return "Quantidade";
		case 2:			
			return "Data";
		}

		return null;
	}

}
