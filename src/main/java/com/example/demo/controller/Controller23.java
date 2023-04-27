package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.mapper.Mapper04;

@Controller
@RequestMapping("sub23")
public class Controller23 {

	@Autowired
	private Mapper04 mapper;
	
	@RequestMapping("link1")
	public void method1() {
		int cnt = mapper.sql1();
		System.out.println(cnt + "개의 행이 삭제됨");
	}
	
	@RequestMapping("link2")
	public void method2(Integer id) {
		int cnt = mapper.sql2(id);
		System.out.println(cnt + "개의 행이 삭제됨");
	}
	
	@RequestMapping("link3")
	public void method3(Integer id) {
		int cnt = mapper.sql3(id);
		System.out.println(cnt + "개의 행이 삭제됨");
	}
}
