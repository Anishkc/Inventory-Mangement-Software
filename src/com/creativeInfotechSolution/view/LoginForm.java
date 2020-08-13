package com.creativeInfotechSolution.view;



import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class LoginForm extends JFrame {

	private JPanel contentPane;
	private JLabel lblUsername;
	private JTextField txtusername;
	private JLabel lblPassword;
	private JPasswordField txtpassword;
	private JButton btnLogin;
	private JButton btnSignUp;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginForm frame = new LoginForm();
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
	public LoginForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblUsername());
		contentPane.add(getTxtusername());
		contentPane.add(getLblPassword());
		contentPane.add(getTxtpassword());
		contentPane.add(getBtnLogin());
		contentPane.add(getBtnSignUp());
	}
	private JLabel getLblUsername() {
		if (lblUsername == null) {
			lblUsername = new JLabel("Username");
			lblUsername.setBounds(59, 75, 107, 20);
		}
		return lblUsername;
	}
	private JTextField getTxtusername() {
		if (txtusername == null) {
			txtusername = new JTextField();
			txtusername.setBounds(162, 72, 118, 20);
			txtusername.setColumns(10);
		}
		return txtusername;
	}
	private JLabel getLblPassword() {
		if (lblPassword == null) {
			lblPassword = new JLabel("password");
			lblPassword.setBounds(59, 133, 96, 25);
		}
		return lblPassword;
	}
	private JPasswordField getTxtpassword() {
		if (txtpassword == null) {
			txtpassword = new JPasswordField();
			txtpassword.setBounds(162, 135, 118, 23);
		}
		return txtpassword;
	}
	private JButton getBtnLogin() {
		if (btnLogin == null) {
			btnLogin = new JButton("login");
			btnLogin.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					String un = txtusername.getText();
					String pwd = txtpassword.getText();
					
					
					
 try {
	Connection  con = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventorydb","root","");
	String sql = "select * from  user where username='"+un+"' and password='"+pwd+"'";
    Statement stm = con.createStatement();
    ResultSet rs = stm.executeQuery(sql);
    if(rs.next()) {
//    	ItemForm emo = new ItemForm();
    	ToDoList todolist = new ToDoList();
//		emo.setVisible(true);
    	todolist.setVisible(true);
	}else {
		JOptionPane.showMessageDialog(null, "login failed");
	}
 
 } catch (SQLException e1) {
	// TODO Auto-generated catch block
	e1.printStackTrace();
}
			
					
				}
			});
			btnLogin.setBounds(162, 204, 89, 23);
		}
		return btnLogin;
	}
	private JButton getBtnSignUp() {
		if (btnSignUp == null) {
			btnSignUp = new JButton("Sign Up");
			btnSignUp.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					SignupForm sf = new SignupForm();
					sf.setVisible(true);
				}
			});
			btnSignUp.setBounds(335, 11, 89, 23);
		}
		return btnSignUp;
	}
}
