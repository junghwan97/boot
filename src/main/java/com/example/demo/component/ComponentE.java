package com.example.demo.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ComponentE {

	@Autowired
	// @Autowired 어노테이션을 사용하면 Spring 컨테이너에서 해당 타입의 빈(Bean)을 찾아 의존성을 자동으로 주입할 수 있습니다.
	private ComponentD comp;
	
	public ComponentD getComp() {
		return comp;
	}
}
