package br.com.while42.argentum.ui;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import br.com.while42.argentum.model.Trade;

public class TradeTableModel extends AbstractTableModel {

	private static final long serialVersionUID = 1L;
	private final List<Trade> trades;

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
			return t.getValue();
		case 1:
			return t.getAmmount();
		case 2:
			return t.getDate();
		}

		return null;
	}

}
