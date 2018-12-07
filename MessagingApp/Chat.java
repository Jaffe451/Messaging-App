package MessagingApp;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.BoxLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JTextArea;

public class Chat {

	JFrame frame;
	private JTextField textField;
	private JPanel panel;
	private JButton btnSend;
	private JButton btnHome;

	/**
	 * Create the application.
	 */
	public Chat() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.controlDkShadow);
		frame.setBounds(100, 100, 700, 500);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(frame);
		
		textField = new JTextField();
		textField.setBounds(176, 383, 377, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		/**
		 * ADD FILE BUTTON
		 */
		JButton btnAddFIle = new JButton("+");
		btnAddFIle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JFileChooser chooser = new JFileChooser();
				chooser.showOpenDialog(null);
				File f = chooser.getSelectedFile();
				String filename = f.getAbsolutePath();
				textField.setText(filename);
			}
		});
		btnAddFIle.setBounds(117, 382, 41, 23);
		frame.getContentPane().add(btnAddFIle);
		
		panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 0, 91, 461);
		frame.getContentPane().add(panel);
		
		/**
		 * HOME BUTTON
		 */
		btnHome = new JButton("Home");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		panel.add(btnHome);
		JTextArea textArea = new JTextArea();
		textArea.setForeground(SystemColor.info);
		textArea.setBackground(SystemColor.controlDkShadow);
		textArea.setBounds(193, 47, 374, 314);
		frame.getContentPane().add(textArea);
		
		/**
		 * SEND BUTTON
		 */
		btnSend = new JButton("Send");
		JButton btnSend = new JButton("Send");

		btnSend.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent ae) {
	        	
			    if(!textField.getText().equals("")) { 	
			        	 String text = textField.getText();
		        	 if(textArea.getText().equals("")) {
		        		 textArea.setText(text);
		        		 textArea.insert("Username    :   ", 0);
		        	 }else {
				         textArea.setText(textArea.getText() + "\n" + text);
		        	 }	
		        	 textField.setText("");
			    }
	        }
	    });
		btnSend.setBounds(592, 382, 69, 23);
		frame.getContentPane().add(btnSend);
	}
}
