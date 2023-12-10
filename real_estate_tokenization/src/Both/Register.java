package Both;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;

import Controller.InvestorController;
import Investor.Login;
import Investor.Market;
import Project_Owner.Login_Owner;

import javax.swing.JPasswordField;
import javax.swing.border.LineBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Register extends JFrame {

	private JPanel contentPane;
	private JTextField txtUserName;
	private JPasswordField txtPassword;
	private boolean role = false;
	private JLabel errorUserName;
	private JLabel errorPassword;
	private JLabel errorRole;
	private ButtonGroup buttonGroup;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register frame = new Register();
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
	public Register() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 563);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 986, 537);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.PINK);
		panel_1.setBounds(0, 0, 486, 527);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon("C:\\Users\\User\\git\\real_estate_tokenization\\real_estate_tokenization\\image\\logo.png"));
		lblNewLabel_5.setBounds(162, 103, 148, 135);
		panel_1.add(lblNewLabel_5);
		
		JLabel lblRealEstateTokenization = new JLabel("Real Estate Tokenization System");
		lblRealEstateTokenization.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblRealEstateTokenization.setBounds(53, 323, 400, 64);
		panel_1.add(lblRealEstateTokenization);
		
		JLabel lblTolTokenize = new JLabel("BB Tokenize");
		lblTolTokenize.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblTolTokenize.setBounds(121, 261, 261, 64);
		panel_1.add(lblTolTokenize);
		
		JLabel lblNewLabel = new JLabel("Register");
		lblNewLabel.setIcon(null);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblNewLabel.setBounds(652, 142, 195, 56);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\User\\git\\real_estate_tokenization\\real_estate_tokenization\\image\\login_investor.png"));
		lblNewLabel_1.setBounds(695, 21, 118, 111);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("User Name");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2.setBounds(616, 208, 102, 22);
		panel.add(lblNewLabel_2);
		
		txtUserName = new JTextField();
		txtUserName.setBorder(new MatteBorder(0, 0, 4, 0, (Color) Color.PINK));
		txtUserName.setBounds(616, 240, 263, 34);
		panel.add(txtUserName);
		txtUserName.setColumns(10);
		
		JLabel lblNewLabel_2_1 = new JLabel("Password");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2_1.setBounds(616, 284, 102, 22);
		panel.add(lblNewLabel_2_1);
		
		txtPassword = new JPasswordField();
		txtPassword.setBorder(new MatteBorder(0, 0, 4, 0, (Color) Color.PINK));
		txtPassword.setBounds(616, 316, 263, 34);
		panel.add(txtPassword);
		
		JPanel panel_2 = new JPanel();
		panel_2.addMouseListener(new MouseAdapter() {
			@Override
		    public void mouseEntered(MouseEvent e) {
		        // Set the font to bold
				panel_2.setBackground(new java.awt.Color(204,204,204));
		    }
		    
		    @Override
		    public void mouseExited(MouseEvent e) {
		    	panel_2.setBackground(new java.awt.Color(255,255,255));
		    }
			@Override
			public void mouseClicked(MouseEvent e) {
				try{
					validateFields();
					InvestorController con = new InvestorController();
					String msg = con.register(role, txtUserName.getText(), txtPassword.getText());
					if(msg.equals("exists")) {
						JOptionPane.showMessageDialog(null, "Username already exists! ", "Error", JOptionPane.INFORMATION_MESSAGE);
					}else if(msg.equals("success")) {
						JOptionPane.showMessageDialog(null, "Register Succesful! " , "Success", JOptionPane.INFORMATION_MESSAGE);
						if (role) {
							setVisible(false);
							Login info = new Login();
							info.setVisible(true);
						}else {
							setVisible(false);
							Login_Owner info = new Login_Owner();
							info.setVisible(true);
						}	
					}else {
						JOptionPane.showMessageDialog(null, msg , "Success", JOptionPane.INFORMATION_MESSAGE);
					}
		        }catch(Exception ex){
		        	
		        } 
			}
		});
		panel_2.setBackground(Color.WHITE);
		panel_2.setBorder(new LineBorder(Color.PINK, 2, true));
		panel_2.setBounds(714, 456, 93, 34);
		panel.add(panel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Sign Up");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_2.add(lblNewLabel_3);
		
		JLabel lblNewLabel_6 = new JLabel("Already have an account?");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblNewLabel_6.setBounds(489, 502, 164, 13);
		panel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Login");
		lblNewLabel_7.addMouseListener(new MouseAdapter() {
			@Override
		    public void mouseEntered(MouseEvent e) {
		        // Set the font to bold
		        Font originalFont = lblNewLabel_7.getFont();
		        Font boldFont = originalFont.deriveFont(Font.BOLD);
		        lblNewLabel_7.setFont(boldFont);
		    }
		    
		    @Override
		    public void mouseExited(MouseEvent e) {
		        // Restore the original font when the mouse exits the label
		        Font originalFont = lblNewLabel_7.getFont();
		        Font plainFont = originalFont.deriveFont(Font.PLAIN);
		        lblNewLabel_7.setFont(plainFont);
		    }
			@Override
			public void mousePressed(MouseEvent e) {
				setVisible(false);
				Login info = new Login();
				info.setVisible(true);
			}
		});
		lblNewLabel_7.setForeground(Color.BLUE);
		lblNewLabel_7.setFont(new Font("Tahoma", Font.ITALIC, 13));
		lblNewLabel_7.setBounds(652, 502, 55, 13);
		panel.add(lblNewLabel_7);
		
		// Create a ButtonGroup to group the radio buttons
		buttonGroup = new ButtonGroup();

		// First radio button (Investor)
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Investor");
		rdbtnNewRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				role = true;
			}
		});
		rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		rdbtnNewRadioButton.setBackground(Color.WHITE);
		rdbtnNewRadioButton.setBounds(614, 388, 93, 21);
		panel.add(rdbtnNewRadioButton);

		// Second radio button (Project Owner)
		JRadioButton rdbtnProjectOwner = new JRadioButton("Project Owner");
		rdbtnProjectOwner.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				role = false;
			}
		});
		rdbtnProjectOwner.setFont(new Font("Tahoma", Font.BOLD, 14));
		rdbtnProjectOwner.setBackground(Color.WHITE);
		rdbtnProjectOwner.setBounds(748, 388, 131, 21);
		panel.add(rdbtnProjectOwner);

		// Add radio buttons to the ButtonGroup
		buttonGroup.add(rdbtnNewRadioButton);
		buttonGroup.add(rdbtnProjectOwner);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Role");
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2_1_1.setBounds(616, 360, 61, 22);
		panel.add(lblNewLabel_2_1_1);
		
		errorUserName = new JLabel("* User Name is Required.");
		errorUserName.setForeground(new Color(255, 0, 0));
		errorUserName.setBounds(766, 215, 148, 14);
		errorUserName.setVisible(false);
		panel.add(errorUserName);
		
		errorPassword = new JLabel("* Password is Required.");
		errorPassword.setForeground(Color.RED);
		errorPassword.setBounds(766, 291, 148, 14);
		errorPassword.setVisible(false);
		panel.add(errorPassword);
		
		errorRole = new JLabel("* Role is Required.");
		errorRole.setForeground(Color.RED);
		errorRole.setBounds(790, 367, 148, 14);
		errorRole.setVisible(false);
		panel.add(errorRole);
		
	}
	public void validateFields() throws Exception {
        boolean hasError = false;
        String username = txtUserName.getText();
        String password = txtPassword.getText();

		//name
        if (username.isEmpty()) {
            errorUserName.setVisible(true);  
            hasError = true;
        }else{
            errorUserName.setVisible(false); 
        }
        

		//pass n
        if (password.isEmpty()) {
            errorPassword.setVisible(true);
            hasError = true;
        }else{
            errorPassword.setVisible(false); 
        }
        
        //role
        if (buttonGroup.getSelection() == null) {
            errorRole.setVisible(true);
            hasError = true;
        } else {
            errorRole.setVisible(false);
        }

        if(hasError){
            throw new Exception("");
        }
    }
	
}
