package com.example.demo.controller;

import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

import com.study.demo.domain.Dto02;
import com.study.demo.domain.Dto04;

import jakarta.servlet.http.*;

@Controller
@RequestMapping("sub9")
public class Controller09 {

	@RequestMapping("link1")
	public String method01(HttpServletRequest req, Model model) {
		// 1. request parameter 수집/가공
		String name = req.getParameter("name");
		int age = Integer.parseInt(req.getParameter("age"));
		
		Dto04 obj = new Dto04();
		obj.setName(name);
		obj.setAge(age);
		
		// 2. business logic
		
		// 3. add attribute
		model.addAttribute("value", obj);
		
		// 4. forward / redirect
		// /WEB-INF/views/sub9/link1.jsp  로 포워드
		return "/sub9/link1"; 
	}
	
	// sub9/link2?name=park&age=50
	@RequestMapping("link2")
	public String method2(@ModelAttribute("value") Dto04 obj) {
		//@ModelAttribute : 
		// = Dto04 obj = new Dto04(); 
		// 	 obj.setName(name);
		// 	 obj.setAge(age); 
		// + model.addAttribute("value", obj);
		return "sub9/link1";
		
	}
	
//	// sub9/link2?name=park&age=50
//		@RequestMapping("link3")
//		public String method3(@ModelAttribute("value") String name, int age) {
//			//@ModelAttribute : 
//			// = Dto04 obj = new Dto04(); 
//			// 	 obj.setName(name);
//			// 	 obj.setAge(age); 
//			// + model.addAttribute("value", obj);
//			return "sub9/link1";
//			
//		}
	
	@RequestMapping("link3")
	public void method3(@ModelAttribute("attr") Dto04 dto04) {
		// 1. request param 수집 / 가공
		// Dto04 객체 만듦
		// name 요청 파라미터를 위 객체에 셋팅
		// age 요청 파라미터 위 객체에 셋팅
		
		// 3. add attribute 추가
		// 위 객체를 attr 이름으로 model 추가
		
		// 4. forward / redirect
		// WEB-INF/views/sub9/link3.jsp로 포워드
	}
	
	@RequestMapping("link4")
	public void meethod4(Dto04 dto04) {
		// 기본 자료형 String wrapper 형이 아니면 @ModelAttribute로 간주, 맞다면 @RequestParam
		// 1. request param 수집 / 가공
		// Dto04 객체 만듦
		// name 요청 파라미터를 위 객체에 셋팅
		// age 요청 파라미터 위 객체에 셋팅
				
		// 3. add attribute 추가
		// 위 객체를 dto04 이름으로 model 추가
				
		// 4. forward / redirect
		// WEB-INF/views/sub9/link4.jsp로 포워드
	}
	
	// 경로 : /sub9/link5?model=sonata&company=hyundai&price=3000
	@RequestMapping("link5")
	public void method5(Dto02 dto) {
		
		// 1. request param 수집 / 가공
		// Dto04 객체 만듦
		// name 요청 파라미터를 위 객체에 셋팅 -> @ModelAttribute가 하는 역할
		// age 요청 파라미터 위 객체에 셋팅 -> @ModelAttribute가 하는 역할
						
		// 3. add attribute 추가
		// 위 객체를 dto02 이름으로 model 추가
						
		// 4. forward / redirect
		// WEB-INF/views/sub9/link5.jsp로 포워드		
	}
}