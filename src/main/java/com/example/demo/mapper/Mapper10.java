package com.example.demo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface Mapper10 {

	@Update("""
			UPDATE Bank
			SET money = money - 500
			WHERE name = 'A'
			""")
	void minusA();

	@Update("""
			UPDATE Bank
			SET money = money + 500
			WHERE name = 'B'
			""")
	void plusB();
}
