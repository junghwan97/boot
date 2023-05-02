package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.mapper.Mapper06;
import com.study.demo.domain.Customer;

@Controller
@RequestMapping("sub26")
public class Controller26 {

	@Autowired
	private Mapper06 mapper;
	
	// 경로 : /sub26/link1?page=3 -> 3페이지
	// 경로 : /sub26/link1?page=1 -> 1페이지
	// 경로 : /sub26/link1        -> 1페이지
	@GetMapping("link1")
	public String method1(@RequestParam(value = "page", defaultValue = "1") Integer page, Model model) {
//		System.out.println(page);
		
		// 쿼리에서 사용하는 시작 인덱스
		Integer startIndex = (page - 1) * 20;
		
		// 페이지네이션 가장 왼쪽 번호, 오른쪽 번호 구하기
		Integer leftPageNumber = (page-1) / 10 * 10 + 1;
		Integer rightPageNumber = leftPageNumber + 9;
		
		// 이전, 다음 버튼 페이지 번호 구하기
		Integer prevPageNumber = leftPageNumber - 10;
		Integer nextPageNumber = rightPageNumber + 1;
//		
		// 마지막 페이지 구하기
		Integer numOfRecord = mapper.countAll();
		Integer lastPageNumber = (numOfRecord + 19) / 20;
//		
		// 오른쪽 페이지 번호가 마지막 페이지 번호보다 클 수 없음
		rightPageNumber = Math.min(rightPageNumber, lastPageNumber);
		
		// 맨처음, 맨마지막으로 가는 페이지
		Integer firstPageNumber = 1;
		
		List<Customer> list = mapper.listCustomer(startIndex);
		
		model.addAttribute("customerList", list);
		model.addAttribute("leftPageNumber", leftPageNumber);
		model.addAttribute("rightPageNumber", rightPageNumber);
		model.addAttribute("prevPageNumber", prevPageNumber);
		model.addAttribute("nextPageNumber", nextPageNumber);
		model.addAttribute("lastPageNumber", lastPageNumber);
		model.addAttribute("currentPageNumber", page);
		model.addAttribute("firstPageNumber", firstPageNumber);
		
		return "sub13/link1";
	}
}
