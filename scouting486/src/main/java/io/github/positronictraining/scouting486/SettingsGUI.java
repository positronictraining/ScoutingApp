package io.github.positronictraining.scouting486;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JComboBox;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;

public class SettingsGUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public SettingsGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblSettings = new JLabel("Settings");
		lblSettings.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		GridBagConstraints gbc_lblSettings = new GridBagConstraints();
		gbc_lblSettings.insets = new Insets(0, 0, 5, 5);
		gbc_lblSettings.gridx = 0;
		gbc_lblSettings.gridy = 0;
		contentPane.add(lblSettings, gbc_lblSettings);
		
		JLabel lblGame = new JLabel("Game");
		GridBagConstraints gbc_lblGame = new GridBagConstraints();
		gbc_lblGame.anchor = GridBagConstraints.WEST;
		gbc_lblGame.insets = new Insets(0, 0, 5, 5);
		gbc_lblGame.gridx = 0;
		gbc_lblGame.gridy = 1;
		contentPane.add(lblGame, gbc_lblGame);
		
		JComboBox gameComboBox = new JComboBox();
		GridBagConstraints gbc_gameComboBox = new GridBagConstraints();
		gbc_gameComboBox.insets = new Insets(0, 0, 5, 5);
		gbc_gameComboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_gameComboBox.gridx = 0;
		gbc_gameComboBox.gridy = 2;
		contentPane.add(gameComboBox, gbc_gameComboBox);
		
		JLabel lblCompetition = new JLabel("Competition");
		GridBagConstraints gbc_lblCompetition = new GridBagConstraints();
		gbc_lblCompetition.anchor = GridBagConstraints.WEST;
		gbc_lblCompetition.insets = new Insets(0, 0, 5, 5);
		gbc_lblCompetition.gridx = 0;
		gbc_lblCompetition.gridy = 3;
		contentPane.add(lblCompetition, gbc_lblCompetition);
		
		JComboBox competitionComboBox = new JComboBox();
		GridBagConstraints gbc_competitionComboBox = new GridBagConstraints();
		gbc_competitionComboBox.insets = new Insets(0, 0, 5, 5);
		gbc_competitionComboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_competitionComboBox.gridx = 0;
		gbc_competitionComboBox.gridy = 4;
		contentPane.add(competitionComboBox, gbc_competitionComboBox);
		
		JButton btnRefreshSetings = new JButton("Refresh Settings");
		GridBagConstraints gbc_btnRefreshSetings = new GridBagConstraints();
		gbc_btnRefreshSetings.insets = new Insets(0, 0, 0, 5);
		gbc_btnRefreshSetings.anchor = GridBagConstraints.EAST;
		gbc_btnRefreshSetings.gridx = 0;
		gbc_btnRefreshSetings.gridy = 6;
		contentPane.add(btnRefreshSetings, gbc_btnRefreshSetings);
	}

}
