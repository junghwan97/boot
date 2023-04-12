package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("sub6")
public class Controller06 {

	@RequestMapping("link1")
	public String method1() {
		System.out.println("link1 method is working");
		return "forward:/sub6/link2";
		
		// 1. request param 얻기 / 제공  
		// 2. business logic 실행
		// 3. add attribute
		// 4. forward / redirect -> 반환값을 주고 forward
	}

	@RequestMapping("link2")
	public void method2() {
		System.out.println("link2 method is working");
	}

	// 경로 : /sub6/link3
	@RequestMapping("link3")
	public String method3() {
		System.out.println("link3 method is working");
		return "forward:/sub6/link2";
	}

	@RequestMapping("link4")
	public void method4(HttpServletRequest req, HttpServletResponse res) throws Exception {

		System.out.println("link4 에서 일함");

		String view = "/WEB-INF/views/abc.jsp";
		req.getRequestDispatcher(view).forward(req, res);
		
		// 1. request param 얻기 / 제공  
		// 2. business logic 실행
		// 3. add attribute
		// 4. forward / redirect -> jsp 파일 요청하여 보기
	}

	@RequestMapping("link5")
	public String method5() {
		System.out.println("link5 working");
		return "forward:/WEB-INF/views/abc.jsp";
	}
	
	@RequestMapping("link6")
	public String method6() {
		System.out.println("link6 일함");
		return "abc";
	}
	
	@RequestMapping("link7")
	public String method7() {
		System.out.println("link7 일함");
		return "def";
	}
	
//	@RequestMapping("link71")
//	public void method71(HttpServletRequest req, HttpServletResponse res) throws Exception{
//		String view = "/WEB-INF/views/def.jsp";
//		req.getRequestDispatcher(view).forward(req, res);	
//	}
	
	// 경로 : /sub6/link8
	@RequestMapping("link8")
	public String method8() {
		System.out.println("8번 메서드 일함");
		// defalut view name : /sub6/link8
		
		return "/sub6/link8";
	}
	
	// 경로 : /sub6/link9
	@RequestMapping("link9")
	public void method9() {
		System.out.println("9번 메서드 일함");
		// defalut view name : /sub6/link9
	}
	
	@RequestMapping("link10")
	public String method10() {
		System.out.println("link10 메서드 일함");
		return null; // forward default view name
	}
	
	// 경로 : /sub6/link11
	@RequestMapping("link11")
	public void method11() {
		System.out.println("link11 메서드 일함");
	}
//	@RequestMapping("link11")
//	public String method11() {
//		System.out.println("link11 메서드 일함");
//		return null;
//	}
//	@RequestMapping("link11")
//	public String method11() {
//		System.out.println("link11 메서드 일함");
//		return "/sub6/link11";
//	}
	
	// 경로 : /sub6/link12?name=park&age=33
	// 1. request parameter 수집 / 가공
	// 2. business logic (생략)
	// 3. add attribute (생략)
	// 4. /WEB-INF/views/sub6/link12.jsp로 forward
	
	
	// 경로 : /sub6/link12?name=park&age=33
	// method12 작성
	// 1. request param 수집/가공
	// 2. business logic (생략)
	// 3. add attribute(생략)
	// 4. /WEB-INF/views/sub6/link12.jsp 로 포워드
	@RequestMapping("link12")
	public void method12(String name, int age) {
		System.out.println(name);
		System.out.println(age);
	}
}















