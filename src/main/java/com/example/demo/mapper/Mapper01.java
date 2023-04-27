package com.example.demo.mapper;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.print.attribute.standard.DateTimeAtCompleted;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.study.demo.domain.Book;
import com.study.demo.domain.Customer;
import com.study.demo.domain.Dto05;
import com.study.demo.domain.Employee;
import com.study.demo.domain.Supplier;

@Mapper
public interface Mapper01 {

	@Select("""
			SELECT CustomerName
			FROM Customers
			WHERE CustomerID = 1
			""")
	String method1();
	
	@Select("""
			SELECT FirstName
			FROM Employees
			WHERE EmployeeID = 1
			""")
	String method2();
	
	@Select("""
			SELECT SupplierName
			FROM Suppliers
			WHERE SupplierID = 1
			""")
	String method3();
	
	@Select("""
			SELECT CustomerName
			FROM Customers
			WHERE CustomerID = #{id}
			""")
	String method4(Integer id);
	
	@Select("""
			SELECT lastName
			FROM Employees
			WHERE EmployeeID = #{id}
			""")
	String method5(Integer id);
	
	@Select("""
			SELECT Price
			FROM MyTable33
			LIMIT 1
			""")
	int method6();
	
	@Select("""
			SELECT Weight
			FROM MyTable33
			LIMIT 1
			""")
	double method7();
	
	@Select("""
			SELECT Published
			FROM MyTable33
			LIMIT 1
			""")
	LocalDate method8();
	
	@Select("""
			SELECT Updated
			FROM MyTable33
			LIMIT 1
			""")
	LocalDateTime method9();
	
	@Select("""
			SELECT Title, 
				   Published,
				   Price,
				   Updated,
				   Weight
			FROM MyTable33
			LIMIT 1
			""")
	// 컬럼명과 대소문자 구분없이 매치되는 빈의 프로퍼티명
	Book method10();
	
	@Select("""
			SELECT
			 	Name,
			 	Age,
			 	Price,
			 	Birth,
			 	Inserted
			FROM MyTable32
			LIMIT 1
			""" )
	Dto05 method11();
	
	@Select("""
			SELECT
				CustomerID AS id,
				CustomerName name,
				ContactName,
				Address,
				City,
				PostalCode,
				Country
			FROM Customers
			WHERE CustomerId = 7;
			""")
	Customer method12();

	@Select("""
			SELECT SupplierId id,
				   SupplierName name,
				   ContactName,
				   Address,
				   City,
				   PostalCode,
				   Country,
				   Phone
			FROM Suppliers
			WHERE SupplierId = 2
			""")
	Supplier method13();
	
	@Select("""
			SELECT
				EmployeeID id,
				LastName,
				FirstName,
				BirthDate birth,
				Photo,
				Notes
			FROM Employees
			WHERE EmployeeId = 5
			""")
	Employee method14();
}
