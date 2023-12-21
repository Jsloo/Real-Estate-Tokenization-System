package Project_Owner;

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

import Investor.Market;

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
import javax.swing.JToggleButton;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TokenDetails extends JFrame {

	private JPanel contentPane;
	private JTextField token;

	/**
	 * Launch the application.
	 */
	public boolean back = false;
	private JTextField name;
	private JTextField state;
	private JTextField city;
	private JTextField zip;
	private JTextField price;
	private JTextPane  address;
	private JLabel image;
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
	public TokenDetails(String[]  details) {
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
		lblNumberOfToken.setBounds(515, 100, 162, 36);
		panel_1.add(lblNumberOfToken);
		
		JLabel lblNumberOfToken_1 = new JLabel("Remaining Token");
		lblNumberOfToken_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNumberOfToken_1.setBounds(516, 152, 162, 36);
		panel_1.add(lblNumberOfToken_1);
		
		JButton Back = new JButton("Back");
		Back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new MyToken().setVisible(true);
			}
		});
		Back.setBackground(Color.WHITE);
		Back.setFont(new Font("Tahoma", Font.BOLD, 18));
		Back.setBounds(755, 308, 117, 36);
		panel_1.add(Back);
		
		JLabel lblState = new JLabel("State");
		lblState.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblState.setBounds(25, 175, 132, 36);
		panel_1.add(lblState);
		
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
		
		token = new JTextField();
		token.setEditable(false);
		token.setColumns(10);
		token.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		token.setBounds(688, 161, 195, 24);
		panel_1.add(token);
		
		address = new JTextPane();
		address.setEditable(false);
		address.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		address.setBounds(253, 299, 195, 81);
		panel_1.add(address);
		
		JLabel lblRm = new JLabel("RM");
		lblRm.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblRm.setBounds(687, 100, 42, 36);
		panel_1.add(lblRm);
		
		name = new JTextField();
		name.setEditable(false);
		name.setColumns(10);
		name.setBorder(new MatteBorder(0, 0, 4, 0, (Color) Color.BLACK));
		name.setBackground(Color.PINK);
		name.setBounds(688, 53, 195, 24);
		panel_1.add(name);
		
		state = new JTextField();
		state.setEditable(false);
		state.setColumns(10);
		state.setBorder(new MatteBorder(0, 0, 4, 0, (Color) Color.BLACK));
		state.setBackground(Color.PINK);
		state.setBounds(253, 175, 195, 24);
		panel_1.add(state);
		
		city = new JTextField();
		city.setEditable(false);
		city.setColumns(10);
		city.setBorder(new MatteBorder(0, 0, 4, 0, (Color) Color.BLACK));
		city.setBackground(Color.PINK);
		city.setBounds(253, 212, 195, 24);
		panel_1.add(city);
		
		zip = new JTextField();
		zip.setEditable(false);
		zip.setColumns(10);
		zip.setBorder(new MatteBorder(0, 0, 4, 0, (Color) Color.BLACK));
		zip.setBackground(Color.PINK);
		zip.setBounds(253, 249, 195, 24);
		panel_1.add(zip);
		
		price = new JTextField();
		price.setEditable(false);
		price.setColumns(10);
		price.setBorder(new MatteBorder(0, 0, 4, 0, (Color) Color.BLACK));
		price.setBackground(Color.PINK);
		price.setBounds(720, 100, 163, 24);
		panel_1.add(price);
		
		setDetails(details);
	}
		
	public void setDetails(String[]  details) {
	    name.setText(details[1]);
	    state.setText(details[2]);
	    city.setText(details[3]);
	    zip.setText(details[4]);
	    address.setText(details[5]);
	    token.setText(details[6]);
	    price.setText(details[7]);
		ImageIcon imageIcon = new ImageIcon(details[8]);
        Image img =imageIcon.getImage().getScaledInstance(250,250,Image.SCALE_SMOOTH);
        image.setIcon(new ImageIcon(img));
	}

}
