package Investor;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import Controller.InvestorController;

import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.sql.SQLException;
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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
	private Integer rsId;
	private Integer saleId;
	private Integer investorId;
	public String type;
	public String market;
	private JLabel image;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TokenDetails frame = new TokenDetails(null,null,null);
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
	public TokenDetails(String[]  details,String market,String type) {
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
		
		image = new JLabel("");
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
		
		JButton btnSubmit = new JButton("Sell");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String m =  null;
				double prices=0;
				Integer qty=0;
				Boolean run = true;
				InvestorController i = new InvestorController();
				
				try {
					qty = Integer.parseInt(quantity.getText());
					String priceText = price.getText();
				    prices = Double.parseDouble(priceText);
			    	
				}catch(Exception ex){
					System.out.println("h2");
					if(type.equals("sell")){
				    	m = "Please Enter a Quantity and Price!";
			    	}else if(type.equals("buy")){
			    		m = "Please Enter a Valid Quantity!";
			    	}
					run = false;
				}
				
				if(run) {
					try {
						if(market.equals("primary")) {
							m = i.buyToken(rsId,qty);
						}else if(market.equals("second")) {
							if(type.equals("buy")) {
								m = i.buySecond(saleId,qty);
							}else if(type.equals("sell")) {
								m = i.sellSecond(rsId,qty,prices);
							}
						}
					}catch(Exception ex) {
					}
				}
				
				if (m.equals("success")) {
					JOptionPane.showMessageDialog(null, type.equals("buy") ? "Purchase Successful!" : "Publish to Market Succesful!", "success", JOptionPane.INFORMATION_MESSAGE);
					setVisible(false);
					Market info = new Market();
					info.setVisible(true);
				}else if(m.equals("less")) {
					JOptionPane.showMessageDialog(null, "Please enter quantity less than it! ", "Error", JOptionPane.INFORMATION_MESSAGE);
				}else {
					JOptionPane.showMessageDialog(null, m, "Error", JOptionPane.INFORMATION_MESSAGE);
				}
				
			}
		});
		btnSubmit.setBackground(Color.WHITE);
		btnSubmit.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnSubmit.setBounds(652, 328, 117, 36);
		panel_1.add(btnSubmit);
		
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
				if (type.equals("buy")) {
					if(market.equals("primary")) {
						new Market().setVisible(true);
					}else {
						new SecondMarket().setVisible(true);
					}
					
				}else {
					new MyToken().setVisible(true);
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
		

		if (type.equals("sell")) {
			lblSellingTokenAmount.setText("Selling Quantity");
			lblNumberOfToken.setText("Selling Price");
			price.setEnabled(true);
			btnSubmit.setText("Sell");
        } 
        if (type.equals("buy")) {
        	lblSellingTokenAmount.setText("Buying Quantity");
        	lblNumberOfToken.setText("Price");
        	price.setEnabled(false);
        	btnSubmit.setText("Buy");
        }
        this.market = market;
        this.type = type;
		setDetails(details);
	}
	
	public void setDetails(String[]  details) {
		if (market.equals("primary")) {
			rsId = Integer.parseInt(details[0]);
		    name.setText(details[1]);
		    state.setText(details[2]);
		    city.setText(details[3]);
		    zip.setText(details[4]);
		    address.setText(details[5]);
		    totalToken.setText(details[6]);
		    quantity.setText("");
		    price.setText(details[7]);
		    ImageIcon imageIcon = new ImageIcon(details[9]);
	        Image img =imageIcon.getImage().getScaledInstance(250,250,Image.SCALE_SMOOTH);
	        image.setIcon(new ImageIcon(img));
		}else if(market.equals("second")) {
			if(type.equals("buy")){
				saleId = Integer.parseInt(details[0]);
				investorId = Integer.parseInt(details[1]);
			    name.setText(details[4]);
			    state.setText(details[5]);
			    city.setText(details[6]);
			    zip.setText(details[7]);
			    address.setText(details[8]);
			    totalToken.setText(details[2]);
			    quantity.setText("");
			    price.setText(details[3]);
			    ImageIcon imageIcon = new ImageIcon(details[9]);
		        Image img =imageIcon.getImage().getScaledInstance(250,250,Image.SCALE_SMOOTH);
		        image.setIcon(new ImageIcon(img));
			}else if(type.equals("sell")){
			    name.setText(details[3]);
			    state.setText(details[4]);
			    city.setText(details[5]);
			    zip.setText(details[6]);
			    address.setText(details[7]);
			    totalToken.setText(details[0]);
			    rsId = Integer.parseInt(details[8]);
			    quantity.setText("");
			    price.setText("");
			    ImageIcon imageIcon = new ImageIcon(details[9]);
		        Image img =imageIcon.getImage().getScaledInstance(250,250,Image.SCALE_SMOOTH);
		        image.setIcon(new ImageIcon(img));
			}
			
		}
		
	}

}
