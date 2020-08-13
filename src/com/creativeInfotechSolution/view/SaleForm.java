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
import com.creativeInfotechSolution.model.Sale;
import com.creativeInfotechSolution.service.ItemService;
import com.creativeInfotechSolution.service.ItemServiceImpl;
import com.creativeInfotechSolution.service.SaleService;
import com.creativeInfotechSolution.service.SaleServiceImpl;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class SaleForm extends JFrame {

	private JPanel contentPane;
	private JTable table_1;
	private JScrollPane scrollPane_1;
	private JButton btnNewButton;
	private JLabel txtSearch;
	private JTextField textSearch;

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
	public SaleForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 836, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
//		contentPane.add(table);
//		contentPane.add(scrollPane);
//		contentPane.add(getTable_1());
		contentPane.add(getScrollPane_1());
		contentPane.add(getBtnNewButton());
		contentPane.add(getTxtSearch());
		contentPane.add(getTextSearch());
		displaySale();
	}
	
	
	private JTable getTable_1() {
		if (table_1 == null) {
			table_1 = new JTable();
			table_1.setModel(new DefaultTableModel(
					new Object[][] {
					},
					new String[] {
						"id","Date","itemName", "customerName","price", "saleQuantity"
					}
				));
		}
		return table_1;
	}
	void displaySale() {  
		 SaleService ss = new SaleServiceImpl();
		   List<Sale>    slist = ss.getAllSale();
		 
		    DefaultTableModel model =(DefaultTableModel)table_1.getModel();
		    model.setRowCount(0);//reset
		    
		    for( Sale  s :slist) {
		    	model.addRow(new Object[]{s.getId(),s.getDate(),s.getItemName(),s.getCustomerName(),s.getSalesPrice(),s.getSalesQuantity()} );
		    }
		 
	 }
	private JScrollPane getScrollPane_1() {
		if (scrollPane_1 == null) {
			scrollPane_1 = new JScrollPane();
			scrollPane_1.setBounds(28, 93, 766, 301);
			scrollPane_1.setViewportView(getTable_1());
		}
		return scrollPane_1;
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
			btnNewButton.setBounds(253, 410, 104, 40);
		}
		return btnNewButton;
	}
	private JLabel getTxtSearch() {
		if (txtSearch == null) {
			txtSearch = new JLabel("Search");
			txtSearch.setBounds(312, 65, 46, 14);
		}
		return txtSearch;
	}
	private JTextField getTextSearch() {
		if (textSearch == null) {
			textSearch = new JTextField();
			textSearch.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					 String input = textSearch.getText().trim();
					 SaleService ss = new SaleServiceImpl();
					 List<Sale> ilist = ss.searchSale(input);
					 DefaultTableModel model =(DefaultTableModel)table_1.getModel();
					    model.setRowCount(0);//reset
					    
					    for( Sale  s1 :ilist) {
					    	model.addRow(new Object[]{s1.getId(),s1.getDate(),s1.getItemName(),s1.getCustomerName(),s1.getSalesPrice(),s1.getSalesQuantity()} );
					    }
				}
			});
			textSearch.setBounds(148, 62, 132, 20);
			textSearch.setColumns(10);
		}
		return textSearch;
	}
}
