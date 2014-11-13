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
import javax.swing.JTextField;
import javax.swing.JButton;

public class NewRobot {private JPanel contentPane;
private final JTextField textField = new JTextField();
private final JTextField textField_1 = new JTextField();

/**
 * Launch the application.
 */
public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
		public void run() {
			try {
				NewRobot frame = new NewRobot();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	});
}

protected void setVisible(boolean b) {
	// TODO Auto-generated method stub
	
}

/**
 * Create the frame.
 */
public NewRobot() {
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
	gbc_lblNewRobot.gridx = 6;
	gbc_lblNewRobot.gridy = 0;
	contentPane.add(lblNewRobot, gbc_lblNewRobot);
	
	JLabel lblName = new JLabel("Name");
	GridBagConstraints gbc_lblName = new GridBagConstraints();
	gbc_lblName.insets = new Insets(0, 0, 5, 5);
	gbc_lblName.gridx = 1;
	gbc_lblName.gridy = 2;
	contentPane.add(lblName, gbc_lblName);
	GridBagConstraints gbc_textField = new GridBagConstraints();
	gbc_textField.fill = GridBagConstraints.HORIZONTAL;
	gbc_textField.gridwidth = 3;
	gbc_textField.insets = new Insets(0, 0, 5, 5);
	gbc_textField.gridx = 1;
	gbc_textField.gridy = 3;
	contentPane.add(textField, gbc_textField);
	textField.setColumns(5);
	
	JLabel lblTeam = new JLabel("Team");
	GridBagConstraints gbc_lblTeam = new GridBagConstraints();
	gbc_lblTeam.insets = new Insets(0, 0, 5, 5);
	gbc_lblTeam.gridx = 1;
	gbc_lblTeam.gridy = 5;
	contentPane.add(lblTeam, gbc_lblTeam);
	GridBagConstraints gbc_textField_1 = new GridBagConstraints();
	gbc_textField_1.gridwidth = 4;
	gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
	gbc_textField_1.insets = new Insets(0, 0, 5, 5);
	gbc_textField_1.gridx = 1;
	gbc_textField_1.gridy = 6;
	contentPane.add(textField_1, gbc_textField_1);
	textField_1.setColumns(10);
	
	JButton btnSubmit = new JButton("Submit");
	GridBagConstraints gbc_btnSubmit = new GridBagConstraints();
	gbc_btnSubmit.insets = new Insets(0, 0, 5, 5);
	gbc_btnSubmit.gridx = 7;
	gbc_btnSubmit.gridy = 8;
	contentPane.add(btnSubmit, gbc_btnSubmit);
}

private void setDefaultCloseOperation(int exitOnClose) {
	
}

private void setBounds(int i, int j, int k, int l) {
	
}

private void setContentPane(JPanel contentPane2) {
	
}

}
