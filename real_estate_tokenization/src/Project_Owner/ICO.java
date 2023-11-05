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
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

public class ICO extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

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

		        if(load == fileChooser.APPROVE_OPTION){
		            File selectedFile = fileChooser.getSelectedFile();
		            String path =selectedFile.getAbsolutePath();
		            ImageIcon imageIcon = new ImageIcon(path);
		            Image img =imageIcon.getImage().getScaledInstance(250,250,Image.SCALE_SMOOTH);
		            lblNewLabel_2.setIcon(new ImageIcon(img));
		        }
			}
		});
		lblNewLabel_2.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		lblNewLabel_2.setBounds(279, 10, 144, 132);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblName.setBounds(25, 155, 163, 36);
		panel_1.add(lblName);
		
		JLabel lblNumberOfToken = new JLabel("Price");
		lblNumberOfToken.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNumberOfToken.setBounds(26, 247, 162, 36);
		panel_1.add(lblNumberOfToken);
		
		JLabel lblNumberOfToken_1 = new JLabel("Number of Token");
		lblNumberOfToken_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNumberOfToken_1.setBounds(25, 201, 162, 36);
		panel_1.add(lblNumberOfToken_1);
		
		textField = new JTextField();
		textField.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		textField.setBounds(253, 167, 195, 24);
		panel_1.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		textField_1.setBounds(253, 213, 195, 24);
		panel_1.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		textField_2.setBounds(253, 259, 195, 24);
		panel_1.add(textField_2);
		
		JButton btnNewButton = new JButton("Publish");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton.setBounds(289, 321, 117, 36);
		panel_1.add(btnNewButton);
	}

}
