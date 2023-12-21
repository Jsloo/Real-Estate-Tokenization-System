package Investor;

import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
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
import java.util.ArrayList;
import java.util.List;

import javax.swing.JSlider;
import javax.swing.JTree;
import javax.swing.JScrollBar;
import javax.swing.JSeparator;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MyToken extends JFrame {

	private JPanel contentPane;
	private JTextField currentPage;
	private JLabel name1;
	private JLabel name2;
	private JLabel name3;
	private JLabel name4;
	private JLabel quantity1;
	private JLabel quantity2;
	private JLabel quantity3;
	private JLabel quantity4;
	private List<String[]> tokenList;
    private int currentIndex;
    private JButton btnDetails1;
    private JButton btnDetails2;
    private JButton btnDetails3;
    private JButton btnDetails4;
    private JPanel mtPanel1;
    private JPanel mtPanel2;
    private JPanel mtPanel3;
    private JPanel mtPanel4;
    public static String[] tokenData;
    public static String[] details1;
    public static String[] details2;
    public static String[] details3;
    public static String[] details4;
    public Integer currentPageIndex=  1;
    public Integer remaining;
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
		
		JLabel lblRealEstateToken = new JLabel("My Token");
		lblRealEstateToken.setFont(new Font("Tahoma", Font.BOLD, 36));
		lblRealEstateToken.setBounds(40, 27, 192, 38);
		panel.add(lblRealEstateToken);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 0, true));
		panel_1.setBackground(Color.PINK);
		panel_1.setBounds(40, 96, 903, 390);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		mtPanel1 = new JPanel();
		mtPanel1.setLayout(null);
		mtPanel1.setBackground(Color.WHITE);
		mtPanel1.setBounds(42, 70, 780, 58);
		panel_1.add(mtPanel1);
		
		name1 = new JLabel("Name");
		name1.setFont(new Font("Tahoma", Font.BOLD, 15));
		name1.setBounds(74, 21, 242, 19);
		mtPanel1.add(name1);
		
		quantity1 = new JLabel("Quantity");
		quantity1.setFont(new Font("Tahoma", Font.BOLD, 15));
		quantity1.setBounds(343, 21, 74, 19);
		mtPanel1.add(quantity1);
		
		JLabel lblNewLabel_3_1 = new JLabel("No");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3_1.setBounds(11, 21, 53, 19);
		mtPanel1.add(lblNewLabel_3_1);
		
		JPanel btnDetails1 = new JPanel();
		btnDetails1.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
		        // Set the font to bold
				btnDetails1.setBackground(new java.awt.Color(204,204,204));
		    }
		    
		    @Override
		    public void mouseExited(MouseEvent e) {
		    	btnDetails1.setBackground(new java.awt.Color(255,255,255));
		    }
			@Override
			public void mouseClicked(MouseEvent e) {	
				setVisible(false);
				new TokenDetails(details1,"second","sell").setVisible(true);
			}
		});
		btnDetails1.setBorder(new LineBorder(Color.PINK, 2, true));
		btnDetails1.setBackground(Color.WHITE);
		btnDetails1.setBounds(674, 10, 96, 34);
		mtPanel1.add(btnDetails1);
		btnDetails1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel_3_4 = new JLabel("Details");
		
		lblNewLabel_3_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnDetails1.add(lblNewLabel_3_4);
		
		mtPanel2 = new JPanel();
		mtPanel2.setLayout(null);
		mtPanel2.setBackground(Color.WHITE);
		mtPanel2.setBounds(42, 148, 780, 58);
		panel_1.add(mtPanel2);
		
		name2 = new JLabel("Name");
		name2.setFont(new Font("Tahoma", Font.BOLD, 15));
		name2.setBounds(74, 21, 242, 19);
		mtPanel2.add(name2);
		
		quantity2 = new JLabel("Quantity");
		quantity2.setFont(new Font("Tahoma", Font.BOLD, 15));
		quantity2.setBounds(343, 21, 74, 19);
		mtPanel2.add(quantity2);
		
		JLabel lblNewLabel_3_1_2 = new JLabel("No");
		lblNewLabel_3_1_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3_1_2.setBounds(11, 21, 53, 19);
		mtPanel2.add(lblNewLabel_3_1_2);
		
		JPanel btnDetails2 = new JPanel();
		btnDetails2.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
		        // Set the font to bold
				btnDetails2.setBackground(new java.awt.Color(204,204,204));
		    }
		    
		    @Override
		    public void mouseExited(MouseEvent e) {
		    	btnDetails2.setBackground(new java.awt.Color(255,255,255));
		    }
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				new TokenDetails(details2,"second","sell").setVisible(true);
			}
		});
		btnDetails2.setBorder(new LineBorder(Color.PINK, 2, true));
		btnDetails2.setBackground(Color.WHITE);
		btnDetails2.setBounds(674, 10, 96, 34);
		mtPanel2.add(btnDetails2);
		btnDetails2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel_3_4_1 = new JLabel("Details");
		lblNewLabel_3_4_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnDetails2.add(lblNewLabel_3_4_1);
		
		mtPanel3 = new JPanel();
		mtPanel3.setLayout(null);
		mtPanel3.setBackground(Color.WHITE);
		mtPanel3.setBounds(42, 228, 780, 58);
		panel_1.add(mtPanel3);
		
		name3 = new JLabel("Name");
		name3.setFont(new Font("Tahoma", Font.BOLD, 15));
		name3.setBounds(74, 21, 242, 19);
		mtPanel3.add(name3);
		
		quantity3 = new JLabel("Quantity");
		quantity3.setFont(new Font("Tahoma", Font.BOLD, 15));
		quantity3.setBounds(343, 21, 74, 19);
		mtPanel3.add(quantity3);
		
		JLabel lblNewLabel_3_1_2_1 = new JLabel("No");
		lblNewLabel_3_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3_1_2_1.setBounds(11, 21, 53, 19);
		mtPanel3.add(lblNewLabel_3_1_2_1);
		
		JPanel btnDetails3 = new JPanel();
		btnDetails3.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
		        // Set the font to bold
				btnDetails3.setBackground(new java.awt.Color(204,204,204));
		    }
		    
		    @Override
		    public void mouseExited(MouseEvent e) {
		    	btnDetails3.setBackground(new java.awt.Color(255,255,255));
		    }
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				new TokenDetails(details3,"second","sell").setVisible(true);
			}
		});
		btnDetails3.setBorder(new LineBorder(Color.PINK, 2, true));
		btnDetails3.setBackground(Color.WHITE);
		btnDetails3.setBounds(674, 10, 96, 34);
		mtPanel3.add(btnDetails3);
		btnDetails3.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel_3_4_1_1 = new JLabel("Details");
		lblNewLabel_3_4_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnDetails3.add(lblNewLabel_3_4_1_1);
		
		mtPanel4 = new JPanel();
		mtPanel4.setLayout(null);
		mtPanel4.setBackground(Color.WHITE);
		mtPanel4.setBounds(42, 309, 780, 58);
		panel_1.add(mtPanel4);
		
		name4 = new JLabel("Name");
		name4.setFont(new Font("Tahoma", Font.BOLD, 15));
		name4.setBounds(74, 21, 242, 19);
		mtPanel4.add(name4);
		
		quantity4 = new JLabel("Quantity");
		quantity4.setFont(new Font("Tahoma", Font.BOLD, 15));
		quantity4.setBounds(343, 21, 74, 19);
		mtPanel4.add(quantity4);
		
		JLabel lblNewLabel_3_1_2_1_1 = new JLabel("No");
		lblNewLabel_3_1_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3_1_2_1_1.setBounds(11, 21, 53, 19);
		mtPanel4.add(lblNewLabel_3_1_2_1_1);
		
		JPanel btnDetails4 = new JPanel();
		btnDetails4.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
		        // Set the font to bold
				btnDetails4.setBackground(new java.awt.Color(204,204,204));
		    }
		    
		    @Override
		    public void mouseExited(MouseEvent e) {
		    	btnDetails4.setBackground(new java.awt.Color(255,255,255));
		    }
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				new TokenDetails(details4,"second","sell").setVisible(true);
			}
		});
		btnDetails4.setBorder(new LineBorder(Color.PINK, 2, true));
		btnDetails4.setBackground(Color.WHITE);
		btnDetails4.setBounds(674, 10, 96, 34);
		mtPanel4.add(btnDetails4);
		btnDetails4.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel_3_4_1_2 = new JLabel("Details");
		lblNewLabel_3_4_1_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnDetails4.add(lblNewLabel_3_4_1_2);
		
		JButton btnNewButton_3_1 = new JButton("<");
		btnNewButton_3_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showPreviousProperties();
			}
		});
		btnNewButton_3_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_3_1.setBackground(Color.WHITE);
		btnNewButton_3_1.setBounds(731, 10, 53, 21);
		panel_1.add(btnNewButton_3_1);
		
		currentPage = new JTextField();
		currentPage.setText("1");
		currentPage.setFont(new Font("Tahoma", Font.BOLD, 15));
		currentPage.setEditable(false);
		currentPage.setColumns(10);
		currentPage.setBorder(new LineBorder(Color.BLACK, 2, true));
		currentPage.setBounds(794, 13, 28, 19);
		panel_1.add(currentPage);
		
		JButton btnNewButton_3_1_1 = new JButton(">");
		btnNewButton_3_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showNextProperties();
			}
		});
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
				new Market().setVisible(true);
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
		
		currentIndex = 0;
		showData();
        showPropertiesAtIndex();
	}
	private void showNextProperties() {
		int nextIndex = currentIndex + 4;
        if (nextIndex < tokenList.size()) {
        	currentPageIndex = currentPageIndex + 1;
            currentIndex = nextIndex;
            showPropertiesAtIndex();
        } 
    }

    private void showPreviousProperties() {
        currentIndex -= 4;
        if (currentIndex < 0) {
            currentIndex = 0;
        }else {
        	currentPageIndex = currentPageIndex -1;
        }
        showPropertiesAtIndex();
    }

    private void showPropertiesAtIndex() {
    	remaining = 0;
    	currentPage.setText(Integer.toString(currentPageIndex));
    	clearLabels();

        int endIndex = Math.min(currentIndex + 4, tokenList.size());

        for (int i = currentIndex, labelIndex = 1; i < endIndex; i++, labelIndex++) {
        	String[] realEstateData = tokenList.get(i);
            updateLabels(labelIndex, realEstateData);
        }

        int remainingData = 4 - remaining;

        if (remainingData == 0) {
        	setPanelVisibility(1, true);
        	setPanelVisibility(2, true);
            setPanelVisibility(3, true);
            setPanelVisibility(4, true);
        } else if (remainingData == 2) {
        	setPanelVisibility(1, true);
        	setPanelVisibility(2, true);
        	setPanelVisibility(3, false);
            setPanelVisibility(4, false);
        } else if (remainingData == 1) {
        	setPanelVisibility(1, true);
        	setPanelVisibility(2, true);
        	setPanelVisibility(3, true);
            setPanelVisibility(4, false);
        }
        else if (remainingData == 3) {
        	setPanelVisibility(1, true);
        	setPanelVisibility(2, false);
        	setPanelVisibility(3, false);
            setPanelVisibility(4, false);
        }
    }
	
	private void setPanelVisibility(int panelIndex, boolean isVisible) {
        switch (panelIndex) {
            case 1:
            	mtPanel1.setVisible(isVisible);
                break;
            case 2:
            	mtPanel2.setVisible(isVisible);
                break;
            case 3:
            	mtPanel3.setVisible(isVisible);
                break;
            case 4:
            	mtPanel4.setVisible(isVisible);
                break;
            default:
                throw new IllegalArgumentException("Invalid panelIndex");
        }
    }

    private void clearLabels() {
        clearLabel(name1);
        clearLabel(name2);
        clearLabel(name3);
        clearLabel(name4);
        clearLabel(quantity1);
        clearLabel(quantity2);
        clearLabel(quantity3);
        clearLabel(quantity4);
    }

    private void clearLabel(JLabel label) {
    	label.setText("");
    }

    private void updateLabels(int labelIndex, String[] realEstateData) {
    	remaining = remaining +1;
        JLabel nameLabel = getLabel("name", labelIndex);
        JLabel quantityLabel = getLabel("quantity", labelIndex);
        
        nameLabel.setText(String.valueOf(realEstateData[3]));
        quantityLabel.setText(String.valueOf(realEstateData[0]));
        switch (labelIndex) {
	        case 1:
	        	details1 = realEstateData;
	            break;
	        case 2:
	            details2 = realEstateData;
	            break; 
	        case 3:
	            details3 = realEstateData;
	            break;
	        case 4:
	            details4 = realEstateData;
	            break;
	        default:
	            throw new IllegalArgumentException("Invalid labelIndex");
        }
    }

    private JLabel getLabel(String type, int index) {
        switch (type) {
            case "name":
                return switch (index) {
                    case 1 -> name1;
                    case 2 -> name2;
                    case 3 -> name3;
                    case 4 -> name4;
                    default -> throw new IllegalArgumentException("Invalid index");
                };
            case "quantity":
                return switch (index) {
                    case 1 -> quantity1;
                    case 2 -> quantity2;
                    case 3 -> quantity3;
                    case 4 -> quantity4;
                    default -> throw new IllegalArgumentException("Invalid index");
                };
            
                
            default:
                throw new IllegalArgumentException("Invalid type");
        }
    }

    
	public void showData() {
		InvestorController i = new InvestorController();
		tokenList = i.showMyToken();
	}
}
