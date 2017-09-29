import java.awt.EventQueue;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;

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
	private static JTabbedPane tabbedPane;
	private static JTextField[] textFieldD = new JTextField[4];
	private static int[] divide = new int[2];
	private static double answer = -1, remainder = -1;
	private static JTextField textField_1;
	private static JTextField textField_2;
	private static int power = 0;
	private static JLabel[][] salLabel1 = new JLabel[4][10];
	private static JTextField textField_3;
	

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
			employeePayWhile();
			divideWhile();
			powersChartWhile();
			salaryWhile();
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
		setResizable(false);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 417, 269);
		contentPane.add(tabbedPane);
		
		employeePay();
		devide();
		powersChart();
		salaryTable();
	}
	
	public static void powersChart(){
		JPanel panel = new JPanel();
		tabbedPane.addTab("Powers Chart", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblEnterNumber = new JLabel("Enter Number");
		lblEnterNumber.setBounds(10, 11, 66, 14);
		panel.add(lblEnterNumber);
		
		textField_1 = new JTextField();
		textField_1.setBounds(86, 8, 86, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);
		textField_1.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char caracter = e.getKeyChar();
                if (((caracter < '0') || (caracter > '9'))
                        && (caracter != '\b') && (caracter !='.')) {
                    e.consume();
                }
            }
        });
		
		textField_2 = new JTextField();
		textField_2.setBounds(10, 36, 392, 20);
		panel.add(textField_2);
		textField_2.setColumns(10);
		textField_2.setEditable(false);
		
		
	}
	
	public static void salaryTable(){
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Salary Table", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel lblYear = new JLabel("Year");
		lblYear.setBounds(10, 11, 46, 14);
		panel_1.add(lblYear);
		
		JLabel lblNewLabel = new JLabel("Old Salary");
		lblNewLabel.setBounds(80, 11, 68, 14);
		panel_1.add(lblNewLabel);
		
		JLabel lblRaise = new JLabel("Raise");
		lblRaise.setBounds(192, 11, 46, 14);
		panel_1.add(lblRaise);
		
		JLabel lblNewSalary = new JLabel("New Salary");
		lblNewSalary.setBounds(296, 11, 76, 14);
		panel_1.add(lblNewSalary);
		
		JLabel lblEnterStartingSalary = new JLabel("Enter Starting Salary");
		lblEnterStartingSalary.setBounds(32, 198, 138, 14);
		panel_1.add(lblEnterStartingSalary);
		
		textField_3 = new JTextField();
		textField_3.setBounds(180, 195, 86, 20);
		panel_1.add(textField_3);
		textField_3.setColumns(10);
		textField_3.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char caracter = e.getKeyChar();
                if (((caracter < '0') || (caracter > '9'))
                        && (caracter != '\b')) {
                    e.consume();
                }
            }
        });
		for (int i = 0; i < salLabel1.length; i++) {
			for (int j = 0; j < salLabel1[i].length; j++) {
				salLabel1[i][j] = new JLabel();
				salLabel1[i][j].setBounds((10 + 100*i), (31 +13 * j), 70, 14);
				salLabel1[i][j].setHorizontalTextPosition(SwingConstants.CENTER);
				panel_1.add(salLabel1[i][j]);
				
			}
		}
		
		
		
		
		
	}
	
	public static void devide(){
		JPanel divide = new JPanel();
		tabbedPane.addTab("Divide", null, divide, null);
		divide.setLayout(null);
		
		JLabel lblFirstNumber = new JLabel("First Number");
		lblFirstNumber.setBounds(10, 11, 85, 14);
		divide.add(lblFirstNumber);
		
		JLabel lblSecondNumber = new JLabel("Second Number");
		lblSecondNumber.setBounds(10, 36, 85, 14);
		divide.add(lblSecondNumber);
		for (int i = 0; i < textFieldD.length; i++) {
			textFieldD[i] = new JTextField();
			divide.add(textFieldD[i]);
			textFieldD[i].setColumns(10);
			textFieldD[i].addKeyListener(new KeyAdapter() {
	            public void keyTyped(KeyEvent e) {
	                char caracter = e.getKeyChar();
	                if (((caracter < '0') || (caracter > '9'))
	                        && (caracter != '\b') && (caracter !='.')) {
	                    e.consume();
	                }
	            }
	        });
		}
	
		textFieldD[0].setBounds(112, 8, 86, 20);
		
		
		textFieldD[1].setBounds(112, 36, 86, 20);
		
		
		JLabel lblQuotient = new JLabel("Quotient");
		lblQuotient.setBounds(10, 70, 56, 14);
		divide.add(lblQuotient);
		
		JLabel lblRemanider = new JLabel("Remanider");
		lblRemanider.setBounds(10, 101, 85, 14);
		divide.add(lblRemanider);
		
		
		
		
		textFieldD[2].setBounds(112, 67, 86, 20);
		textFieldD[2].setEditable(false);
		textFieldD[3].setBounds(112, 98, 86, 20);
		textFieldD[3].setEditable(false);
	}
	public static void employeePay(){
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
	
	public static void salaryWhile(){
		try{
			int salary = 40000;
			try{
				salary = Integer.parseInt(textField_3.getText());
			}catch(NumberFormatException e){
				salary = 0;
			}
			
			int newSalary = 40000;
			for (int i = 0; i < 10; i++) {
				salLabel1[0][i].setText(String.valueOf(i + 1));
				salLabel1[1][i].setText(String.valueOf(salary));
				newSalary = (int) (salary * 1.03);
				salLabel1[2][i].setText(String.valueOf(newSalary - salary));
				salLabel1[3][i].setText(String.valueOf(newSalary));
				salary = newSalary;
				
			}
		}catch (NullPointerException e){
			
		}
		
	}
	
	public static void powersChartWhile(){
		try{
			try{
				 power = Integer.parseInt(textField_1.getText());
				
				} catch ( NumberFormatException e){
					power = 0;
				}
			if (power > 10){
				power = 10;
				textField_1.setText("10");
			}
			int[] powerSum = new int[power + 1];
			
			for (int i = 0; i <= power; i++) {
				powerSum[i] = (int) Math.pow(2, i);
				
			}
			String powerString = " ";
			for (int j = 0; j < powerSum.length; j++) {
				powerString = powerString + String.valueOf(powerSum[j]) + ", ";
			}
			textField_2.setText(powerString);
			powerString = "";
		}catch (NullPointerException e){
			
		}
	}
	
	public static void divideWhile(){
		try{
			for (int i = 0; i < 2; i++) {
				try{
				divide[i] = Integer.parseInt(textFieldD[i].getText());
				
				} catch ( NumberFormatException e){
					
				}
			}
			try{
			if (divide[0] > divide [1]){
				remainder =  Math.IEEEremainder(divide[0], divide[1]);
				answer = divide[0] / divide[1];
				
			}else if (divide[0] < divide [1]){
				remainder = Math.IEEEremainder(divide[1], divide[0]);
				answer = divide[1] / divide[0];
				
			}
			} catch (ArithmeticException e){
				
			}
		//	System.out.println(answer);
			
			textFieldD[3].setText(String.valueOf(remainder));
			textFieldD[2].setText(String.valueOf(answer));
		}catch (NullPointerException e ){
			
		}
		
	}
	
	
	public static void employeePayWhile(){
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


