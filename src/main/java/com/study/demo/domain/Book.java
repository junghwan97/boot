package com.study.demo.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.Data;

@Data
public class Book {

	private String title;
	private LocalDate published;
	private int price;
	private LocalDateTime updated;
	private double weight;
}
