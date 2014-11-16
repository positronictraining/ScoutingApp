package io.github.positronictraining.scouting486;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.GridBagLayout;

import javax.swing.JLabel;

import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;

public class NewRobotGUI extends JFrame implements ActionListener{
		
	private JPanel contentPane;
	private final JTextField textField_teamNumber = new JTextField();
	private SerializationComm serialcomm = new SerializationComm();
	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the frame.
	 */
	public NewRobotGUI() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblNewRobot = new JLabel("New Robot");
		lblNewRobot.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblNewRobot = new GridBagConstraints();
		gbc_lblNewRobot.gridwidth = 3;
		gbc_lblNewRobot.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewRobot.gridx = 1;
		gbc_lblNewRobot.gridy = 1;
		contentPane.add(lblNewRobot, gbc_lblNewRobot);
		
		JLabel lblTeamNumber = new JLabel("Team Number");
		GridBagConstraints gbc_lblName = new GridBagConstraints();
		gbc_lblName.insets = new Insets(0, 0, 5, 5);
		gbc_lblName.gridx = 1;
		gbc_lblName.gridy = 2;
		contentPane.add(lblTeamNumber, gbc_lblName);
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridwidth = 3;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 3;
		contentPane.add(textField_teamNumber, gbc_textField);
		textField_teamNumber.setColumns(5);
		
		JButton btnSubmit = new JButton("Submit");
		GridBagConstraints gbc_btnSubmit = new GridBagConstraints();
		gbc_btnSubmit.insets = new Insets(0, 0, 5, 5);
		gbc_btnSubmit.gridx = 7;
		gbc_btnSubmit.gridy = 8;
		contentPane.add(btnSubmit, gbc_btnSubmit);
		
		btnSubmit.addActionListener(this);
		
		this.setVisible(true);
	}
	
	private void clearAll(){
		//Use for all future team properties
		textField_teamNumber.setText("");
	}

	public void actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
		System.out.println("the submit button was pressed");
		Competition selectedCompetition = serialcomm.getLibrary().getSelectedCompetition();
		selectedCompetition.addRobot(this.textField_teamNumber.getText());
		serialcomm.writeGame(serialcomm.getLibrary().getSelectedGame());
		this.clearAll();
	}

}
