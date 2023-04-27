package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.mapper.Mapper02;
import com.study.demo.domain.Dto07;
import com.study.demo.domain.Dto08;

@Controller
@RequestMapping("sub21")
public class Controller21 {

	@Autowired
	private Mapper02 mapper;
	
	@RequestMapping("link1")
	public void method1() {
		
		List<String> list = mapper.sql1();
		
		list.forEach(System.out::println);
	}
	
	@RequestMapping("link2")
	public void methdo2() {
		
		List<String> list = mapper.sql2();
		list.forEach(System.out::println);
	}
	
	@RequestMapping("link3")
	public void method3() {
		List<Dto07> list = mapper.sql3();
		list.forEach(System.out::println);
	}
	
	@RequestMapping("link4")
	public void method4() {
		List<Dto08> list = mapper.sql4();
		list.forEach(System.out::println);
	}
	
	// /sub21/link5?cid=3
	@RequestMapping("link5")
	public void method5(Integer cid) {
		List<String> list = mapper.sql5(cid);
		list.forEach(System.out::println);
	}
	
	// /sub21/link6?country=uk
	// /sub21/link6?country=canada
	// 각 국가에 있는 고객명(CustomerName)이 콘솔에 출력
	@RequestMapping("link6")
	public void method6(String country) {
		List<String> name = mapper.sql6(country);
		name.forEach(System.out::println);
	}
	
	@RequestMapping("link7")
	public void method7(Integer cid) {
		List<Dto08> name = mapper.sql7(cid);
		name.forEach(System.out::println);
	}
}
