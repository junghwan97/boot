package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Controller01 {

	@RequestMapping("/sub1/link1")
	public void method01() {
		System.out.println("일함!!!!");
	}

	@RequestMapping("/sub1/link2")
	public void method02() {
		System.out.println("/sub2/link2 결로 요청에서 일하는 메서드!!!!");
	}
	
	@RequestMapping("/sub1/link3")
	public void method3() {
		System.out.println("일하는 request handler 메서드 작성");
	}
}
