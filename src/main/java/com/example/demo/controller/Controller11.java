package com.example.demo.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("sub11")
public class Controller11 {

	@Value("${spring.datasource.url}")
	private String url;
	@Value("${spring.datasource.username}")
	private String name;
	@Value("${spring.datasource.password}")
	private String password;

	@RequestMapping("link1")
	public void method1(Model model) {
		// 1. request param

		// 2. business logic

		// 아이디 1인 고객 이름 조회
		// SELECT CustomerName FROM Customers WHERE CustomerID = 1;
		String sql = "SELECT CustomerName FROM Customers WHERE CustomerID = 1";

		try (Connection con = DriverManager.getConnection(url, name, password);
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql);) {
			String name = "";
			if (rs.next()) {
				name = rs.getString("CustomerName");

			}

			model.addAttribute("customerName", name);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@RequestMapping("link2")
	public void method2(Model model) {

		String employeeName = "";

		String sql = "SELECT lastName FROM Employees WHERE EmployeeId = 3";
		try (Connection con = DriverManager.getConnection(url, name, password);
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql);) {
			if (rs.next()) {
				employeeName = rs.getString("lastName");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(employeeName);
	}

	@RequestMapping("link3")
	public void method3(Model model) {

		String productName = "";
		String sql = "SELECT ProductName FROM Products WHERE ProductID = 5";

		try (Connection con = DriverManager.getConnection(url, name, password);
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql);) {
			if (rs.next()) {
				productName = rs.getString("productName");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("ProductName", productName);
	}

	@RequestMapping("link4")
	public void method4(Model model) {
		// #업무
		// 고객 이름들 조회

		String sql = """
				SELECT CustomerName
				FROM Customers
				""";

		List<String> list = new ArrayList<>();

		try {
			Connection con = DriverManager.getConnection(url, name, password);
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			try (con; stmt; rs;) {
				// list에 고객 이름들을 담고
				while (rs.next()) {
					list.add(rs.getString("CustomerName"));
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		// 3. add attribute
		model.addAttribute("customerNames", list);

		// 4. forward
	}

	@RequestMapping("link5")
	public void method5(Model model) {
		// 직원 이름(firstName)들을 조회해서 jsp로 출력
		String sql = """
				SELECT firstName
				FROM Employees
				""";

		List<String> list = new ArrayList<>();

		try {
			Connection con = DriverManager.getConnection(url, name, password);
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			try (con; stmt; rs;) {
				while (rs.next()) {
					list.add(rs.getString("firstName"));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		model.addAttribute("names", list);
	}
}
