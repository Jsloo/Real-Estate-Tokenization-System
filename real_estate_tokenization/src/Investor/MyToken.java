package Investor;

import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JSlider;
import javax.swing.JTree;
import javax.swing.JScrollBar;
import javax.swing.JSeparator;
import javax.swing.JTextPane;

public class MyToken extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static String[] selectedDetails = {"image","state","city","zipcode","address","name","token"};
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyToken frame = new MyToken();
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
	
	
	public MyToken() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 563);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 986, 526);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblRealEstateToken = new JLabel("My Token");
		lblRealEstateToken.setFont(new Font("Tahoma", Font.BOLD, 36));
		lblRealEstateToken.setBounds(40, 27, 192, 38);
		panel.add(lblRealEstateToken);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 0, true));
		panel_1.setBackground(Color.PINK);
		panel_1.setBounds(40, 96, 903, 390);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(42, 70, 780, 58);
		panel_1.add(panel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Name");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3.setBounds(74, 21, 242, 19);
		panel_2.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("Quantity");
		lblNewLabel_3_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3_1_1.setBounds(343, 21, 74, 19);
		panel_2.add(lblNewLabel_3_1_1);
		
		JLabel lblNewLabel_3_1 = new JLabel("No");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3_1.setBounds(11, 21, 53, 19);
		panel_2.add(lblNewLabel_3_1);
		
		JPanel panel_2_3 = new JPanel();
		panel_2_3.addMouseListener(new MouseAdapter() {
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
				ArrayList<String[]> details = new ArrayList<>();
				
				details.add(selectedDetails);
				String[] sellDetails = {"sell"};
				details.add(sellDetails);
				
				
				new TokenDetails(details).setVisible(true);
			}
		});
		panel_2_3.setBorder(new LineBorder(Color.PINK, 2, true));
		panel_2_3.setBackground(Color.WHITE);
		panel_2_3.setBounds(674, 10, 96, 34);
		panel_2.add(panel_2_3);
		panel_2_3.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel_3_4 = new JLabel("Details");
		
		lblNewLabel_3_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_2_3.add(lblNewLabel_3_4);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setLayout(null);
		panel_2_1.setBackground(Color.WHITE);
		panel_2_1.setBounds(42, 148, 780, 58);
		panel_1.add(panel_2_1);
		
		JLabel lblNewLabel_3_2 = new JLabel("Name");
		lblNewLabel_3_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3_2.setBounds(74, 21, 242, 19);
		panel_2_1.add(lblNewLabel_3_2);
		
		JLabel lblNewLabel_3_1_1_1 = new JLabel("Quantity");
		lblNewLabel_3_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3_1_1_1.setBounds(343, 21, 74, 19);
		panel_2_1.add(lblNewLabel_3_1_1_1);
		
		JLabel lblNewLabel_3_1_2 = new JLabel("No");
		lblNewLabel_3_1_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3_1_2.setBounds(11, 21, 53, 19);
		panel_2_1.add(lblNewLabel_3_1_2);
		
		JPanel panel_2_3_1 = new JPanel();
		panel_2_3_1.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
		        // Set the font to bold
				panel_2_3_1.setBackground(new java.awt.Color(204,204,204));
		    }
		    
		    @Override
		    public void mouseExited(MouseEvent e) {
		    	panel_2_3_1.setBackground(new java.awt.Color(255,255,255));
		    }
		});
		panel_2_3_1.setBorder(new LineBorder(Color.PINK, 2, true));
		panel_2_3_1.setBackground(Color.WHITE);
		panel_2_3_1.setBounds(674, 10, 96, 34);
		panel_2_1.add(panel_2_3_1);
		panel_2_3_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel_3_4_1 = new JLabel("Details");
		lblNewLabel_3_4_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_2_3_1.add(lblNewLabel_3_4_1);
		
		JPanel panel_2_1_1 = new JPanel();
		panel_2_1_1.setLayout(null);
		panel_2_1_1.setBackground(Color.WHITE);
		panel_2_1_1.setBounds(42, 228, 780, 58);
		panel_1.add(panel_2_1_1);
		
		JLabel lblNewLabel_3_2_1 = new JLabel("Name");
		lblNewLabel_3_2_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3_2_1.setBounds(74, 21, 242, 19);
		panel_2_1_1.add(lblNewLabel_3_2_1);
		
		JLabel lblNewLabel_3_1_1_1_1 = new JLabel("Quantity");
		lblNewLabel_3_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3_1_1_1_1.setBounds(343, 21, 74, 19);
		panel_2_1_1.add(lblNewLabel_3_1_1_1_1);
		
		JLabel lblNewLabel_3_1_2_1 = new JLabel("No");
		lblNewLabel_3_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3_1_2_1.setBounds(11, 21, 53, 19);
		panel_2_1_1.add(lblNewLabel_3_1_2_1);
		
		JPanel panel_2_3_1_1 = new JPanel();
		panel_2_3_1_1.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
		        // Set the font to bold
				panel_2_3_1_1.setBackground(new java.awt.Color(204,204,204));
		    }
		    
		    @Override
		    public void mouseExited(MouseEvent e) {
		    	panel_2_3_1_1.setBackground(new java.awt.Color(255,255,255));
		    }
		});
		panel_2_3_1_1.setBorder(new LineBorder(Color.PINK, 2, true));
		panel_2_3_1_1.setBackground(Color.WHITE);
		panel_2_3_1_1.setBounds(674, 10, 96, 34);
		panel_2_1_1.add(panel_2_3_1_1);
		panel_2_3_1_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel_3_4_1_1 = new JLabel("Details");
		lblNewLabel_3_4_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_2_3_1_1.add(lblNewLabel_3_4_1_1);
		
		JPanel panel_2_1_1_1 = new JPanel();
		panel_2_1_1_1.setLayout(null);
		panel_2_1_1_1.setBackground(Color.WHITE);
		panel_2_1_1_1.setBounds(42, 309, 780, 58);
		panel_1.add(panel_2_1_1_1);
		
		JLabel lblNewLabel_3_2_1_1 = new JLabel("Name");
		lblNewLabel_3_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3_2_1_1.setBounds(74, 21, 242, 19);
		panel_2_1_1_1.add(lblNewLabel_3_2_1_1);
		
		JLabel lblNewLabel_3_1_1_1_1_1 = new JLabel("Quantity");
		lblNewLabel_3_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3_1_1_1_1_1.setBounds(343, 21, 74, 19);
		panel_2_1_1_1.add(lblNewLabel_3_1_1_1_1_1);
		
		JLabel lblNewLabel_3_1_2_1_1 = new JLabel("No");
		lblNewLabel_3_1_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3_1_2_1_1.setBounds(11, 21, 53, 19);
		panel_2_1_1_1.add(lblNewLabel_3_1_2_1_1);
		
		JPanel panel_2_3_1_2 = new JPanel();
		panel_2_3_1_2.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
		        // Set the font to bold
				panel_2_3_1_2.setBackground(new java.awt.Color(204,204,204));
		    }
		    
		    @Override
		    public void mouseExited(MouseEvent e) {
		    	panel_2_3_1_2.setBackground(new java.awt.Color(255,255,255));
		    }
		});
		panel_2_3_1_2.setBorder(new LineBorder(Color.PINK, 2, true));
		panel_2_3_1_2.setBackground(Color.WHITE);
		panel_2_3_1_2.setBounds(674, 10, 96, 34);
		panel_2_1_1_1.add(panel_2_3_1_2);
		panel_2_3_1_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel_3_4_1_2 = new JLabel("Details");
		lblNewLabel_3_4_1_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_2_3_1_2.add(lblNewLabel_3_4_1_2);
		
		JButton btnNewButton_3_1 = new JButton("<");
		btnNewButton_3_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_3_1.setBackground(Color.WHITE);
		btnNewButton_3_1.setBounds(731, 10, 53, 21);
		panel_1.add(btnNewButton_3_1);
		
		textField = new JTextField();
		textField.setText("1");
		textField.setFont(new Font("Tahoma", Font.BOLD, 15));
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBorder(new LineBorder(Color.BLACK, 2, true));
		textField.setBounds(794, 13, 28, 19);
		panel_1.add(textField);
		
		JButton btnNewButton_3_1_1 = new JButton(">");
		btnNewButton_3_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_3_1_1.setBackground(Color.WHITE);
		btnNewButton_3_1_1.setBounds(832, 12, 55, 21);
		panel_1.add(btnNewButton_3_1_1);
		
		JLabel lblNewLabel_3_1_3 = new JLabel("No");
		lblNewLabel_3_1_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3_1_3.setBounds(42, 40, 53, 19);
		panel_1.add(lblNewLabel_3_1_3);
		
		JLabel lblNewLabel_3_3 = new JLabel("Name");
		lblNewLabel_3_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3_3.setBounds(114, 41, 242, 19);
		panel_1.add(lblNewLabel_3_3);
		
		JLabel lblNewLabel_3_1_1_2 = new JLabel("Quantity");
		lblNewLabel_3_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3_1_1_2.setBounds(384, 45, 74, 19);
		panel_1.add(lblNewLabel_3_1_1_2);
		
		JPanel panel_2_3_2 = new JPanel();
		panel_2_3_2.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
		        // Set the font to bold
				panel_2_3_2.setBackground(new java.awt.Color(204,204,204));
		    }
		    
		    @Override
		    public void mouseExited(MouseEvent e) {
		    	panel_2_3_2.setBackground(new java.awt.Color(255,255,255));
		    }
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				new Market().setVisible(true);
			}
		});
		panel_2_3_2.setBorder(new LineBorder(Color.PINK, 2, true));
		panel_2_3_2.setBackground(Color.WHITE);
		panel_2_3_2.setBounds(847, 27, 96, 34);
		panel.add(panel_2_3_2);
		panel_2_3_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel_3_4_2 = new JLabel("Back");
		lblNewLabel_3_4_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_2_3_2.add(lblNewLabel_3_4_2);
		
		
	}
}
