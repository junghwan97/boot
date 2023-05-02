package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("sub25")
public class Controller25 {
	
	@RequestMapping(path = "link1", method = RequestMethod.GET)
	public void method1() {
		// Get방식이 지원되지 않는다는 오류
		System.out.println("/sub25/link1에서 일하는 메서드");
	}
	
	//@RequstMapping(value = "link2", method = RequestMethod.GET)
	@GetMapping("link2")
	public void method2() {
		System.out.println("/sub25/link2 GET");
	}
	
	//@RequestMapping(value = "link3", method = RequestMethod.POST)
	@PostMapping("link3")
	public void method3() {
		System.out.println("/sub25/link3 POST에서 메서드 일함");
	}
	
	// /sub25/link4/abc
	// /sub25/link4/def
	@GetMapping("link4/{var1}")
	public void method4(@PathVariable("var1")String p1) {
		System.out.println("var1 : " + p1);
	}
	
	// localhost:8080/sub25/link5/abc/25
	@GetMapping("link5/{id}/{age}")
	public void method5(@PathVariable("id") String id,
						@PathVariable("age") int age) {
		System.out.println(id + "," + age);
	}
	
	// /sub25/link6/id/5/name/son
	@GetMapping("link6/id/{var1}/name/{var2}")
	public void method6(@PathVariable("var1") String id,
						@PathVariable("var2") String name) {
		System.out.println(id + "," + name);
	}
	
	@GetMapping("link7")
	public String method7() {
		
		return "hello"; // /WEB-INF/views/hello.jsp
	}
	
	// redirect
	// redirect를 사용하면 클라이언트의 브라우저가 새로운 페이지를 로딩하게 되므로,
	// 새로운 페이지에서는 이전 페이지에서 사용한 데이터를 유지할 수 없습니다.
	@GetMapping("link8")
	public String method8() {
		return "redirect:/sub25/link7";
	}
	
	// 경로 : /sub25/link9?value1
	@GetMapping("link9")
	public String method9(Model model) {
		
		model.addAttribute("attr1", "value1");
		// model 속 데이터를 view로 건네줄 때 request 사용
		return "redirect:link10";
	}
	
	@GetMapping("link10")
	public void method10() {
		
	}
	
	@GetMapping("link11")
	public String method11(RedirectAttributes rttr) {
		rttr.addFlashAttribute("attr1", "redriect attribute!");
		
		return "redirect:link10";
	}
	
	@GetMapping("link12")
	public String method12(RedirectAttributes rttr) {
		List<String> list = new ArrayList<>();
		list.add("java");
		list.add("Spring");
		rttr.addFlashAttribute("list", list);
		
		return "redirect:link13";
	}
	
	@GetMapping("link13")
	public void method13() {
		
	}
	
	@GetMapping("link14")
	public String method14(RedirectAttributes rttr) {  
//		목적지의 Model Attribute로
//		rttr.addFlashAttribute(null, rttr);
		
		// 쿼리 스트링으로 붙어서
		rttr.addAttribute("address", "Seoul");
		
		return "redirect:link15";
	}
	
	@GetMapping("link15")
	public String method15(RedirectAttributes rttr) {
		rttr.addAttribute("email", "google@gmail.com");
		rttr.addAttribute("location", "Seoul");
		
		return "redirect:link16";
	}
	
	@GetMapping("link16")
	public void method16(@RequestParam("email") String email,
						 @RequestParam("location") String location) {
		
		System.out.println("email : " + email);
		System.out.println("location : " + location);
		
	}
}
