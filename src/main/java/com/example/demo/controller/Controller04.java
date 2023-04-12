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

		// 2.
		// 3.
		// 4.
	}

	// 경로 : /sub4/link6?email=son@email.com
	@RequestMapping("link6")
	public void method06(@RequestParam /* ("email") */ String email) {
		// request parameter와 method argument의 이름이 같다면 @RequestParam 인자 생략 가능
		// https://docs.spring.io/spring-framework/docs/current/reference/html/web.html#mvc-ann-arguments
		// Any other argument

		System.out.println("email : " + email);
	}

	// 경로 : /sub4/link7?age=33

	@RequestMapping("link7")
	public void method07(@RequestParam int age) {
		System.out.println("age : " + age);
	}

	// 경로 : /sub4/link8?address=Seoul
	@RequestMapping("link8")
	public void method08(String address) {
		// any other Param으로 @ReqeustParam이 생략 가능하지만 가독성이 떨어진다.
		System.out.println("address : " + address);
	}
	
	// 경로 : /sub4/link9?score=100.0
	@RequestMapping("link9")
	public void method09(double score) {
		System.out.println("score : " + score);
	}
}
