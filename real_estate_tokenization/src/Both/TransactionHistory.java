package Both;

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
import Controller.OwnerController;
import Investor.Market;
import Project_Owner.MyToken;

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

public class TransactionHistory extends JFrame {

	private JPanel contentPane;
	private JTextField currentPage;
	private JLabel from1;
	private JLabel from2;
	private JLabel from3;
	private JLabel from4;
	private JLabel to1;
	private JLabel to2;
	private JLabel to3;
	private JLabel to4;
	private JLabel rsName1;
	private JLabel rsName2;
	private JLabel rsName3;
	private JLabel rsName4;
	private JLabel amount1;
	private JLabel amount2;
	private JLabel amount3;
	private JLabel amount4;
	private JLabel market1;
	private JLabel market2;
	private JLabel market3;
	private JLabel market4;
	private List<String[]> tokenList;
    private int currentIndex;
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
    public String type;
	/**
	 * Launch the application.
	 */
	public static String[] selectedDetails = {"image","state","city","zipcode","address","name","token"};
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TransactionHistory frame = new TransactionHistory("investor");
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
	
	
	public TransactionHistory(String type) {
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
		
		JLabel lblRealEstateToken = new JLabel("Transaction History");
		lblRealEstateToken.setFont(new Font("Tahoma", Font.BOLD, 36));
		lblRealEstateToken.setBounds(40, 27, 382, 38);
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
		mtPanel1.setBounds(42, 70, 819, 58);
		panel_1.add(mtPanel1);
		
		from1 = new JLabel("Name");
		from1.setFont(new Font("Tahoma", Font.BOLD, 15));
		from1.setBounds(21, 21, 181, 19);
		mtPanel1.add(from1);
		
		to1 = new JLabel("to");
		to1.setFont(new Font("Tahoma", Font.BOLD, 15));
		to1.setBounds(212, 21, 160, 19);
		mtPanel1.add(to1);
		
		amount1 = new JLabel("Amount");
		amount1.setFont(new Font("Tahoma", Font.BOLD, 15));
		amount1.setBounds(613, 21, 74, 19);
		mtPanel1.add(amount1);
		
		market1 = new JLabel("Market");
		market1.setFont(new Font("Tahoma", Font.BOLD, 15));
		market1.setBounds(735, 21, 74, 19);
		mtPanel1.add(market1);
		
		rsName1 = new JLabel("RS Name");
		rsName1.setFont(new Font("Tahoma", Font.BOLD, 15));
		rsName1.setBounds(398, 21, 141, 19);
		mtPanel1.add(rsName1);
		
		mtPanel2 = new JPanel();
		mtPanel2.setLayout(null);
		mtPanel2.setBackground(Color.WHITE);
		mtPanel2.setBounds(42, 148, 819, 58);
		panel_1.add(mtPanel2);
		
		from2 = new JLabel("Name");
		from2.setFont(new Font("Tahoma", Font.BOLD, 15));
		from2.setBounds(22, 21, 183, 19);
		mtPanel2.add(from2);
		
		to2 = new JLabel("to");
		to2.setFont(new Font("Tahoma", Font.BOLD, 15));
		to2.setBounds(215, 21, 160, 19);
		mtPanel2.add(to2);
		
		amount2 = new JLabel("Amount");
		amount2.setFont(new Font("Tahoma", Font.BOLD, 15));
		amount2.setBounds(615, 21, 74, 19);
		mtPanel2.add(amount2);
		
		market2 = new JLabel("Market");
		market2.setFont(new Font("Tahoma", Font.BOLD, 15));
		market2.setBounds(735, 21, 74, 19);
		mtPanel2.add(market2);
		
		rsName2 = new JLabel("RS Name");
		rsName2.setFont(new Font("Tahoma", Font.BOLD, 15));
		rsName2.setBounds(399, 21, 133, 19);
		mtPanel2.add(rsName2);
		
		mtPanel3 = new JPanel();
		mtPanel3.setLayout(null);
		mtPanel3.setBackground(Color.WHITE);
		mtPanel3.setBounds(42, 228, 819, 58);
		panel_1.add(mtPanel3);
		
		from3 = new JLabel("Name");
		from3.setFont(new Font("Tahoma", Font.BOLD, 15));
		from3.setBounds(27, 21, 181, 19);
		mtPanel3.add(from3);
		
		to3 = new JLabel("to");
		to3.setFont(new Font("Tahoma", Font.BOLD, 15));
		to3.setBounds(218, 21, 160, 19);
		mtPanel3.add(to3);
		
		amount3 = new JLabel("Amount");
		amount3.setFont(new Font("Tahoma", Font.BOLD, 15));
		amount3.setBounds(614, 21, 74, 19);
		mtPanel3.add(amount3);
		
		market3 = new JLabel("Market");
		market3.setFont(new Font("Tahoma", Font.BOLD, 15));
		market3.setBounds(735, 21, 74, 19);
		mtPanel3.add(market3);
		
		rsName3 = new JLabel("RS Name");
		rsName3.setFont(new Font("Tahoma", Font.BOLD, 15));
		rsName3.setBounds(402, 21, 133, 19);
		mtPanel3.add(rsName3);
		
		mtPanel4 = new JPanel();
		mtPanel4.setLayout(null);
		mtPanel4.setBackground(Color.WHITE);
		mtPanel4.setBounds(42, 309, 819, 58);
		panel_1.add(mtPanel4);
		
		from4 = new JLabel("Name");
		from4.setFont(new Font("Tahoma", Font.BOLD, 15));
		from4.setBounds(28, 21, 182, 19);
		mtPanel4.add(from4);
		
		to4 = new JLabel("to");
		to4.setFont(new Font("Tahoma", Font.BOLD, 15));
		to4.setBounds(220, 21, 160, 19);
		mtPanel4.add(to4);
		
		amount4 = new JLabel("Amount");
		amount4.setFont(new Font("Tahoma", Font.BOLD, 15));
		amount4.setBounds(611, 21, 74, 19);
		mtPanel4.add(amount4);
		
		market4 = new JLabel("Market");
		market4.setFont(new Font("Tahoma", Font.BOLD, 15));
		market4.setBounds(735, 21, 74, 19);
		mtPanel4.add(market4);
		
		rsName4 = new JLabel("RS Name");
		rsName4.setFont(new Font("Tahoma", Font.BOLD, 15));
		rsName4.setBounds(406, 21, 133, 19);
		mtPanel4.add(rsName4);
		
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
		
		JLabel lblNewLabel_3_3 = new JLabel("From");
		lblNewLabel_3_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3_3.setBounds(58, 41, 242, 19);
		panel_1.add(lblNewLabel_3_3);
		
		JLabel lblNewLabel_3_1_1_2 = new JLabel("To");
		lblNewLabel_3_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3_1_1_2.setBounds(254, 41, 74, 19);
		panel_1.add(lblNewLabel_3_1_1_2);
		
		JLabel lblNewLabel_3_1_1_2_1 = new JLabel("Amount");
		lblNewLabel_3_1_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3_1_1_2_1.setBounds(659, 41, 74, 19);
		panel_1.add(lblNewLabel_3_1_1_2_1);
		
		JLabel lblNewLabel_3_1_1_2_1_1 = new JLabel("Market");
		lblNewLabel_3_1_1_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3_1_1_2_1_1.setBounds(776, 41, 74, 19);
		panel_1.add(lblNewLabel_3_1_1_2_1_1);
		
		JLabel lblNewLabel_3_1_1_2_2 = new JLabel("Real Esatate Name");
		lblNewLabel_3_1_1_2_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3_1_1_2_2.setBounds(431, 41, 160, 19);
		panel_1.add(lblNewLabel_3_1_1_2_2);
		
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
				if(type.equals("investor")) {
					new Market().setVisible(true);
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
		
		this.type = type;
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
        clearLabel(from1);
        clearLabel(from2);
        clearLabel(from3);
        clearLabel(from4);
        clearLabel(to1);
        clearLabel(to2);
        clearLabel(to3);
        clearLabel(to4);
        clearLabel(rsName1);
        clearLabel(rsName2);
        clearLabel(rsName3);
        clearLabel(rsName4);
        clearLabel(amount1);
        clearLabel(amount2);
        clearLabel(amount4);
        clearLabel(amount3);
        clearLabel(market1);
        clearLabel(market2);
        clearLabel(market3);
        clearLabel(market4);
    }

    private void clearLabel(JLabel label) {
    }

    private void updateLabels(int labelIndex, String[] realEstateData) {
    	remaining = remaining +1;
        JLabel fromLabel = getLabel("from", labelIndex);
        JLabel toLabel = getLabel("to", labelIndex);
        JLabel rsNameLabel = getLabel("rsName", labelIndex);
        JLabel amountLabel = getLabel("amount", labelIndex);
        JLabel marketLabel = getLabel("market", labelIndex);
        
        fromLabel.setText(String.valueOf(realEstateData[0]));
        toLabel.setText(String.valueOf(realEstateData[1]));
        rsNameLabel.setText(String.valueOf(realEstateData[2]));
        amountLabel.setText(String.valueOf(realEstateData[3]));
        marketLabel.setText(String.valueOf(realEstateData[4]));
    }

    private JLabel getLabel(String type, int index) {
        switch (type) {
            case "from":
                return switch (index) {
                    case 1 -> from1;
                    case 2 -> from2;
                    case 3 -> from3;
                    case 4 -> from4;
                    default -> throw new IllegalArgumentException("Invalid index");
                };
            case "to":
                return switch (index) {
                    case 1 -> to1;
                    case 2 -> to2;
                    case 3 -> to3;
                    case 4 -> to4;
                    default -> throw new IllegalArgumentException("Invalid index");
                };
            case "rsName":
                return switch (index) {
                    case 1 -> rsName1;
                    case 2 -> rsName2;
                    case 3 -> rsName3;
                    case 4 -> rsName4;
                    default -> throw new IllegalArgumentException("Invalid index");
                };
            case "amount":
                return switch (index) {
                    case 1 -> amount1;
                    case 2 -> amount2;
                    case 3 -> amount3;
                    case 4 -> amount4;
                    default -> throw new IllegalArgumentException("Invalid index");
                };
            case "market":
                return switch (index) {
                    case 1 -> market1;
                    case 2 -> market2;
                    case 3 -> market3;
                    case 4 -> market4;
                    default -> throw new IllegalArgumentException("Invalid index");
                };
            
                
            default:
                throw new IllegalArgumentException("Invalid type");
        }
    }

    
	public void showData() {
		InvestorController i = new InvestorController();
		OwnerController o = new OwnerController();
		tokenList = i.showTransactionHistory(type);
	}
}
