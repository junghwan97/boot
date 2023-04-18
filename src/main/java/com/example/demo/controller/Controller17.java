package com.example.demo.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.study.demo.domain.Customer;
import com.study.demo.domain.Supplier;

@Controller
@RequestMapping("sub17")
public class Controller17 {

	@Value("${spring.datasource.url}")
	private String url;
	@Value("${spring.datasource.username}")
	private String username;
	@Value("${spring.datasource.password}")
	private String password;

	// ?id=40&SupplierName=하도영
	@RequestMapping("link1")
	public void method1(String name, int id) throws Exception {

		String sql = """
				UPDATE Suppliers
				SET
					SupplierName = ?
				WHERE SupplierID = ?
				""";

		try (Connection con = DriverManager.getConnection(url, username, password);
				PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setString(1, name);
			pstmt.setInt(2, id);
			int cnt = pstmt.executeUpdate();
			System.out.println(cnt + "개의 데이터가 수정됨");
		}
	}
	// ?id=62&address=Seoul
	// SupplierID가 62번인 공급자 주소를 Seoul로 변경

	@RequestMapping("link2")
	public void method2(int id, String address) throws Exception {

		String sql = """
				UPDATE Suppliers
				SET
					Address = ?
				WHERE SupplierID = ?
				""";

		try (Connection con = DriverManager.getConnection(url, username, password);
				PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setString(1, address);
			pstmt.setInt(2, id);
			int cnt = pstmt.executeUpdate();
			System.out.println(cnt + "개의 데이터가 수정됨");
		}
	}

	@RequestMapping("link3")
	public void method3(Supplier supplier) throws Exception {
		String sql = """
				UPDATE Suppliers
				SET
					SupplierName = ?,
					ContactName = ?,
					Address = ?,
					City = ?,
					PostalCode = ?,
					Country = ?,
					Phone = ?
				WHERE
					SupplierId = ?
				""";

		try (Connection con = DriverManager.getConnection(url, username, password);
				PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setString(1, supplier.getName());
			pstmt.setString(2, supplier.getContactName());
			pstmt.setString(3, supplier.getAddress());
			pstmt.setString(4, supplier.getCity());
			pstmt.setString(5, supplier.getPostalCode());
			pstmt.setString(6, supplier.getCountry());
			pstmt.setString(7, supplier.getPhone());
			pstmt.setInt(8, supplier.getId());

			int cnt = pstmt.executeUpdate();
			System.out.println(supplier.getId() + "번 공급자 수정됨");

		}

	}

	// /sub17/link4?id=65
	@RequestMapping("link4")
	public void method4(int id, Model model) throws Exception {
		String sql = """
				SELECT
					SupplierId,
					SupplierName,
					ContactName,
					Address,
					City,
					PostalCode,
					Country,
					Phone
				FROM Suppliers
				WHERE SupplierId = ?
				""";
		try (Connection con = DriverManager.getConnection(url, this.username, password);
				PreparedStatement pstmt = con.prepareStatement(sql);) {

			pstmt.setInt(1, id);
			try (ResultSet rs = pstmt.executeQuery();) {
				if (rs.next()) {
					Supplier supplier = new Supplier();
					supplier.setId(rs.getInt("supplierId"));
					supplier.setName(rs.getString("supplierName"));
					supplier.setContactName(rs.getString("contactName"));
					supplier.setAddress(rs.getString("address"));
					supplier.setCity(rs.getString("city"));
					supplier.setPostalCode(rs.getString("postalCode"));
					supplier.setCountry(rs.getString("country"));
					supplier.setPhone(rs.getString("phone"));
					model.addAttribute("supplier", supplier);
				}

			}

		}

		// 왜 try문이 2번 사용되었을까?
		// 두 번째 try-with-resources 문이 첫 번째 try-with-resources 문 안에 중첩되어 있는 이유는 ResultSet
		// 객체가 생성된 후에는 PreparedStatement 객체와 Connection 객체가 여전히 사용 중인 상태이기 때문이다. 또한
		// ResultSet 객체도 자원을 사용하는 객체이므로 try-with-resources 문을 사용하여 안전하게 자원을 해제해야 한다.
		// 따라서 두 번째 try-with-resources 문에서 ResultSet 객체를 생성하여 안전하게 자원을 해제할 수 있도록 한다.
	}

	@RequestMapping("link5")
//	public void method5(int id, Customer customer) throws Exception{
	public void method5(int id, Model model) throws Exception {

		String sql = """
				SELECT
				CustomerID,
				CustomerName,
				ContactName,
				Address,
				City,
				PostalCode,
				Country
				FROM Customers
				WHERE CustomerID = ?
				""";

		try (Connection con = DriverManager.getConnection(url, username, password);
				PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setInt(1, id);
			try (ResultSet rs = pstmt.executeQuery();) {
				if (rs.next()) {
					Customer customer = new Customer();
					customer.setId(rs.getInt(1));
					customer.setName(rs.getString(2));
					customer.setContactName(rs.getString(3));
					customer.setAddress(rs.getString(4));
					customer.setCity(rs.getString(5));
					customer.setPostalCode(rs.getString(6));
					customer.setCountry(rs.getString(7));
					model.addAttribute("customer", customer);
				}
			}
		}

	}

	@RequestMapping("link6")
	public void method6(Customer customer) throws Exception {
		String sql = """
				UPDATE Customers
				SET
					CustomerName = ?,
					ContactName = ?,
					Address = ?,
					City = ?,
					PostalCode = ?,
					Country = ?
				WHERE
					CustomerID = ?
				""";
		try (Connection con = DriverManager.getConnection(url, username, password);
				PreparedStatement pstmt = con.prepareStatement(sql);) {

			pstmt.setString(1, customer.getName());
			pstmt.setString(2, customer.getContactName());
			pstmt.setString(3, customer.getAddress());
			pstmt.setString(4, customer.getCity());
			pstmt.setString(5, customer.getPostalCode());
			pstmt.setString(6, customer.getCountry());
			pstmt.setInt(7, customer.getId());
			int cnt = pstmt.executeUpdate();
			System.out.println(cnt + "개의 데이터 수정");
		}

	}
}
