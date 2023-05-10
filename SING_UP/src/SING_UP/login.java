package SING_UP;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class login {

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
					login window = new login();
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
	public login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.CYAN);
		frame.setBounds(100, 100, 634, 488);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("LOGIN");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblNewLabel.setBounds(231, 70, 160, 90);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ENTER USERNAME");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_1.setBounds(47, 191, 214, 41);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("ENTER PASSWORD");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_1_1.setBounds(47, 260, 232, 41);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		t1 = new JTextField();
		t1.setBounds(327, 192, 214, 35);
		frame.getContentPane().add(t1);
		t1.setColumns(10);
		
		p1 = new JPasswordField();
		p1.setBounds(327, 260, 214, 29);
		frame.getContentPane().add(p1);
		
		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String user=t1.getText();
				String pass=p1.getText();
				try {
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/abhi","root","mrec");
					String q="select count(*) from sign where username=? and password=?";
					PreparedStatement ps=con.prepareStatement(q);
					ps.setString(1, user);
					ps.setString(2, pass);
					ResultSet rs=ps.executeQuery();
					rs.next();
					int c=rs.getInt(1);
					if(c==0)
					{
						JOptionPane.showMessageDialog(btnNewButton, "invalid");
					}
					else
					{
						JOptionPane.showMessageDialog(btnNewButton, "done");
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnNewButton.setBounds(240, 327, 151, 61);
		frame.getContentPane().add(btnNewButton);
	}

}
