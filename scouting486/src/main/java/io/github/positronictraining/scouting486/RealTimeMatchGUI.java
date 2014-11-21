package io.github.positronictraining.scouting486;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.GridBagLayout;

import javax.swing.JLabel;

import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.ComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JSpinner;

public class RealTimeMatchGUI extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JComboBox pointTypeRed1;
	private JComboBox pointTypeRed2;
	private JComboBox pointTypeRed3;
	private JComboBox pointTypeBlue1;
	private JComboBox pointTypeBlue2;
	private JComboBox pointTypeBlue3;
	private JTextField penaltyBoxRed1;
	private JTextField penaltyBoxRed2;
	private JTextField penaltyBoxRed3;
	private JTextField penaltyBoxBlue1;
	private JTextField penaltyBoxBlue2;
	private JTextField penaltyBoxBlue3;
	private JSpinner penaltyValRed1;
	private JSpinner penaltyValRed2;
	private JSpinner penaltyValRed3;
	private JSpinner penaltyValBlue1;
	private JSpinner penaltyValBlue2;
	private JSpinner penaltyValBlue3;
	private JTextField redScore;
	private JTextField blueScore;
	
	private SerializationComm serialComm;
	private DataModel dataModel;
	private Match match;

	public RealTimeMatchGUI(SerializationComm serialComm, DataModel dataModel, Match newMatch) {
		
		this.serialComm = serialComm;
		this.dataModel = dataModel;
		this.match = newMatch;
		ArrayList<Point> refreshedPointTypes = serialComm.getLibrary().getSelectedGame().getPointTypes();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 450);
		contentPane = new JPanel();
		contentPane.setForeground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel redAlliance = new JLabel("Red Alliance");
		redAlliance.setForeground(Color.RED);
		GridBagConstraints gbc_redAlliance = new GridBagConstraints();
		gbc_redAlliance.insets = new Insets(0, 0, 5, 5);
		gbc_redAlliance.gridx = 0;
		gbc_redAlliance.gridy = 0;
		contentPane.add(redAlliance, gbc_redAlliance);
		
		JLabel lblPointTypes = new JLabel("Point Types");
		GridBagConstraints gbc_lblPointTypes = new GridBagConstraints();
		gbc_lblPointTypes.insets = new Insets(0, 0, 5, 5);
		gbc_lblPointTypes.gridx = 1;
		gbc_lblPointTypes.gridy = 0;
		contentPane.add(lblPointTypes, gbc_lblPointTypes);
		
		JLabel lblPenalties = new JLabel("Penalties");
		GridBagConstraints gbc_lblPenalties = new GridBagConstraints();
		gbc_lblPenalties.insets = new Insets(0, 0, 5, 5);
		gbc_lblPenalties.gridx = 2;
		gbc_lblPenalties.gridy = 0;
		contentPane.add(lblPenalties, gbc_lblPenalties);
		
		JLabel lblRed1 = new JLabel(match.redAlliance[0]);
		GridBagConstraints gbc_lblRed1 = new GridBagConstraints();
		gbc_lblRed1.anchor = GridBagConstraints.EAST;
		gbc_lblRed1.insets = new Insets(0, 0, 5, 5);
		gbc_lblRed1.gridx = 0;
		gbc_lblRed1.gridy = 1;
		contentPane.add(lblRed1, gbc_lblRed1);
		
		pointTypeRed1 = new JComboBox(refreshedPointTypes.toArray(new Point[refreshedPointTypes.size()]));
		GridBagConstraints gbc_pointTypeRed1 = new GridBagConstraints();
		gbc_pointTypeRed1.insets = new Insets(0, 0, 5, 5);
		gbc_pointTypeRed1.fill = GridBagConstraints.HORIZONTAL;
		gbc_pointTypeRed1.gridx = 1;
		gbc_pointTypeRed1.gridy = 1;
		contentPane.add(pointTypeRed1, gbc_pointTypeRed1);
		
		penaltyBoxRed1 = new JTextField();
		GridBagConstraints gbc_penaltyBoxRed1 = new GridBagConstraints();
		gbc_penaltyBoxRed1.insets = new Insets(0, 0, 5, 5);
		gbc_penaltyBoxRed1.fill = GridBagConstraints.HORIZONTAL;
		gbc_penaltyBoxRed1.gridx = 2;
		gbc_penaltyBoxRed1.gridy = 1;
		contentPane.add(penaltyBoxRed1, gbc_penaltyBoxRed1);
		penaltyBoxRed1.setColumns(10);
		
		penaltyValRed1 = new JSpinner();
		GridBagConstraints gbc_penaltyValRed1 = new GridBagConstraints();
		gbc_penaltyValRed1.fill = GridBagConstraints.HORIZONTAL;
		gbc_penaltyValRed1.insets = new Insets(0, 0, 5, 0);
		gbc_penaltyValRed1.gridx = 3;
		gbc_penaltyValRed1.gridy = 1;
		contentPane.add(penaltyValRed1, gbc_penaltyValRed1);
		
		JLabel lblRed2 = new JLabel(match.redAlliance[1]);
		GridBagConstraints gbc_lblRed2 = new GridBagConstraints();
		gbc_lblRed2.anchor = GridBagConstraints.EAST;
		gbc_lblRed2.insets = new Insets(0, 0, 5, 5);
		gbc_lblRed2.gridx = 0;
		gbc_lblRed2.gridy = 2;
		contentPane.add(lblRed2, gbc_lblRed2);
		
		pointTypeRed2 = new JComboBox(refreshedPointTypes.toArray(new Point[refreshedPointTypes.size()]));
		GridBagConstraints gbc_pointTypeRed2 = new GridBagConstraints();
		gbc_pointTypeRed2.insets = new Insets(0, 0, 5, 5);
		gbc_pointTypeRed2.fill = GridBagConstraints.HORIZONTAL;
		gbc_pointTypeRed2.gridx = 1;
		gbc_pointTypeRed2.gridy = 2;
		contentPane.add(pointTypeRed2, gbc_pointTypeRed2);
		
		penaltyBoxRed2 = new JTextField();
		GridBagConstraints gbc_penaltyBoxRed2 = new GridBagConstraints();
		gbc_penaltyBoxRed2.insets = new Insets(0, 0, 5, 5);
		gbc_penaltyBoxRed2.fill = GridBagConstraints.HORIZONTAL;
		gbc_penaltyBoxRed2.gridx = 2;
		gbc_penaltyBoxRed2.gridy = 2;
		contentPane.add(penaltyBoxRed2, gbc_penaltyBoxRed2);
		penaltyBoxRed2.setColumns(10);
		
		penaltyValRed2 = new JSpinner();
		GridBagConstraints gbc_penaltyValRed2 = new GridBagConstraints();
		gbc_penaltyValRed2.fill = GridBagConstraints.HORIZONTAL;
		gbc_penaltyValRed2.insets = new Insets(0, 0, 5, 0);
		gbc_penaltyValRed2.gridx = 3;
		gbc_penaltyValRed2.gridy = 2;
		contentPane.add(penaltyValRed2, gbc_penaltyValRed2);
		
		JLabel lblRed3 = new JLabel(match.redAlliance[2]);
		GridBagConstraints gbc_lblRed3 = new GridBagConstraints();
		gbc_lblRed3.insets = new Insets(0, 0, 5, 5);
		gbc_lblRed3.anchor = GridBagConstraints.BELOW_BASELINE_TRAILING;
		gbc_lblRed3.gridx = 0;
		gbc_lblRed3.gridy = 3;
		contentPane.add(lblRed3, gbc_lblRed3);
		
		pointTypeRed3 = new JComboBox(refreshedPointTypes.toArray(new Point[refreshedPointTypes.size()]));
		GridBagConstraints gbc_pointTypeRed3 = new GridBagConstraints();
		gbc_pointTypeRed3.insets = new Insets(0, 0, 5, 5);
		gbc_pointTypeRed3.fill = GridBagConstraints.HORIZONTAL;
		gbc_pointTypeRed3.gridx = 1;
		gbc_pointTypeRed3.gridy = 3;
		contentPane.add(pointTypeRed3, gbc_pointTypeRed3);
		
		penaltyBoxRed3 = new JTextField();
		GridBagConstraints gbc_penaltyBoxRed3 = new GridBagConstraints();
		gbc_penaltyBoxRed3.insets = new Insets(0, 0, 5, 5);
		gbc_penaltyBoxRed3.fill = GridBagConstraints.HORIZONTAL;
		gbc_penaltyBoxRed3.gridx = 2;
		gbc_penaltyBoxRed3.gridy = 3;
		contentPane.add(penaltyBoxRed3, gbc_penaltyBoxRed3);
		penaltyBoxRed3.setColumns(10);
		
		penaltyValRed3 = new JSpinner();
		GridBagConstraints gbc_penaltyValRed3 = new GridBagConstraints();
		gbc_penaltyValRed3.fill = GridBagConstraints.HORIZONTAL;
		gbc_penaltyValRed3.insets = new Insets(0, 0, 5, 0);
		gbc_penaltyValRed3.gridx = 3;
		gbc_penaltyValRed3.gridy = 3;
		contentPane.add(penaltyValRed3, gbc_penaltyValRed3);
		
		JLabel lblBluealliance = new JLabel("BlueAlliance");
		lblBluealliance.setForeground(Color.BLUE);
		GridBagConstraints gbc_lblBluealliance = new GridBagConstraints();
		gbc_lblBluealliance.insets = new Insets(0, 0, 5, 5);
		gbc_lblBluealliance.gridx = 0;
		gbc_lblBluealliance.gridy = 5;
		contentPane.add(lblBluealliance, gbc_lblBluealliance);
		
		JLabel lblPointTypes_1 = new JLabel("Point Types");
		GridBagConstraints gbc_lblPointTypes_1 = new GridBagConstraints();
		gbc_lblPointTypes_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblPointTypes_1.gridx = 1;
		gbc_lblPointTypes_1.gridy = 5;
		contentPane.add(lblPointTypes_1, gbc_lblPointTypes_1);
		
		JLabel lblPenalties_1 = new JLabel("Penalties");
		GridBagConstraints gbc_lblPenalties_1 = new GridBagConstraints();
		gbc_lblPenalties_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblPenalties_1.gridx = 2;
		gbc_lblPenalties_1.gridy = 5;
		contentPane.add(lblPenalties_1, gbc_lblPenalties_1);
		
		JLabel lblBlue1 = new JLabel(match.blueAlliance[0]);
		lblBlue1.setForeground(Color.BLACK);
		GridBagConstraints gbc_lblBlue1 = new GridBagConstraints();
		gbc_lblBlue1.anchor = GridBagConstraints.EAST;
		gbc_lblBlue1.insets = new Insets(0, 0, 5, 5);
		gbc_lblBlue1.gridx = 0;
		gbc_lblBlue1.gridy = 6;
		contentPane.add(lblBlue1, gbc_lblBlue1);
		
		pointTypeBlue1 = new JComboBox(refreshedPointTypes.toArray(new Point[refreshedPointTypes.size()]));
		GridBagConstraints gbc_pointTypeBlue1 = new GridBagConstraints();
		gbc_pointTypeBlue1.insets = new Insets(0, 0, 5, 5);
		gbc_pointTypeBlue1.fill = GridBagConstraints.HORIZONTAL;
		gbc_pointTypeBlue1.gridx = 1;
		gbc_pointTypeBlue1.gridy = 6;
		contentPane.add(pointTypeBlue1, gbc_pointTypeBlue1);
		
		penaltyBoxBlue1 = new JTextField();
		GridBagConstraints gbc_penaltyBoxBlue1 = new GridBagConstraints();
		gbc_penaltyBoxBlue1.insets = new Insets(0, 0, 5, 5);
		gbc_penaltyBoxBlue1.fill = GridBagConstraints.HORIZONTAL;
		gbc_penaltyBoxBlue1.gridx = 2;
		gbc_penaltyBoxBlue1.gridy = 6;
		contentPane.add(penaltyBoxBlue1, gbc_penaltyBoxBlue1);
		penaltyBoxBlue1.setColumns(10);
		
		penaltyValBlue1 = new JSpinner();
		GridBagConstraints gbc_penaltyValBlue1 = new GridBagConstraints();
		gbc_penaltyValBlue1.fill = GridBagConstraints.HORIZONTAL;
		gbc_penaltyValBlue1.insets = new Insets(0, 0, 5, 0);
		gbc_penaltyValBlue1.gridx = 3;
		gbc_penaltyValBlue1.gridy = 6;
		contentPane.add(penaltyValBlue1, gbc_penaltyValBlue1);
		
		JLabel lblBlue2 = new JLabel(match.blueAlliance[1]);
		lblBlue2.setForeground(Color.BLACK);
		GridBagConstraints gbc_lblBlue2 = new GridBagConstraints();
		gbc_lblBlue2.insets = new Insets(0, 0, 5, 5);
		gbc_lblBlue2.anchor = GridBagConstraints.EAST;
		gbc_lblBlue2.gridx = 0;
		gbc_lblBlue2.gridy = 7;
		contentPane.add(lblBlue2, gbc_lblBlue2);
		
		pointTypeBlue2 = new JComboBox(refreshedPointTypes.toArray(new Point[refreshedPointTypes.size()]));
		GridBagConstraints gbc_pointTypeBlue2 = new GridBagConstraints();
		gbc_pointTypeBlue2.insets = new Insets(0, 0, 5, 5);
		gbc_pointTypeBlue2.fill = GridBagConstraints.HORIZONTAL;
		gbc_pointTypeBlue2.gridx = 1;
		gbc_pointTypeBlue2.gridy = 7;
		contentPane.add(pointTypeBlue2, gbc_pointTypeBlue2);
		
		penaltyBoxBlue2 = new JTextField();
		GridBagConstraints gbc_penaltyBoxBlue2 = new GridBagConstraints();
		gbc_penaltyBoxBlue2.insets = new Insets(0, 0, 5, 5);
		gbc_penaltyBoxBlue2.fill = GridBagConstraints.HORIZONTAL;
		gbc_penaltyBoxBlue2.gridx = 2;
		gbc_penaltyBoxBlue2.gridy = 7;
		contentPane.add(penaltyBoxBlue2, gbc_penaltyBoxBlue2);
		penaltyBoxBlue2.setColumns(10);
		
		penaltyValBlue2 = new JSpinner();
		GridBagConstraints gbc_penaltyValBlue2 = new GridBagConstraints();
		gbc_penaltyValBlue2.fill = GridBagConstraints.HORIZONTAL;
		gbc_penaltyValBlue2.insets = new Insets(0, 0, 5, 0);
		gbc_penaltyValBlue2.gridx = 3;
		gbc_penaltyValBlue2.gridy = 7;
		contentPane.add(penaltyValBlue2, gbc_penaltyValBlue2);
		
		JLabel lblBlue3 = new JLabel(match.blueAlliance[2]);
		lblBlue3.setForeground(Color.BLACK);
		GridBagConstraints gbc_lblBlue3 = new GridBagConstraints();
		gbc_lblBlue3.anchor = GridBagConstraints.EAST;
		gbc_lblBlue3.insets = new Insets(0, 0, 5, 5);
		gbc_lblBlue3.gridx = 0;
		gbc_lblBlue3.gridy = 8;
		contentPane.add(lblBlue3, gbc_lblBlue3);
		
		pointTypeBlue3 = new JComboBox(refreshedPointTypes.toArray(new Point[refreshedPointTypes.size()]));
		GridBagConstraints gbc_pointTypeBlue3 = new GridBagConstraints();
		gbc_pointTypeBlue3.insets = new Insets(0, 0, 5, 5);
		gbc_pointTypeBlue3.fill = GridBagConstraints.HORIZONTAL;
		gbc_pointTypeBlue3.gridx = 1;
		gbc_pointTypeBlue3.gridy = 8;
		contentPane.add(pointTypeBlue3, gbc_pointTypeBlue3);
		
		penaltyBoxBlue3 = new JTextField();
		GridBagConstraints gbc_penaltyBoxBlue3 = new GridBagConstraints();
		gbc_penaltyBoxBlue3.insets = new Insets(0, 0, 5, 5);
		gbc_penaltyBoxBlue3.fill = GridBagConstraints.HORIZONTAL;
		gbc_penaltyBoxBlue3.gridx = 2;
		gbc_penaltyBoxBlue3.gridy = 8;
		contentPane.add(penaltyBoxBlue3, gbc_penaltyBoxBlue3);
		penaltyBoxBlue3.setColumns(10);
		
		penaltyValBlue3 = new JSpinner();
		GridBagConstraints gbc_penaltyValBlue3 = new GridBagConstraints();
		gbc_penaltyValBlue3.fill = GridBagConstraints.HORIZONTAL;
		gbc_penaltyValBlue3.insets = new Insets(0, 0, 5, 0);
		gbc_penaltyValBlue3.gridx = 3;
		gbc_penaltyValBlue3.gridy = 8;
		contentPane.add(penaltyValBlue3, gbc_penaltyValBlue3);
		
		JButton btnSubmitPointsScored = new JButton("Submit Points Scored");
		btnSubmitPointsScored.addActionListener(this);
		GridBagConstraints gbc_btnSubmitPointsScored = new GridBagConstraints();
		gbc_btnSubmitPointsScored.insets = new Insets(0, 0, 5, 5);
		gbc_btnSubmitPointsScored.gridx = 1;
		gbc_btnSubmitPointsScored.gridy = 9;
		contentPane.add(btnSubmitPointsScored, gbc_btnSubmitPointsScored);
		
		JButton btnSubmitPenalties = new JButton("Submit Penalties");
		btnSubmitPenalties.addActionListener(this);
		GridBagConstraints gbc_btnSubmitPenalties = new GridBagConstraints();
		gbc_btnSubmitPenalties.insets = new Insets(0, 0, 5, 5);
		gbc_btnSubmitPenalties.gridx = 2;
		gbc_btnSubmitPenalties.gridy = 9;
		contentPane.add(btnSubmitPenalties, gbc_btnSubmitPenalties);
		
		JLabel lblRedAllianceScore = new JLabel("Red Alliance Score");
		lblRedAllianceScore.setForeground(Color.RED);
		GridBagConstraints gbc_lblRedAllianceScore = new GridBagConstraints();
		gbc_lblRedAllianceScore.insets = new Insets(0, 0, 5, 5);
		gbc_lblRedAllianceScore.gridx = 0;
		gbc_lblRedAllianceScore.gridy = 10;
		contentPane.add(lblRedAllianceScore, gbc_lblRedAllianceScore);
		
		redScore = new JTextField();
		redScore.setEditable(false);
		redScore.setForeground(Color.RED);
		GridBagConstraints gbc_redScore = new GridBagConstraints();
		gbc_redScore.fill = GridBagConstraints.HORIZONTAL;
		gbc_redScore.insets = new Insets(0, 0, 5, 5);
		gbc_redScore.gridx = 0;
		gbc_redScore.gridy = 11;
		contentPane.add(redScore, gbc_redScore);
		redScore.setColumns(10);
		
		JLabel lblBlueAllianceScore = new JLabel("Blue Alliance Score");
		lblBlueAllianceScore.setForeground(Color.BLUE);
		GridBagConstraints gbc_lblBlueAllianceScore = new GridBagConstraints();
		gbc_lblBlueAllianceScore.insets = new Insets(0, 0, 5, 5);
		gbc_lblBlueAllianceScore.gridx = 0;
		gbc_lblBlueAllianceScore.gridy = 12;
		contentPane.add(lblBlueAllianceScore, gbc_lblBlueAllianceScore);
		
		blueScore = new JTextField();
		blueScore.setEditable(false);
		blueScore.setForeground(Color.BLUE);
		GridBagConstraints gbc_blueScore = new GridBagConstraints();
		gbc_blueScore.fill = GridBagConstraints.HORIZONTAL;
		gbc_blueScore.insets = new Insets(0, 0, 0, 5);
		gbc_blueScore.gridx = 0;
		gbc_blueScore.gridy = 13;
		contentPane.add(blueScore, gbc_blueScore);
		blueScore.setColumns(10);
		
		this.setVisible(true);
	}
	
	private void resetPenaltyBoxes(){
		penaltyBoxRed1.setText(null);
		penaltyBoxRed2.setText(null);
		penaltyBoxRed3.setText(null);
		penaltyBoxBlue1.setText(null);
		penaltyBoxBlue2.setText(null);
		penaltyBoxBlue3.setText(null);
	}
	
	private void submitPenaltyBoxes(){
		if(checkIfNoValue(penaltyBoxRed1.getText())){
			match.penalty(penaltyBoxRed1.getText(), (Integer) penaltyValRed1.getValue(), match.redAlliance[0], "red");
		}
		if(checkIfNoValue(penaltyBoxRed2.getText())){
			match.penalty(penaltyBoxRed2.getText(), (Integer) penaltyValRed2.getValue(), match.redAlliance[1], "red");
		}
		if(checkIfNoValue(penaltyBoxRed3.getText())){
			match.penalty(penaltyBoxRed3.getText(), (Integer) penaltyValRed3.getValue(), match.redAlliance[2], "red");
		}
		if(checkIfNoValue(penaltyBoxBlue1.getText())){
			match.penalty(penaltyBoxBlue1.getText(), (Integer) penaltyValBlue1.getValue(), match.blueAlliance[0], "blue");
		}
		if(checkIfNoValue(penaltyBoxBlue2.getText())){
			match.penalty(penaltyBoxBlue2.getText(), (Integer) penaltyValBlue2.getValue(), match.blueAlliance[1], "blue");
		}
		if(checkIfNoValue(penaltyBoxBlue3.getText())){
			match.penalty(penaltyBoxBlue3.getText(), (Integer) penaltyValBlue3.getValue(), match.blueAlliance[2], "blue");
		}
		this.resetPenaltyBoxes();
	}
	
	private boolean checkIfNoValue(Object object){
		if(object == null){
			return true;
		}else{
			return false;
		}
	}
	
	private void submitPointsScored(){
		if(checkIfNoValue(pointTypeRed1.getSelectedItem())){
			match.pointScored(serialComm.getLibrary().getSelectedGame(), (pointTypeRed1.getSelectedIndex() - 1), match.blueAlliance[0], "red");
		}
		if(checkIfNoValue(pointTypeRed2.getSelectedItem())){
			match.pointScored(serialComm.getLibrary().getSelectedGame(), (pointTypeRed2.getSelectedIndex() - 1), match.blueAlliance[1], "red");
		}
		if(checkIfNoValue(pointTypeRed3.getSelectedItem())){
			match.pointScored(serialComm.getLibrary().getSelectedGame(), (pointTypeRed3.getSelectedIndex() - 1), match.blueAlliance[2], "red");
		}
		if(checkIfNoValue(pointTypeBlue1.getSelectedItem())){
			match.pointScored(serialComm.getLibrary().getSelectedGame(), (pointTypeBlue1.getSelectedIndex() - 1), match.blueAlliance[0], "blue");
		}
		if(checkIfNoValue(pointTypeBlue2.getSelectedItem())){
			match.pointScored(serialComm.getLibrary().getSelectedGame(), (pointTypeBlue2.getSelectedIndex() - 1), match.blueAlliance[1], "blue");
		}
		if(checkIfNoValue(pointTypeBlue3.getSelectedItem())){
			match.pointScored(serialComm.getLibrary().getSelectedGame(), (pointTypeBlue3.getSelectedIndex() - 1), match.blueAlliance[2], "blue");
		}
	}
	
	private void updateScoreBoard(){
		
	}

	public void actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
		if (event.getSource() == "btnSubmitPointsScored"){
			this.submitPenaltyBoxes();
		}else{
			this.submitPointsScored();
		}
	}
}