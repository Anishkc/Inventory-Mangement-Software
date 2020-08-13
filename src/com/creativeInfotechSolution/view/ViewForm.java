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
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ViewForm extends JFrame {

	private JPanel contentPane;
	private JTable table_1;
	private JScrollPane scrollPane_1;
	private JButton btnNewButton;
	private JButton btnSoldOut;
	private JLabel lblSearch;
	private JTextField textField;
	private JTextField txtSch;

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
	public ViewForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 664, 410);
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
		//contentPane.add(getTextField());
		contentPane.add(getTxtSch());
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
			scrollPane_1.setBounds(10, 52, 584, 257);
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
			btnNewButton.setBounds(202, 320, 104, 40);
		}
		return btnNewButton;
	}
	private JButton getBtnSoldOut() {
		if (btnSoldOut == null) {
			btnSoldOut = new JButton("Sell");
			btnSoldOut.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(table_1.getSelectedRow()<0) {
						  JOptionPane.showMessageDialog(null, "select any row");
						  return;
					  }
					  
						  int row = table_1.getSelectedRow();
						  int id = (int)table_1.getModel().getValueAt(row,0);
				
						    EditForm ef = new EditForm();
						     ef.setData(id);
						     ef.setVisible(true);
						     
						     dispose();
				}
			});
			btnSoldOut.setBounds(20, 320, 119, 40);
		}
		return btnSoldOut;
	}
	private JLabel getLblSearch() {
		if (lblSearch == null) {
			lblSearch = new JLabel("Search");
			lblSearch.setBounds(300, 16, 46, 30);
		}
		return lblSearch;
	}
	
	private JTextField getTxtSch() {
		if (txtSch == null) {
			txtSch = new JTextField();
			txtSch.addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e) {
					 String input = txtSch.getText().trim();
					 ItemService is = new ItemServiceImpl();
					 List<Item> ilist = is.searchItem(input);
					 DefaultTableModel model =(DefaultTableModel)table_1.getModel();
					    model.setRowCount(0);//reset
					    
					    for( Item e1 :ilist) {
					    	model.addRow(new Object[]{e1.getId(),e1.getItemName(),e1.getPrice(),e1.getItemQuantity()} );
					    }
				}
			});
			txtSch.setBounds(129, 21, 134, 20);
			txtSch.setColumns(10);
		}
		return txtSch;
	}
}
