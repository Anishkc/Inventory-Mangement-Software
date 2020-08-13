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
import com.creativeInfotechSolution.model.Sale;

public class SaleServiceImpl implements SaleService {
	
	Connection con = null;
	
	 public SaleServiceImpl() {
		con = DB.getDb();
	 }
	@Override
	public boolean addSale(Sale sale) {
		String sql ="insert into sale(date ,salesName , itemName,salesPrice,salesQuantity)values(?,?,?,?,?)";
		try {
			PreparedStatement pstm = con.prepareStatement(sql);
			pstm.setString(1,sale.getDate());
			pstm.setString(2,sale.getCustomerName());
			pstm.setString(3,sale.getItemName());
			pstm.setString(4,sale.getSalesPrice());
			pstm.setInt(5,sale.getSalesQuantity()); 
			
			pstm.execute();
			return true ;
		} catch (SQLException e) {
			 
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public List<Sale> getAllSale() {
		List<Sale>  slist = new ArrayList<>();
		String sql = "select id ,date, itemName ,salesName,salesPrice ,salesQuantity from  sale";
		try {
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			
			while(rs.next()) {
				Sale sale = new Sale();
				sale.setId(rs.getInt("id"));
				sale.setDate(rs.getString("date"));
				sale.setItemName(rs.getString("itemName"));
				sale.setCustomerName(rs.getString("salesName"));
				sale.setSalesPrice(rs.getString("salesPrice"));
				sale.setSalesQuantity(rs.getInt("salesQuantity"));
				
				slist.add(sale);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return slist;
	}
	@Override
	public List<Sale> searchSale(String input) {
		List<Sale>  salelist = new ArrayList<>();
		String sql = "select id ,date ,itemName,salesName,salesPrice,salesQuantity from  sale where date like '%"+input+"%' ";
		try {
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			
			while(rs.next()) {
				Sale sale = new Sale();
				sale.setId(rs.getInt("id"));
				sale.setDate(rs.getString("date"));
				sale.setItemName((rs.getString("itemName")));
				sale.setCustomerName(rs.getString("salesName"));
				sale.setSalesPrice(rs.getString("salesPrice"));
				sale.setSalesQuantity(rs.getInt("salesQuantity"));
				
			    salelist.add(sale);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return salelist;
	}

}
