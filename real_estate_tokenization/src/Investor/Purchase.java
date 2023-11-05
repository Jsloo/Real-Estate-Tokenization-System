package Investor;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Rectangle;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.JButton;

public class Purchase extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Purchase frame = new Purchase();
					frame.setVisible(true);
					System.out.print("test");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Purchase() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 563);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(0, 0, 986, 537);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Real Estate Token Market");
		lblNewLabel.setBounds(34, 10, 480, 29);
		panel_1.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 36));
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.PINK);
		panel.setBounds(36, 110, 921, 399);
		panel_1.add(panel);
		panel.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(43, 61, 224, 276);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		lblNewLabel_2.setBounds(41, 10, 144, 132);
		panel_2.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Name");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3.setBounds(81, 152, 53, 19);
		panel_2.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("Price");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3_1.setBounds(81, 181, 53, 19);
		panel_2.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("Quantity");
		lblNewLabel_3_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3_1_1.setBounds(76, 210, 74, 19);
		panel_2.add(lblNewLabel_3_1_1);
		
		JButton btnNewButton = new JButton("Buy");
		btnNewButton.setBounds(65, 245, 85, 21);
		panel_2.add(btnNewButton);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setLayout(null);
		panel_2_1.setBackground(Color.WHITE);
		panel_2_1.setBounds(347, 61, 224, 276);
		panel.add(panel_2_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("");
		lblNewLabel_2_1.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		lblNewLabel_2_1.setBounds(41, 10, 144, 132);
		panel_2_1.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_3_2 = new JLabel("Name");
		lblNewLabel_3_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3_2.setBounds(81, 152, 53, 19);
		panel_2_1.add(lblNewLabel_3_2);
		
		JLabel lblNewLabel_3_1_2 = new JLabel("Price");
		lblNewLabel_3_1_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3_1_2.setBounds(81, 181, 53, 19);
		panel_2_1.add(lblNewLabel_3_1_2);
		
		JLabel lblNewLabel_3_1_1_2 = new JLabel("Quantity");
		lblNewLabel_3_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3_1_1_2.setBounds(76, 210, 74, 19);
		panel_2_1.add(lblNewLabel_3_1_1_2);
		
		JButton btnNewButton_1 = new JButton("Buy");
		btnNewButton_1.setBounds(65, 245, 85, 21);
		panel_2_1.add(btnNewButton_1);
		
		JPanel panel_2_2 = new JPanel();
		panel_2_2.setLayout(null);
		panel_2_2.setBackground(Color.WHITE);
		panel_2_2.setBounds(648, 61, 224, 276);
		panel.add(panel_2_2);
		
		JLabel lblNewLabel_2_2 = new JLabel("");
		lblNewLabel_2_2.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		lblNewLabel_2_2.setBounds(41, 10, 144, 132);
		panel_2_2.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_3_3 = new JLabel("Name");
		lblNewLabel_3_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3_3.setBounds(81, 152, 53, 19);
		panel_2_2.add(lblNewLabel_3_3);
		
		JLabel lblNewLabel_3_1_3 = new JLabel("Price");
		lblNewLabel_3_1_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3_1_3.setBounds(81, 181, 53, 19);
		panel_2_2.add(lblNewLabel_3_1_3);
		
		JLabel lblNewLabel_3_1_1_3 = new JLabel("Quantity");
		lblNewLabel_3_1_1_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3_1_1_3.setBounds(76, 210, 74, 19);
		panel_2_2.add(lblNewLabel_3_1_1_3);
		
		JButton btnNewButton_2 = new JButton("Buy");
		btnNewButton_2.setBounds(65, 245, 85, 21);
		panel_2_2.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Next");
		btnNewButton_3.setBounds(823, 11, 85, 21);
		panel.add(btnNewButton_3);
		
		JButton btnNewButton_3_1 = new JButton("Previous");
		btnNewButton_3_1.setBounds(696, 11, 85, 21);
		panel.add(btnNewButton_3_1);
		
		JLabel lblNewLabel_4 = new JLabel("1");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_4.setBounds(791, 13, 21, 13);
		panel.add(lblNewLabel_4);
		
		textField = new JTextField();
		textField.setBounds(119, 71, 161, 19);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Search:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(42, 69, 67, 18);
		panel_1.add(lblNewLabel_1);
	}
}
