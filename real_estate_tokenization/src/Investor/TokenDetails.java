package Investor;

import java.awt.EventQueue;

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
import java.util.Arrays;

import javax.swing.JSlider;
import javax.swing.JTree;
import javax.swing.JScrollBar;
import javax.swing.JSeparator;
import javax.swing.JTextPane;
import javax.swing.border.MatteBorder;
import java.awt.SystemColor;
import java.awt.FlowLayout;

public class TokenDetails extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;

	/**
	 * Launch the application.
	 */
	public boolean back = false;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TokenDetails frame = new TokenDetails(null);
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
	public TokenDetails(ArrayList<String[]>  details) {
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
		
		JLabel lblRealEstateToken = new JLabel("Token Details");
		lblRealEstateToken.setFont(new Font("Tahoma", Font.BOLD, 36));
		lblRealEstateToken.setBounds(40, 27, 269, 29);
		panel.add(lblRealEstateToken);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 0, true));
		panel_1.setBackground(Color.PINK);
		panel_1.setBounds(40, 96, 903, 390);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Image");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(25, 10, 73, 36);
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JFileChooser fileChooser = new JFileChooser();
		        FileNameExtensionFilter fnef = new FileNameExtensionFilter("PNG JPG AND JPEG","png","jpeg","jpg");
		        fileChooser.addChoosableFileFilter(fnef);
		        int load = fileChooser.showOpenDialog(null);

		        if(load == JFileChooser.APPROVE_OPTION){
		            File selectedFile = fileChooser.getSelectedFile();
		            String path =selectedFile.getAbsolutePath();
		            ImageIcon imageIcon = new ImageIcon(path);
		            Image img =imageIcon.getImage().getScaledInstance(250,250,Image.SCALE_SMOOTH);
		            lblNewLabel_2.setIcon(new ImageIcon(img));
		        }
			}
		});
		lblNewLabel_2.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		lblNewLabel_2.setBounds(253, 10, 195, 154);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblName.setBounds(515, 53, 163, 36);
		panel_1.add(lblName);
		
		JLabel lblNumberOfToken = new JLabel("Selling Price");
		lblNumberOfToken.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNumberOfToken.setBounds(516, 262, 162, 36);
		panel_1.add(lblNumberOfToken);
		
		JLabel lblNumberOfToken_1 = new JLabel("Total Token");
		lblNumberOfToken_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNumberOfToken_1.setBounds(516, 114, 162, 36);
		panel_1.add(lblNumberOfToken_1);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		textField.setBounds(253, 185, 195, 24);
		panel_1.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		textField_1.setBounds(253, 222, 195, 24);
		panel_1.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setBackground(new Color(255, 228, 225));
		textField_2.setColumns(10);
		textField_2.setBorder(new MatteBorder(0, 0, 4, 0, (Color) Color.BLACK));
		textField_2.setBounds(688, 212, 195, 24);
		panel_1.add(textField_2);
		
		JButton btnNewButton = new JButton("Sell");
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton.setBounds(652, 328, 117, 36);
		panel_1.add(btnNewButton);
		
		JLabel lblState = new JLabel("State");
		lblState.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblState.setBounds(25, 175, 132, 36);
		panel_1.add(lblState);
		
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		textField_3.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		textField_3.setBounds(688, 63, 195, 24);
		panel_1.add(textField_3);
		
		JLabel lblName_1_1 = new JLabel("City");
		lblName_1_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblName_1_1.setBounds(25, 212, 132, 36);
		panel_1.add(lblName_1_1);
		
		JLabel lblName_1_1_1 = new JLabel("Zip Code");
		lblName_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblName_1_1_1.setBounds(25, 249, 132, 36);
		panel_1.add(lblName_1_1_1);
		
		JLabel lblName_1_1_1_1 = new JLabel("Address");
		lblName_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblName_1_1_1_1.setBounds(25, 293, 132, 36);
		panel_1.add(lblName_1_1_1_1);
		
		textField_4 = new JTextField();
		textField_4.setEditable(false);
		textField_4.setColumns(10);
		textField_4.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		textField_4.setBounds(687, 114, 195, 24);
		panel_1.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setEditable(false);
		textField_5.setColumns(10);
		textField_5.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		textField_5.setBounds(253, 259, 195, 24);
		panel_1.add(textField_5);
		
		JTextPane textPane = new JTextPane();
		textPane.setEditable(false);
		textPane.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		textPane.setBounds(253, 299, 195, 81);
		panel_1.add(textPane);
		
		JLabel lblRm = new JLabel("RM");
		lblRm.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblRm.setBounds(687, 262, 42, 36);
		panel_1.add(lblRm);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBorder(new MatteBorder(0, 0, 4, 0, (Color) Color.BLACK));
		textField_6.setBackground(new Color(255, 228, 225));
		textField_6.setBounds(720, 262, 163, 24);
		panel_1.add(textField_6);
		
		JLabel lblSellingTokenAmount = new JLabel("Selling Quantity");
		lblSellingTokenAmount.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblSellingTokenAmount.setBounds(515, 212, 163, 36);
		panel_1.add(lblSellingTokenAmount);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new MatteBorder(5, 5, 0, 0, (Color) Color.LIGHT_GRAY));
		panel_2.setBackground(new Color(255, 228, 225));
		panel_2.setBounds(482, 185, 421, 205);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
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
				if (back) {
					new MyToken().setVisible(true);
				}else {
					new Market().setVisible(true);
				}
				
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
		
		for (String[] detail : details) {
            if (detail[0].equals("sell")) {
				lblSellingTokenAmount.setText("Selling Quantity");
				lblNumberOfToken.setText("Selling Price");
				textField_6.setEnabled(true);
				back = true;
				btnNewButton.setText("Sell");
            } 
            if (detail[0].equals("buy")) {
            	lblSellingTokenAmount.setText("Buying Quantity");
            	lblNumberOfToken.setText("Price");
            	textField_6.setEnabled(false);
            	back = false;
            	btnNewButton.setText("Buy");
            }
        }
	}
	

}
