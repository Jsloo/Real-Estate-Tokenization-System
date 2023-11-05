package Investor;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Rectangle;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Market extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static String[] selectedDetails = {"image","state","city","zipcode","address","name","token"};
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Market frame = new Market();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Market() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 563);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(0, 0, 986, 537);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Real Estate Token Market");
		lblNewLabel.setBounds(36, 24, 480, 29);
		panel_1.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 36));
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.PINK);
		panel.setBounds(36, 110, 921, 399);
		panel_1.add(panel);
		panel.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(43, 61, 224, 276);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		lblNewLabel_2.setBounds(41, 10, 144, 132);
		panel_2.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Name");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3.setBounds(81, 152, 53, 19);
		panel_2.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("Price");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3_1.setBounds(81, 181, 53, 19);
		panel_2.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("Quantity");
		lblNewLabel_3_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3_1_1.setBounds(76, 210, 74, 19);
		panel_2.add(lblNewLabel_3_1_1);
		
		JButton btnNewButton = new JButton("Buy");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				ArrayList<String[]> details = new ArrayList<>();
				
				details.add(selectedDetails);
				String[] sellDetails = {"buy"};
				details.add(sellDetails);
				
				
				new TokenDetails(details).setVisible(true);
			}
		});
		btnNewButton.setBounds(65, 245, 85, 21);
		panel_2.add(btnNewButton);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setLayout(null);
		panel_2_1.setBackground(Color.WHITE);
		panel_2_1.setBounds(347, 61, 224, 276);
		panel.add(panel_2_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("");
		lblNewLabel_2_1.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		lblNewLabel_2_1.setBounds(41, 10, 144, 132);
		panel_2_1.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_3_2 = new JLabel("Name");
		lblNewLabel_3_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3_2.setBounds(81, 152, 53, 19);
		panel_2_1.add(lblNewLabel_3_2);
		
		JLabel lblNewLabel_3_1_2 = new JLabel("Price");
		lblNewLabel_3_1_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3_1_2.setBounds(81, 181, 53, 19);
		panel_2_1.add(lblNewLabel_3_1_2);
		
		JLabel lblNewLabel_3_1_1_2 = new JLabel("Quantity");
		lblNewLabel_3_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3_1_1_2.setBounds(76, 210, 74, 19);
		panel_2_1.add(lblNewLabel_3_1_1_2);
		
		JButton btnNewButton_1 = new JButton("Buy");
		btnNewButton_1.setBounds(65, 245, 85, 21);
		panel_2_1.add(btnNewButton_1);
		
		JPanel panel_2_2 = new JPanel();
		panel_2_2.setLayout(null);
		panel_2_2.setBackground(Color.WHITE);
		panel_2_2.setBounds(648, 61, 224, 276);
		panel.add(panel_2_2);
		
		JLabel lblNewLabel_2_2 = new JLabel("");
		lblNewLabel_2_2.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		lblNewLabel_2_2.setBounds(41, 10, 144, 132);
		panel_2_2.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_3_3 = new JLabel("Name");
		lblNewLabel_3_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3_3.setBounds(81, 152, 53, 19);
		panel_2_2.add(lblNewLabel_3_3);
		
		JLabel lblNewLabel_3_1_3 = new JLabel("Price");
		lblNewLabel_3_1_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3_1_3.setBounds(81, 181, 53, 19);
		panel_2_2.add(lblNewLabel_3_1_3);
		
		JLabel lblNewLabel_3_1_1_3 = new JLabel("Quantity");
		lblNewLabel_3_1_1_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3_1_1_3.setBounds(76, 210, 74, 19);
		panel_2_2.add(lblNewLabel_3_1_1_3);
		
		JButton btnNewButton_2 = new JButton("Buy");
		btnNewButton_2.setBounds(65, 245, 85, 21);
		panel_2_2.add(btnNewButton_2);
		
		JButton btnNewButton_3_1 = new JButton("<");
		btnNewButton_3_1.setBackground(Color.WHITE);
		btnNewButton_3_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_3_1.setBounds(755, 11, 53, 21);
		panel.add(btnNewButton_3_1);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setBorder(new LineBorder(Color.BLACK, 2, true));
		textField_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		textField_1.setText("1");
		textField_1.setBounds(818, 12, 28, 19);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton_3_1_1 = new JButton(">");
		btnNewButton_3_1_1.setBackground(Color.WHITE);
		btnNewButton_3_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_3_1_1.setBounds(856, 11, 55, 21);
		panel.add(btnNewButton_3_1_1);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField.setBorder(new LineBorder(Color.BLACK, 2, true));
		textField.setBounds(119, 83, 161, 19);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Search:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(42, 83, 67, 18);
		panel_1.add(lblNewLabel_1);
		
		JPanel panel_2_3 = new JPanel();
		
		panel_2_3.addMouseListener(new MouseAdapter() {
			@Override
		    public void mouseEntered(MouseEvent e) {
		        // Set the font to bold
				panel_2_3.setBackground(new java.awt.Color(204,204,204));
		    }
		    
		    @Override
		    public void mouseExited(MouseEvent e) {
		    	panel_2_3.setBackground(new java.awt.Color(255,255,255));
		    }
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				new MyToken().setVisible(true);
			}
		});
		panel_2_3.setBorder(new LineBorder(Color.PINK, 2, true));
		panel_2_3.setBackground(Color.WHITE);
		panel_2_3.setBounds(851, 66, 103, 34);
		panel_1.add(panel_2_3);
		panel_2_3.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel_3_4 = new JLabel("My Token");
		panel_2_3.add(lblNewLabel_3_4);
		lblNewLabel_3_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JLabel lblUsername = new JLabel("UserName");
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 36));
		lblUsername.setBounds(754, 24, 200, 29);
		panel_1.add(lblUsername);
	}
}
