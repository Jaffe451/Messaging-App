package MessagingApp;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JMenu;
import javax.swing.JOptionPane;

public class Home {

	JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home window = new Home();
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
	public Home() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 736, 519);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblUsernameId = new JLabel("Username ID");
		lblUsernameId.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblUsernameId.setBounds(27, 11, 111, 46);
		frame.getContentPane().add(lblUsernameId);
		
	
		JComboBox comboBox = new JComboBox();
		comboBox.addItem("My Groups");
		comboBox.addItem("Friends");
		comboBox.setBounds(152, 11, 123, 46);
		frame.getContentPane().add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.addItem("My Lists");
		comboBox_1.addItem("Create List");
		comboBox_1.addItem("Edit List");
		comboBox_1.addItem("Delete List");
		comboBox_1.setBounds(290, 11, 123, 46);
		frame.getContentPane().add(comboBox_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.addItem("My Polls");
		comboBox_2.addItem("Create Poll");
		comboBox_2.addItem("Edit Poll");
		comboBox_2.addItem("Delete Poll");
		comboBox_2.setBounds(429, 11, 123, 46);
		frame.getContentPane().add(comboBox_2);
		
		JButton btnNewButton = new JButton("Log Off");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(31, 396, 98, 46);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnSendAnnouncement = new JButton("Send Announcement");
		btnSendAnnouncement.setBounds(282, 276, 131, 23);
		frame.getContentPane().add(btnSendAnnouncement);
		
		JButton btnCreateGroup = new JButton("Create Group/Poll");
		btnCreateGroup.setBounds(282, 310, 131, 23);
		frame.getContentPane().add(btnCreateGroup);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog( btnNewButton,  "Logged Out Successful");
				frame.dispose();
				Login_S nw = new Login_S();
				nw.frame.setVisible(true);
				
			};
		});
		
	}
}

		
	



