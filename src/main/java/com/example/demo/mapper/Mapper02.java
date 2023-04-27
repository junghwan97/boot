package com.example.demo.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import com.study.demo.domain.Dto07;
import com.study.demo.domain.Dto08;

@Mapper
public interface Mapper02 {

	@Select("""
			SELECT CustomerName FROM Customers
			""")
	List<String>sql1();
	
	@Select(""" 
			SELECT LastName FROM Employees
			""")
	List<String> sql2();
	
	@Select("""
			SELECT LastName, FirstName
			FROM Employees
			""")
	List<Dto07>sql3();
	
	@Select("""
			SELECT ProductName, Price
			FROM Products
			""")
	List<Dto08>sql4();
	
	@Select("""
			SELECT ProductName
			FROM Products
			WHERE CategoryId = #{cid}
			""")
	List<String> sql5(Integer cid);
	
	@Select("""
			SELECT CustomerName
			FROM Customers
			WHERE Country = #{country}
			""")
	List<String> sql6(String country);
	
	@Select("""
			SELECT ProductName, Price
			FROM Products
			WHERE CategoryId = #{cid}
			""")
	// 메서드 작성
	// 작성된 메서드를 controller21 7번 메서드에서 호출
	List<Dto08> sql7(Integer cid);
}
