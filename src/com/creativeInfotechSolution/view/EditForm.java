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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class EditForm extends JFrame {

	private JPanel contentPane;
	private JLabel lblItem;
	private JTextField textItem;
	private JLabel lblPrice;
	private JTextField txtPrice;
	private JLabel lblQuantity;
	private JTextField textQuantity;
	private JButton btnEdit;
	private int uid=0;
	private JLabel lblCustomerName;
	private JTextField txtCustomer;
	private JLabel lblSaleNumber;
	private JTextField txtSaleNo;
	private JLabel lblDate;
	private JTextField textDate;
	private JLabel lblEg;

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
	public EditForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 692, 501);
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
		contentPane.add(getLblCustomerName());
		contentPane.add(getTxtCustomer());
		contentPane.add(getLblSaleNumber());
		contentPane.add(getTxtSaleNo());
		contentPane.add(getLblDate());
		contentPane.add(getTextDate());
		contentPane.add(getLblEg());
	}
	private JLabel getLblItem() {
		if (lblItem == null) {
			lblItem = new JLabel("Item");
			lblItem.setBounds(154, 87, 75, 27);
		}
		return lblItem;
	}
	private JTextField getTextItem() {
		if (textItem == null) {
			textItem = new JTextField();
			textItem.setEditable(false);
			textItem.setBounds(359, 81, 139, 39);
			textItem.setColumns(10);
		}
		return textItem;
	}
	private JLabel getLblPrice() {
		if (lblPrice == null) {
			lblPrice = new JLabel("Price");
			lblPrice.setBounds(154, 290, 72, 35);
		}
		return lblPrice;
	}
	private JTextField getTxtPrice() {
		if (txtPrice == null) {
			txtPrice = new JTextField();
			txtPrice.setBounds(359, 290, 139, 35);
			txtPrice.setColumns(10);
		}
		return txtPrice;
	}
	private JLabel getLblQuantity() {
		if (lblQuantity == null) {
			lblQuantity = new JLabel("Quantity");
			lblQuantity.setBounds(151, 160, 75, 26);
		}
		return lblQuantity;
	}
	private JTextField getTextQuantity() {
		if (textQuantity == null) {
			textQuantity = new JTextField();
			textQuantity.setBounds(359, 154, 139, 38);
			textQuantity.setColumns(10);
		}
		return textQuantity;
	}
	private JButton getBtnEdit() {
		if (btnEdit == null) {
			btnEdit = new JButton("Sell");
			btnEdit.addActionListener(new ActionListener() {
				 public void actionPerformed(ActionEvent e) {
	          Item item = new  Item();
	          Sale sale = new Sale();          
					item.setId(uid);
//					item.setItemName(textItem.getText());
			//		item.setPrice(Integer.parseInt(txtPrice.getText()));
//					int updatedItemQty = Integer.parseInt(textQuantity.getText())
//					-Integer.parseInt(txtSaleNo.getText());
					item.setItemQuantity(Integer.parseInt(textQuantity.getText()));
				
					sale.setDate(textDate.getText());
					sale.setItemName(textItem.getText());
					sale.setCustomerName(txtCustomer.getText());
					sale.setSalesPrice(txtPrice.getText());
					sale.setSalesQuantity(Integer.parseInt(txtSaleNo.getText()));
		   
				ItemService is = new ItemServiceImpl();
				SaleService ss = new SaleServiceImpl();
				if(is.updateItemQuantity(item)&& ss.addSale(sale)) {
					JOptionPane.showMessageDialog(null, "update succesfuly");
					new ViewForm().setVisible(true);
					dispose();
				}
				}
			});
			btnEdit.setBounds(257, 428, 89, 23);
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
	private JLabel getLblCustomerName() {
		if (lblCustomerName == null) {
			lblCustomerName = new JLabel("Customer name");
			lblCustomerName.setBounds(151, 233, 116, 20);
		}
		return lblCustomerName;
	}
	private JTextField getTxtCustomer() {
		if (txtCustomer == null) {
			txtCustomer = new JTextField();
			txtCustomer.setBounds(359, 226, 139, 35);
			txtCustomer.setColumns(10);
		}
		return txtCustomer;
	}
	private JLabel getLblSaleNumber() {
		if (lblSaleNumber == null) {
			lblSaleNumber = new JLabel("Sale quantity");
			lblSaleNumber.setBounds(151, 358, 89, 35);
		}
		return lblSaleNumber;
	}
	private JTextField getTxtSaleNo() {
		if (txtSaleNo == null) {
			txtSaleNo = new JTextField();
			txtSaleNo.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {				
					ItemService  is = new ItemServiceImpl();
				    Item item =	is.getById(uid);				    
				    int updatedItemQty =  item.getItemQuantity()- Integer.parseInt(txtSaleNo.getText());
				    
				   if(updatedItemQty > 0) { 
				    textQuantity.setText(String.valueOf(updatedItemQty));
				   }
				   else {
					   txtSaleNo.setText(null);
					   textQuantity.setText(String.valueOf(item.getItemQuantity()));
						JOptionPane.showMessageDialog(null, "out of stock");
						  return;   
				   }
				}
			});
			txtSaleNo.setBounds(359, 358, 139, 35);
			txtSaleNo.setColumns(10);
		}
		return txtSaleNo;
	}
	private JLabel getLblDate() {
		if (lblDate == null) {
			lblDate = new JLabel("Date");
			lblDate.setBounds(154, 32, 46, 14);
		}
		return lblDate;
	}
	private JTextField getTextDate() {
		if (textDate == null) {
			textDate = new JTextField();
			textDate.setBounds(359, 20, 139, 39);
			textDate.setColumns(10);
		}
		return textDate;
	}
	private JLabel getLblEg() {
		if (lblEg == null) {
			lblEg = new JLabel("eg : 2072/03/27");
			lblEg.setBounds(508, 20, 114, 39);
		}
		return lblEg;
	}
}
