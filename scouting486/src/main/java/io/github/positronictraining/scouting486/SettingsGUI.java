package io.github.positronictraining.scouting486;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.GridBagLayout;

import javax.swing.JComboBox;

import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.Font;
import java.util.ArrayList;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;

import javax.swing.SwingConstants;
import java.awt.GridLayout;
import javax.swing.Box;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class SettingsGUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	
	public JComboBox gameSelect, competitionSelect;
	private SerializationComm serialcomm;
	private JButton btnRefreshSettings;
	
	public SettingsGUI(SerializationComm serialcomm) {
		this.serialcomm = serialcomm;
		init();
	}
	
	public void init() {
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		ArrayList<Competition> compList = serialcomm.getLibrary().getSelectedGame().getCompetitions();
		contentPane.setLayout(new BorderLayout(0, 0));
		
		Box verticalBox = Box.createVerticalBox();
		contentPane.add(verticalBox, BorderLayout.NORTH);
		
		btnRefreshSettings = new JButton("Refresh Settings");
		btnRefreshSettings.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent arg0) {
				btnRefreshSettings.doClick();
			}
		});
		btnRefreshSettings.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (serialcomm.getLibrary().gameSelected()) {
					gameSelect.setSelectedItem(serialcomm.getLibrary().getSelectedGame());
				} else {
					gameSelect.setSelectedIndex(0);
					serialcomm.getLibrary().setSelectedGame((Game)gameSelect.getSelectedItem());
				}
			}
		});
		btnRefreshSettings.setVerticalAlignment(SwingConstants.BOTTOM);
		contentPane.add(btnRefreshSettings, BorderLayout.SOUTH);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblSettings = new JLabel("Settings");
		panel_1.add(lblSettings);
		lblSettings.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblSettings.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		
		JPanel panel_2 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_2.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panel.add(panel_2);
		
		JLabel lblGame = new JLabel("Game");
		panel_2.add(lblGame);
		
		JPanel panel_3 = new JPanel();
		panel.add(panel_3);
		panel_3.setLayout(new BoxLayout(panel_3, BoxLayout.X_AXIS));
		
		gameSelect = new JComboBox(serialcomm.getLibrary().getGameArray());
		panel_3.add(gameSelect);
		
		JPanel panel_4 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_4.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		panel.add(panel_4);
		
		JLabel lblCompetition = new JLabel("Competition");
		panel_4.add(lblCompetition);
		
		JPanel panel_5 = new JPanel();
		panel.add(panel_5);
		panel_5.setLayout(new BoxLayout(panel_5, BoxLayout.X_AXIS));
		competitionSelect = new JComboBox(compList.toArray(new Competition[compList.size()]));
		panel_5.add(competitionSelect);
		
		
		this.setVisible(true);
	}

}
