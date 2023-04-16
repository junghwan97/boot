package com.example.demo.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("sub12")
public class Controller12 {

	@Value("${spring.datasource.url}")
	private String url;
	@Value("${spring.datasource.username}")
	private String name;
	@Value("${spring.datasource.password}")
	private String password;

	@RequestMapping("link1")
	public void method1() {
		String sql = "SELECT LastName FROM Employees";

		try {
			Connection con = DriverManager.getConnection(url, name, password);
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			try (con; stmt; rs;) {

//				https://docs.oracle.com/en/java/javase/17/docs/api/java.sql/java/sql/ResultSet.html#method-detail
//				.next() 메서드 : 행
//				.getString() 메서드 : 열

				System.out.println(rs.next()); // true //
				String name1 = rs.getString("lastName");
				System.out.println(name1);
				System.out.println(rs.next()); // true
				String name2 = rs.getString("lastName");
				System.out.println(name2);
				System.out.println(rs.next()); // true
				String name4 = rs.getString("lastName");
				System.out.println(name4);
				System.out.println(rs.next()); // true
				String name5 = rs.getString("lastName");
				System.out.println(name5);
				System.out.println(rs.next()); // true
				String name6 = rs.getString("lastName");
				System.out.println(name6);
				System.out.println(rs.next()); // true
				String name7 = rs.getString("lastName");
				System.out.println(name7);
				System.out.println(rs.next()); // true
				String name8 = rs.getString("lastName");
				System.out.println(name8);
				System.out.println(rs.next()); // true
				String name9 = rs.getString("lastName");
				System.out.println(name9);
				System.out.println(rs.next()); // true

				System.out.println(rs.next()); // false
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@RequestMapping("link2")
	public void method2() {
		String sql = "SELECT LastName FROM Employees";

		try {
			Connection con = DriverManager.getConnection(url, name, password);
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			try (con; stmt; rs;) {
				while (rs.next()) {
					System.out.println(rs.getString("LastName"));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@RequestMapping("link3")
	public void method3(Model model) {

		String sql = "SELECT ShipperName FROM Shippers";

		List<String> shipperNames = new ArrayList<>();
		try {
			Connection con = DriverManager.getConnection(url, name, password);
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			try (con; stmt; rs;) {
				while (rs.next()) {
					System.out.println(rs.getString("ShipperName"));
					shipperNames.add(rs.getString("ShipperName"));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("list", shipperNames);
	}

	@RequestMapping("link4")
	public void method4() {

		String sql = "SELECT * FROM Customers";
		try {
			Connection con = DriverManager.getConnection(url, name, password);
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			try (con; stmt; rs;) {
				rs.next();
				System.out.println(rs.getString("customerName"));
				System.out.println(rs.getString("contactName"));
				System.out.println(rs.getString("country"));

				rs.next();
				System.out.println(rs.getString("customerName"));
				System.out.println(rs.getString("contactName"));
				System.out.println(rs.getString("country"));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@RequestMapping("link5")
	public void method5() {
		String sql = "SELECT * FROM Customers";
		try {
			Connection con = DriverManager.getConnection(url, name, password);
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			try (con; stmt; rs;) {
				while (rs.next()) {
					System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
					System.out.println(rs.getString("customerName"));
					System.out.println(rs.getString("contactName"));
					System.out.println(rs.getString("country"));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@RequestMapping("link6")
	public void method6() {
		String sql = "SELECT * from Products WHERE ProductID <= 3";

		try {
			Connection con = DriverManager.getConnection(url, name, password);
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			try (con; stmt; rs;) {
				while (rs.next()) {
					System.out.println(rs.getInt("ProductID"));
					System.out.println(rs.getString("ProductName"));
					System.out.println(rs.getDouble("Price"));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@RequestMapping("link7")
	public void method7(Model model) {

		String sql = "SELECT * FROM Customers WHERE CustomerID < 10";

		Map<Integer, String> customerList = new HashMap<>();
		try {
			Connection con = DriverManager.getConnection(url, name, password);
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			try (con; stmt; rs;) {
				while (rs.next()) {
					// column은 1부터 시작
					// getInt(String columnLabel), getString(String columnLabel)
//					customerList.put(rs.getInt("CustomerID"), rs.getString("CustomerName"));

					// getInt(int columnIndex), getString(int columnIndex)
					customerList.put(rs.getInt(1), rs.getString(2));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("list", customerList);
	}

	@RequestMapping("link8")
	public void method8() throws Exception {
		String sql = "SELECT LastName, FirstName FROM Employees WHERE EmployeeID < 4";
		Connection con = DriverManager.getConnection(url, name, password);
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sql);

		try (con; stmt; rs;) {
			while (rs.next()) {
				String lastName = rs.getString(1);
				String firstName = rs.getString(2);

				System.out.println(lastName + ", " + firstName);

			}
		}
	}

	@RequestMapping("link9")
	public void method9() throws Exception {

		String sql = "SELECT CustomerID, CustomerName, Country FROM Customers";

		Connection con = DriverManager.getConnection(url, name, password);
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sql);

		try (con; stmt; rs) {
			while (rs.next()) {
				int customerId = rs.getInt(1);
				String customerName = rs.getString(2);
				String country = rs.getString(3);
				
				System.out.println(customerId + ", " + customerName + ", " + country);
			}
		}
		
	}
	
	
}
