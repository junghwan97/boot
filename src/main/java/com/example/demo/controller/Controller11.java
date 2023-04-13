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
	@Value("${spring.datasource.name}")
	private String name;
	@Value("${spring.datasource.password}")
	private String password;

	@RequestMapping("link1")
	public void method1(Model model) {
		// 1. request param 수집

		// 2. business logic
		// 아이디가 1인 고객 이름 조회

		// SELECT CustomerName FROM Customers WHERE CustomerID = 1;

		String sql = "SELECT CustomerName FROM Customers WHERE CustomerID = 1";
		try (
				// db 연결
				Connection connection = DriverManager.getConnection(url, name, password);
				// Statement 객체 생성
				Statement statement = connection.createStatement();
				// 쿼리 실행
				// 쿼리 실행 결과 얻고
				ResultSet resultSet = statement.executeQuery(sql);) {
			// 쿼리 실행 결과 가공
			String name = "";
			if (resultSet.next()) {
				name = resultSet.getString("CustomerName");
			}

			// 3. add attribute
			model.addAttribute("customerName", name);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 4. forward
	}

	@RequestMapping("link2")
	public void method2() {
		String employeeName = "";
		// 2. business logic
		// 아이디가 3인 직원의 LastName 조회

		String sql = "SELECT LastName FROM Employees WHERE EmployeeId = 3";
		try (
				// 1. 연결하기
				Connection con = DriverManager.getConnection(url, name, password);
				// 2. statement 생성
				Statement stmt = con.createStatement();
				// 3. 쿼리 실행 후 resultSet 얻기
				ResultSet rs = stmt.executeQuery(sql);
		// 4. resultSet에 결과 있는 지 확인하고
		) {
			if (rs.next()) {
				// 5. 결과 꺼내서 담기
				employeeName = rs.getString("LastName");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(employeeName);
	}

	@RequestMapping("link3")
	public void method3(Model model) {
		// 업무
		// 아이디가 5인 상품 이름 조회
		String sql = """
				SELECT ProductName
				FROM Products
				WHERE ProductID = 5
				""";
		try (
				// 1. 연결하기
				Connection con = DriverManager.getConnection(url, name, password);
				// 2. statement 생성
				Statement stmt = con.createStatement();
				// 3. 쿼리 실행 후 resultSet 얻기
				ResultSet rs = stmt.executeQuery(sql);
		// 4. resultSet에 결과 있는지 확인하고
		) {
			String productName = "";
			if (rs.next()) {
				// 5. 결과 꺼내서 담기
				productName = rs.getString("ProductName");
			}
			model.addAttribute("ProductName", productName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@RequestMapping("link4")
	public void method4(Model model) {
		// 업무
		// 고객 이름들 조회

		String sql = "SELECT CustomerName FROM Customers";
		List<String> customerList = new ArrayList<>();
		try {
			// 1. 연결하기
			Connection con = DriverManager.getConnection(url, name, password);
			// 2. Statement 생성
			Statement stmt = con.createStatement();
			// 3. 쿼리 실행 후 resultSet 얻기
			ResultSet rs = stmt.executeQuery(sql);
			// 4. resultSet에 결과 있는지 확인하고
			try (con; stmt; rs;) {
				while (rs.next()) {
					// 5. 결과 꺼내서 담기
					customerList.add(rs.getString("CustomerName"));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("CustomerNames", customerList);
	}

	@RequestMapping("link5")
	public void method5(Model model) {
		String sql = "SELECT firstName FROM Employees";
		List<String> list = new ArrayList<>();
		try {
			// 1. 연결하기
			Connection con = DriverManager.getConnection(url, name, password);
			// 2. Statement 생성
			Statement stmt = con.createStatement();
			// 3. 쿼리 실행 후 ResultSet 얻기
			ResultSet rs = stmt.executeQuery(sql);
			// 4. resultSet에 결과 있는지 확인하고
			try (con; stmt; rs;) {
				while (rs.next()) {
					// 5. 결과 꺼내서 담기
					list.add(rs.getString("firstName"));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("firstName", list);
	}
}
