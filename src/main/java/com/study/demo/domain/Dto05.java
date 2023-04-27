package com.study.demo.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.Data;

@Data
public class Dto05 {

	private int age;
	private String name;
	private LocalDate birth;
	private double price;
	private LocalDateTime inserted;
}
