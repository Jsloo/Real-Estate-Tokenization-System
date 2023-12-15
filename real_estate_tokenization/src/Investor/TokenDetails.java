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
	private JTextField state;
	private JTextField city;
	private JTextField quantity;
	private JTextField name;
	private JTextField totalToken;
	private JTextField zip;
	private JTextField price;
	private JTextPane  address;


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
	public TokenDetails(ArrayList<Object[]>  details) {
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
		
		JLabel image = new JLabel("");
		image.addMouseListener(new MouseAdapter() {
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
		            image.setIcon(new ImageIcon(img));
		        }
			}
		});
		image.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		image.setBounds(253, 10, 195, 154);
		panel_1.add(image);
		
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
		
		state = new JTextField();
		state.setEditable(false);
		state.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		state.setBounds(253, 185, 195, 24);
		panel_1.add(state);
		state.setColumns(10);
		
		city = new JTextField();
		city.setEditable(false);
		city.setColumns(10);
		city.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		city.setBounds(253, 222, 195, 24);
		panel_1.add(city);
		
		quantity = new JTextField();
		quantity.setBackground(new Color(255, 228, 225));
		quantity.setColumns(10);
		quantity.setBorder(new MatteBorder(0, 0, 4, 0, (Color) Color.BLACK));
		quantity.setBounds(688, 212, 195, 24);
		panel_1.add(quantity);
		
		JButton btnNewButton = new JButton("Sell");
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton.setBounds(652, 328, 117, 36);
		panel_1.add(btnNewButton);
		
		JLabel lblState = new JLabel("State");
		lblState.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblState.setBounds(25, 175, 132, 36);
		panel_1.add(lblState);
		
		name = new JTextField();
		name.setEditable(false);
		name.setColumns(10);
		name.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		name.setBounds(688, 63, 195, 24);
		panel_1.add(name);
		
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
		
		totalToken = new JTextField();
		totalToken.setEditable(false);
		totalToken.setColumns(10);
		totalToken.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		totalToken.setBounds(687, 114, 195, 24);
		panel_1.add(totalToken);
		
		zip = new JTextField();
		zip.setEditable(false);
		zip.setColumns(10);
		zip.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		zip.setBounds(253, 259, 195, 24);
		panel_1.add(zip);
		
		address = new JTextPane();
		address.setEditable(false);
		address.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		address.setBounds(253, 299, 195, 81);
		panel_1.add(address);
		
		JLabel lblRm = new JLabel("RM");
		lblRm.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblRm.setBounds(687, 262, 42, 36);
		panel_1.add(lblRm);
		
		price = new JTextField();
		price.setColumns(10);
		price.setBorder(new MatteBorder(0, 0, 4, 0, (Color) Color.BLACK));
		price.setBackground(new Color(255, 228, 225));
		price.setBounds(720, 262, 163, 24);
		panel_1.add(price);
		
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
		
		for (Object[] detail : details) {
            if (detail[0].equals("sell")) {
				lblSellingTokenAmount.setText("Selling Quantity");
				lblNumberOfToken.setText("Selling Price");
				price.setEnabled(true);
				back = true;
				btnNewButton.setText("Sell");
            } 
            if (detail[0].equals("buy")) {
            	lblSellingTokenAmount.setText("Buying Quantity");
            	lblNumberOfToken.setText("Price");
            	price.setEnabled(false);
            	back = false;
            	btnNewButton.setText("Buy");

            }
        }
		setDetails(details);
	}
	
	public void setDetails(ArrayList<Object[]>  details) {
		for (int i = 0; i < details.size(); i++) {
		    Object[] detail = details.get(i);

		    // Print only the second array
		    if (i == 0) {
		        
		        if (detail.length > 1) {
		            name.setText(String.valueOf(detail[1])); 
		            state.setText(String.valueOf(detail[2])); 
		            city.setText(String.valueOf(detail[3])); 
		            zip.setText(String.valueOf(detail[4])); 
		            address.setText(String.valueOf(detail[5])); 
		            totalToken.setText(String.valueOf(detail[6])); 
		            quantity.setText(""); 
		            price.setText(""); 
		            
		        }
		    }
		    
//		    if(i==1) {
//		    	System.out.println(detail[0]);
//		    	if ("sell".equals(detail[0])) {
//	                System.out.println("sell");
//	                quantity.setText(String.valueOf(detail[6])); 
//	                price.setText(String.valueOf(detail[7])); 
//	            } 
//	            if ("buy".equals(detail[0])) {
//	                System.out.println("buy");
//	                quantity.setText(String.valueOf(detail[6]));
//	                price.setText(""); 
//	            }
//		    }
		}
	}

}
