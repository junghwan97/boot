package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

import com.study.demo.domain.Dto01;
import com.study.demo.domain.Dto02;
import com.study.demo.domain.Dto04;

import jakarta.servlet.http.*;

@Controller
@RequestMapping("sub7")
public class Controller07 {

	@RequestMapping("link1")
	public void method1(HttpServletRequest req) {
		// 1.
		// 2.
		// 3. add attribute
		req.setAttribute("myName", "서태웅");
		
		// 4. /WEB-INF/views/sub7/link1.jsp 로 포워드
	}
	
	@RequestMapping("link2")
	public String method2(Model model) {
		
		// 3. add attribute
		model.addAttribute("myName", "채치수");
		
		// 4. forward / redirect
		return "/sub7/link1";
	}
	
	// 경로 : /sub7/link3
	@RequestMapping("link3")
	public void method13(Model model) {
		model.addAttribute("myAddress", "Seoul");
	}
	
	@RequestMapping("link4")
	public String method14(Model model) {
		// Model : addAttribute(String attributeName, Object attributeValue)
		model.addAttribute("list", List.of("java", "spring"));
		return null;
//		= return "/sub7/link4";
	}
	
	@RequestMapping("link5")
	public void method15(Model model) {
		model.addAttribute("myMap", Map.of("address", "Goyang", "age", "27", "email", "123@gmail.com"));
	}
	
	@RequestMapping("link6")
	public void method16(Model model) {
		model.addAttribute("name", "이한나");
		model.addAttribute("job", "매니저");
		model.addAttribute("hobby", List.of("영화", "독서", "TV"));
	}
	
	@RequestMapping("link7")
	public void method17(Model model) {
		model.addAttribute("age", 40);
		model.addAttribute("country", "Korea");
		
		List<String> list = new ArrayList<>();
		list.add("괴물");
		list.add("설국열차");
		list.add("기생충");
		list.add("옥자");
		list.add("살인의 추억");
		model.addAttribute("movieList", list);
	}
	
	@RequestMapping("link8")
	public void method8	(Model model) {
		Dto01 o1 = new Dto01();
		o1.setName("박지성");
		o1.setAge(40);
		model.addAttribute("player", o1);
	}
	
	@RequestMapping("link9")
	public void method9(Model model) {
		Dto02 o2 = new Dto02();
		o2.setModel("K9");
		o2.setPrice(8000);
		o2.setCompany("Kia");
		model.addAttribute("value", o2);
	}
	
	@RequestMapping("link10")
	public void method10(Model model) {
		Dto04 o4 = new Dto04();
		model.addAttribute("player", o4);
		o4.setName("sonny");
		o4.setAge(31);
	}
	
	
}