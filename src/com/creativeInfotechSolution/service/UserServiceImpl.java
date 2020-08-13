package com.creativeInfotechSolution.service;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.creativeInfotechSolution.db.DB;
import com.creativeInfotechSolution.model.User;

public class UserServiceImpl implements UserService {

	Connection con = null; 
	
	public UserServiceImpl() {
		// TODO Auto-generated constructor stub
		con = DB.getDb();
	}
	
	@Override
	public boolean addUser(User u) {
		String sql = "insert into user(username,password,fname,lname,email,address,phone,country)values(?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement pstm = con.prepareStatement(sql);
			pstm.setString(1,u.getUsername());
			pstm.setString(2,u.getPassword());
			pstm.setString(3,u.getFname());
			pstm.setString(4,u.getLname());
			pstm.setString(5,u.getEmail());
			pstm.setString(6,u.getAddress());
			pstm.setString(7,u.getPhone());
			pstm.setString(8,u.getCountry());
			
			pstm.execute();
			return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	}

