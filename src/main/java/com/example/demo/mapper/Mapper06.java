package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.study.demo.domain.Customer;




@Mapper
public interface Mapper06 {

	@Select("""
			SELECT 
				CustomerId id,
				CustomerName name,
				ContactName,
				Address
			FROM Customers
			ORDER BY CustomerId DESC
			LIMIT #{startIndex}, 20
			""")
	List<Customer> listCustomer(Integer startIndex);

	
	@Select("""
			SELECT COUNT(*)
			FROM Customers;
			""")
	Integer countAll();
	
}
