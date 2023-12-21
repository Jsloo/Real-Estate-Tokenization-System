package Project_Owner;

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
import Controller.OwnerController;
import Investor.Market;

import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import javax.swing.JSlider;
import javax.swing.JTree;
import javax.swing.JScrollBar;
import javax.swing.JSeparator;
import javax.swing.JTextPane;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ICO extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private JTextField amount;
	private JTextField price;
	private JTextField state;
	private JTextField city;
	private JTextField zip;
	private JTextPane address;
	private String path =null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ICO frame = new ICO();
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
	public ICO() {
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
		
		JLabel lblRealEstateToken = new JLabel("Real Estate Token ICO");
		lblRealEstateToken.setFont(new Font("Tahoma", Font.BOLD, 36));
		lblRealEstateToken.setBounds(10, 10, 421, 29);
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
		            String path1 =selectedFile.getAbsolutePath();
		            ImageIcon imageIcon = new ImageIcon(path1);
		            Image img =imageIcon.getImage().getScaledInstance(250,250,Image.SCALE_SMOOTH);
		            lblNewLabel_2.setIcon(new ImageIcon(img));
		            path = path1;
		        }
			}
		});
		lblNewLabel_2.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		lblNewLabel_2.setBounds(253, 10, 195, 154);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblName.setBounds(25, 195, 163, 36);
		panel_1.add(lblName);
		
		JLabel lblNumberOfToken = new JLabel("Price");
		lblNumberOfToken.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNumberOfToken.setBounds(30, 295, 162, 36);
		panel_1.add(lblNumberOfToken);
		
		JLabel lblNumberOfToken_1 = new JLabel("Number of Token");
		lblNumberOfToken_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNumberOfToken_1.setBounds(25, 241, 162, 36);
		panel_1.add(lblNumberOfToken_1);
		
		name = new JTextField();
		name.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		name.setBounds(253, 205, 195, 24);
		panel_1.add(name);
		name.setColumns(10);
		
		amount = new JTextField();
		amount.setColumns(10);
		amount.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		amount.setBounds(253, 251, 195, 24);
		panel_1.add(amount);
		
		price = new JTextField();
		price.setColumns(10);
		price.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		price.setBounds(253, 305, 195, 24);
		panel_1.add(price);
		
		JButton btnNewButton = new JButton("Publish");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					validateFields();
					String m=null;
					OwnerController i = new OwnerController();
					m = i.publishToken(path,name.getText(), state.getText(), city.getText(), Integer.parseInt(zip.getText()),
							address.getText(), Integer.parseInt(amount.getText()), Double.parseDouble(price.getText()));
					
					
					if (m.equals("success")) {
						JOptionPane.showMessageDialog(null, "Publish to Market Succesful!", "success", JOptionPane.INFORMATION_MESSAGE);
						setVisible(false);
						MyToken info = new MyToken();
						info.setVisible(true);
					}else if(m.equals("exists")) {
						JOptionPane.showMessageDialog(null, "The Token Name is Exists! ", "Error", JOptionPane.INFORMATION_MESSAGE);
					}else {
						JOptionPane.showMessageDialog(null, m, "Error", JOptionPane.INFORMATION_MESSAGE);
					}
				}catch(Exception ex) {
					
				}
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton.setBounds(425, 344, 117, 36);
		panel_1.add(btnNewButton);
		
		JLabel lblState = new JLabel("State");
		lblState.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblState.setBounds(524, 10, 132, 36);
		panel_1.add(lblState);
		
		state = new JTextField();
		state.setColumns(10);
		state.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		state.setBounds(687, 20, 195, 24);
		panel_1.add(state);
		
		JLabel lblName_1_1 = new JLabel("City");
		lblName_1_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblName_1_1.setBounds(524, 67, 132, 36);
		panel_1.add(lblName_1_1);
		
		JLabel lblName_1_1_1 = new JLabel("Zip Code");
		lblName_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblName_1_1_1.setBounds(524, 128, 132, 36);
		panel_1.add(lblName_1_1_1);
		
		JLabel lblName_1_1_1_1 = new JLabel("Address");
		lblName_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblName_1_1_1_1.setBounds(524, 201, 132, 36);
		panel_1.add(lblName_1_1_1_1);
		
		city = new JTextField();
		city.setColumns(10);
		city.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		city.setBounds(687, 77, 195, 24);
		panel_1.add(city);
		
		zip = new JTextField();
		zip.setColumns(10);
		zip.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		zip.setBounds(687, 140, 195, 24);
		panel_1.add(zip);
		
		address = new JTextPane();
		address.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		address.setBounds(687, 213, 195, 116);
		panel_1.add(address);
		
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
				new MyToken().setVisible(true);
			}
		});
		panel_2_3_2.setBorder(new LineBorder(Color.PINK, 2, true));
		panel_2_3_2.setBackground(Color.WHITE);
		panel_2_3_2.setBounds(800, 55, 143, 34);
		panel.add(panel_2_3_2);
		panel_2_3_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel_3_4_2 = new JLabel("Back");
		lblNewLabel_3_4_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_2_3_2.add(lblNewLabel_3_4_2);
	}
	
	public void validateFields() throws Exception {
        boolean hasError = false;
        String name1 = name.getText();
        String state1 = state.getText();
        String city1 = city.getText();
        String zip1 = zip.getText();
        String address1 = address.getText();
        String amount1 = amount.getText();
        String price1 = price.getText();
		//name
        if (name1.isEmpty()) {
        	JOptionPane.showMessageDialog(null, "Token Name is Required!", "Error", JOptionPane.INFORMATION_MESSAGE);
        	hasError = true;   
        }else if (state1.isEmpty()) {
            hasError = true;
        	JOptionPane.showMessageDialog(null, "State is Required!", "Error", JOptionPane.INFORMATION_MESSAGE);
        }else if (city1.isEmpty()) {
            hasError = true;
        	JOptionPane.showMessageDialog(null, "City is Required!", "Error", JOptionPane.INFORMATION_MESSAGE);
        }else if (zip1.isEmpty()) {
            hasError = true;
        	JOptionPane.showMessageDialog(null, "Zip is Required!", "Error", JOptionPane.INFORMATION_MESSAGE);
        }else if (!isInteger(zip1)) {
            hasError = true;
            JOptionPane.showMessageDialog(null, "Zip must be a number!", "Error", JOptionPane.INFORMATION_MESSAGE);
        }else if (address1.isEmpty()) {
            hasError = true;
        	JOptionPane.showMessageDialog(null, "Address is Required!", "Error", JOptionPane.INFORMATION_MESSAGE);
        }else if (amount1.isEmpty()) {
            hasError = true;
        	JOptionPane.showMessageDialog(null, "Number of Token is Required!", "Error", JOptionPane.INFORMATION_MESSAGE);
        }else if (!isInteger(amount1)) {
            hasError = true;
            JOptionPane.showMessageDialog(null, "Amount must be a number!", "Error", JOptionPane.INFORMATION_MESSAGE);
        }else if (price1.isEmpty()) {
            hasError = true;
        	JOptionPane.showMessageDialog(null, "Price is Required!", "Error", JOptionPane.INFORMATION_MESSAGE);
        }else if (!isDouble(price1)) {
            hasError = true;
            JOptionPane.showMessageDialog(null, "Price must be a number!", "Error", JOptionPane.INFORMATION_MESSAGE);
        }else if (path==null) {
            hasError = true;
            JOptionPane.showMessageDialog(null, "Image is Required!", "Error", JOptionPane.INFORMATION_MESSAGE);
        }
        

        if(hasError){
            throw new Exception("");
        }
    }
	
	private boolean isInteger(String value) {
	    try {
	        Integer.parseInt(value);
	        return true;
	    } catch (NumberFormatException e) {
	        return false;
	    }
	}

	private boolean isDouble(String value) {
	    try {
	        Double.parseDouble(value);
	        return true;
	    } catch (NumberFormatException e) {
	        return false;
	    }
	}
}
