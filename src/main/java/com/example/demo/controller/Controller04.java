package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("sub4")
public class Controller04 {
	// method argument(parameter)
	
	// 경로 : /sub4/link1
	@RequestMapping("link1")
	public void method01(HttpServletRequest request) {
		
		// 1. request parameter 수집 / 가공
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		
		System.out.println("name : " + name);
		System.out.println("age : " + age);
		
		// 2. business logic
		
		// 3. add attribute
		
		// 4. forward / redirect
	}
	// 경로 : /sub4/link2?address=seoul&email=korea@gmail.com
	@RequestMapping("link2")
	public void method02(HttpServletRequest request) {
		String address = request.getParameter("address");
		String email = request.getParameter("email");
		
		System.out.println("address : " + address);
		System.out.println("email : " + email);
	}
	
	@RequestMapping("link3")
	public void method03(@RequestParam("address") String address) {
		System.out.println("address : " + address);
	}
	
	// 경로 : /sub4/link4?age=99
	@RequestMapping("link4")
	public void method04(@RequestParam("age") String age) {
		System.out.println("age : " + age);
		
		int myAge = Integer.parseInt(age);
	}
	
	@RequestMapping("link5")
	public void method05(@RequestParam("score") int score) {
		System.out.println("score : " + score);
	}
	
}
