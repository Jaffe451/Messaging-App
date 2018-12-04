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

public class Chat {

	private JFrame frame;
	private JTextField textField;
	private JPanel panel;
	private JButton btnSend;
	private JButton btnHome;
	private JPanel panel_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Chat window = new Chat();
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
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(frame);
		
		textField = new JTextField();
		textField.setBounds(193, 383, 377, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		////ADD FILE BUTTON///////////
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
		btnAddFIle.setBounds(125, 382, 41, 23);
		frame.getContentPane().add(btnAddFIle);
		
		panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 0, 91, 461);
		frame.getContentPane().add(panel);
		
		btnHome = new JButton("Home");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame.dispose();
				Home nw = new Home();
				nw.frame.setVisible(true);
				
			}
		});
		panel.add(btnHome);
		
		btnSend = new JButton("Send");
		btnSend.setBounds(604, 382, 57, 23);
		frame.getContentPane().add(btnSend);
		
		panel_1 = new JPanel();
		panel_1.setBounds(94, 9, 580, 363);
		frame.getContentPane().add(panel_1);
	}
}
