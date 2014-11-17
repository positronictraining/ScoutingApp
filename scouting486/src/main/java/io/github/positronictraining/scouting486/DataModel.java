package io.github.positronictraining.scouting486;

import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

public class DataModel extends AbstractTableModel{
	
	public DataModel(){
		ArrayList<Object> e = new ArrayList<Object>();
		e.add("0");
		e.add("0");
		e.add("0");
		e.add("0");
		e.add("0");
		data.add(e);
	}
	
	private String[] columnNames = {
			"Team",
			"Wins",
			"Losses",
			"Total Points",
			"Total Penalties"
	};
	private ArrayList<ArrayList<Object>> data = new ArrayList<ArrayList<Object>>();
	
	public int getRowCount() {
		// TODO Auto-generated method stub
		return data.size();
	}

	public int getColumnCount() {
		// TODO Auto-generated method stub
		return columnNames.length;
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return data.get(rowIndex).get(columnIndex);
	}
	
	public String getColumnName(int column){
		return columnNames[column];
	}
	
	public void updateData(Competition competition){
		data.clear();
		ArrayList<Robot> allTeams = competition.getRobots();
		System.out.println(allTeams.size());
		for (int i = 0; i < allTeams.size(); i++){
			data.add(competition.teamStats(allTeams.get(i).teamNumber));
		}
		this.fireTableStructureChanged();
	}
}
