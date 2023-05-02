package com.example.demo.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.mapper.Mapper09;
import com.study.demo.domain.Supplier;

@Controller
@RequestMapping("sub28")
public class Controller28 {

	@Autowired
	private Mapper09 mapper;
	
	@GetMapping("link1")
	public void method1() {
		mapper.sql1(List.of("UK", "USA"));
	}
	
	@GetMapping("link2")
	public void method2() {
		List<Supplier> list1 = mapper.sql2(List.of("UK", "USA", "JAPAN"));
		list1.forEach(System.out::println);
		
		List<Supplier> list2 = mapper.sql2(List.of("BRAZIL", "GERMANY"));
		list2.forEach(System.out::println);
	}
	
	@GetMapping("link3")
	public void method3() {
		
	}
	
	@GetMapping("link4")
	public void method4(@RequestParam(value="country", required=false) List<String> country) {
		System.out.println(country);
		mapper.sql2(country).forEach(System.out::println);;
	}
}
