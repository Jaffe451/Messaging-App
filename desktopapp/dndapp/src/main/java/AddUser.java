

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JPopupMenu;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddUser {

	JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JButton chat;
	private final Home mw;
	
	private static int userBufferSpacing = 20;



	/**
	 * Create the application.
	 */
	public AddUser(Home mw) {
		this.mw = mw;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String password = textField_1.getText(); 
				String username = textField.getText();
				
				if(password.length() > 3 && username.length() > 3) {
					
					JOptionPane.showMessageDialog( btnNewButton, "Added User To Chat");
				
					
				{
					
					
					JButton chat = new JButton( username.substring(0,1));
					chat.setBackground(Color.LIGHT_GRAY);
					chat.setFont(new Font("Malgun Gothic", Font.PLAIN, 12));
					chat.setBounds(0, 0, 70, 60); //initialize in corner with size
					chat.setLocation(15,35+(80*mw.getNumUsers()) + userBufferSpacing); //move to position
				
					
					
				
					
					
					chat.addActionListener(new ActionListener() {
					    public void actionPerformed(ActionEvent arg0) {
					
					    	Chat nw = new Chat(mw);
							nw.frame.setVisible(true);
						
					    }
					    
				});
					frame.dispose();
					mw.frame.getContentPane().add(chat);
					mw.incUsers();
					mw.frame.setVisible(true);
					}	
			}
				else {
					JOptionPane.showMessageDialog(null, "Invalid Login Details", "Login Error", JOptionPane.ERROR_MESSAGE);
					textField_1.setText(null);
					textField.setText(null);
				}
			}
		});
		
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
