package io.github.positronictraining.scouting486;

import javax.swing.table.AbstractTableModel;

public class DataModel extends AbstractTableModel{
	
	private String[] columnNames = {
			"Team",
			"Wins",
			"Losses",
			"Total Points",
			"Total Penalties"
	};
	private Object[][] data = {{"486","1000","0","1000000","0"}};
	
	public int getRowCount() {
		// TODO Auto-generated method stub
		return 1;
	}

	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 5;
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return data[rowIndex][columnIndex];
	}
	
	public String getColumnName(int column){
		return columnNames[column];
	}
	
}
