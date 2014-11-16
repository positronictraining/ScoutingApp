package io.github.positronictraining.scouting486;

import javax.swing.table.AbstractTableModel;

public class TableModel extends AbstractTableModel{
	
	private String[] columnNames = {
			"Team",
			"Wins",
			"Losses",
			"Total Points",
			"Total Penalties"
	};
	private Object[][] data = {};
	
	public int getRowCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
