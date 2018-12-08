import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Shape;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JOptionPane;
import java.awt.SystemColor;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

import javax.swing.SwingConstants;

public class Home {

	public JFrame frame;
	private JTextField textField;
	private JTextArea textArea;
	private String message;
	private JScrollPane jsp;
	private Home thisFrame;
	private ArrayList<String> lists;
	private ArrayList<String> Polls;
	private int numUsers;

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
		numUsers = 0;
		lists = new ArrayList<String>();
		Polls = new ArrayList<String>();
		thisFrame = this;
		initialize();
	}
	
	public void addList(String newList) {
		lists.add(newList);
	}
	
	public void addPoll(String newPoll) {
		Polls.add(newPoll);
	}
	
	
	public ArrayList<String> getLists(){
		return lists;
	}
	
	public ArrayList<String> getPolls(){
		return Polls ;
	}
	
	public void incUsers() {
		numUsers++;
	}
	
	public int getNumUsers() {
		return numUsers;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	
	private void initialize() {
		
		
		
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.controlDkShadow);
		frame.setBounds(100, 100, 736, 519);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(frame);

		
		
		
		JButton btnCreateList = new JButton("Create List");
		btnCreateList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				List nw = new List(thisFrame);
				nw.frame.setVisible(true);
			}
		});
		btnCreateList.setBounds(474, 446, 106, 23);
		frame.getContentPane().add(btnCreateList);
		
		JButton btnCreatePoll = new JButton("Create Poll");
		btnCreatePoll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				CreatePoll nw = new CreatePoll(thisFrame);
				nw.frame.setVisible(true);
			}
		});
		btnCreatePoll.setBounds(167, 446, 106, 23);
		frame.getContentPane().add(btnCreatePoll);
		
		
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 0, 106, 480);
		frame.getContentPane().add(panel);
		
		JButton btnNewButton = new JButton("Log Off");
		panel.add(btnNewButton);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JButton btnViewLists = new JButton("View Lists");
		btnViewLists.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				viewList nw = new viewList(thisFrame);
				nw.frame.setVisible(true);
				
			}
		});
		btnViewLists.setBounds(593, 36, 100, 23);
		frame.getContentPane().add(btnViewLists);
		
		JButton btnAddUser = new JButton("Add User");
		btnAddUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AddUser nw = new AddUser( thisFrame );
				nw.frame.setVisible(true);
			}
		});
		btnAddUser.setBounds(136, 36, 106, 23);
		frame.getContentPane().add(btnAddUser);
		
		JButton btnViewPolls = new JButton("View Polls");
		btnViewPolls.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewPolls nw = new ViewPolls(thisFrame);
				nw.frame.setVisible(true);
			}
		});
		btnViewPolls.setBounds(363, 36, 115, 23);
		frame.getContentPane().add(btnViewPolls);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(167, 405, 413, 20);
		frame.getContentPane().add(textField);
		
		
		JTextArea textArea = new JTextArea();
		

		textArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
		textArea.setEditable(false);
		textArea.setForeground(SystemColor.controlLtHighlight);
		textArea.setLineWrap(true);
		textArea.setBackground(SystemColor.controlDkShadow);


		frame.getContentPane().setBackground(SystemColor.controlDkShadow);
		textArea.setBounds(167, 91, 413, 268);
		frame.getContentPane().add(textArea);
		
		//////////////Send Button//////////////////////////
		JButton btnSend = new JButton("Send");
		btnSend.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				
				if(arg0.getKeyCode() == KeyEvent.VK_ENTER) {
					if(!textField.getText().equals("")) { 	
						String text = textField.getText();
						if(textArea.getText().equals("")) {
							textArea.setText(text);
							textArea.insert("Username    :   ", 0);
				      
						}	
						else {
							textArea.setText(textArea.getText() + "\n" + text);
						}	
						textField.setText("");
					}
				}
				
			}
		});

		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
			        
				if(!textField.getText().equals("")) { 	
					String text = textField.getText();
					if(textArea.getText().equals("")) {
						textArea.setText(text);
						textArea.insert("Username    :   ", 0);
			      
					}	
					else {
						textArea.setText(textArea.getText() + "\n" + text);
					}	
					textField.setText("");
				}
							
			  }
		});
				
		btnSend.setBounds(604, 404, 89, 23);
		frame.getContentPane().add(btnSend);
		
		////////ADD Files Button//////////////
		JButton button = new JButton("+");
		
		
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JFileChooser chooser = new JFileChooser();
				chooser.showOpenDialog(null);
				File f = chooser.getSelectedFile();
				String filename = f.getAbsolutePath();
				textField.setText(filename);
				
				String sb = "TEST CONTENT";
			
			  
				chooser.setCurrentDirectory(new File("/home/me/Documents"));
			    int retrival = chooser.showSaveDialog(null);
			    if (retrival == JFileChooser.APPROVE_OPTION) {
			        try {
			            FileWriter fw = new FileWriter(chooser.getSelectedFile()+".txt");
			            fw.write(sb.toString());
			        } catch (Exception ex) {
			            ex.printStackTrace();
			        }
			    }
				
				
				
			}
		});
		button.setBounds(116, 404, 41, 23);
		frame.getContentPane().add(button);
		

		
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
	



