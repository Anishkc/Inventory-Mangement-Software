package com.creativeInfotechSolution.view;



import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.creativeInfotechSolution.model.User;
import com.creativeInfotechSolution.service.UserService;
import com.creativeInfotechSolution.service.UserServiceImpl;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SignupForm extends JFrame {

	private JPanel contentPane;
	private JLabel lblUsername;
	private JTextField txtusername;
	private JLabel lblPassword;
	private JTextField txtpassword;
	private JLabel lblNewLabel;
	private JTextField txtfname;
	private JLabel lblLastname;
	private JTextField txtlname;
	private JLabel lblEmail;
	private JTextField txtemail;
	private JLabel lblAddress;
	private JTextField txtaddress;
	private JLabel lblPhone;
	private JTextField txtphn;
	private JLabel lblCountry;
	private JTextField txtcountry;
	private JButton btnSave;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					SignupForm frame = new SignupForm();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public SignupForm() {
		setTitle("Sign up");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 541, 438);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblUsername());
		contentPane.add(getTxtusername());
		contentPane.add(getLblPassword());
		contentPane.add(getTxtpassword());
		contentPane.add(getLblNewLabel());
		contentPane.add(getTxtfname());
		contentPane.add(getLblLastname());
		contentPane.add(getTxtlname());
		contentPane.add(getLblEmail());
		contentPane.add(getTxtemail());
		contentPane.add(getLblAddress());
		contentPane.add(getTxtaddress());
		contentPane.add(getLblPhone());
		contentPane.add(getTxtphn());
		contentPane.add(getLblCountry());
		contentPane.add(getTxtcountry());
		contentPane.add(getBtnSave());
	}
	private JLabel getLblUsername() {
		if (lblUsername == null) {
			lblUsername = new JLabel("Username");
			lblUsername.setBounds(34, 37, 71, 30);
		}
		return lblUsername;
	}
	private JTextField getTxtusername() {
		if (txtusername == null) {
			txtusername = new JTextField();
			txtusername.setBounds(99, 38, 132, 30);
			txtusername.setColumns(10);
		}
		return txtusername;
	}
	private JLabel getLblPassword() {
		if (lblPassword == null) {
			lblPassword = new JLabel("password");
			lblPassword.setBounds(259, 43, 86, 19);
		}
		return lblPassword;
	}
	private JTextField getTxtpassword() {
		if (txtpassword == null) {
			txtpassword = new JTextField();
			txtpassword.setBounds(314, 38, 123, 30);
			txtpassword.setColumns(10);
		}
		return txtpassword;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("firstname");
			lblNewLabel.setBounds(35, 106, 70, 30);
		}
		return lblNewLabel;
	}
	private JTextField getTxtfname() {
		if (txtfname == null) {
			txtfname = new JTextField();
			txtfname.setBounds(99, 106, 132, 30);
			txtfname.setColumns(10);
		}
		return txtfname;
	}
	private JLabel getLblLastname() {
		if (lblLastname == null) {
			lblLastname = new JLabel("lastname");
			lblLastname.setBounds(259, 114, 71, 14);
		}
		return lblLastname;
	}
	private JTextField getTxtlname() {
		if (txtlname == null) {
			txtlname = new JTextField();
			txtlname.setBounds(314, 106, 123, 30);
			txtlname.setColumns(10);
		}
		return txtlname;
	}
	private JLabel getLblEmail() {
		if (lblEmail == null) {
			lblEmail = new JLabel("Email");
			lblEmail.setBounds(34, 173, 71, 30);
		}
		return lblEmail;
	}
	private JTextField getTxtemail() {
		if (txtemail == null) {
			txtemail = new JTextField();
			txtemail.setBounds(99, 173, 132, 30);
			txtemail.setColumns(10);
		}
		return txtemail;
	}
	private JLabel getLblAddress() {
		if (lblAddress == null) {
			lblAddress = new JLabel("Address");
			lblAddress.setBounds(259, 179, 71, 19);
		}
		return lblAddress;
	}
	private JTextField getTxtaddress() {
		if (txtaddress == null) {
			txtaddress = new JTextField();
			txtaddress.setBounds(314, 173, 123, 30);
			txtaddress.setColumns(10);
		}
		return txtaddress;
	}
	private JLabel getLblPhone() {
		if (lblPhone == null) {
			lblPhone = new JLabel("Phone");
			lblPhone.setBounds(34, 229, 71, 30);
		}
		return lblPhone;
	}
	private JTextField getTxtphn() {
		if (txtphn == null) {
			txtphn = new JTextField();
			txtphn.setBounds(99, 234, 132, 30);
			txtphn.setColumns(10);
		}
		return txtphn;
	}
	private JLabel getLblCountry() {
		if (lblCountry == null) {
			lblCountry = new JLabel("country");
			lblCountry.setBounds(258, 237, 72, 22);
		}
		return lblCountry;
	}
	private JTextField getTxtcountry() {
		if (txtcountry == null) {
			txtcountry = new JTextField();
			txtcountry.setBounds(312, 234, 125, 30);
			txtcountry.setColumns(10);
		}
		return txtcountry;
	}
	private JButton getBtnSave() {
		if (btnSave == null) {
			btnSave = new JButton("Sign Up");
			btnSave.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				
					User u = new User();
					
					u.setUsername(txtusername.getText());
					u.setPassword(txtpassword.getText());
					u.setLname(txtlname.getText());
					u.setFname(txtfname.getText());
					u.setLname(txtlname.getText());
					u.setEmail(txtemail.getText());
					u.setAddress(txtaddress.getText());
					u.setPhone(txtphn.getText());
					u.setCountry(txtcountry.getText());
					
					UserService us = new UserServiceImpl();
					
					if(us.addUser(u)) {
						LoginForm lf = new LoginForm();
						lf.setVisible(true);
					}
					else {
						JOptionPane.showMessageDialog(null, "mistake");
					}
					
				
				}
			});
			btnSave.setBounds(192, 319, 89, 23);
		}
		return btnSave;
	}
}
