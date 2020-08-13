package com.creativeInfotechSolution.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import com.creativeInfotechSolution.model.Item;
import com.creativeInfotechSolution.model.Sale;
import com.creativeInfotechSolution.service.ItemService;
import com.creativeInfotechSolution.service.ItemServiceImpl;
import com.creativeInfotechSolution.service.SaleService;
import com.creativeInfotechSolution.service.SaleServiceImpl;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.awt.event.ActionEvent;

public class EditFormForStock extends JFrame {

	private JPanel contentPane;
	private JLabel lblItem;
	private JTextField textItem;
	private JLabel lblPrice;
	private JTextField txtPrice;
	private JLabel lblQuantity;
	private JTextField textQuantity;
	private JButton btnEdit;
	private int uid=0;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					EditForm frame = new EditForm();
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
	public EditFormForStock() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 560, 418);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblItem());
		contentPane.add(getTextItem());
		contentPane.add(getLblPrice());
		contentPane.add(getTxtPrice());
		contentPane.add(getLblQuantity());
		contentPane.add(getTextQuantity());
		contentPane.add(getBtnEdit());
	}
	private JLabel getLblItem() {
		if (lblItem == null) {
			lblItem = new JLabel("Item");
			lblItem.setBounds(58, 43, 75, 27);
		}
		return lblItem;
	}
	private JTextField getTextItem() {
		if (textItem == null) {
			textItem = new JTextField();
			textItem.setBounds(195, 46, 86, 20);
			textItem.setColumns(10);
		}
		return textItem;
	}
	private JLabel getLblPrice() {
		if (lblPrice == null) {
			lblPrice = new JLabel("Price");
			lblPrice.setBounds(58, 93, 46, 14);
		}
		return lblPrice;
	}
	private JTextField getTxtPrice() {
		if (txtPrice == null) {
			txtPrice = new JTextField();
			txtPrice.setBounds(195, 90, 86, 20);
			txtPrice.setColumns(10);
		}
		return txtPrice;
	}
	private JLabel getLblQuantity() {
		if (lblQuantity == null) {
			lblQuantity = new JLabel("Quantity");
			lblQuantity.setBounds(58, 140, 46, 14);
		}
		return lblQuantity;
	}
	private JTextField getTextQuantity() {
		if (textQuantity == null) {
			textQuantity = new JTextField();
			textQuantity.setBounds(195, 137, 86, 20);
			textQuantity.setColumns(10);
		}
		return textQuantity;
	}
	private JButton getBtnEdit() {
		if (btnEdit == null) {
			btnEdit = new JButton("Update stock");
			btnEdit.addActionListener(new ActionListener() {
				 public void actionPerformed(ActionEvent e) {
	          Item item = new  Item();
//	          Sale sale = new Sale();
	          
	          
					item.setId(uid);
					item.setItemName(textItem.getText());
					item.setPrice(Integer.parseInt(txtPrice.getText()));
					item.setItemQuantity(Integer.parseInt(textQuantity.getText()));
				
//					sale.setCustomerName(txtCustomer.getText());
//					sale.setSalesPrice(txtPrice.getText());
//					sale.setSalesQuantity(Integer.parseInt(txtSaleNo.getText()));
		   
				ItemService is = new ItemServiceImpl();
//				SaleService ss = new SaleServiceImpl();
				if(is.updateItem(item)) {
					JOptionPane.showMessageDialog(null, "update succesfuly");
					new ViewFormWithStock().setVisible(true);
					dispose();
				}
				}
			});
			btnEdit.setBounds(106, 241, 89, 23);
		}
		return btnEdit;
	}
	
	//set all  data in edit form
		public void  setData(int id){
			uid = id;
			ItemService  is = new ItemServiceImpl();
		    Item item =	is.getById(id);
		    
		    textItem.setText(item.getItemName());
		    txtPrice.setText(String.valueOf(item.getPrice()));
		    textQuantity.setText(String.valueOf(item.getItemQuantity()));
		    
		    
		}
}
