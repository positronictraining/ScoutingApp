package io.github.positronictraining.scouting486;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

import java.awt.BorderLayout;

import javax.swing.JTable;
import javax.swing.JList;
import javax.swing.JPanel;

import java.awt.GridBagLayout;

import javax.swing.JTextField;

import java.awt.GridBagConstraints;

import javax.swing.JLabel;

import java.awt.Insets;
import java.awt.Font;

import javax.swing.JComboBox;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;

public class Overview extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable dataTable;
	private JTextField competitionNameTxtFld;
	private JTextField startDateTxtFld;
	private JTextField endDateTxtFld;
	private JComboBox competitionGameComboBox;
	private JList competitionList;
	
	private XmlTranslator xmlTranslator = new XmlTranslator();
	
	public Overview() {
		initialize();
		this.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		this.setBounds(100, 100, 450, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setPreferredSize(new Dimension(500,400));
		this.pack();
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		this.getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
		dataTable = new JTable();
		tabbedPane.addTab("Competition Statistics", null, dataTable, null);
		
		competitionList = new JList();
		tabbedPane.addTab("Competitions List", null, competitionList, null);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("New Competition", null, panel, null);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblNewCompetition = new JLabel("New Competition");
		lblNewCompetition.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		GridBagConstraints gbc_lblNewCompetition = new GridBagConstraints();
		gbc_lblNewCompetition.anchor = GridBagConstraints.SOUTH;
		gbc_lblNewCompetition.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewCompetition.gridx = 0;
		gbc_lblNewCompetition.gridy = 0;
		panel.add(lblNewCompetition, gbc_lblNewCompetition);
		JButton newCompetitionBtn = new JButton("Create New Competition");
		newCompetitionBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("the new competition button was pressed");
			}
		});
		
		JLabel competitionNameLabel = new JLabel("Competition Name");
		competitionNameLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		GridBagConstraints gbc_competitionNameLabel = new GridBagConstraints();
		gbc_competitionNameLabel.anchor = GridBagConstraints.WEST;
		gbc_competitionNameLabel.insets = new Insets(0, 0, 5, 0);
		gbc_competitionNameLabel.gridx = 0;
		gbc_competitionNameLabel.gridy = 2;
		panel.add(competitionNameLabel, gbc_competitionNameLabel);
		
		competitionNameTxtFld = new JTextField();
		GridBagConstraints gbc_competitionNameTxtFld = new GridBagConstraints();
		gbc_competitionNameTxtFld.fill = GridBagConstraints.BOTH;
		gbc_competitionNameTxtFld.insets = new Insets(0, 0, 5, 0);
		gbc_competitionNameTxtFld.gridx = 0;
		gbc_competitionNameTxtFld.gridy = 3;
		panel.add(competitionNameTxtFld, gbc_competitionNameTxtFld);
		competitionNameTxtFld.setColumns(10);
		
		JLabel lblCompetitionGame = new JLabel("Competition Game");
		GridBagConstraints gbc_lblCompetitionGame = new GridBagConstraints();
		gbc_lblCompetitionGame.insets = new Insets(0, 0, 5, 0);
		gbc_lblCompetitionGame.anchor = GridBagConstraints.WEST;
		gbc_lblCompetitionGame.gridx = 0;
		gbc_lblCompetitionGame.gridy = 4;
		panel.add(lblCompetitionGame, gbc_lblCompetitionGame);
		
		competitionGameComboBox = new JComboBox();
		GridBagConstraints gbc_competitionGameComboBox = new GridBagConstraints();
		gbc_competitionGameComboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_competitionGameComboBox.insets = new Insets(0, 0, 5, 0);
		gbc_competitionGameComboBox.gridx = 0;
		gbc_competitionGameComboBox.gridy = 5;
		panel.add(competitionGameComboBox, gbc_competitionGameComboBox);
		
		JLabel lblStartDate = new JLabel("Start Date");
		GridBagConstraints gbc_lblStartDate = new GridBagConstraints();
		gbc_lblStartDate.insets = new Insets(0, 0, 5, 0);
		gbc_lblStartDate.anchor = GridBagConstraints.WEST;
		gbc_lblStartDate.gridx = 0;
		gbc_lblStartDate.gridy = 6;
		panel.add(lblStartDate, gbc_lblStartDate);
		
		startDateTxtFld = new JTextField();
		GridBagConstraints gbc_startDateTxtFld = new GridBagConstraints();
		gbc_startDateTxtFld.fill = GridBagConstraints.HORIZONTAL;
		gbc_startDateTxtFld.insets = new Insets(0, 0, 5, 0);
		gbc_startDateTxtFld.gridx = 0;
		gbc_startDateTxtFld.gridy = 7;
		panel.add(startDateTxtFld, gbc_startDateTxtFld);
		startDateTxtFld.setColumns(10);
		
		JLabel lblEndDate = new JLabel("End Date");
		GridBagConstraints gbc_lblEndDate = new GridBagConstraints();
		gbc_lblEndDate.insets = new Insets(0, 0, 5, 0);
		gbc_lblEndDate.anchor = GridBagConstraints.WEST;
		gbc_lblEndDate.gridx = 0;
		gbc_lblEndDate.gridy = 8;
		panel.add(lblEndDate, gbc_lblEndDate);
		
		endDateTxtFld = new JTextField();
		GridBagConstraints gbc_endDateTxtFld = new GridBagConstraints();
		gbc_endDateTxtFld.fill = GridBagConstraints.HORIZONTAL;
		gbc_endDateTxtFld.insets = new Insets(0, 0, 5, 0);
		gbc_endDateTxtFld.gridx = 0;
		gbc_endDateTxtFld.gridy = 9;
		panel.add(endDateTxtFld, gbc_endDateTxtFld);
		
		endDateTxtFld.setColumns(10);
		GridBagConstraints gbc_newCompetitionBtn = new GridBagConstraints();
		gbc_newCompetitionBtn.anchor = GridBagConstraints.EAST;
		gbc_newCompetitionBtn.gridx = 0;
		gbc_newCompetitionBtn.gridy = 11;
		panel.add(newCompetitionBtn, gbc_newCompetitionBtn);
	}
	
	public void refreshJList(File file){
		this.competitionList.setListData(this.xmlTranslator.getCompetitionNames(file));
	}
}
