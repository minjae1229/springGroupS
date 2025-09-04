package com.spring.springGroupS.vo;

import lombok.Data;

@Data
public class BmiVO {
	private String name;
	private double height;
	private double weight;
	
	private double bmi;			// 계산한 BMI
	private String result;	// 비만도
}
