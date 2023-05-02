package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.mapper.Mapper10;

@Controller
@RequestMapping("sub30")
public class Controller30 {

	@Autowired
	private Mapper10 mapper;

	@GetMapping("link1")
	public void method1() {
		// A고객의 돈 500원 차감
		mapper.minusA();
		// B고객의 돈 500원 증가
		mapper.plusB();
	}

	@GetMapping("link2")
	public void method2() {
		// A고객의 돈 500원 차감
		mapper.minusA();
		
		int a = 3 /0; // runtimeException
		
		// B고객의 돈 500원 증가
		mapper.plusB();
	}
	
	@GetMapping("link3")
	@Transactional
	public void method3() {
		// A고객의 돈 500원 차감
		mapper.minusA();
		
		int a = 3 /0; // runtimeException
		
		// B고객의 돈 500원 증가
		mapper.plusB();
	}
	
	@GetMapping("link4")
	@Transactional 
	// If no custom rollback rules are configured in this annotation, 
	// the transaction will roll back on RuntimeException and Error but not on checked exceptions.
	public void method4() throws Exception {
		// A고객의 돈 500원 차감
		mapper.minusA();
		
		Class.forName("java.lang.String2"); // check exception
		
		// B고객의 돈 500원 증가
		mapper.plusB();
	}
	
	@GetMapping("link5")
	@Transactional(rollbackFor = Exception.class)
	public void method5() throws Exception {
		// A고객의 돈 500원 차감
		mapper.minusA();
		
		Class.forName("java.lang.String2"); // check exception
		
		// B고객의 돈 500원 증가
		mapper.plusB();
	}
}
