package com.spring.springGroupS.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.spring.springGroupS.vo.SungjukVO;

@Service
public class SungjukService {
	
	public void calcSungjuk(SungjukVO vo) {
		int tot = vo.getKor() + vo.getEng() + vo.getMat();
		double avg = tot / 3.0;
		
		String grade;
		if(avg >= 90) grade = "A";
		else if(avg >= 80) grade = "B";
		else if(avg >= 70) grade = "C";
		else if(avg >= 60) grade = "D";
		else grade = "F";
		
		vo.setTot(tot);
		vo.setAvg(avg);
		vo.setGrade(grade);
	}
	
	public void calcSungjukList(List<SungjukVO> vos) {
		for(SungjukVO vo : vos) {
			calcSungjuk(vo);
		}
	}
}
