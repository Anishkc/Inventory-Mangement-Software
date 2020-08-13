package com.creativeInfotechSolution.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


import com.creativeInfotechSolution.model.Item;
import com.creativeInfotechSolution.service.ItemService;
import com.creativeInfotechSolution.service.ItemServiceImpl;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ItemForm extends JFrame {

	private JPanel contentPane;
	private JLabel itemName;
	private JTextField txtItemName;
	private JLabel lblPrice;
	private JTextField txtPrice;
	private JLabel lblQuantity;
	private JTextField txtQty;
	private JButton btnAdd;
	private JScrollPane scrollPane;
	private JTable table;
	private JButton btnEdit;
	private JTextField textSearch;
	private JLabel lblSearch;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					ItemForm frame = new ItemForm();
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
	public ItemForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 771, 448);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getItemName());
		contentPane.add(getTxtItemName());
		contentPane.add(getLabel_1());
		contentPane.add(getTxtPrice());
		contentPane.add(getLabel_2());
		contentPane.add(getTxtQty());
		contentPane.add(getBtnAdd());
		contentPane.add(getScrollPane());
		contentPane.add(getBtnEdit());
		contentPane.add(getTextSearch());
		contentPane.add(getLblSearch());
		displayData();
	}
	private JLabel getItemName() {
		if (itemName == null) {
			itemName = new JLabel("Item Name :");
			itemName.setBounds(34, 49, 102, 30);
		}
		return itemName;
	}
	private JTextField getTxtItemName() {
		if (txtItemName == null) {
			txtItemName = new JTextField();
			txtItemName.setBounds(116, 54, 86, 20);
			txtItemName.setColumns(10);
		}
		return txtItemName;
	}
	private JLabel getLabel_1() {
		if (lblPrice == null) {
			lblPrice = new JLabel("Price :");
			lblPrice.setBounds(35, 106, 71, 30);
		}
		return lblPrice;
	}
	private JTextField getTxtPrice() {
		if (txtPrice == null) {
			txtPrice = new JTextField();
			txtPrice.setBounds(116, 111, 86, 20);
			txtPrice.setColumns(10);
		}
		return txtPrice;
	}
	private JLabel getLabel_2() {
		if (lblQuantity == null) {
			lblQuantity = new JLabel("Quantity :");
			lblQuantity.setBounds(34, 169, 72, 14);
		}
		return lblQuantity;
	}
	private JTextField getTxtQty() {
		if (txtQty == null) {
			txtQty = new JTextField();
			txtQty.setBounds(116, 166, 86, 20);
			txtQty.setColumns(10);
		}
		return txtQty;
	}
	private JButton getBtnAdd() {
		if (btnAdd == null) {
			btnAdd = new JButton("Add");
			btnAdd.setBounds(61, 266, 89, 23);
			btnAdd.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Item item = new  Item();
					
      				item.setItemName(txtItemName.getText());
					item.setPrice(Integer.parseInt(txtPrice.getText()));
					item.setItemQuantity(Integer.parseInt(txtQty.getText()));
					
		    		
					
				ItemService is = new ItemServiceImpl();
				if(is.addItem(item)) {
					JOptionPane.showMessageDialog(null, "added succesfuly");
  				displayData();
				}

				}
			});
		}
		return btnAdd;
	}
	
	private JTable getTable() {
		if (table == null) {
			table = new JTable();
			table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"id","itemName", "price", "itemQuantity"
				}
			));
		}
		return table;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(254, 37, 387, 258);
			scrollPane.setViewportView(getTable());
		}
		return scrollPane;
	}
	
	// display  data in jtable
		 void displayData() {  
			 ItemService es = new ItemServiceImpl();
			   List<Item>    elist = es.getAllItem();
			 
			    DefaultTableModel model =(DefaultTableModel)table.getModel();
			    model.setRowCount(0);//reset
			    
			    for( Item e :elist) {
			    	model.addRow(new Object[]{e.getId(),e.getItemName(),e.getPrice(),e.getItemQuantity()} );
			    }
			 
		 }
	private JButton getBtnEdit() {
		if (btnEdit == null) {
			btnEdit = new JButton("Update");
			btnEdit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(table.getSelectedRow()<0) {
						  JOptionPane.showMessageDialog(null, "select any row");
						  return;
					  }
					  
						  int row = table.getSelectedRow();
						  int id = (int)table.getModel().getValueAt(row,0);
				
						    EditForm ef = new EditForm();
						     ef.setData(id);
						     ef.setVisible(true);
						     
						     dispose();
				}
			});
			btnEdit.setBounds(264, 306, 89, 23);
		}
		return btnEdit;
	}
	
	
	private JTextField getTextSearch() {
		if (textSearch == null) {
			textSearch = new JTextField();
			textSearch.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					 String input = textSearch.getText().trim();
					 ItemService is = new ItemServiceImpl();
					 List<Item> itemlist = is.searchItem(input);
					 DefaultTableModel model =(DefaultTableModel)table.getModel();
					    model.setRowCount(0);//reset
					    
					    for( Item e1 :itemlist) {
					    	model.addRow(new Object[]{e1.getId(),e1.getItemName(),e1.getPrice(),e1.getItemQuantity()} );
					    }
				}
			});
			textSearch.setBounds(316, 12, 135, 20);
			textSearch.setColumns(10);
		}
		return textSearch;
	}
	private JLabel getLblSearch() {
		if (lblSearch == null) {
			lblSearch = new JLabel("Search");
			lblSearch.setBounds(254, 14, 52, 17);
		}
		return lblSearch;
	}
}
