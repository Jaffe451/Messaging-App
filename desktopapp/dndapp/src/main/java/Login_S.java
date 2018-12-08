
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPasswordField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.SystemColor;

public class Login_S {

	JFrame frame;
	private JTextField txtUsername;
	private JPasswordField txtPassword;

	private JButton btnLogin;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login_S window = new Login_S();
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
	public Login_S() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.controlDkShadow);
		frame.getContentPane().setFont(new Font("Malgun Gothic", Font.PLAIN, 12));
		frame.setBounds(200, 200, 500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(frame);
		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setForeground(SystemColor.menu);
		lblNewLabel.setFont(new Font("Malgun Gothic", Font.PLAIN, 30));
		lblNewLabel.setBounds(199, 28, 86, 41);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setForeground(SystemColor.scrollbar);
		lblUsername.setFont(new Font("Malgun Gothic", Font.PLAIN, 23));
		lblUsername.setBounds(13, 115, 148, 36);
		frame.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(SystemColor.scrollbar);
		lblPassword.setFont(new Font("Malgun Gothic", Font.PLAIN, 23));
		lblPassword.setBounds(13, 211, 115, 33);
		frame.getContentPane().add(lblPassword);
		
		txtUsername = new JTextField();
		
		txtUsername.setBounds(154, 117, 275, 33);
		frame.getContentPane().add(txtUsername);
		txtUsername.setColumns(10);
		
		
// LOGIN BUTTON //////////////
		btnLogin = new JButton("Login");
		btnLogin.setBackground(Color.LIGHT_GRAY);
		btnLogin.setForeground(Color.BLACK);
		btnLogin.setFont(new Font("Malgun Gothic", Font.PLAIN, 12));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				submit();
			}
		});
		btnLogin.setBounds(20, 327, 120, 41);
		frame.getContentPane().add(btnLogin);
	
		// RESET BUTTON//////////////
		JButton btnReset = new JButton("Reset");
		btnReset.setForeground(Color.WHITE);
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				txtUsername.setText(null);
				txtPassword.setText(null);
				
			}
		});
		btnReset.setBackground(Color.GRAY);
		btnReset.setFont(new Font("Malgun Gothic", Font.PLAIN, 12));
		btnReset.setBounds(182, 327, 120, 41);
		frame.getContentPane().add(btnReset);
		
		// REGISTER BUTTON//////////////
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Brings up new window for user to create an account
			Register nw = new Register();
			nw.frame.setVisible(true);
			frame.dispose();
			
			}
		});
		btnRegister.setBackground(Color.LIGHT_GRAY);
		btnRegister.setFont(new Font("Malgun Gothic", Font.PLAIN, 12));
		btnRegister.setBounds(341, 327, 120, 41);
		frame.getContentPane().add(btnRegister);
		
		txtPassword = new JPasswordField();
		txtPassword.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				
				if(arg0.getKeyCode() == KeyEvent.VK_ENTER) {
					

					submit();	
				}	
			}
		});
		
		txtUsername.addKeyListener(new KeyAdapter() {
				
			public void keyPressed(KeyEvent arg0) {
			
				if(arg0.getKeyCode() == KeyEvent.VK_ENTER) {
				
					submit();
				}	
				
			}
				
	    });
		txtPassword.setBounds(154, 207, 275, 33);
		frame.getContentPane().add(txtPassword);
	}
	
	private void submit() {
		String password = txtPassword.getText(); 
		String username = txtUsername.getText();
		
		if(password.length() > 3&& username.length() > 3) {
			JOptionPane.showMessageDialog( btnLogin, "Login Successful");
			
			frame.dispose();
			Home nw = new Home();
			nw.frame.setVisible(true);
			
			
		}
		else {
			JOptionPane.showMessageDialog(null, "Invalid Login Details", "Login Error", JOptionPane.ERROR_MESSAGE);
			txtPassword.setText(null);
			txtUsername.setText(null);
		}	
	}
}