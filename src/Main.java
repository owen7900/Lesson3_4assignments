import java.awt.EventQueue;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Main extends JFrame {

	private JPanel contentPane;
	private static JTextField[] employeeText = new JTextField[5];

	
	private static JTextField[][] textField = new JTextField[6][3];
	private static JPanel[] EmployeePanel = new JPanel[6];
	private static JLabel[][] label = new JLabel[6][3];
	
	
	private static double[] hours = new double[5];
	private static double[] overtimeHours = new double[5];
	private static double total = 0, totalR = 0, totalO = 0;
	private static double pay = 15;
	private static double overTimePay = 22.5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		while(true){
			try{
				for (int i = 0; i < employeeText.length; i++) {
					try{
					hours[i] = Double.parseDouble(employeeText[i].getText());
					} catch (NumberFormatException e){
						
					}
				}
				
				for (int i = 0; i < hours.length; i++) {
					if (hours[i] >= 40 && hours[i] <= 70){
						overtimeHours[i] = hours[i] - 40;
						hours[i] = 40;
					}else if (hours[i] > 70){
						hours[i] = 70;
						employeeText[i].setText("70");
					}
					textField[i][0].setText(String.valueOf((hours[i] * pay)));
					textField[i][1].setText(String.valueOf((overtimeHours[i] * overTimePay)));
					textField[i][2].setText(String.valueOf(((overtimeHours[i] * overTimePay) + (hours[i] * pay))));
					total += ((overtimeHours[i] * overTimePay) + (hours[i] * pay));
					totalR += (hours[i] * pay);
					totalO += (overtimeHours[i] * overTimePay);
				}
				textField[5][0].setText(String.valueOf(totalR));
				textField[5][1].setText(String.valueOf(totalO));
				textField[5][2].setText(String.valueOf(total));
				total = 0;
				totalR= 0;
				totalO = 0;
				
			}catch(NullPointerException e){
				
			}
			
			
			
		}
	}

	/**
	 * Create the frame.
	 */
	public Main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 433, 308);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 417, 269);
		contentPane.add(tabbedPane);
		
		JPanel employeePayPanel = new JPanel();
		tabbedPane.addTab("Employee Pay", null, employeePayPanel, null);
		employeePayPanel.setLayout(null);
		
		JLabel lblEmployeeHours = new JLabel("Employee 1 hours");
		lblEmployeeHours.setBounds(10, 11, 90, 14);
		employeePayPanel.add(lblEmployeeHours);
		for (int i = 0; i < employeeText.length; i++) {
			employeeText[i] = new JTextField();
			employeePayPanel.add(employeeText[i]);
			employeeText[i].setColumns(10);
			employeeText[i].addKeyListener(new KeyAdapter() {
	            public void keyTyped(KeyEvent e) {
	                char caracter = e.getKeyChar();
	                if (((caracter < '0') || (caracter > '9'))
	                        && (caracter != '\b') && (caracter !='.')) {
	                    e.consume();
	                }
	            }
	        });
		}
		
		
		
		employeeText[0].setBounds(110, 8, 86, 20);
		
		
		
		
		JLabel lblEmployeeHours_1 = new JLabel("Employee 3 hours");
		lblEmployeeHours_1.setBounds(10, 38, 90, 14);
		employeePayPanel.add(lblEmployeeHours_1);
		
		
		employeeText[2].setBounds(110, 35, 86, 20);
		
		JLabel lblEmployeeHours_2 = new JLabel("Employee 5 hours");
		lblEmployeeHours_2.setBounds(10, 66, 90, 14);
		employeePayPanel.add(lblEmployeeHours_2);
		
		
		employeeText[4].setBounds(110, 63, 86, 20);
		
		JLabel lblEmployeeHours_3 = new JLabel("Employee 2 hours");
		lblEmployeeHours_3.setBounds(206, 11, 90, 14);
		employeePayPanel.add(lblEmployeeHours_3);
		
		
		employeeText[1].setBounds(306, 8, 86, 20);
		
		JLabel lblEmployeeHours_4 = new JLabel("Employee 4 hours");
		lblEmployeeHours_4.setBounds(206, 38, 90, 14);
		employeePayPanel.add(lblEmployeeHours_4);
		
		
		employeeText[3].setBounds(306, 35, 86, 20);
		
		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_1.setBounds(43, 110, 359, 120);
		employeePayPanel.add(tabbedPane_1);
		
		JPanel divide = new JPanel();
		tabbedPane.addTab("New tab", null, divide, null);
		for (int j = 0; j < EmployeePanel.length; j++) {
			EmployeePanel[j] = new JPanel();
			if(j == 5) {
				tabbedPane_1.addTab("Total", null, EmployeePanel[j], null);
			}else{
			tabbedPane_1.addTab("Employee " + (j+1), null, EmployeePanel[j], null);
			}
			EmployeePanel[j].setLayout(null);
		}
		for (int i = 0; i < label.length; i++) {
			for (int j = 0; j < label[i].length; j++) {
				label[i][j] = new JLabel();
				EmployeePanel[i].add(label[i][j]);
			}
		}
		
		
		
		
		
		for (int i = 0; i < textField.length; i++) {
			for (int j = 0; j < textField[i].length; j++) {
				textField[i][j] = new JTextField();
				
				EmployeePanel[i].add(textField[i][j]);
				textField[i][j].setColumns(10);
				textField[i][j].setEditable(false);
			}
		}
		
		
		textField[0][0].setBounds(72, 8, 86, 20);
		textField[0][1].setBounds(248, 8, 86, 20);
		textField[0][2].setBounds(180, 38, 86, 20);
		
		textField[1][0].setBounds(72, 8, 86, 20);
		textField[1][1].setBounds(248, 8, 86, 20);
		textField[1][2].setBounds(180, 38, 86, 20);
		
		textField[2][0].setBounds(72, 8, 86, 20);
		textField[2][1].setBounds(248, 8, 86, 20);
		textField[2][2].setBounds(180, 38, 86, 20);
		
		textField[3][0].setBounds(72, 8, 86, 20);
		textField[3][1].setBounds(248, 8, 86, 20);
		textField[3][2].setBounds(180, 38, 86, 20);

		textField[4][0].setBounds(72, 8, 86, 20);
		textField[4][1].setBounds(248, 8, 86, 20);
		textField[4][2].setBounds(180, 38, 86, 20);
		
		textField[5][0].setBounds(72, 8, 86, 20);
		textField[5][1].setBounds(248, 8, 86, 20);
		textField[5][2].setBounds(180, 38, 86, 20);
		
		label[0][0].setText("Regular Pay");
		label[0][0].setBounds(10, 11, 66, 14);
		
		
		label[0][1].setText("Overtime Pay");
		label[0][1].setBounds(172, 11, 66, 14);
		
		
		label[0][2].setText("Total Pay");
		label[0][2].setBounds(113, 42, 66, 14);
		
		
		label[1][0].setText("Regular Pay");
		label[1][0].setBounds(10, 11, 66, 14);
		
		
		label[1][1].setText("Overtime Pay");
		label[1][1].setBounds(172, 11, 66, 14);
		
		
		label[1][2].setText("Total Pay");
		label[1][2].setBounds(113, 42, 66, 14);
		
		label[2][0].setText("Regular Pay");
		label[2][0].setBounds(10, 11, 66, 14);
		
		
		label[2][1].setText("Overtime Pay");
		label[2][1].setBounds(172, 11, 66, 14);
		
		
		label[2][2].setText("Total Pay");
		label[2][2].setBounds(113, 42, 66, 14);
		
		label[3][0].setText("Regular Pay");
		label[3][0].setBounds(10, 11, 66, 14);
		
		
		label[3][1].setText("Overtime Pay");
		label[3][1].setBounds(172, 11, 66, 14);
		
		
		label[3][2].setText("Total Pay");
		label[3][2].setBounds(113, 42, 66, 14);
		
		label[4][0].setText("Regular Pay");
		label[4][0].setBounds(10, 11, 66, 14);
		
		
		label[4][1].setText("Overtime Pay");
		label[4][1].setBounds(172, 11, 66, 14);
		
		
		label[4][2].setText("Total Pay");
		label[4][2].setBounds(113, 42, 66, 14);
		label[5][0].setText("Regular Pay");
		label[5][0].setBounds(10, 11, 66, 14);
		
		
		label[5][1].setText("Overtime Pay");
		label[5][1].setBounds(172, 11, 66, 14);
		
		
		label[5][2].setText("Total Pay");
		label[5][2].setBounds(113, 42, 66, 14);
		
	}
}
