package calculator;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Error extends JFrame {

	private JPanel contentPane;

	/**Launch the application.**/
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Error frame = new Error();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**Create the frame.**/
	public Error() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 350, 137);
		setTitle("Error");
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel errorLabel = new JLabel("do not divide by 0!");
		errorLabel.setFont(new Font("Dialog", Font.BOLD, 14));
		errorLabel.setHorizontalAlignment(SwingConstants.CENTER);
		errorLabel.setBounds(34, 37, 285, 15);
		errorLabel.setForeground(Color.red);
		contentPane.add(errorLabel);
	}

}
