package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sub02")
public class Controller02 {

	@RequestMapping("/link1")
	public void method01() {
		System.out.println("/sub2/link1에서 일하는 메서드!!");
	}
	
	@RequestMapping("/link2")
	public void method02() {
		System.out.println("/sub2/link2에서 일하는 메서드!!");
	}
	
}
