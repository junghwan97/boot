package com.example.demo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import com.study.demo.domain.Category;
import com.study.demo.domain.Supplier;



@Mapper
public interface Mapper11 {

	
	@Select("""
			SELECT 
				c.CategoryId,
				c.CategoryName,
				c.Description,
				p.ProductName
			FROM Categories c JOIN Products p
			  ON c.CategoryId = p.CategoryId
			WHERE c.CategoryId = #{id}
			""")
	@ResultMap("categoryResult")
	Category sql1(int id);
	
	@Select("""
			SELECT 
				c.CategoryId,
				c.CategoryName,
				c.Description,
				p.ProductName,
				p.Price
			FROM Categories c JOIN Products p
			  ON c.CategoryId = p.CategoryId
			WHERE c.CategoryId = #{id}
			""")
	@ResultMap("categoryResultMap")
	Category sql2(int id);

	@Select("""
			SELECT 
				s.SupplierId,
				s.SupplierName,
				s.ContactName,
				s.Address,
				s.city,
				s.PostalCode,
				s.Country,
				s.Phone,
				p.ProductName,
				p.price
			FROM Suppliers s JOIN Products p
			  ON s.SupplierId = p.SupplierId
			WHERE s.SupplierId = #{id}
			""")
	@ResultMap("supplierResultMap")
	Supplier sql3(int id);

	
	
}
