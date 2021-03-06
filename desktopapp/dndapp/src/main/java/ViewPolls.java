

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.JLabel;

public class ViewPolls  {

	JFrame frame;
	
	private final Home mw;
	private JComboBox comboBox;
	
	private ArrayList<String> allPolls;
	private int PollIndex;

	/**
	 * Create the application.
	 */
	public ViewPolls(Home home) {
		mw = home;

		allPolls = mw.getPolls();
		
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
		
		JLabel lblNewLabel = new JLabel("View Polls Created");
		lblNewLabel.setForeground(SystemColor.inactiveCaptionText);
		lblNewLabel.setFont(new Font("Malgun Gothic", Font.PLAIN, 29));
		lblNewLabel.setBounds(155, 26, 253, 45);
		panel.add(lblNewLabel);
		
				
		
		String[] listNames = new String[allPolls.size()];
		PollIndex=0;
		
		for(String list : allPolls) {
			String title = list.split(",")[0];
			listNames[PollIndex] = title;
			PollIndex++;			
		}
		
		comboBox = new JComboBox(listNames);
		comboBox.setBounds(188, 122, 188, 20);
		panel.add(comboBox);
		
		
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnCancel.setBounds(392, 280, 89, 23);
		panel.add(btnCancel);
		
		JButton btnView = new JButton("View");
		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				List nw = new List(mw, allPolls.get(comboBox.getSelectedIndex()));
				nw.frame.setVisible(true);
				frame.dispose();
			}
		});
		btnView.setForeground(SystemColor.infoText);
		btnView.setFont(new Font("Malgun Gothic", Font.PLAIN, 11));
		btnView.setBounds(82, 280, 89, 23);
		panel.add(btnView);
		




	}

	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		
	}

}
