package com.creativeInfotechSolution.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.creativeInfotechSolution.model.Item;
import com.creativeInfotechSolution.service.ItemService;
import com.creativeInfotechSolution.service.ItemServiceImpl;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddItemForm extends JFrame {

	private JPanel contentPane;
	private JLabel lblItem;
	private JTextField txtItemName;
	private JLabel lblPrice;
	private JTextField txtPrice;
	private JLabel lblQuantity;
	private JTextField txtQty;
	private JButton btnInsert;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddItemForm frame = new AddItemForm();
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
	public AddItemForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 470, 324);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblItem());
		contentPane.add(getTxtItemName());
		contentPane.add(getLblPrice());
		contentPane.add(getTxtPrice());
		contentPane.add(getLblQuantity());
		contentPane.add(getTxtQty());
		contentPane.add(getBtnInsert());
	}

	private JLabel getLblItem() {
		if (lblItem == null) {
			lblItem = new JLabel("Item name");
			lblItem.setBounds(71, 35, 84, 37);
		}
		return lblItem;
	}
	private JTextField getTxtItemName() {
		if (txtItemName == null) {
			txtItemName = new JTextField();
			txtItemName.setBounds(165, 36, 132, 34);
			txtItemName.setColumns(10);
		}
		return txtItemName;
	}
	private JLabel getLblPrice() {
		if (lblPrice == null) {
			lblPrice = new JLabel("Price");
			lblPrice.setBounds(71, 93, 70, 25);
		}
		return lblPrice;
	}
	private JTextField getTxtPrice() {
		if (txtPrice == null) {
			txtPrice = new JTextField();
			txtPrice.setBounds(165, 87, 132, 37);
			txtPrice.setColumns(10);
		}
		return txtPrice;
	}
	private JLabel getLblQuantity() {
		if (lblQuantity == null) {
			lblQuantity = new JLabel("Quantity");
			lblQuantity.setBounds(71, 155, 46, 14);
		}
		return lblQuantity;
	}
	private JTextField getTxtQty() {
		if (txtQty == null) {
			txtQty = new JTextField();
			txtQty.setBounds(165, 144, 132, 37);
			txtQty.setColumns(10);
		}
		return txtQty;
	}
	private JButton getBtnInsert() {
		if (btnInsert == null) {
			btnInsert = new JButton("Add Item");
			btnInsert.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
		Item item = new  Item();
					
      				item.setItemName(txtItemName.getText());
					item.setPrice(Integer.parseInt(txtPrice.getText()));
					item.setItemQuantity(Integer.parseInt(txtQty.getText()));
					
		    		
					
				ItemService is = new ItemServiceImpl();
				if(is.addItem(item)) {
					JOptionPane.showMessageDialog(null, "added succesfuly");
//  				displayData();
					ToDoList toDoList = new ToDoList();
					toDoList.setVisible(true);
				}
				}
			});
			btnInsert.setBounds(165, 228, 113, 33);
		}
		return btnInsert;
	}
}
