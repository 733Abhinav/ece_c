package SING_UP;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class SING_UP {

	private JFrame frame;
	private JTextField t1;
	private JPasswordField p1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SING_UP window = new SING_UP();
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
	public SING_UP() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.CYAN);
		frame.setBounds(100, 100, 628, 492);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("SING UP");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblNewLabel.setBounds(222, 79, 180, 33);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("SET USER NAME ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_1.setBounds(75, 152, 194, 53);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("SET PASSWORD ");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_1_1.setBounds(75, 216, 194, 53);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		t1 = new JTextField();
		t1.setBounds(316, 161, 221, 33);
		frame.getContentPane().add(t1);
		t1.setColumns(10);
		
		p1 = new JPasswordField();
		p1.setBounds(316, 232, 221, 26);
		frame.getContentPane().add(p1);
		
		JButton btnNewButton = new JButton("SIGNUP");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String u=t1.getText();
				String p=p1.getText();
				try {
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/abhi","root","mrec");
					String q="insert into sign values('"+u+"','"+p+"')";
					Statement sta=con.createStatement();
					sta.execute(q);
					con.close();
					JOptionPane.showMessageDialog(btnNewButton, "done signup");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnNewButton.setBounds(219, 292, 147, 61);
		frame.getContentPane().add(btnNewButton);
	}
}
