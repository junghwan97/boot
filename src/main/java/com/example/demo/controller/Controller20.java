package com.example.demo.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.mapper.Mapper01;
import com.study.demo.domain.Book;
import com.study.demo.domain.Customer;
import com.study.demo.domain.Dto05;
import com.study.demo.domain.Employee;
import com.study.demo.domain.Supplier;

@Controller
@RequestMapping("sub20")
public class Controller20 {
	
	@Autowired
	private Mapper01 mapper;
	
	@RequestMapping("link1")
	public void method1() {
		String name = mapper.method1();
		System.out.println(name);
		System.out.println(mapper.method2());
	}

	@RequestMapping("link2")
	public void method2() {
		
		System.out.println(mapper.method3());
	}
	
	@RequestMapping("link3")
	public void methid3() {
		System.out.println(mapper.method4(3));
	}
	
	@RequestMapping("link4")
	public void method4(@RequestParam("id") Integer customerId) {
		String name = mapper.method4(customerId); 
		System.out.println(name);
	}
	
	// 2번 직원의 lastName을 콘솔에 출력
	@RequestMapping("link5")
	public void method5(Integer employeeId) {
		String name = mapper.method5(employeeId);
		System.out.println(name);
		
	}
	
	@RequestMapping("link6")
	public void method6() {
		System.out.println("가격 : " + mapper.method6());
		
		Double weight = mapper.method7();
		System.out.println("무게 : " + weight);
		
		LocalDate published = mapper.method8();
		System.out.println("출판일 : " + published);
		
		LocalDateTime updated = mapper.method9();
		System.out.println("수정일 : " + updated);
	}
	
	@RequestMapping("link7")
	public void method7() {
		Book book = mapper.method10();
		System.out.println(book);
	}
	
	@RequestMapping("link8")
	public void method8() {
		Dto05 dto05 = mapper.method11();
		System.out.println(dto05);
	}
	
	@RequestMapping("link9")
	public void method9() {
		Customer customer = mapper.method12();
		System.out.println(customer);
	}
	
	@RequestMapping("link10")
	public void method10() {
		Supplier sup = mapper.method13();
		System.out.println(sup);
	}
	
	@RequestMapping("link11")
	public void method11() {
		Employee emp = mapper.method14();
		System.out.println(emp);
	}
}
