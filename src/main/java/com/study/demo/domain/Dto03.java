package com.study.demo.domain;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
// 위에 다 합친 어노테이션 @Data
@AllArgsConstructor
@NoArgsConstructor
public class Dto03 {
	private String name;
	private int age;

}
