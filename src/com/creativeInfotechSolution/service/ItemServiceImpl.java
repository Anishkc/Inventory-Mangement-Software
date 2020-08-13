package com.creativeInfotechSolution.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import com.creativeInfotechSolution.db.DB;
import com.creativeInfotechSolution.model.Item;

public class ItemServiceImpl implements ItemService {

	Connection con = null;
	
	 public ItemServiceImpl() {
		con = DB.getDb();
	}
	
	@Override
	public boolean addItem(Item item) {
		String sql ="insert into item(itemName ,price,itemQuantity)values(?,?,?)";
		try {
			PreparedStatement pstm = con.prepareStatement(sql);
			pstm.setString(1,item.getItemName());
			pstm.setInt(2,item.getPrice());
			pstm.setInt(3,item.getItemQuantity()); 
			
			pstm.execute();
			return true ;
		} catch (SQLException e) {
			 
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteItem(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateItemQuantity(Item item) {
		String sql = "update item set itemQuantity= ? where id = ?";
		try {
			PreparedStatement pstm = con.prepareStatement(sql);
//			pstm.setString(1,item.getItemName());
//			pstm.setInt(2,item.getPrice());
			pstm.setInt(1,item.getItemQuantity());
			pstm.setInt(2,item.getId());
			pstm.execute();
			
			return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	@Override
	public boolean updateItem(Item item) {
		String sql = "update item set itemName=?,price= ?,itemQuantity= ? where id = ?";
		try {
			PreparedStatement pstm = con.prepareStatement(sql);
			pstm.setString(1,item.getItemName());
			pstm.setInt(2,item.getPrice());
			pstm.setInt(3,item.getItemQuantity());
			pstm.setInt(4,item.getId());
			pstm.execute();
			
			return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	

	@Override
	public Item getById(int id) {
		Item item = new Item();
		String sql = "select  * from  item where id ="+id;
		try {
			Statement stm=con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			
		    while(rs.next()) {
		    	 item.setId(rs.getInt("id"));
		    	 item.setItemName(rs.getString("itemName"));
		    	  item.setPrice(rs.getInt("price"));
		    	  item.setItemQuantity(rs.getInt("itemQuantity"));
		    	
		    }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return item;
	}

	@Override
	public List<Item> getAllItem() {
		List<Item>  elist = new ArrayList<>();
		String sql = "select id , itemName ,price ,itemQuantity from  item";
		try {
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			
			while(rs.next()) {
				Item itm = new Item();
				itm.setId(rs.getInt("id"));
				itm.setItemName(rs.getString("itemName"));
				itm.setPrice(rs.getInt("price"));
				itm.setItemQuantity(rs.getInt("itemQuantity"));
				
				elist.add(itm);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return elist;
	}

	@Override
	public List<Item> searchItem(String input) {
		List<Item>  itemlist = new ArrayList<>();
		String sql = "select id ,itemName,price,itemQuantity from  item where itemName like '"+input+"%' ";
		try {
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			
			while(rs.next()) {
				Item item = new Item();
				item.setId(rs.getInt("id"));
				item.setItemName(rs.getString("itemName"));
				item.setPrice(rs.getInt("price"));
				item.setItemQuantity(rs.getInt("itemQuantity"));
				
				itemlist.add(item);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return itemlist;
	}

	

}
