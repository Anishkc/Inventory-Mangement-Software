package com.creativeInfotechSolution.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;


import com.creativeInfotechSolution.model.Item;
import com.creativeInfotechSolution.service.ItemService;
import com.creativeInfotechSolution.service.ItemServiceImpl;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ViewFormWithStock extends JFrame {

	private JPanel contentPane;
	private JTable table_1;
	private JScrollPane scrollPane_1;
	private JButton btnNewButton;
	private JButton btnSoldOut;
	private JTextField textField;
	private JLabel lblSearch;
	private JTextField txtsearxh;
	private JTextField txtSearch;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewForm frame = new ViewForm();
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
	public ViewFormWithStock() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 773, 511);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
//		contentPane.add(table);
//		contentPane.add(scrollPane);
//		contentPane.add(getTable_1());
		contentPane.add(getScrollPane_1());
		contentPane.add(getBtnNewButton());
		contentPane.add(getBtnSoldOut());
		contentPane.add(getLblSearch());
		contentPane.add(getTxtSearch());
		displayData();
	}
	
	
	private JTable getTable_1() {
		if (table_1 == null) {
			table_1 = new JTable();
			table_1.setModel(new DefaultTableModel(
					new Object[][] {
					},
					new String[] {
						"id","itemName", "price", "itemQuantity"
					}
				));
		}
		return table_1;
	}
	private JScrollPane getScrollPane_1() {
		if (scrollPane_1 == null) {
			scrollPane_1 = new JScrollPane();
			scrollPane_1.setBounds(0, 81, 592, 363);
			scrollPane_1.setViewportView(getTable_1());
		}
		return scrollPane_1;
	}
	
	void displayData() {  
		 ItemService es = new ItemServiceImpl();
		   List<Item>    elist = es.getAllItem();
		 
		    DefaultTableModel model =(DefaultTableModel)table_1.getModel();
		    model.setRowCount(0);//reset
		    
		    for( Item e :elist) {
		    	model.addRow(new Object[]{e.getId(),e.getItemName(),e.getPrice(),e.getItemQuantity()} );
		    }
		 
	 }
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("Back");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					ToDoList todolist = new ToDoList();
					todolist.setVisible(true);
				}
			});
			btnNewButton.setBounds(602, 271, 104, 40);
		}
		return btnNewButton;
	}
	private JButton getBtnSoldOut() {
		if (btnSoldOut == null) {
			btnSoldOut = new JButton("update Item");
			btnSoldOut.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(table_1.getSelectedRow()<0) {
						  JOptionPane.showMessageDialog(null, "select any row");
						  return;
					  }
					  
						  int row = table_1.getSelectedRow();
						  int id = (int)table_1.getModel().getValueAt(row,0);
				
						    EditFormForStock effs = new EditFormForStock();
						     effs.setData(id);
						     effs.setVisible(true);
						     
						     dispose();
				}
			});
			btnSoldOut.setBounds(602, 179, 119, 40);
		}
		return btnSoldOut;
	}

	private JLabel getLblSearch() {
		if (lblSearch == null) {
			lblSearch = new JLabel("Search");
			lblSearch.setBounds(306, 53, 46, 14);
		}
		return lblSearch;
	}
	private JTextField getTxtSearch() {
		if (txtSearch == null) {
			txtSearch = new JTextField();
			txtSearch.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					 String input = txtSearch.getText().trim();
					 ItemService is = new ItemServiceImpl();
					 List<Item> ilist = is.searchItem(input);
					 DefaultTableModel model =(DefaultTableModel)table_1.getModel();
					    model.setRowCount(0);//reset
					    
					    for( Item e1 :ilist) {
					    	model.addRow(new Object[]{e1.getId(),e1.getItemName(),e1.getPrice(),e1.getItemQuantity()} );
					    }
				}
			});
			txtSearch.setBounds(129, 50, 119, 20);
			txtSearch.setColumns(10);
		}
		return txtSearch;
	}
}
