package com.example.demo.controller;

import java.sql.*;
import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;


import com.study.demo.domain.Customer;

@Controller
@RequestMapping("sub14")
public class Controller14 {

	@Value("${spring.datasource.url}")
	private String url;
	@Value("${spring.datasource.username}")
	private String name;
	@Value("${spring.datasource.password}")
	private String password;
	
	// /sub14/link1?keyword=or
	@RequestMapping("link1")
	public String method1(String keyword, String kk, Model model) throws Exception {
		String sql = """
				SELECT CustomerID, CustomerName, Address, ContactName
				FROM Customers
				WHERE CustomerName LIKE ?
				AND ContactName LIKE ?
				""";
		var list = new ArrayList<Customer>();
		
		Connection con = DriverManager.getConnection(url, name, password);
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, "%" + keyword + "%");
		pstmt.setString(2, "%" + kk + "%");
		ResultSet rs = pstmt.executeQuery();
		
		try (con; pstmt; rs;) {
			while (rs.next()) {
				Customer c = new Customer();
				c.setId(rs.getInt("customerId"));
				c.setAddress(rs.getString("address"));
				c.setName(rs.getString("customerName"));
				c.setContactName(rs.getString("contactname"));
				list.add(c);
			}
		}
		
		model.addAttribute("customerList", list);
		
		return "/sub13/link1";
	}
}