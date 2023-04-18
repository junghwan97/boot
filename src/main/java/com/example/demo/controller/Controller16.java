package com.example.demo.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("sub16")
public class Controller16 {

	@Value("${spring.datasource.url}")
	private String url;
	@Value("${spring.datasource.username}")
	private String name;
	@Value("${spring.datasource.password}")
	private String password;

	@RequestMapping("link1")
	public void method1(int id) throws Exception {

		String sql = """
				DELETE FROM Suppliers
				WHERE SupplierID = ?
				""";

		try (Connection con = DriverManager.getConnection(url, name, password);
				PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setInt(1, id);
			int cnt = pstmt.executeUpdate();
			System.out.println(cnt + "번 데이터가 삭제됨");
		}
	}

	// /sub16/link2?id=30
	// 고객 테이블의 데이터 삭제 메서드 작성

	@RequestMapping("link2")
	public void method2(int id) throws Exception {

		String sql = """
				DELETE FROM Customers
				WHERE CustomerID = ?
				""";

		try (Connection con = DriverManager.getConnection(url, name, password);
				PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setInt(1, id);
			int cnt = pstmt.executeUpdate();
			System.out.println(cnt + "개의 데이터가 삭제됨");
		}
	}

}
