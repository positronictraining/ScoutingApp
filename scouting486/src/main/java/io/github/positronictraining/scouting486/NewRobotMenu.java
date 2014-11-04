package io.github.positronictraining.scouting486;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.LayoutManager;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

public class NewRobotMenu {


	private final JTextField textField = new JTextField();
	private final JTextField textField_1 = new JTextField();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewRobotMenu frame = new NewRobotMenu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	protected void setVisible(boolean b) {
		
	}

	/**
	 * Create the frame.
	 */
	public NewRobotMenu() {
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout((LayoutManager) new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		JLabel lblNewRobot = new JLabel("New Robot");
		lblNewRobot.setFont(new Font("Tahoma", Font.PLAIN, 20));
		getContentPane().add(lblNewRobot, "12, 2");
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		getContentPane().add(lblName, "4, 6");
		getContentPane().add(textField, "4, 8");
		textField.setColumns(4);
		
		JLabel lblTeam = new JLabel("Team");
		lblTeam.setFont(new Font("Tahoma", Font.PLAIN, 15));
		getContentPane().add(lblTeam, "4, 12");
		getContentPane().add(textField_1, "4, 14");
		textField_1.setColumns(8);
		
		JButton btnSave = new JButton("Save");
		getContentPane().add(btnSave, "12, 18");

	}

	private JFrame getContentPane() {
		return null;
	}

	private void setDefaultCloseOperation(int exitOnClose) {
		
	}

	private void setBounds(int i, int j, int k, int l) {
		
	}

}
