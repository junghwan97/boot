package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.study.demo.domain.Dto02;
import com.study.demo.domain.Dto03;
import com.study.demo.domain.Dto04;

@Controller
@RequestMapping("sub8")
public class Controller08 {

	@RequestMapping("link1")
	public String method1(@ModelAttribute("player") Dto04 dto04) {

		dto04.setName("채소연");
		dto04.setAge(22);

		return "sub7/link10";
	}

	@RequestMapping("link2")
	public String method2(@ModelAttribute("product") Dto02 dto02) {
		dto02.setCompany("Apple");
		dto02.setModel("Iphone14");
		dto02.setPrice(1000);
		return null;
	}

	@RequestMapping("link3")
	public void method3(Model model) {
		Dto02 dto2 = new Dto02();
		Dto03 dto3 = new Dto03();
		model.addAttribute("product", dto2);
		model.addAttribute("member", dto3);
	}

	@RequestMapping("link4")
	public void method4(@ModelAttribute("product") Dto02 dto02, @ModelAttribute("member") Dto03 dto03) {
		// 3. add attribute
		// 4. forward
		// 위 과정들을 수행
	}

	// @ModelAttribute의 이름을 생략하면 클래스 이름을 lowerCamelCase
	// 예 ) CompanyMember -> companyMember
	@RequestMapping("link5")
	public void method5(@ModelAttribute Dto02 dto02, // @ModelAttribute("dto02") Dto02 dto02와 같음
						@ModelAttribute("dto03") Dto03 dto03) {

		// 3. add attribute
		dto02.setCompany("apple");
		dto03.setName("steve");
		// 4. forward
		// 위 과정들을 수행
	}
}
