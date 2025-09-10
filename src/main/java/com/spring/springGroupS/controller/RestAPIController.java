package com.spring.springGroupS.controller;

import java.awt.Point;

//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/*@Controller*/

@RestController
@RequestMapping("/restApi")
public class RestAPIController {
	
	// Rest Controller를 통한 일반 메시지 처리3(o)
	@GetMapping("/restApi1/{message}")
	public String restApi1Get(@PathVariable String message) {
		System.out.println("message : " + message);
		return "message : " + message;
	}
	
	// Rest Controller를 통한 객체 처리4(o)
	@RequestMapping(value = "/restApi2/{message}", method = RequestMethod.GET)
//	public String restApi2Get(@PathVariable String message) {
	public Point restApi2Get(@PathVariable String message) {
		System.out.println("message : " + message);
		
		Point p = new Point(123, 567);
		System.out.println("p : " +p);
		
//		return p.toString();
		return p;
	}
}
