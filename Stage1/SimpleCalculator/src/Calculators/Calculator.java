package Calculators;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Calculator {

	private JFrame frame;
	private JTextField txtDisplay;
	
	double FirstNum;
	double SecNum;
	String operations;
	double result;
	String answer;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calculator window = new Calculator();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Calculator() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 322, 339);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		txtDisplay = new JTextField();
		txtDisplay.setBounds(10, 10, 277, 54);
		frame.getContentPane().add(txtDisplay);
		txtDisplay.setColumns(10);
		
		JButton btn7 = new JButton("7");
		btn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			String EnterNumber = txtDisplay.getText() + btn7.getText(); // getting numbers 
			txtDisplay.setText(EnterNumber);                           //into our text field
			}
		});
		btn7.setFont(new Font("ËÎÌå", Font.BOLD, 17));
		btn7.setBounds(10, 74, 45, 45);
		frame.getContentPane().add(btn7);
		
		JButton btn8 = new JButton("8");
		btn8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String EnterNumber = txtDisplay.getText() + btn8.getText();
				txtDisplay.setText(EnterNumber);
			}
		});
		btn8.setFont(new Font("ËÎÌå", Font.BOLD, 16));
		btn8.setBounds(65, 74, 45, 45);
		frame.getContentPane().add(btn8);
		
		JButton btn9 = new JButton("9");
		btn9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String EnterNumber = txtDisplay.getText() + btn9.getText();
				txtDisplay.setText(EnterNumber);
			}
		});
		btn9.setFont(new Font("ËÎÌå", Font.BOLD, 17));
		btn9.setBounds(120, 74, 45, 45);
		frame.getContentPane().add(btn9);
		
		JButton btn4 = new JButton("4");
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String EnterNumber = txtDisplay.getText() + btn4.getText();
				txtDisplay.setText(EnterNumber);
			}
		});
		btn4.setFont(new Font("ËÎÌå", Font.BOLD, 17));
		btn4.setBounds(10, 129, 45, 45);
		frame.getContentPane().add(btn4);
		
		
		
		JButton btn5 = new JButton("5");
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String EnterNumber = txtDisplay.getText() + btn5.getText();
				txtDisplay.setText(EnterNumber);
			}
		});
		btn5.setFont(new Font("ËÎÌå", Font.BOLD, 17));
		btn5.setBounds(65, 129, 45, 45);
		frame.getContentPane().add(btn5);
		
		JButton btn6 = new JButton("6");
		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String EnterNumber = txtDisplay.getText() + btn6.getText();
				txtDisplay.setText(EnterNumber);
			}
		});
		btn6.setFont(new Font("ËÎÌå", Font.BOLD, 17));
		btn6.setBounds(120, 129, 45, 45);
		frame.getContentPane().add(btn6);
		
		JButton btn1 = new JButton("1");
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String EnterNumber = txtDisplay.getText() + btn1.getText();
				txtDisplay.setText(EnterNumber);
			}
		});
		btn1.setFont(new Font("ËÎÌå", Font.BOLD, 17));
		btn1.setBounds(10, 184, 45, 45);
		frame.getContentPane().add(btn1);
		
		JButton btn2 = new JButton("2");
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String EnterNumber = txtDisplay.getText() + btn2.getText();
				txtDisplay.setText(EnterNumber);
			}
		});
		btn2.setFont(new Font("ËÎÌå", Font.BOLD, 17));
		btn2.setBounds(65, 184, 45, 45);
		frame.getContentPane().add(btn2);
		
		JButton btn3 = new JButton("3");
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String EnterNumber = txtDisplay.getText() + btn3.getText();
				txtDisplay.setText(EnterNumber);
			}
		});
		btn3.setFont(new Font("ËÎÌå", Font.BOLD, 17));
		btn3.setBounds(120, 184, 45, 45);
		frame.getContentPane().add(btn3);
		
		JButton btn0 = new JButton("0");
		btn0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String EnterNumber = txtDisplay.getText() + btn0.getText();
				txtDisplay.setText(EnterNumber);
			}
		});
		btn0.setFont(new Font("ËÎÌå", Font.BOLD, 17));
		btn0.setBounds(10, 239, 100, 45);
		frame.getContentPane().add(btn0);
		
		JButton btnClear = new JButton("C");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtDisplay.setText(null);
			}});
		btnClear.setFont(new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 17));
		btnClear.setBounds(120, 239, 45, 45);
		frame.getContentPane().add(btnClear);
		
		JButton btnPlus = new JButton("+");
		btnPlus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FirstNum = Double.parseDouble(txtDisplay.getText());
				txtDisplay.setText("");
				operations = "+";
			}
		});
		btnPlus.setFont(new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 16));
		btnPlus.setBounds(175, 74, 57, 63);
		frame.getContentPane().add(btnPlus);
		
		JButton btnMinus = new JButton("-");
		btnMinus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FirstNum = Double.parseDouble(txtDisplay.getText());
				txtDisplay.setText("");
				operations = "-";
			}
		});
		btnMinus.setFont(new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 17));
		btnMinus.setBounds(242, 74, 54, 63);
		frame.getContentPane().add(btnMinus);
		
		JButton btnMultiplication = new JButton("x");
		btnMultiplication.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FirstNum = Double.parseDouble(txtDisplay.getText());
				txtDisplay.setText("");
				operations = "x";
			}
		});
		btnMultiplication.setFont(new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 17));
		btnMultiplication.setBounds(175, 147, 57, 63);
		frame.getContentPane().add(btnMultiplication);
		
		JButton btnDivision = new JButton("/");
		btnDivision.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FirstNum = Double.parseDouble(txtDisplay.getText());
				txtDisplay.setText("");
				operations = "/";
			}
		});
		btnDivision.setFont(new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 17));
		btnDivision.setBounds(242, 147, 54, 63);
		frame.getContentPane().add(btnDivision);
		
		JButton btnEquality = new JButton("=");
		btnEquality.setFont(new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 17));
		btnEquality.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String answer;
				SecNum = Double.parseDouble(txtDisplay.getText());
				if(operations == "+")
				{
					result = FirstNum + SecNum;
					answer = String.format("%.2f",result);
					txtDisplay.setText(answer);
				}
				else if (operations == "-")
				{
					result = FirstNum - SecNum;
					answer = String.format("%.2f",result);
					txtDisplay.setText(answer);
				}else if(operations == "x")
				{
					result = FirstNum * SecNum;
					answer = String.format("%.2f",result);
					txtDisplay.setText(answer);
				}else if(operations == "/")
				{
					result = FirstNum / SecNum;
					answer = String.format("%.2f",result);
					txtDisplay.setText(answer);
				}
			}
		});
		btnEquality.setBounds(175, 221, 121, 63);
		frame.getContentPane().add(btnEquality);
	}
}
