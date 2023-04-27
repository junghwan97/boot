package com.example.demo.controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.study.demo.domain.Book;
import com.study.demo.domain.Dto05;

@Controller
@RequestMapping("sub19")
public class Controller19 {

	@Value("${spring.datasource.url}")
	private String url;
	@Value("${spring.datasource.username}")
	private String username;
	@Value("${spring.datasource.password}")
	private String password;

	@RequestMapping("link1")
	public void method1() throws Exception {

		String sql = """
				INSERT INTO MyTable30(Col1, Col2)
				VALUES (?, ?)
				""";
		try (Connection con = DriverManager.getConnection(url, username, password);
				PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setInt(1, 99);
			pstmt.setString(2, "hello");
			int cnt = pstmt.executeUpdate();
			System.out.println(cnt + "개 입력");
		}
	}

	@RequestMapping("link2")
	public void method2() throws Exception {

		String sql = """
				INSERT INTO MyTable30(Col1, Col2)
				VALUES (?, ?)
				""";
		try (Connection con = DriverManager.getConnection(url, username, password);
				PreparedStatement pstmt = con.prepareStatement(sql);) {
//					pstmt.setInt(1, 99);
//					pstmt.setString(2, "hello");
			pstmt.setString(1, "888");
			pstmt.setInt(2, 12345);

			int cnt = pstmt.executeUpdate();
			System.out.println(cnt + "개 입력");
		}
	}

	@RequestMapping("link3")
	public void method3() throws Exception {

		String sql = """
				INSERT INTO MyTable31(Col1, Col2)
				VALUES (?, ?)
				""";
		try (Connection con = DriverManager.getConnection(url, username, password);
				PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setString(1, "2023-04-21");
			pstmt.setString(2, "2023-04-21 12:23:55");
			int cnt = pstmt.executeUpdate();
			System.out.println(cnt + "개 입력");
		}
	}

	@RequestMapping("link4")
	public void method4() throws Exception {

		String sql = """
				INSERT INTO MyTable31(Col1, Col2)
				VALUES (?, ?)
				""";
		try (Connection con = DriverManager.getConnection(url, username, password);
				PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setDate(1, Date.valueOf("2023-04-22"));
			pstmt.setTimestamp(2, Timestamp.valueOf("2000-01-01 22:22:11"));
			int cnt = pstmt.executeUpdate();
			System.out.println(cnt + "개 입력");
		}
	}

	@RequestMapping("link5")
	public void method5() throws Exception {

		String sql = """
				INSERT INTO MyTable32(Name, Age, Price, Birth, Inserted)
				VALUES (?, ?, ?, ?, ?)
				""";
		try (Connection con = DriverManager.getConnection(url, username, password);
				PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setString(1, "괴테");
			pstmt.setInt(2, 31);
			pstmt.setDouble(3, 3000.00);
			pstmt.setDate(4, Date.valueOf("1800-04-21"));
			pstmt.setTimestamp(5, Timestamp.valueOf("1850-04-21 12:23:55"));
			int cnt = pstmt.executeUpdate();
			System.out.println(cnt + "개 행 입력");
		}
	}

	@RequestMapping("link6")
	public void method6() {

	}

	@RequestMapping("link7")
	public void method7(String name, String age, String price, String birth, String inserted) throws Exception {

		String sql = """
				INSERT INTO MyTable32(Name, Age, Price, Birth, Inserted)
				VALUES (?, ?, ?, ?, ?)
				""";
		try (Connection con = DriverManager.getConnection(url, username, password);
				PreparedStatement pstmt = con.prepareStatement(sql);) {

			pstmt.setString(1, name);
			pstmt.setString(2, age);
			pstmt.setString(3, price);
			pstmt.setString(4, birth);
			pstmt.setString(5, inserted);
			int cnt = pstmt.executeUpdate();
			System.out.println(cnt + "개 행 입력됨");
		}
	}

	@RequestMapping("link8")
	public void method8(String name, Integer age, Double price, LocalDate birth, LocalDateTime inserted)
			throws Exception {

		String sql = """
				INSERT INTO MyTable32(Name, Age, Price, Birth, Inserted)
				VALUES (?, ?, ?, ?, ?)
				""";

		try (Connection con = DriverManager.getConnection(url, username, password);
				PreparedStatement pstmt = con.prepareStatement(sql);) {

			pstmt.setString(1, name);
			pstmt.setInt(2, age);
			pstmt.setDouble(3, price);
			pstmt.setDate(4, Date.valueOf(birth));
			pstmt.setTimestamp(5, Timestamp.valueOf(inserted));
			int cnt = pstmt.executeUpdate();
			System.out.println(cnt + "개 행 입력됨");
		}
	}

	@RequestMapping("link9")
	public void method9() {

	}

	@RequestMapping("link10")
	public void method10(String title, LocalDate published, Integer price, LocalDateTime updated, Double weight)
			throws Exception {

		String sql = """
				INSERT INTO MyTable33(Title, Published, Price, Updated, Weight)
				VALUES(?, ?, ?, ?, ?)
				""";

		try (Connection con = DriverManager.getConnection(url, username, password);
				PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setString(1, title);
			pstmt.setDate(2, Date.valueOf(published));
			pstmt.setInt(3, price);
			pstmt.setTimestamp(4, Timestamp.valueOf(updated));
			pstmt.setDouble(5, weight);
			int cnt = pstmt.executeUpdate();
			System.out.println(cnt + "개의 행 입력됨");
		}

	}

	@RequestMapping("link11")
	public void method11() throws Exception {

		String sql = """
				SELECT Title, Published, Price, Updated, Weight
				FROM MyTable33
				""";
		try (Connection con = DriverManager.getConnection(url, username, password);
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql);) {
			if (rs.next()) {
				String title = rs.getString("title");
				String published = rs.getString("published");
				String price = rs.getString("price");
				String updated = rs.getString("updated");
				String weight = rs.getString("weight");

				System.out.println("제목 : " + title);
				System.out.println("출판일 : " + published);
				System.out.println("가격 : " + price);
				System.out.println("수정일시 : " + updated);
				System.out.println("무게 : " + weight);

			}
		}
	}

	@RequestMapping("link12")
	public void method12() throws Exception {
		String sql = """
				SELECT Title, Published, Price, Updated, Weight
				FROM MyTable33
				""";
		try (Connection con = DriverManager.getConnection(url, username, password);
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql);) {
			if (rs.next()) {
				String title = rs.getString("title");
				LocalDate published = rs.getDate("published").toLocalDate();
				Integer price = rs.getInt("price");
				LocalDateTime updated = rs.getTimestamp("updated").toLocalDateTime();
				Double weight = rs.getDouble("weight");

				System.out.println("제목 : " + title);
				System.out.println("출판일 : " + published);
				System.out.println("가격 : " + price);
				System.out.println("수정일시 : " + updated);
				System.out.println("무게 : " + weight);

			}
		}
	}

	@RequestMapping("link13")
	public void method13() throws Exception {

		String sql = """
				SELECT Age, Name, Price, Birth, Inserted
				FROM MyTable32
				""";
		try (Connection con = DriverManager.getConnection(url, username, password);
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql);) {
			if (rs.next()) {
				Integer age = rs.getInt("age");
				String name = rs.getString("name");
				Double price = rs.getDouble("price");
				LocalDate birth = rs.getDate("birth").toLocalDate();
				LocalDateTime inserted = rs.getTimestamp("inserted").toLocalDateTime();

				System.out.println("나이 : " + age);
				System.out.println("이름 : " + name);
				System.out.println("가격 : " + price);
				System.out.println("생일 : " + birth);
				System.out.println("출판일 : " + inserted);
			}
		}
	}

	@RequestMapping("link14")
	public void method14(Model model) throws Exception {
		String sql = """
				SELECT Age, Name, Price, Birth, Inserted
				FROM MyTable32
				""";
		List<Dto05> list = new ArrayList<>();
		try (Connection con = DriverManager.getConnection(url, username, password);
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql);) {
			while (rs.next()) {
				Dto05 o = new Dto05();
				o.setName(rs.getString("name"));
				o.setAge(rs.getInt("age"));
				o.setPrice(rs.getDouble("price"));
				o.setBirth(rs.getDate("birth").toLocalDate());
				o.setInserted(rs.getTimestamp("inserted").toLocalDateTime());
				list.add(o);
			}
			model.addAttribute("memberList", list);
		}
	}

	@RequestMapping("link15")
	public void method15(Model model) throws Exception {

		String sql = """
				SELECT Title, Published, Price, Updated, Weight
				FROM MyTable33
				""";
		List<Book> list = new ArrayList<>();

		try (Connection con = DriverManager.getConnection(url, username, password);
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql);) {
			while (rs.next()) {
				Book book = new Book();
				book.setTitle(rs.getString("title"));
				book.setPublished(rs.getDate("published").toLocalDate());
				book.setPrice(rs.getInt("price"));
				book.setUpdated(rs.getTimestamp("updated").toLocalDateTime());
				book.setWeight(rs.getDouble("weight"));
				list.add(book);
			}
		}
		model.addAttribute("bookList", list);
	}

}
