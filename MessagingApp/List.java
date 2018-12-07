package MessagingApp;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.SystemColor;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JCheckBox;
import java.awt.ScrollPane;
import java.awt.TextArea;

public class List {

	JFrame frame;
	private JTextField textField;
	private JTextField textListName;
	
	private String theList;
	private Home mw;
	private JTextArea textArea;

	/**
	 * Create the application.
	 * @wbp.parser.constructor 
	 */
	public List(Home home) {
		mw = home;
		theList = new String();
		
		initialize();
	}
	
	public List(Home home, String list) {
		mw = home;
		theList = list; 
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 400);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(frame);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.scrollbar);
		panel.setBounds(10, 11, 564, 339);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		/**
		 * Add Item Label
		 */
		JLabel lblAddItem = new JLabel("Add Item");
		lblAddItem.setFont(new Font("Malgun Gothic", Font.PLAIN, 14));
		lblAddItem.setForeground(SystemColor.controlDkShadow);
		lblAddItem.setBounds(10, 76, 62, 14);
		panel.add(lblAddItem);
		
		/**
		 * OK BUTTON
		 */
		JButton btnSend = new JButton("OK");
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mw.addList(theList);
				frame.dispose();
			}
		});
		btnSend.setBounds(340, 305, 89, 23);
		panel.add(btnSend);
		
		JList list = new JList();
		list.setBounds(357, 56, 181, 238);
		panel.add(list);
		
		/**
		 * ADD BUTTON
		 */
		JButton btnADD = new JButton("ADD");
		btnADD.setFont(new Font("Malgun Gothic", Font.PLAIN, 11));
		DefaultListModel mod = new DefaultListModel();
		btnADD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(!textField.getText().contains(",")) {
					// set model to JList
					list.setModel(mod);
					
					// Save to model
					theList += "," + textField.getText();
					
					// Add item
					mod.addElement(textField.getText().trim());
					textField.setText("");
				}else {
					//error
					textField.setText("");
				}
			}
		});
		btnADD.setBounds(41, 106, 62, 23);
		panel.add(btnADD);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if(arg0.getKeyCode() == KeyEvent.VK_ENTER) {
					if(!textField.getText().contains(",")) {
						// set model to JList
						list.setModel(mod);
						
						// Save to model
						theList += "," + textField.getText();
						
						// Add item
						mod.addElement(textField.getText().trim());
						textField.setText("");
					}else {
						//error
						textField.setText("");
					}
				}
			}
		});
		textField.setBounds(82, 73, 176, 20);
		panel.add(textField);
		textField.setColumns(10);
				
		/**
		 * DELETE BUTTON
		 */
		JButton btnDelete = new JButton("Delete");
		btnDelete.setFont(new Font("Malgun Gothic", Font.PLAIN, 11));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int index = list.getSelectedIndex();
				mod.removeElementAt(index);
			}
		});
		btnDelete.setBounds(124, 106, 72, 23);
		panel.add(btnDelete);
		
		/**
		 * EDIT BUTTON
		 */
		JButton btnEdit = new JButton("Edit");
		btnEdit.setFont(new Font("Malgun Gothic", Font.PLAIN, 11));
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int index = list.getSelectedIndex();
				mod.setElementAt(textField.getText(), index);
				textField.setText("");
			}
		});
		btnEdit.setBounds(216, 106, 62, 23);
		panel.add(btnEdit);
		
		/**
		 * List Name Label
		 */
		JLabel lblListName = new JLabel("List Name");
		lblListName.setForeground(SystemColor.controlDkShadow);
		lblListName.setFont(new Font("Malgun Gothic", Font.PLAIN, 14));
		lblListName.setBounds(10, 32, 72, 14);
		panel.add(lblListName);
		
		textArea = new JTextArea();
		textArea.setFont(new Font("Malgun Gothic", Font.PLAIN, 17));
		textArea.setBackground(SystemColor.scrollbar);
		textArea.setForeground(SystemColor.controlDkShadow);
		textArea.setBounds(374, 24, 145, 22);
		panel.add(textArea);
		
		textListName = new JTextField();
		textListName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if(arg0.getKeyCode() == KeyEvent.VK_ENTER) {
					String text = textListName.getText();
					textArea.setText(text);
					if(theList.equals("")) {
						theList = text;
					}
					textListName.setText("");
				}
				textArea.setEditable(false);
			}
		});
		textListName.setColumns(10);
		textListName.setBounds(82, 31, 176, 20);
		panel.add(textListName);
		
		/**
		 * RESET BUTTON
		 */
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textListName.setText(null);
				textField.setText(null);
				textArea.setText(null);
				list.setListData(new Object[0]);
				theList = "";
				mod.removeAllElements();
			}
		});
		btnReset.setBounds(465, 305, 89, 23);
		panel.add(btnReset);
		
		/**
		 * CANCEL BUTTON
		 */
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnCancel.setBounds(25, 305, 89, 23);
		panel.add(btnCancel);
		
		if(!theList.equals("")) {
			list.setModel(mod);
			String[] listElements = theList.split(",");
			int numElements = listElements.length;
			getTextArea().setText(listElements[0]);
			
			for(int i=1; i<numElements; i++) {
				mod.addElement(listElements[i].trim());
			}	
		}	
	}
	
	public JTextArea getTextArea() {
		return textArea;
	}
}
