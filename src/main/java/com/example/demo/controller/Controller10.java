package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.study.demo.domain.Dto04;

@Controller
@RequestMapping("sub10")
public class Controller10 {
	
	@RequestMapping("link1")
	public void method1(@RequestParam("name") String name) {
		
		// Servlet api와 비교해서 생략된 코드 : String name = request.getParameter("name");
	}
	
	@RequestMapping("link2")
	public void method2(@ModelAttribute Dto04 dto) {

// 		Servlet api와 비교해서 생략된 코드 :
//		Dto04 dto = new Dto04();
//		dto.setName(request.getParameter("name"));
//		dto.setAge(Integer.parseInt(request.getParameter("age"));
//		
//		request.setAtttibute("dto04", dto);
	}
	
	// sub10/link3?model=ray&price=3.14&name=son&age22
	@RequestMapping("link3")
	public void method3(String model, // @RequestParam
						double price, // @RequestParam
						Dto04 dto,     // @ModelAttribute
						Model m) {  
		
		// model과 price는 model에 저장된 것이 아니기 때문에 view에서 볼 수 없음
		// view에서 보려면 model m에 저장하는 코드를 작성
		m.addAttribute("model", model);
		m.addAttribute("price", price);
	}
	
//	// sub10/link3?model=ray&price=3.14&name=son&age22
//		@RequestMapping("link3")
//		public void method4(
//							@ModelAttribute	
//							String model, // @RequestParam
//							@ModelAttribute("price")
//							double price, // @RequestParam
//							Dto04 dto,     // @ModelAttribute
//							Model m) {  
//			
//			// model과 price는 model에 저장된 것이 아니기 때문에 view에서 볼 수 없음
//			
//			m.addAttribute("model", model);
//			m.addAttribute("price", price);
//		}
	
	@RequestMapping("link4")
	public void method4() {
		// 1. request param 수집 / 제공

		// 2. business logic
		// data를 생성 (create), 읽기 (read), 수정 (update), 삭제(delete) -> 위의 코드들로 2번에만 집중할 수 있게 됨
		
		// 3. add attribute
		// 4. forward
		
	}
	
}
