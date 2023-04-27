package com.example.demo.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.RequestParam;

@Mapper
public interface Mapper04 {

	@Delete("""
			DELETE FROM MyTable40
			""")
	int sql1();
	
	@Delete("""
			DELETE FROM MyTable39
			WHERE Col1 = #{id}
			""")
	int sql2(Integer id);
	
	@Delete("""
			DELETE FROM Customers
			WHERE CustomerId = #{id}
			""")
	int sql3(Integer id);
}
