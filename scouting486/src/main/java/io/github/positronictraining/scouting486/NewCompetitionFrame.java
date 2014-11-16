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
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class NewCompetitionFrame extends JFrame {

	private JPanel contentPane;
	private JTextField competitionNameTxtFld;
	private JTextField startDateTxtFld;
	private JTextField endDateTxtFld;
	private JButton newCompetitionBtn;
	private JComboBox<Game> competitionGameComboBox;
	private SerializationComm serialcomm;
	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	
	public NewCompetitionFrame(SerializationComm serialcomm) {
		this.serialcomm = serialcomm;
		initialize();
	}
	
	public void initialize() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 337);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel label = new JLabel("New Competition");
		label.setFont(new Font("Dialog", Font.PLAIN, 16));
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.anchor = GridBagConstraints.SOUTH;
		gbc_label.insets = new Insets(0, 0, 5, 0);
		gbc_label.gridx = 0;
		gbc_label.gridy = 0;
		panel.add(label, gbc_label);
		
		JLabel label_1 = new JLabel("Competition Name");
		label_1.setFont(new Font("Dialog", Font.PLAIN, 13));
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.anchor = GridBagConstraints.WEST;
		gbc_label_1.insets = new Insets(0, 0, 5, 0);
		gbc_label_1.gridx = 0;
		gbc_label_1.gridy = 2;
		panel.add(label_1, gbc_label_1);
		
		competitionNameTxtFld = new JTextField();
		competitionNameTxtFld.setColumns(10);
		GridBagConstraints gbc_competitionNameTxtFld = new GridBagConstraints();
		gbc_competitionNameTxtFld.fill = GridBagConstraints.BOTH;
		gbc_competitionNameTxtFld.insets = new Insets(0, 0, 5, 0);
		gbc_competitionNameTxtFld.gridx = 0;
		gbc_competitionNameTxtFld.gridy = 3;
		panel.add(competitionNameTxtFld, gbc_competitionNameTxtFld);
		
		JLabel label_2 = new JLabel("Competition Game");
		GridBagConstraints gbc_label_2 = new GridBagConstraints();
		gbc_label_2.anchor = GridBagConstraints.WEST;
		gbc_label_2.insets = new Insets(0, 0, 5, 0);
		gbc_label_2.gridx = 0;
		gbc_label_2.gridy = 4;
		panel.add(label_2, gbc_label_2);
		
		competitionGameComboBox = new JComboBox<Game>();
		GridBagConstraints gbc_competitionGameComboBox = new GridBagConstraints();
		gbc_competitionGameComboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_competitionGameComboBox.insets = new Insets(0, 0, 5, 0);
		gbc_competitionGameComboBox.gridx = 0;
		gbc_competitionGameComboBox.gridy = 5;
		panel.add(competitionGameComboBox, gbc_competitionGameComboBox);
		
		JLabel label_3 = new JLabel("Start Date");
		GridBagConstraints gbc_label_3 = new GridBagConstraints();
		gbc_label_3.anchor = GridBagConstraints.WEST;
		gbc_label_3.insets = new Insets(0, 0, 5, 0);
		gbc_label_3.gridx = 0;
		gbc_label_3.gridy = 6;
		panel.add(label_3, gbc_label_3);
		
		startDateTxtFld = new JTextField();
		startDateTxtFld.setColumns(10);
		GridBagConstraints gbc_startDateTxtFld = new GridBagConstraints();
		gbc_startDateTxtFld.fill = GridBagConstraints.HORIZONTAL;
		gbc_startDateTxtFld.insets = new Insets(0, 0, 5, 0);
		gbc_startDateTxtFld.gridx = 0;
		gbc_startDateTxtFld.gridy = 7;
		panel.add(startDateTxtFld, gbc_startDateTxtFld);
		
		JLabel label_4 = new JLabel("End Date");
		GridBagConstraints gbc_label_4 = new GridBagConstraints();
		gbc_label_4.anchor = GridBagConstraints.WEST;
		gbc_label_4.insets = new Insets(0, 0, 5, 0);
		gbc_label_4.gridx = 0;
		gbc_label_4.gridy = 8;
		panel.add(label_4, gbc_label_4);
		
		endDateTxtFld = new JTextField();
		endDateTxtFld.setColumns(10);
		GridBagConstraints gbc_endDateTxtFld = new GridBagConstraints();
		gbc_endDateTxtFld.fill = GridBagConstraints.HORIZONTAL;
		gbc_endDateTxtFld.insets = new Insets(0, 0, 5, 0);
		gbc_endDateTxtFld.gridx = 0;
		gbc_endDateTxtFld.gridy = 9;
		panel.add(endDateTxtFld, gbc_endDateTxtFld);
		
		newCompetitionBtn = new JButton("Create New Competition");
		GridBagConstraints gbc_newCompetitionBtn = new GridBagConstraints();
		gbc_newCompetitionBtn.anchor = GridBagConstraints.EAST;
		gbc_newCompetitionBtn.gridx = 0;
		gbc_newCompetitionBtn.gridy = 11;
		newCompetitionBtn.addActionListener(new ActionListener() {	//What is done if newCompetitionBtn is pressed
			public void actionPerformed(ActionEvent arg0) {
				
				Game game = (Game)competitionGameComboBox.getSelectedItem();
				game.addNewCompetition(competitionNameTxtFld.getText(),game,startDateTxtFld.getText(),endDateTxtFld.getText());
				serialcomm.writeLibrary();
				
				competitionNameTxtFld.setText("");
				startDateTxtFld.setText("");
				endDateTxtFld.setText("");
			}

		});
		panel.add(newCompetitionBtn, gbc_newCompetitionBtn);
		this.setVisible(true);
	}

}
