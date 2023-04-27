package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.mapper.Mapper03;
import com.study.demo.domain.Dto09;
import com.study.demo.domain.Dto10;
import com.study.demo.domain.Dto11;
import com.study.demo.domain.Dto12;

@Controller
@RequestMapping("sub22")
public class Controller22 {

	@Autowired
	private Mapper03 mapper;
	
	@RequestMapping("link1")
	public void method1() {
		int cnt1 = mapper.sql1(77, "java");
		int cnt2 = mapper.sql1(88, "jsp");
		int cnt3 = mapper.sql1(99, "css");
		
		System.out.println(cnt1);
		System.out.println(cnt2);
		System.out.println(cnt3);
	}
	
	
	@RequestMapping("link2")
	public void method2() {
		System.out.println(mapper.sql2(7.987, "hello mybatis"));
		System.out.println(mapper.sql2(392742.283, "hi weekend"));
	}
	
	
	
	// /sub22/link3?val1=2.3&val2=spring
	@RequestMapping("link3")
	public void method3(Double v1, String v2) {
		System.out.println(mapper.sql2(v1, v2));
	}
	
	@RequestMapping("link4")
	public void method4() {
		Dto09 dto = new Dto09();
		dto.setProp1(300);
		dto.setProp2("hello mybatis");
		dto.setProp3(33.33);
		
		int cnt = mapper.sql3(dto);
		System.out.println(cnt);
	}
	
	@RequestMapping("link5")
	public void method5() {
		Dto10 dto = new Dto10();
		dto.setAge(30);
		dto.setName("손흥민");
		dto.setScore(23.5);
		int cnt = mapper.sql4(dto);
		System.out.println(cnt);
	}
	
	@RequestMapping("link6")
	public void method6(Dto10 dto) {
		int cnt = mapper.sql4(dto);
		System.out.println(cnt + "개의 행이 입력됨");
	}
	
	@RequestMapping("link7")
	public void method7(Dto09 dto) {
		int cnt = mapper.sql3(dto);
		System.out.println(cnt + "개의 행이 입력됨");
	}
	
	@RequestMapping("link8")
	public void method8() {
		Dto09 dto1 = new Dto09();
		Dto10 dto2 = new Dto10();
		dto1.setProp1(345);
		dto2.setName("서태웅");
		dto1.setProp3(99.88);
		int cnt = mapper.sql5(dto1, dto2);
		System.out.println(cnt + "개의 행이 입력됨");
	}
	
	@RequestMapping("link9")
	public void method9() {
	Dto09 dto1 = new Dto09();
	Dto10 dto2 = new Dto10();
	
	dto1.setProp1(10);
	dto1.setProp2("해리");
	dto1.setProp3(9.9);
	
	dto2.setAge(29);
	dto2.setName("케인");
	dto2.setScore(10.999);
	
	int cnt = mapper.sql6(dto1, dto2);
	System.out.println(cnt + "개의 행이 입력됨");
	}
	
	// / sub22/link10?prop1=7&prop2=lunch&prop3=3.14&age=44&name=nick&score=99.55
	@RequestMapping("link10")
	public void method10(Dto09 p1, Dto10 p2) {
//		Dto09 p1 = new Dto09();
//		Dto10 p2 = new Dto10();
		int cnt = mapper.sql6(p1, p2);
		System.out.println(cnt + "개의 행 입력");
	}
	
	// /sub22/link11?prop2=mybaits&prop3=321
	@RequestMapping("link11")
	public String method11(Dto11 dto) {
		System.out.println("prop1 : " + dto.getProp1());
		int cnt = mapper.sql7(dto);
		System.out.println("prop1 : " + dto.getProp1());
		
		System.out.println(cnt + "개의 행 입력");
		
		return dto.getProp1() + "번째 데이터 입력완료";
	}
	
	// /sub22/link12?age=40&name=son&score=9.9
	@RequestMapping("link12")
	public void method12(Dto12 dto) {
		int cnt = mapper.sql8(dto);
		System.out.println(cnt + "개의 행 입력");
	}
	
}
