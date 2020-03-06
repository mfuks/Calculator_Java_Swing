package calculator;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Calculator implements ActionListener{

	private JFrame frame;
	JTextField t1;
	JButton b1;
	JButton b2;
	JButton b3;
	JButton b4;
	JButton b5;
	JButton b6;
	JButton b7;
	JButton b8;
	JButton b9;
	JButton b0;
	JButton bplus;
	JButton bmin;
	JButton bmult;
	JButton bdiv;
	JButton bdot;
	JButton brow;
	JButton bC;

	/** Launch the application.**/
	
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					Calculator window = new Calculator();
					window.frame.setVisible(true);
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**Create the application.**/
	
	public Calculator() 
	{
		frame = new JFrame();
		frame.setFont(new Font("AnjaliOldLipi", Font.PLAIN, 12));
		frame.setBounds(100, 100, 245, 245);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("Calculator");
		frame.setLocationRelativeTo(null);
		
		t1 = new JTextField();
		t1.setHorizontalAlignment(SwingConstants.RIGHT);
		t1.setBounds(13, 12, 149, 25);
		frame.getContentPane().add(t1);
		t1.setColumns(10);
		t1.addKeyListener(new KeyAdapter() 
		{
			@Override
			public void keyReleased(KeyEvent e) 
			{
				try
				{
					t1.setText(t1.getText().substring(0, (t1.getText().length() - 1)));  //blocking keyboard input
				}
				catch(Exception e4)
				{
					
				}
			}
		});
		
		b1 = new JButton("1");
		b1.setBounds(12, 49, 45, 25);
		frame.getContentPane().add(b1);
		b1.addActionListener(this);
		
		b2 = new JButton("2");
		b2.setBounds(66, 49, 45, 25);
		frame.getContentPane().add(b2);
		b2.addActionListener(this);
		
		b3 = new JButton("3");
		b3.setBounds(120, 49, 45, 25);
		frame.getContentPane().add(b3);
		b3.addActionListener(this);
		
		b4 = new JButton("4");
		b4.setBounds(12, 86, 45, 25);
		frame.getContentPane().add(b4);
		b4.addActionListener(this);
		
		b5 = new JButton("5");
		b5.setBounds(66, 86, 45, 25);
		frame.getContentPane().add(b5);
		b5.addActionListener(this);
		
		b6 = new JButton("6");
		b6.setBounds(120, 86, 45, 25);
		frame.getContentPane().add(b6);
		b6.addActionListener(this);
		
		b7 = new JButton("7");
		b7.setBounds(13, 123, 45, 25);
		frame.getContentPane().add(b7);
		b7.addActionListener(this);
		
		b8 = new JButton("8");
		b8.setBounds(66, 123, 45, 25);
		frame.getContentPane().add(b8);
		b8.addActionListener(this);
		
		b9 = new JButton("9");
		b9.setBounds(120, 123, 45, 25);
		frame.getContentPane().add(b9);
		b9.addActionListener(this);
		
		bC = new JButton("C");
		bC.setBounds(13, 161, 45, 24);
		frame.getContentPane().add(bC);
		bC.addActionListener(this);
		
		b0 = new JButton("0");
		b0.setBounds(66, 161, 45, 25);
		frame.getContentPane().add(b0);
		b0.addActionListener(this);
		
		bplus = new JButton("+");
		bplus.setBounds(174, 49, 45, 25);
		frame.getContentPane().add(bplus);
		bplus.addActionListener(this);
		
		bmin = new JButton("-");
		bmin.setBounds(174, 86, 45, 25);
		frame.getContentPane().add(bmin);
		bmin.addActionListener(this);
		
		bmult = new JButton("*");
		bmult.setBounds(174, 123, 45, 25);
		frame.getContentPane().add(bmult);
		bmult.addActionListener(this);
		
		bdiv = new JButton("/");
		bdiv.setBounds(174, 160, 45, 25);
		frame.getContentPane().add(bdiv);
		bdiv.addActionListener(this);
		
		brow = new JButton("=");
		brow.setBounds(174, 12, 45, 25);
		frame.getContentPane().add(brow);
		brow.addActionListener(this);
		
		bdot = new JButton(".");
		bdot.setBounds(120, 161, 45, 24);
		frame.getContentPane().add(bdot);
		bdot.addActionListener(this);
	}
	
	double x = 0;
	double buf = 0;
	String sign = "";
	int counterDot = 0;
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		Object target = e.getSource();
		
		if(target == b1 || target == b2 || target == b3 || target == b4 || target == b5 || 
		   target == b6 || target == b7 || target == b8 || target == b9 || target == b0)
		{
			t1.setText(t1.getText() + ((JButton)target).getText());
			t1.requestFocus();	
		}
		
		else if(target == bdot)
		{
			for (int i = 0; i < t1.getText().length(); i++) //checking the number of dots
		      {
		          if(t1.getText().charAt(i) == '.') 
		          {           
		              counterDot++;
	              }
		      } 
			
			if(counterDot == 0)
			{
				 t1.setText(t1.getText() + ((JButton)target).getText());
	             t1.requestFocus();
	             counterDot = 1;
			}
			else if(t1.getText() == "")
			{
				 t1.setText("0" + t1.getText() + ((JButton)target).getText());
	             t1.requestFocus();
	             counterDot = 1;
			}
		}
		
		else if(target == bplus || target == bmin || target == bmult || target == bdiv)
		{
			try
			{
				buf = Double.parseDouble(t1.getText());
				t1.setText("");
				t1.requestFocus();
				counterDot = 0;
				
				if(target == bplus)
				{
					sign = "+";
				}
				else if(target == bmin)
				{
					sign = "-";
				}
				else if(target == bmult)
				{
					sign = "*";
				}
				else if(target == bdiv)
				{
					sign = "/";
				}
			}
			catch(Exception e1)
			{
				System.out.println("invalid value");;
			}
		}
		
		else if(target == brow || target == t1)
		{
			try
			{
				x = Double.parseDouble(t1.getText());
				
				if(sign == "+")
				{
					x = buf + x;
				}
				else if(sign == "-")
				{
					x = buf - x;
				}
				else if(sign == "*")
				{
					x = buf * x;
				}
				else if(sign == "/")
				{
					if(buf == 0)
					{
						Error error = new Error();
						error.setVisible(true);
						
						t1.setText("");
					}
					else
					{
						x = buf / x;
						t1.setText(Double.toString(x));
					}
				}

				if(sign == "+" || sign == "-" || sign == "*")
				{
					t1.setText(Double.toString(x));
				}
				
				t1.requestFocus();
				counterDot = 1;
				sign = "";
			}
			catch(Exception e1)
			{
				System.out.println("invalid value");;
			}
		}
		
		else if(target == bC)
		{
			x = 0;
			buf = 0;
			t1.setText("");
			counterDot = 0;
		}
		
	}
}
