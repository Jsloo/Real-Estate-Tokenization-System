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
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import Both.TransactionHistory;
import Controller.InvestorController;

import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.ImageIcon;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class SecondMarket extends JFrame {

	private JPanel contentPane;
	private JTextField currentPage;
	private JLabel image1;
	private JLabel image2;
	private JLabel image3;
	private JLabel name1;
	private JLabel name2;
	private JLabel name3;
	private JLabel price1;
	private JLabel price2;
	private JLabel price3;
	private JLabel quantity1;
	private JLabel quantity2;
	private JLabel quantity3;
	private List<String[]> realEstateList;
    private int currentIndex;
    private JButton btnBuy1;
    private JButton btnBuy2;
    private JButton btnBuy3;
    private JPanel rsPanel1;
    private JPanel rsPanel2;
    private JPanel rsPanel3;
    public static String[] realEstateData;
    public static String[] details1;
    public static String[] details2;
    public static String[] details3;
    public Integer currentPageIndex=  1;
    public Integer remaining;
    private JPanel panel_2_3_2;
    private JLabel lblNewLabel_3_4_2;
    private JPanel panel_2_3_3;
    private JLabel lblNewLabel_3_4_3;

	/** 
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SecondMarket frame = new SecondMarket();
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
	public SecondMarket() {
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
		
		JLabel lblNewLabel = new JLabel("Real Estate Token Secondary Market");
		lblNewLabel.setBounds(36, 24, 687, 29);
		panel_1.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 36));
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.PINK);
		panel.setBounds(36, 110, 921, 399);
		panel_1.add(panel);
		panel.setLayout(null);
		
		rsPanel1 = new JPanel();
		rsPanel1.setBackground(Color.WHITE);
		rsPanel1.setBounds(43, 61, 224, 276);
		panel.add(rsPanel1);
		rsPanel1.setLayout(null);
		
		image1 = new JLabel("");
		image1.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		image1.setBounds(41, 10, 144, 132);
		rsPanel1.add(image1);
		
		name1 = new JLabel("Name");
		name1.setHorizontalAlignment(SwingConstants.CENTER);
		name1.setFont(new Font("Tahoma", Font.BOLD, 15));
		name1.setBounds(59, 150, 104, 19);
		rsPanel1.add(name1);
		
		price1 = new JLabel("Price");
		price1.setHorizontalAlignment(SwingConstants.CENTER);
		price1.setFont(new Font("Tahoma", Font.BOLD, 15));
		price1.setBounds(59, 180, 104, 19);
		rsPanel1.add(price1);
		
		quantity1 = new JLabel("Quantity");
		quantity1.setHorizontalAlignment(SwingConstants.CENTER);
		quantity1.setFont(new Font("Tahoma", Font.BOLD, 15));
		quantity1.setBounds(59, 210, 109, 19);
		rsPanel1.add(quantity1);
		
		btnBuy1 = new JButton("Buy");
		btnBuy1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new TokenDetails(details1,"second","buy").setVisible(true);
			}
		});
		
		btnBuy1.setBounds(65, 245, 85, 21);
		rsPanel1.add(btnBuy1);
		
		rsPanel2 = new JPanel();
		rsPanel2.setLayout(null);
		rsPanel2.setBackground(Color.WHITE);
		rsPanel2.setBounds(347, 61, 224, 276);
		panel.add(rsPanel2);
		
		image2 = new JLabel("");
		image2.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		image2.setBounds(41, 10, 144, 132);
		rsPanel2.add(image2);
		
		name2 = new JLabel("Name");
		name2.setHorizontalAlignment(SwingConstants.CENTER);
		name2.setFont(new Font("Tahoma", Font.BOLD, 15));
		name2.setBounds(61, 151, 104, 19);
		rsPanel2.add(name2);
		
		price2 = new JLabel("Price");
		price2.setHorizontalAlignment(SwingConstants.CENTER);
		price2.setFont(new Font("Tahoma", Font.BOLD, 15));
		price2.setBounds(61, 180, 104, 19);
		rsPanel2.add(price2);
		
		quantity2 = new JLabel("Quantity");
		quantity2.setHorizontalAlignment(SwingConstants.CENTER);
		quantity2.setFont(new Font("Tahoma", Font.BOLD, 15));
		quantity2.setBounds(61, 210, 109, 19);
		rsPanel2.add(quantity2);
		
		btnBuy2 = new JButton("Buy");
		btnBuy2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new TokenDetails(details2,"second","buy").setVisible(true);
			}
		});
		btnBuy2.setBounds(65, 245, 85, 21);
		rsPanel2.add(btnBuy2);
		
		rsPanel3 = new JPanel();
		rsPanel3.setLayout(null);
		rsPanel3.setBackground(Color.WHITE);
		rsPanel3.setBounds(648, 61, 224, 276);
		panel.add(rsPanel3);
		
		image3 = new JLabel("");
		image3.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		image3.setBounds(41, 10, 144, 132);
		rsPanel3.add(image3);
		
		name3 = new JLabel("Name");
		name3.setHorizontalAlignment(SwingConstants.CENTER);
		name3.setFont(new Font("Tahoma", Font.BOLD, 15));
		name3.setBounds(63, 153, 104, 19);
		rsPanel3.add(name3);
		
		price3 = new JLabel("Price");
		price3.setHorizontalAlignment(SwingConstants.CENTER);
		price3.setFont(new Font("Tahoma", Font.BOLD, 15));
		price3.setBounds(63, 180, 104, 19);
		rsPanel3.add(price3);
		
		quantity3 = new JLabel("Quantity");
		quantity3.setHorizontalAlignment(SwingConstants.CENTER);
		quantity3.setFont(new Font("Tahoma", Font.BOLD, 15));
		quantity3.setBounds(63, 210, 109, 19);
		rsPanel3.add(quantity3);
		
		btnBuy3 = new JButton("Buy");
		btnBuy3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new TokenDetails(details3,"second","buy").setVisible(true);
			}
		});
		btnBuy3.setBounds(65, 245, 85, 21);
		rsPanel3.add(btnBuy3);
		
		JButton btnNewButton_3_1 = new JButton("<");
		btnNewButton_3_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showPreviousProperties();
			}
		});
		btnNewButton_3_1.setBackground(Color.WHITE);
		btnNewButton_3_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_3_1.setBounds(755, 11, 53, 21);
		panel.add(btnNewButton_3_1);
		
		currentPage = new JTextField();
		currentPage.setEditable(false);
		currentPage.setBorder(new LineBorder(Color.BLACK, 2, true));
		currentPage.setFont(new Font("Tahoma", Font.BOLD, 15));
		currentPage.setText("1");
		currentPage.setBounds(818, 12, 28, 19);
		panel.add(currentPage);
		currentPage.setColumns(10);
		
		JButton btnNewButton_3_1_1 = new JButton(">");
		btnNewButton_3_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showNextProperties();
			}
		});
		btnNewButton_3_1_1.setBackground(Color.WHITE);
		btnNewButton_3_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_3_1_1.setBounds(856, 11, 55, 21);
		panel.add(btnNewButton_3_1_1);
		
		JPanel panel_2_3 = new JPanel();
		
		panel_2_3.addMouseListener(new MouseAdapter() {
			@Override
		    public void mouseEntered(MouseEvent e) {
				panel_2_3.setBackground(new java.awt.Color(204,204,204));
		    }
		    
		    @Override
		    public void mouseExited(MouseEvent e) {
		    	panel_2_3.setBackground(new java.awt.Color(255,255,255));
		    }
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				new MyToken().setVisible(true);
			}
		});
		panel_2_3.setBorder(new LineBorder(Color.PINK, 2, true));
		panel_2_3.setBackground(Color.WHITE);
		panel_2_3.setBounds(670, 65, 103, 34);
		panel_1.add(panel_2_3);
		panel_2_3.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel_3_4 = new JLabel("My Token");
		panel_2_3.add(lblNewLabel_3_4);
		lblNewLabel_3_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JPanel panel_2_3_1 = new JPanel();
		panel_2_3_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				new Market().setVisible(true);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_2_3_1.setBackground(new java.awt.Color(204,204,204));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panel_2_3_1.setBackground(new java.awt.Color(255,255,255));
			}
		});
		panel_2_3_1.setBorder(new LineBorder(Color.PINK, 2, true));
		panel_2_3_1.setBackground(Color.WHITE);
		panel_2_3_1.setBounds(499, 65, 161, 34);
		panel_1.add(panel_2_3_1);
		panel_2_3_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel_3_4_1 = new JLabel("Primary Market");
		lblNewLabel_3_4_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_2_3_1.add(lblNewLabel_3_4_1);
		
		panel_2_3_2 = new JPanel();
		panel_2_3_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				new TransactionHistory("investor").setVisible(true);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_2_3_2.setBackground(new java.awt.Color(204,204,204));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panel_2_3_2.setBackground(new java.awt.Color(255,255,255));
			}
		});
		panel_2_3_2.setBorder(new LineBorder(Color.PINK, 2, true));
		panel_2_3_2.setBackground(Color.WHITE);
		panel_2_3_2.setBounds(784, 65, 173, 34);
		panel_1.add(panel_2_3_2);
		panel_2_3_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		lblNewLabel_3_4_2 = new JLabel("Transaction History");
		lblNewLabel_3_4_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_2_3_2.add(lblNewLabel_3_4_2);
		
		panel_2_3_3 = new JPanel();
		panel_2_3_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				InvestorController out = new InvestorController();
				out.logOut();
				setVisible(false);
				new Login().setVisible(true);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_2_3_3.setBackground(new java.awt.Color(204,204,204));
		    }
		    
		    @Override
		    public void mouseExited(MouseEvent e) {
		    	panel_2_3_3.setBackground(new java.awt.Color(255,255,255));
		    }
		});
		panel_2_3_3.setBorder(new LineBorder(Color.PINK, 2, true));
		panel_2_3_3.setBackground(Color.WHITE);
		panel_2_3_3.setBounds(854, 19, 103, 34);
		panel_1.add(panel_2_3_3);
		panel_2_3_3.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		lblNewLabel_3_4_3 = new JLabel("Log Out");
		lblNewLabel_3_4_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_2_3_3.add(lblNewLabel_3_4_3);
		
		currentIndex = 0;
		showData();
        showPropertiesAtIndex();

	}
	
	private void showNextProperties() {
		int nextIndex = currentIndex + 3;
        if (nextIndex < realEstateList.size()) {
        	currentPageIndex = currentPageIndex + 1;
            currentIndex = nextIndex;
            showPropertiesAtIndex();
        } 
    }

    private void showPreviousProperties() {
        currentIndex -= 3;
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

        int endIndex = Math.min(currentIndex + 3, realEstateList.size());

        for (int i = currentIndex, labelIndex = 1; i < endIndex; i++, labelIndex++) {
        	String[] realEstateData = realEstateList.get(i);
            updateLabels(labelIndex, realEstateData);
        }

        int remainingData = 3 - remaining;

        if (remainingData == 0) {
        	setPanelVisibility(1, true);
        	setPanelVisibility(2, true);
            setPanelVisibility(3, true);
        } else if (remainingData == 2) {
        	setPanelVisibility(1, true);
        	setPanelVisibility(2, false);
            setPanelVisibility(3, false);
        } else if (remainingData == 1) {
        	setPanelVisibility(1, true);
        	setPanelVisibility(2, true);
            setPanelVisibility(3, false);
        }
    }
    
    private void setPanelVisibility(int panelIndex, boolean isVisible) {
        switch (panelIndex) {
            case 1:
            	rsPanel1.setVisible(isVisible);
                break;
            case 2:
            	rsPanel2.setVisible(isVisible);
                break;
            case 3:
            	rsPanel3.setVisible(isVisible);
                break;
            default:
                throw new IllegalArgumentException("Invalid panelIndex");
        }
    }

    private void clearLabels() {
    	clearLabel(image1);
        clearLabel(image2);
        clearLabel(image3);
        clearLabel(name1);
        clearLabel(name2);
        clearLabel(name3);
        clearLabel(price1);
        clearLabel(price2);
        clearLabel(price3);
        clearLabel(quantity1);
        clearLabel(quantity2);
        clearLabel(quantity3);
    }

    private void clearLabel(JLabel label) {
    	label.setText("");
    }

    private void updateLabels(int labelIndex, String[] realEstateData) {
    	remaining = remaining +1;
        JLabel nameLabel = getLabel("name", labelIndex);
        JLabel priceLabel = getLabel("price", labelIndex);
        JLabel quantityLabel = getLabel("quantity", labelIndex);
        JLabel imageLabel = getLabel("image", labelIndex);

        ImageIcon imageIcon = new ImageIcon(String.valueOf(realEstateData[9]));
        Image img =imageIcon.getImage().getScaledInstance(250,250,Image.SCALE_SMOOTH);
        imageLabel.setIcon(new ImageIcon(img));
        nameLabel.setText(String.valueOf(realEstateData[4]));
        priceLabel.setText(String.valueOf(realEstateData[3]));
        quantityLabel.setText(String.valueOf(realEstateData[2]));
        
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
	        default:
	            throw new IllegalArgumentException("Invalid labelIndex");
        }
    }

    private JLabel getLabel(String type, int index) {
        switch (type) {
        	case "image":
	            return switch (index) {
	                case 1 -> image1;
	                case 2 -> image2;
	                case 3 -> image3;
	                default -> throw new IllegalArgumentException("Invalid index");
	            };
            case "name":
                return switch (index) {
                    case 1 -> name1;
                    case 2 -> name2;
                    case 3 -> name3;
                    default -> throw new IllegalArgumentException("Invalid index");
                };
            case "price":
                return switch (index) {
                    case 1 -> price1;
                    case 2 -> price2;
                    case 3 -> price3;
                    default -> throw new IllegalArgumentException("Invalid index");
                };
            case "quantity":
                return switch (index) {
                    case 1 -> quantity1;
                    case 2 -> quantity2;
                    case 3 -> quantity3;
                    default -> throw new IllegalArgumentException("Invalid index");
                };
            
                
            default:
                throw new IllegalArgumentException("Invalid type");
        }
    }

    
	public void showData() {
		InvestorController i = new InvestorController();
		realEstateList = i.showSecondMarket();
	}
}
