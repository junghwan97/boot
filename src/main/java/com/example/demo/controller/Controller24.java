package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.mapper.Mapper05;
import com.study.demo.domain.Customer;
import com.study.demo.domain.Employee;

@Controller
@RequestMapping("sub24")
public class Controller24 {

	@Autowired
	private Mapper05 mapper;
	
	@RequestMapping("link1")
	public void method1() {
		int cnt = mapper.sql1();
		System.out.println(cnt + "개의 행이 수정됨");
	}
	
	@RequestMapping("link2")
	public void method2() {
		int cnt = mapper.sql2(3, "마이바티스", 9834);
		System.out.println(cnt + "개의 행이 수정됨");
	}
	
//	public void method2(Integer key, String val1, Integer val2) {
//		int cnt = mapper.sql2(key, val1, val2);
//		System.out.println(cnt + "개의 행이 수정됨");
//	}
	
	@RequestMapping("link3")
	public void method3() {
		int cnt = mapper.sql3(10, "새로운 고객명", "대한민국");
		System.out.println(cnt + "개의 행 수정됨");
	}
	
	
	// /sub24/link4?id=3&name=sdf&contactName=dddd&address=Gangnam&city=Seoul&postalCode=111-111&country=Korea
	@RequestMapping("link4")
	public void method4(Customer customer) {
		
		int cnt = mapper.sql4(customer);
		System.out.println(cnt + "개의 행이 수정됨");
	}
	
	@RequestMapping("link5")
	public void method5(Customer customer) {
		int cnt = mapper.sql4(customer);
		System.out.println(cnt + "개 행 수정됨");
	}
	
	@RequestMapping("link6")
	public void method6(Integer id, Model model) {
		Customer customer = mapper.sql5(id);
		model.addAttribute("customer", customer);
	}
	
	@RequestMapping("link7")
	public void method7(Integer id, Model model) {
		Employee employee = mapper.sql7(id);
		model.addAttribute(employee); // 해당 model을 참고하여 view화면에 전달
		
	}
	
	@RequestMapping("link8")
	public void method8(@ModelAttribute("employee") Employee employee) {
		int cnt = mapper.sql6(employee);
		System.out.println(cnt + "개의 행 수정됨");
		
	}
}


