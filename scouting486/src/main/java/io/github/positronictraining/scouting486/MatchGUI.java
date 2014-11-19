package io.github.positronictraining.scouting486;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.GridBagLayout;

import javax.swing.JButton;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;

import javax.swing.JToggleButton;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class MatchGUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	
	private DataModel dataModel;
	private SerializationComm serialComm;
	
	public MatchGUI(SerializationComm serialComm, DataModel dataModel){
		this.initialize();
		this.setVisible(true);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.dataModel = dataModel;
		this.serialComm = serialComm;
	}
	
	private void initialize() {
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblEnterRed_2 = new JLabel("Enter Red 1 Team Name");
		GridBagConstraints gbc_lblEnterRed_2 = new GridBagConstraints();
		gbc_lblEnterRed_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblEnterRed_2.anchor = GridBagConstraints.EAST;
		gbc_lblEnterRed_2.gridx = 2;
		gbc_lblEnterRed_2.gridy = 1;
		contentPane.add(lblEnterRed_2, gbc_lblEnterRed_2);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 3;
		gbc_textField.gridy = 1;
		contentPane.add(textField, gbc_textField);
		textField.setColumns(10);
		
		JLabel lblEnterRed = new JLabel("Enter Red 2 Team Name");
		GridBagConstraints gbc_lblEnterRed = new GridBagConstraints();
		gbc_lblEnterRed.anchor = GridBagConstraints.EAST;
		gbc_lblEnterRed.insets = new Insets(0, 0, 5, 5);
		gbc_lblEnterRed.gridx = 2;
		gbc_lblEnterRed.gridy = 2;
		contentPane.add(lblEnterRed, gbc_lblEnterRed);
		
		textField_1 = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 3;
		gbc_textField_1.gridy = 2;
		contentPane.add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);
		
		JLabel lblEnterRed_1 = new JLabel("Enter Red 3 Team Name");
		GridBagConstraints gbc_lblEnterRed_1 = new GridBagConstraints();
		gbc_lblEnterRed_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblEnterRed_1.anchor = GridBagConstraints.EAST;
		gbc_lblEnterRed_1.gridx = 2;
		gbc_lblEnterRed_1.gridy = 3;
		contentPane.add(lblEnterRed_1, gbc_lblEnterRed_1);
		
		textField_2 = new JTextField();
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.insets = new Insets(0, 0, 5, 5);
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.gridx = 3;
		gbc_textField_2.gridy = 3;
		contentPane.add(textField_2, gbc_textField_2);
		textField_2.setColumns(10);
		
		JLabel lblEnterBlue = new JLabel("Enter Blue 1 Team Name");
		GridBagConstraints gbc_lblEnterBlue = new GridBagConstraints();
		gbc_lblEnterBlue.insets = new Insets(0, 0, 5, 5);
		gbc_lblEnterBlue.anchor = GridBagConstraints.EAST;
		gbc_lblEnterBlue.gridx = 2;
		gbc_lblEnterBlue.gridy = 4;
		contentPane.add(lblEnterBlue, gbc_lblEnterBlue);
		
		textField_3 = new JTextField();
		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
		gbc_textField_3.insets = new Insets(0, 0, 5, 5);
		gbc_textField_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_3.gridx = 3;
		gbc_textField_3.gridy = 4;
		contentPane.add(textField_3, gbc_textField_3);
		textField_3.setColumns(10);
		
		JLabel lblEnterBlue_1 = new JLabel("Enter Blue 2 Team Name");
		GridBagConstraints gbc_lblEnterBlue_1 = new GridBagConstraints();
		gbc_lblEnterBlue_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblEnterBlue_1.anchor = GridBagConstraints.EAST;
		gbc_lblEnterBlue_1.gridx = 2;
		gbc_lblEnterBlue_1.gridy = 5;
		contentPane.add(lblEnterBlue_1, gbc_lblEnterBlue_1);
		
		textField_4 = new JTextField();
		GridBagConstraints gbc_textField_4 = new GridBagConstraints();
		gbc_textField_4.insets = new Insets(0, 0, 5, 5);
		gbc_textField_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_4.gridx = 3;
		gbc_textField_4.gridy = 5;
		contentPane.add(textField_4, gbc_textField_4);
		textField_4.setColumns(10);
		
		JLabel lblEnterBlue_2 = new JLabel("Enter Blue 3 Team Name");
		GridBagConstraints gbc_lblEnterBlue_2 = new GridBagConstraints();
		gbc_lblEnterBlue_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblEnterBlue_2.anchor = GridBagConstraints.EAST;
		gbc_lblEnterBlue_2.gridx = 2;
		gbc_lblEnterBlue_2.gridy = 6;
		contentPane.add(lblEnterBlue_2, gbc_lblEnterBlue_2);
		
		textField_5 = new JTextField();
		GridBagConstraints gbc_textField_5 = new GridBagConstraints();
		gbc_textField_5.insets = new Insets(0, 0, 5, 5);
		gbc_textField_5.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_5.gridx = 3;
		gbc_textField_5.gridy = 6;
		contentPane.add(textField_5, gbc_textField_5);
		textField_5.setColumns(10);
		
		JButton btnCreateMatch = new JButton("Create Match");
		btnCreateMatch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Create New Match Button");
				addNewMatch(textField.getText(),textField_1.getText(),textField_2.getText(),textField_3.getText(),textField_4.getText(),textField_5.getText());
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				textField_4.setText("");
				textField_5.setText("");
				realTimeMatchGUI realTimeMatchGUI = new realTimeMatchGUI();
			}
		});
		GridBagConstraints gbc_btnCreateMatch = new GridBagConstraints();
		gbc_btnCreateMatch.insets = new Insets(0, 0, 0, 5);
		gbc_btnCreateMatch.gridx = 3;
		gbc_btnCreateMatch.gridy = 7;
		contentPane.add(btnCreateMatch, gbc_btnCreateMatch);
	}
	private void addNewMatch(String red1, String red2, String red3, String blue1, String blue2, String blue3){
		serialComm.getLibrary().getSelectedCompetition().addMatch(red1, red2, red3, blue1, blue2, blue3);
		dataModel.updateData(serialComm.getLibrary().getSelectedCompetition());
		this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
	}
}
