package com.study.demo.domain;

import java.time.LocalDate;

import lombok.Data;

@Data
public class Employee {
	private int id;
	private String lastName;
	private String firstName;
	private LocalDate birth;
	private String photo;
	private String notes;
}
