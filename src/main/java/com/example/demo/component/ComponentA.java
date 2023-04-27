package com.example.demo.component;

public class ComponentA {

	private ComponentB comp;
	
	
	// 필드에 값을 설정하는 2가지 -- 의존성 주입
	
	// 1. 생성자
	public ComponentA(ComponentB comp) {
		this.comp = comp;
	}

	// 2. set method
	public void setComp(ComponentB comp) {
		this.comp = comp;
	}

	public ComponentB getComp() {
		return comp;
	}

	
	
}
