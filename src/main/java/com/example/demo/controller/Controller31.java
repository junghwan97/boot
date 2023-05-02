package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.mapper.Mapper11;
import com.study.demo.domain.Category;
import com.study.demo.domain.Supplier;

@Controller
@RequestMapping("sub31")
public class Controller31 {

	@Autowired
	private Mapper11 mapper;

	@GetMapping("link1")
	public void method1(int id) {
		// 1번 카테고리 정보
		Category category = mapper.sql1(id);

		System.out.println(category);
		category.getProducts().forEach(System.out::println);

	}

	@GetMapping("link2")
	public void method2(int id) {
		Category category = mapper.sql2(id);

		System.out.println(category);
		category.getProducts().forEach(System.out::println);
	}
	
	@GetMapping("link3")
	public void method3(int id) {
		Supplier supplier = mapper.sql3(id);
		System.out.println(supplier);
		supplier.getProducts().forEach(System.out::println);
	}
}
