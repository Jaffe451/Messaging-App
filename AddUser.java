package MessagingApp;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddUser {

	JFrame frame;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddUser window = new AddUser();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AddUser() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(frame);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(27, 27, 381, 212);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name:");
		lblNewLabel.setForeground(SystemColor.window);
		lblNewLabel.setFont(new Font("Malgun Gothic", Font.PLAIN, 16));
		lblNewLabel.setBounds(20, 69, 63, 14);
		panel.add(lblNewLabel);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setForeground(SystemColor.window);
		lblEmail.setFont(new Font("Malgun Gothic", Font.PLAIN, 16));
		lblEmail.setBounds(20, 122, 63, 14);
		panel.add(lblEmail);
		
		textField = new JTextField();
		textField.setBounds(83, 69, 263, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(83, 122, 263, 20);
		panel.add(textField_1);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.setBounds(83, 178, 89, 23);
		panel.add(btnNewButton);
		
		JLabel lblAddUserTo = new JLabel("Add User to Group");
		lblAddUserTo.setForeground(SystemColor.infoText);
		lblAddUserTo.setFont(new Font("Malgun Gothic", Font.PLAIN, 17));
		lblAddUserTo.setBounds(117, 11, 162, 33);
		panel.add(lblAddUserTo);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				frame.dispose();
				
			}
		});
		btnCancel.setBounds(257, 178, 89, 23);
		panel.add(btnCancel);
	}
}
