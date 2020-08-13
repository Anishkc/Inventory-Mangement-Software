package com.creativeInfotechSolution.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.creativeInfotechSolution.model.Item;
import com.creativeInfotechSolution.service.ItemService;
import com.creativeInfotechSolution.service.ItemServiceImpl;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Dimension;

public class ToDoList extends JFrame {

	private JPanel contentPane;
	private JButton btnAddItem;
	private JButton btnViewTem;
	private JButton btnSales;
	private JButton btnNewSale;
	private JLabel lblStock;
	private JLabel lblSale;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ToDoList frame = new ToDoList();
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
	public ToDoList() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 706, 458);
		contentPane = new JPanel();
		contentPane.setFont(new Font("Verdana", Font.PLAIN, 10));
		contentPane.setSize(new Dimension(6, 6));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getBtnAddItem());
		contentPane.add(getBtnViewTem());
		contentPane.add(getBtnSales());
		contentPane.add(getBtnNewSale());
		contentPane.add(getLblStock());
		contentPane.add(getLblSale());
	}
	private JButton getBtnAddItem() {
		if (btnAddItem == null) {
			btnAddItem = new JButton("go.   d.n ");
		    btnAddItem.setFont(new Font("Preeti", Font.PLAIN, 19));
			btnAddItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				AddItemForm additemform = new AddItemForm();
				additemform.setVisible(true);
				}
			});
			btnAddItem.setBounds(69, 120, 202, 52);
		}
		return btnAddItem;
	}
	private JButton getBtnViewTem() {
		if (btnViewTem == null) {
			btnViewTem = new JButton("View Stock");
			btnViewTem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ViewFormWithStock viewForm = new ViewFormWithStock();
					viewForm.setVisible(true);
				}
			});
			btnViewTem.setBounds(69, 218, 202, 52);
		}
		return btnViewTem;
	}
	private JButton getBtnSales() {
		if (btnSales == null) {
			btnSales = new JButton("Sales History");
			btnSales.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					SaleForm sf = new SaleForm();
					sf.setVisible(true);
				}
			});
			btnSales.setBounds(421, 218, 202, 49);
		}
		return btnSales;
	}
	private JButton getBtnNewSale() {
		if (btnNewSale == null) {
			btnNewSale = new JButton("New Sale");
			btnNewSale.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ViewForm vf =  new ViewForm();
					vf.setVisible(true);
				}
			});
			btnNewSale.setBounds(421, 120, 202, 52);
		}
		return btnNewSale;
	}
	private JLabel getLblStock() {
		if (lblStock == null) {
			lblStock = new JLabel("Stock");
			lblStock.setFont(new Font("Verdana", Font.PLAIN, 22));
			lblStock.setPreferredSize(new Dimension(2399, 3499));
			lblStock.setMaximumSize(new Dimension(238, 214));
			lblStock.setBounds(69, 52, 202, 79);
		}
		return lblStock;
	}
	private JLabel getLblSale() {
		if (lblSale == null) {
			lblSale = new JLabel("Sale\r\n");
			lblSale.setFont(new Font("Arial Black", Font.PLAIN, 22));
			lblSale.setPreferredSize(new Dimension(2200, 2199));
			lblSale.setBounds(421, 64, 141, 57);
		}
		return lblSale;
	}
}
