package io.github.positronictraining.scouting486;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

public class MainMenu extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L; //weird eclipse fix--don't worry about this
	private JPanel contentPane;
	private JButton btnTeamStatistics;
	private JButton btnNewMatch;
	private JButton btnNewRobot;
	private JButton btnQrCode;
	
	private CompetitionGUI competitionGUI;
	private MatchGUI newMatch;
	private NewRobotGUI newRobot;
	private SettingsGUI settingsGUI;
	
	private SerializationComm serialComm;
	private JButton btnSettings;
	
	public MainMenu(SerializationComm serialComm) {
		this.serialComm = serialComm;
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //sets up main menu frame
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		btnTeamStatistics = new JButton("Team Statistics");	//adds team stats button
		GridBagConstraints gbc_btnTeamStatistics = new GridBagConstraints();
		gbc_btnTeamStatistics.insets = new Insets(0, 0, 5, 0);
		gbc_btnTeamStatistics.gridx = 1;
		gbc_btnTeamStatistics.gridy = 1;
		contentPane.add(btnTeamStatistics, gbc_btnTeamStatistics);
		
		btnNewMatch = new JButton("New Match");	//adds new match button
		GridBagConstraints gbc_btnNewMatch = new GridBagConstraints();
		gbc_btnNewMatch.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewMatch.gridx = 1;
		gbc_btnNewMatch.gridy = 2;
		contentPane.add(btnNewMatch, gbc_btnNewMatch);
		
		btnNewRobot = new JButton("New Robot");	//adds new robot button
		GridBagConstraints gbc_btnNewRobot = new GridBagConstraints();
		gbc_btnNewRobot.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewRobot.gridx = 1;
		gbc_btnNewRobot.gridy = 3;
		contentPane.add(btnNewRobot, gbc_btnNewRobot);
		
		btnQrCode = new JButton("QR Code");		//adds qr code button
		GridBagConstraints gbc_btnQrCode = new GridBagConstraints();
		gbc_btnQrCode.insets = new Insets(0, 0, 5, 0);
		gbc_btnQrCode.gridx = 1;
		gbc_btnQrCode.gridy = 4;
		contentPane.add(btnQrCode, gbc_btnQrCode);
		
		btnSettings = new JButton("Settings");
		GridBagConstraints gbc_btnSettings = new GridBagConstraints();
		gbc_btnSettings.gridx = 1;
		gbc_btnSettings.gridy = 5;
		contentPane.add(btnSettings, gbc_btnSettings);
		
		btnTeamStatistics.addActionListener(this);		//adds action listeners for all buttons
		btnNewMatch.addActionListener(this);
		btnNewRobot.addActionListener(this);
		btnQrCode.addActionListener(this);
		btnSettings.addActionListener(this);
		
		setVisible(true); 					//makes the frame visible
	}
	
	public void actionPerformed(ActionEvent event){ //what happens when a button of any type is pressed
		if (event.getSource() == btnTeamStatistics){ //what happens if the team statistics button was pressed
			System.out.println("the team statistics button was pressed");
			competitionGUI = new CompetitionGUI(serialComm);
			competitionGUI.refreshCompetitionGameComboBox(serialComm.getLibrary().getGameList());
			System.out.println(serialComm.getLibrary().getGameList());
			
			Game[] gameArray = serialComm.getLibrary().getGameArray();
			competitionGUI.refreshGameList(gameArray);
			
			competitionGUI.refreshDataTable();
		}
		else if (event.getSource() == btnNewMatch){ //what happens if the new match button was pressed
			System.out.println("the new match button was pressed");
			newMatch = new MatchGUI();
		}
		else if (event.getSource() == btnNewRobot){ //what happens if the new robot button was pressed
			System.out.println("the new robot button was pressed");
			newRobot = new NewRobotGUI();
			//TODO
		}
		else if (event.getSource() == btnQrCode){ //what happens if the qr code button is pressed
			System.out.println("the qr code button was pressed");
			//TODO
		}
		else{
			//(code for settings button)
			System.out.println("the settings button was pressed");
			settingsGUI = new SettingsGUI(serialComm);
		}
	}
}
