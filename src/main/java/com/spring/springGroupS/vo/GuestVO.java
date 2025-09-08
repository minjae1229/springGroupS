package com.spring.springGroupS.vo;

import lombok.Data;

@Data
public class GuestVO {
	private int idx;
	private String name;
	private String content;
	private String email;
	private String homePage;
	private String vDate;
	private String hostIp;
	
	public String getvDate() {
		return vDate;
	}
	public void setvDate(String vDate) {
		this.vDate = vDate;
	}
}
