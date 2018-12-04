package MessagingApp;



// Smack Api //



import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.SystemColor;

public class Register extends JFrame{

	JFrame frame;
	private JTextField txtUsername;
	private JPasswordField txtPassword;
	private JPasswordField txtRetypePass;


	/**
	 * Launch the application.
	 */
	public static void Register() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register window = new Register();
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
	public Register() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.controlDkShadow);
		frame.setBounds(200, 200, 500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(frame);
		
		JLabel lblNewLabel = new JLabel("Register");
		lblNewLabel.setForeground(SystemColor.menu);
		lblNewLabel.setFont(new Font("Malgun Gothic", Font.PLAIN, 30));
		lblNewLabel.setBounds(189, 28, 115, 42);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setForeground(SystemColor.scrollbar);
		lblUsername.setFont(new Font("Malgun Gothic", Font.PLAIN, 24));
		lblUsername.setBounds(13, 115, 148, 36);
		frame.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(SystemColor.scrollbar);
		lblPassword.setFont(new Font("Malgun Gothic", Font.PLAIN, 24));
		lblPassword.setBounds(13, 179, 115, 33);
		frame.getContentPane().add(lblPassword);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(154, 117, 275, 33);
		frame.getContentPane().add(txtUsername);
		txtUsername.setColumns(10);
		
		
// Register Me BUTTON //////////////
		JButton btnRegisterme = new JButton("Register Me");
		btnRegisterme.setBackground(SystemColor.scrollbar);
		btnRegisterme.setForeground(Color.BLACK);
		btnRegisterme.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnRegisterme.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String username = txtUsername.getText();
				String password = txtPassword.getText();
				String retypepass = txtRetypePass.getText();
				
				if(username.contains("email") && password.contains("1234") && retypepass.contains("1234")) {
					
					JOptionPane.showMessageDialog( btnRegisterme, "Registration Successful");
					
					frame.dispose();
					Login_S nw = new Login_S();
					nw.frame.setVisible(true);
					
				}
				
				if(password.contains(null)){
					JOptionPane.showMessageDialog(null, "Invalid Password Details", "Register Error", JOptionPane.ERROR_MESSAGE);
					txtPassword.setText(null);
				}
				
				if(username.contains(null)) {
					JOptionPane.showMessageDialog(null, "Invalid Username Details", "Register Error", JOptionPane.ERROR_MESSAGE);
					txtUsername.setText(null);
				}	
				
				if(retypepass != password) {
					JOptionPane.showMessageDialog(null, "Password Mismatch", "Register Error", JOptionPane.ERROR_MESSAGE);
					txtRetypePass.setText(null);
				}
				
				
			}
		});
		btnRegisterme.setBounds(46, 327, 135, 41);
		frame.getContentPane().add(btnRegisterme);
	
		// RESET BUTTON//////////////
		JButton btnReset = new JButton("Reset");
		btnReset.setForeground(Color.WHITE);
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				txtUsername.setText(null);
				txtPassword.setText(null);
				txtRetypePass.setText(null);
				
			}
		});
		btnReset.setBackground(Color.GRAY);
		btnReset.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnReset.setBounds(298, 327, 120, 41);
		frame.getContentPane().add(btnReset);
		
		JLabel lblRetypePass = new JLabel("Retype Pass");
		lblRetypePass.setForeground(SystemColor.scrollbar);
		lblRetypePass.setFont(new Font("Malgun Gothic", Font.PLAIN, 20));
		lblRetypePass.setBounds(13, 240, 115, 33);
		frame.getContentPane().add(lblRetypePass);
		
		// BACK BUTTON////////////
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Login_S nw = new Login_S();
				nw.frame.setVisible(true);
			
				
			}
		});
		btnBack.setFont(new Font("Malgun Gothic", Font.PLAIN, 17));
		btnBack.setBounds(26, 29, 90, 41);
		frame.getContentPane().add(btnBack);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(154, 179, 275, 32);
		frame.getContentPane().add(txtPassword);
		
		txtRetypePass = new JPasswordField();
		txtRetypePass.setBounds(155, 234, 274, 36);
		frame.getContentPane().add(txtRetypePass);
		
			
				
	}
}