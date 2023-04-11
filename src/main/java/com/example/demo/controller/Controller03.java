package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sub3")
public class Controller03 {
	
	// spring mvc request handler method
	// 
	
	@RequestMapping("link1")
	public void method1() {
		System.out.println("/sub3/link1에서 일하는 메서드!!!!!!!!!");
	}

	@RequestMapping("link2")
	public void method2() {
		System.out.println("/sub3/link2에서 일하는 메서드!!!!!!!!!");
	}
	
}
