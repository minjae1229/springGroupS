package com.spring.springGroupS.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.spring.springGroupS.vo.BmiVO;

@Service
public class BmiService {
	
	public void calcBmi(BmiVO vo) {
		double height = vo.getHeight() / 100.0;	// 미터로 변환
		double bmi = vo.getWeight() / (height * height); // bmi 계산식 : 몸무게 / (키*키)
		
		String result;
		if(bmi < 18.5) result = "저체중";
		else if(bmi < 22.9) result = "정상";
		else if(bmi < 24.9) result = "과체중";
		else result = "비만";
		
		vo.setBmi(Math.round(bmi * 100) / 100.0); // 소수점 2자리 반올림
		vo.setResult(result);
	}
	
	public void calcBmiList(List<BmiVO> vos) {
		for(BmiVO vo : vos) {
			calcBmi(vo);
		}
	}
}
