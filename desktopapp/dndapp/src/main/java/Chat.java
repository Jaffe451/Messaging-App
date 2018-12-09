
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.BoxLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

public class Chat {

	JFrame frame;
	private JTextField textField;
	private JPanel panel;
	private JButton btnSend;
	private JButton btnHome;
	
	private JTextPane textArea;


	private final Home mw;
	private final String username;

	/**
	 * Create the application.
	 */
	public Chat(Home home, String username) {
		
		mw = home;
		this.username = username;
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
				
				
			}
		});
		panel.add(btnHome);
		textArea = new JTextPane();
		textArea.setEditable(false);
		textArea.setForeground(SystemColor.info);
		textArea.setBackground(SystemColor.controlDkShadow);
		textArea.setBounds(193, 47, 374, 314);
		frame.getContentPane().add(textArea);
		
		btnSend = new JButton("Send");
		JButton btnSend = new JButton("Send");

		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if(arg0.getKeyCode() == KeyEvent.VK_ENTER) {

					submit();
				}
				
			}
		});
		
		btnSend.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent ae) {
	        	
	           submit();
	        }
	    });
		btnSend.setBounds(604, 382, 57, 23);
		frame.getContentPane().add(btnSend);
	
	}
	
	private void submit() {
			
		if(!textField.getText().equals("")) { 	
			String text = textField.getText();
			if(textArea.getText().equals("")) {
				textArea.setText(mw.getUser() + " : " + text);

			}	
			else {
				textArea.setText(textArea.getText() + "\n" + text);
			}
			mw.getChat().sendPrivateMessage(text, username+"@"+mw.getHost());
			textField.setText("");
		}
		
	}
}
