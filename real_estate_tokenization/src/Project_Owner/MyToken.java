package Project_Owner;

import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import Controller.InvestorController;
import Controller.OwnerController;
import Investor.Market;
import Project_Owner.TokenDetails;

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
	private JPanel panel_1;
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
		
		JLabel lblRealEstateToken = new JLabel("My Published Token");
		lblRealEstateToken.setFont(new Font("Tahoma", Font.BOLD, 36));
		lblRealEstateToken.setBounds(40, 27, 380, 38);
		panel.add(lblRealEstateToken);
		
		panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 0, true));
		panel_1.setBackground(Color.PINK);
		panel_1.setBounds(40, 96, 903, 390);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
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
				new ICO().setVisible(true);
			}
		});
		panel_2_3_2.setBorder(new LineBorder(Color.PINK, 2, true));
		panel_2_3_2.setBackground(Color.WHITE);
		panel_2_3_2.setBounds(802, 59, 143, 34);
		panel.add(panel_2_3_2);
		panel_2_3_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel_3_4_2 = new JLabel("Publish Token");
		lblNewLabel_3_4_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_2_3_2.add(lblNewLabel_3_4_2);
		
		showMenu();
		
	}



public void showMenu(){

	int xPosition = 30; 
    int yPosition = 70; 
    int maxItemsPerRow = 2;
    int itemCounter = 0;

    Font nameFont = new Font("Tahoma", Font.BOLD, 26);
    Font priceFont = new Font("SansSerif", Font.BOLD, 22);
        
    try {
    	OwnerController o = new OwnerController();
    	ArrayList<String[]> TokenList = new ArrayList<>();
    	TokenList = o.showToken();
    	System.out.println(TokenList);


        for (String[] TokenData : TokenList) {
        	System.out.println('1');
            JPanel TokenPanel = new JPanel();
            TokenPanel.setBackground(new java.awt.Color(255,255,255));
            TokenPanel.setLayout(null);

            JLabel nameLabel = new JLabel(TokenData[0]);
            nameLabel.setBounds(80, 25, 230, 30);
            nameLabel.setFont(nameFont);
            nameLabel.setForeground(Color.BLACK);
            TokenPanel.add(nameLabel);

            
            JLabel priceLabel = new JLabel(TokenData[1]);
            priceLabel.setBounds(358, 25, 230, 30);
            priceLabel.setForeground(Color.BLACK);
            priceLabel.setFont(priceFont);
            TokenPanel.add(priceLabel);

            
            TokenPanel.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
//                    TokenDetails  = new TokenDetails();
//                    item.setVisible(true);
                }
                
//                @Override
//                public void mouseEntered(MouseEvent e) {
//                	TokenPanel.setBackground(new java.awt.Color(0,153,153));
//                    imageLabel.setBounds(10, 10, 230, 230);
//                }
//                
//                @Override
//                public void mouseExited(MouseEvent e) {
//                    greenPanel.setBackground(new java.awt.Color(0,102,102));
//                    imageLabel.setBounds(5, 5, 240, 240);
//                }
            });

            
            TokenPanel.setBounds(xPosition, yPosition, 860, 80);

            
            panel_1.add(TokenPanel);

            
            itemCounter++;
            if (itemCounter >= maxItemsPerRow) {
            	System.out.println('2');
                itemCounter = 0;
                xPosition = 30;
                yPosition += 50;
            } 
            
            
        }
    }catch(Exception e) {
            e.printStackTrace();
        }
}
}

//public void showData() {
//	OwnerController o = new OwnerController();
//	ArrayList<String[]> TokenList = new ArrayList<>();
//	TokenList = o.showToken();
//}