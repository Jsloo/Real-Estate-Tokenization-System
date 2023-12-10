package Investor;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Window;

import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;

import Both.Register;
import Controller.InvestorController;
import Project_Owner.Login_Owner;

import javax.swing.JPasswordField;
import javax.swing.border.LineBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;


public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtUserName;
	private JPasswordField txtPassword;
	private JLabel errorUserName;
	private JLabel errorPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public Login() {
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
		lblTolTokenize.setBounds(122, 260, 255, 64);
		panel_1.add(lblTolTokenize);
		
		JLabel lblNewLabel = new JLabel("Welcome");
		lblNewLabel.setIcon(null);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblNewLabel.setBounds(656, 170, 195, 64);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\User\\git\\real_estate_tokenization\\real_estate_tokenization\\image\\login_investor.png"));
		lblNewLabel_1.setBounds(691, 61, 118, 111);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("User Name");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2.setBounds(616, 260, 102, 22);
		panel.add(lblNewLabel_2);
		
		txtUserName = new JTextField();
		txtUserName.setBorder(new MatteBorder(0, 0, 4, 0, (Color) Color.PINK));
		txtUserName.setBounds(616, 292, 263, 34);
		panel.add(txtUserName);
		txtUserName.setColumns(10);
		
		JLabel lblNewLabel_2_1 = new JLabel("Password");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2_1.setBounds(616, 347, 102, 22);
		panel.add(lblNewLabel_2_1);
		
		txtPassword = new JPasswordField();
		txtPassword.setBorder(new MatteBorder(0, 0, 4, 0, (Color) Color.PINK));
		txtPassword.setBounds(616, 370, 263, 34);
		panel.add(txtPassword);
		
		JPanel btnLogin = new JPanel();
		btnLogin.addMouseListener(new MouseAdapter() {
			@Override
		    public void mouseEntered(MouseEvent e) {
		        // Set the font to bold
				btnLogin.setBackground(new java.awt.Color(204,204,204));
		    }
		    
		    @Override
		    public void mouseExited(MouseEvent e) {
		    	btnLogin.setBackground(new java.awt.Color(255,255,255));
		    }
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					InvestorController con = new InvestorController();
					validateFields();
					String msg = con.login(txtUserName.getText(), txtPassword.getText());
					if(msg.equals("Success")) {
						JOptionPane.showMessageDialog(null, "Login Successful! ", "success", JOptionPane.INFORMATION_MESSAGE);
						setVisible(false);
						Market info = new Market();
						info.setVisible(true);
					}else if(msg.equals("Error")) {
						JOptionPane.showMessageDialog(null, "Invalid User Name or Password! ", "error", JOptionPane.INFORMATION_MESSAGE);
					}else {
						JOptionPane.showMessageDialog(null, msg, "error", JOptionPane.INFORMATION_MESSAGE);
					}	
				}catch(Exception ex) {
					
				}
				
			}
		});
		btnLogin.setBackground(Color.WHITE);
		btnLogin.setBorder(new LineBorder(Color.PINK, 2, true));
		btnLogin.setBounds(714, 456, 93, 34);
		panel.add(btnLogin);
		
		JLabel lblNewLabel_3 = new JLabel("Login");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnLogin.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Login in as Project Owner");
		lblNewLabel_4.addMouseListener(new MouseAdapter() {
			@Override
		    public void mouseEntered(MouseEvent e) {
		        // Set the font to bold
		        Font originalFont = lblNewLabel_4.getFont();
		        Font boldFont = originalFont.deriveFont(Font.BOLD);
		        lblNewLabel_4.setFont(boldFont);
		    }
		    
		    @Override
		    public void mouseExited(MouseEvent e) {
		        // Restore the original font when the mouse exits the label
		        Font originalFont = lblNewLabel_4.getFont();
		        Font plainFont = originalFont.deriveFont(Font.PLAIN);
		        lblNewLabel_4.setFont(plainFont);
		    }
			@Override
			public void mousePressed(MouseEvent e) {
				setVisible(false);
				Login_Owner info = new Login_Owner();
				info.setVisible(true);
			}
		});
		lblNewLabel_4.setForeground(Color.BLUE);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(616, 414, 191, 13);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_6 = new JLabel("Don't have an account?");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblNewLabel_6.setBounds(489, 502, 154, 13);
		panel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Sign Up");
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
				Register info = new Register();
				info.setVisible(true);
			}
		});
		lblNewLabel_7.setForeground(Color.BLUE);
		lblNewLabel_7.setFont(new Font("Tahoma", Font.ITALIC, 13));
		lblNewLabel_7.setBounds(631, 502, 55, 13);
		panel.add(lblNewLabel_7);
		
		errorUserName = new JLabel("* User Name is Required.");
		errorUserName.setForeground(new Color(255, 0, 0));
		errorUserName.setBounds(756, 267, 148, 14);
		errorUserName.setVisible(false);
		panel.add(errorUserName);
		
		errorPassword = new JLabel("* Password is Required.");
		errorPassword.setForeground(Color.RED);
		errorPassword.setBounds(756, 354, 148, 14);
		errorPassword.setVisible(false);
		panel.add(errorPassword);
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

        if(hasError){
            throw new Exception("");
        }
    }
}
