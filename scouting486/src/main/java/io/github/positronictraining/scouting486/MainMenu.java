package io.github.positronictraining.scouting486;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.BoxLayout;

import java.awt.Component;
import java.awt.CardLayout;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTable;

public class MainMenu extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L; //weird eclipse fix--don't worry about this
	private JPanel contentPane;
	private JButton btnNewMatch;
	private JButton btnNewRobot;
	private JButton btnQrCode;
	
	private MatchGUI newMatch;
	private NewRobotGUI newRobot;
	private SettingsGUI settingsGUI;
	private NewCompetitionFrame newCompetitionFrame;
	
	private SerializationComm serialComm;
	private JButton btnSettings;
	private JPanel panel;
	private JToolBar toolBar;
	private JPanel panel_1;
	private JTable table;
	private JButton btnNewCompetition;
	
	private DataModel dataModel = new DataModel();
	
	public MainMenu(SerializationComm serialComm) {
		this.serialComm = serialComm;
		this.setTitle("Scouting486 - Main Menu");
		try {
			//UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
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
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 5, 5, 5));
		setContentPane(contentPane);
		
		panel_1 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
		
		panel = new JPanel();
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(panel_1, BorderLayout.NORTH);
		
		toolBar = new JToolBar();
		panel_1.add(toolBar);
		toolBar.setFloatable(false);
		
		btnNewCompetition = new JButton("New Competition");
		btnNewCompetition.setToolTipText("");
		toolBar.add(btnNewCompetition);
		btnNewCompetition.addActionListener(this);
		
		btnNewMatch = new JButton("New Match");
		btnNewMatch.setToolTipText("Create a new match");
		toolBar.add(btnNewMatch);
		btnNewMatch.addActionListener(this);
		
		btnNewRobot = new JButton("New Robot");
		btnNewRobot.setToolTipText("Create a new robot");
		toolBar.add(btnNewRobot);
		btnNewRobot.addActionListener(this);
		
		btnQrCode = new JButton("QR Code");
		btnQrCode.setToolTipText("Not implemented yet");
		btnQrCode.setEnabled(false);
		toolBar.add(btnQrCode);
		btnQrCode.addActionListener(this);
		
		btnSettings = new JButton("Settings");
		btnSettings.setToolTipText("Manage settings");
		toolBar.add(btnSettings);
		btnSettings.addActionListener(this);

		contentPane.add(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0};
		gbl_panel.rowHeights = new int[]{0, 0};
		gbl_panel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		table = new JTable(dataModel);
		table.setPreferredScrollableViewportSize(new Dimension(550,350));
		table.setFillsViewportHeight(true);
		JScrollPane jScrollPane = new JScrollPane(table);
		GridBagConstraints gbc_table = new GridBagConstraints();
		gbc_table.fill = GridBagConstraints.BOTH;
		gbc_table.gridx = 0;
		gbc_table.gridy = 0;
		panel.add(jScrollPane, gbc_table);
		dataModel.updateData(serialComm.getLibrary().getSelectedCompetition());
		System.out.println(serialComm.getLibrary().getSelectedCompetition().robots.size() + "this is the selected competition robot size");
		
		setVisible(true); 					//makes the frame visible
	}
	
	public void actionPerformed(ActionEvent event){ //what happens when a button of any type is pressed
		if (event.getSource() == btnNewCompetition){
			System.out.println("the new competition button was pressed");
			newCompetitionFrame = new NewCompetitionFrame(serialComm);
			newCompetitionFrame.refreshCompetitionGameComboBox(serialComm.getLibrary().getGameList());
		}
		else if (event.getSource() == btnNewMatch){ //what happens if the new match button was pressed
			System.out.println("the new match button was pressed");
			newMatch = new MatchGUI(serialComm,dataModel);
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
