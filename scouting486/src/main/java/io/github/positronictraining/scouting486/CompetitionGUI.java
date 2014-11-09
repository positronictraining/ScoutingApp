package io.github.positronictraining.scouting486;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

import java.awt.BorderLayout;

import javax.swing.ComboBoxModel;
import javax.swing.JTable;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.MutableComboBoxModel;

import java.awt.GridBagLayout;

import javax.swing.JTextField;

import java.awt.GridBagConstraints;

import javax.swing.JLabel;

import java.awt.Dimension;
import java.awt.Insets;
import java.awt.Font;

import javax.swing.JComboBox;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.util.ArrayList;

//TODO: implement text field and competition button to add data
//TODO: implement data table to actually display data
//TODO: implement competition list to display data
//TODO: implement competition list to change data table on component selection
//TODO: implement JComboBox
//TODO: get rid of diagnositcs

public class CompetitionGUI extends JFrame {
	
	//FRAME COMPONENTS
	private static final long serialVersionUID = 1L;
	public JTable dataTable;
	public JTextField competitionNameTxtFld;
	public JTextField startDateTxtFld;
	public JTextField endDateTxtFld;
	public JComboBox competitionGameComboBox;
	public JList competitionList;
	public JList gameList;

	private SerializationComm serialcomm = new SerializationComm();
	
	//METHODS
	public CompetitionGUI() { //initializes and shows a new overview page whenever a new instance of Overview is made
		initialize();
		this.setVisible(true);
	}
	
	private void initialize() { //Makes a new GUI for the overview
		
		this.setBounds(100, 100, 500, 400);	//Sets the size of the frame
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);	//adds a tabs mechanic to the GUI
		this.getContentPane().add(tabbedPane, BorderLayout.CENTER); //specifies that it should be front and center
		
		dataTable = new JTable(); //makes a data-table
		tabbedPane.addTab("Competition Statistics", null, dataTable, null); //calls that pane "Competition Statistics and adds the data-table to the tabs
		
		gameList = new JList();
		tabbedPane.addTab("Game List",null,gameList,null);
		
		competitionList = new JList(); //makes a competition-list JList
		tabbedPane.addTab("Competitions List", null, competitionList, null); //calls that pane "Competitions List and adds the JList to the tabs
		
		JPanel panel = new JPanel(); //makes a new panel (to eventually put on a new tab)
		tabbedPane.addTab("New Competition", null, panel, null); //adds that new panel to a new tab called 
		GridBagLayout gbl_panel = new GridBagLayout(); //makes a grid bag layout for that panel to effectively store all the JComponents
		gbl_panel.columnWidths = new int[]{0, 0}; //Grid bag stuff
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}; //Grid bag stuff
		gbl_panel.columnWeights = new double[]{1.0, Double.MIN_VALUE}; //Grid bag stuff
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE}; //Grid bag stuff
		panel.setLayout(gbl_panel); //adds grid bag stuff to the panel
		
		JLabel lblNewCompetition = new JLabel("New Competition");			//New Label called lblNewCompetition
		lblNewCompetition.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		GridBagConstraints gbc_lblNewCompetition = new GridBagConstraints();
		gbc_lblNewCompetition.anchor = GridBagConstraints.SOUTH;
		gbc_lblNewCompetition.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewCompetition.gridx = 0;
		gbc_lblNewCompetition.gridy = 0;
		panel.add(lblNewCompetition, gbc_lblNewCompetition);
		JButton newCompetitionBtn = new JButton("Create New Competition");	//New JButton called newCompetitionBtn
		newCompetitionBtn.addActionListener(new ActionListener() {	//What is done if newCompetitionBtn is pressed
			public void actionPerformed(ActionEvent arg0) {
				
				String gameName = competitionGameComboBox.getSelectedItem().toString();
				String gameDirectory = serialcomm.findGameFileDirectory(gameName);
				
				try {
					
					Game game = serialcomm.readGame(gameDirectory);
					game.addNewCompetition(competitionNameTxtFld.getText(),game,startDateTxtFld.getText(),endDateTxtFld.getText());
					
					competitionNameTxtFld.setText("");
					startDateTxtFld.setText("");
					endDateTxtFld.setText("");
					
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
			}
		});
		JLabel competitionNameLabel = new JLabel("Competition Name");	//New Label called lblNewCompetition
		competitionNameLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		GridBagConstraints gbc_competitionNameLabel = new GridBagConstraints();
		gbc_competitionNameLabel.anchor = GridBagConstraints.WEST;
		gbc_competitionNameLabel.insets = new Insets(0, 0, 5, 0);
		gbc_competitionNameLabel.gridx = 0;
		gbc_competitionNameLabel.gridy = 2;
		panel.add(competitionNameLabel, gbc_competitionNameLabel);
		
		competitionNameTxtFld = new JTextField();					//new TextField called competitionNameTxtFld
		GridBagConstraints gbc_competitionNameTxtFld = new GridBagConstraints();
		gbc_competitionNameTxtFld.fill = GridBagConstraints.BOTH;
		gbc_competitionNameTxtFld.insets = new Insets(0, 0, 5, 0);
		gbc_competitionNameTxtFld.gridx = 0;
		gbc_competitionNameTxtFld.gridy = 3;
		panel.add(competitionNameTxtFld, gbc_competitionNameTxtFld);
		competitionNameTxtFld.setColumns(10);
		
		JLabel lblCompetitionGame = new JLabel("Competition Game");	//new label
		GridBagConstraints gbc_lblCompetitionGame = new GridBagConstraints();
		gbc_lblCompetitionGame.insets = new Insets(0, 0, 5, 0);
		gbc_lblCompetitionGame.anchor = GridBagConstraints.WEST;
		gbc_lblCompetitionGame.gridx = 0;
		gbc_lblCompetitionGame.gridy = 4;
		panel.add(lblCompetitionGame, gbc_lblCompetitionGame);
		
		competitionGameComboBox = new JComboBox();					//new combo box
		GridBagConstraints gbc_competitionGameComboBox = new GridBagConstraints();
		gbc_competitionGameComboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_competitionGameComboBox.insets = new Insets(0, 0, 5, 0);
		gbc_competitionGameComboBox.gridx = 0;
		gbc_competitionGameComboBox.gridy = 5;
		panel.add(competitionGameComboBox, gbc_competitionGameComboBox);
		
		JLabel lblStartDate = new JLabel("Start Date");				//new label
		GridBagConstraints gbc_lblStartDate = new GridBagConstraints();
		gbc_lblStartDate.insets = new Insets(0, 0, 5, 0);
		gbc_lblStartDate.anchor = GridBagConstraints.WEST;
		gbc_lblStartDate.gridx = 0;
		gbc_lblStartDate.gridy = 6;
		panel.add(lblStartDate, gbc_lblStartDate);
		
		startDateTxtFld = new JTextField();							//new text field
		GridBagConstraints gbc_startDateTxtFld = new GridBagConstraints();
		gbc_startDateTxtFld.fill = GridBagConstraints.HORIZONTAL;
		gbc_startDateTxtFld.insets = new Insets(0, 0, 5, 0);
		gbc_startDateTxtFld.gridx = 0;
		gbc_startDateTxtFld.gridy = 7;
		panel.add(startDateTxtFld, gbc_startDateTxtFld);
		startDateTxtFld.setColumns(10);
		
		JLabel lblEndDate = new JLabel("End Date");					//new label
		GridBagConstraints gbc_lblEndDate = new GridBagConstraints();
		gbc_lblEndDate.insets = new Insets(0, 0, 5, 0);
		gbc_lblEndDate.anchor = GridBagConstraints.WEST;
		gbc_lblEndDate.gridx = 0;
		gbc_lblEndDate.gridy = 8;
		panel.add(lblEndDate, gbc_lblEndDate);
		
		endDateTxtFld = new JTextField();							//new text field
		GridBagConstraints gbc_endDateTxtFld = new GridBagConstraints();
		gbc_endDateTxtFld.fill = GridBagConstraints.HORIZONTAL;
		gbc_endDateTxtFld.insets = new Insets(0, 0, 5, 0);
		gbc_endDateTxtFld.gridx = 0;
		gbc_endDateTxtFld.gridy = 9;
		panel.add(endDateTxtFld, gbc_endDateTxtFld);
		
		endDateTxtFld.setColumns(10);								//new text field
		GridBagConstraints gbc_newCompetitionBtn = new GridBagConstraints();
		gbc_newCompetitionBtn.anchor = GridBagConstraints.EAST;
		gbc_newCompetitionBtn.gridx = 0;
		gbc_newCompetitionBtn.gridy = 11;
		panel.add(newCompetitionBtn, gbc_newCompetitionBtn);
	}
	
	public void refreshDataTable(){
		
	}
	
	private String[] newTabelRow(Game game, Robot robot){
		
		return null;
	}
	
	public void refreshCompetitionGameComboBox(ArrayList<Game> gameList){
		this.competitionGameComboBox.removeAll(); //
		for (Game g:gameList) {
			this.competitionGameComboBox.addItem(g); //
		}
//		competitionGameComboBox = new JComboBox(gameList.toArray());
		System.out.println("Refreshed Game List"); //
	}
}
