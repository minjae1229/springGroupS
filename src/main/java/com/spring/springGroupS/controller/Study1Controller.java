package com.spring.springGroupS.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.springGroupS.service.Study1Service;
import com.spring.springGroupS.vo.HoewonVO;
import com.spring.springGroupS.vo.SiteInfor2VO;
import com.spring.springGroupS.vo.SiteInforVO;
import com.spring.springGroupS.vo.SungjukVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/study1") // 중간 경로 설정
public class Study1Controller {
	
	@Autowired
	Study1Service study1Service; // 생성하지 않고 사용
	
//	@RequestMapping(value = "/study1/mapping/menu", method = RequestMethod.GET)
//	public String menuGet() {	// method 먼저 작성시 @ 작성시 ctrl + space 가능
//		return "study1/mapping/menu";
//	}

	/*------------------------ 1.Query String 방식 -----------------------*/	
	
	@GetMapping("/mapping/menu") // spring boot에서는 rest api가 기본이므로 무조건 @GetMapping만 사용가능
	public String menuGet() {
		return "study1/mapping/menu";
	}
	@GetMapping("/mapping/test1")	// 기존 jsp에서 사용하던 방식 
	public String test1Get(HttpServletRequest request) {
		String mid = request.getParameter("mid");
		String pwd = request.getParameter("pwd");
		
		request.setAttribute("mid", mid);
		request.setAttribute("pwd", pwd);
		
		return "study1/mapping/test01";
	}
	@GetMapping("/mapping/test2") // spring 저장소 Model을 사용하자.
	public String test2Get(Model model, String mid, String pwd) { // model 객체는 자동생성되었다.
		model.addAttribute("mid", mid);
		model.addAttribute("pwd", pwd);
		return "study1/mapping/test02";
	}
	@GetMapping("/mapping/test3") // 매개변수의 이름을 다르게 주는 경우, boot에서는 필수이다.
	public String test3Get(Model model,
			@RequestParam(name="mid") String id,
			@RequestParam(name="pwd") String passwd
			) {
		model.addAttribute("mid", id);
		model.addAttribute("pwd", passwd);
		return "study1/mapping/test03";
	}
	@GetMapping("/mapping/test4") // 매개변수의 값을 받지 못한 경우 default 설정
	public String test4Get(Model model,
			@RequestParam(name="mid") String id,
			@RequestParam(name="pwd") String passwd,
			@RequestParam(name="name", defaultValue="손님", required = false) String name,
			@RequestParam(name="sex") int gender // type을 변경 가능(String -> int)
			) {
		model.addAttribute("mid", id);
		model.addAttribute("pwd", passwd);
		model.addAttribute("name", name);
		
		if(gender == 1 || gender == 3) {
			model.addAttribute("gender", "남자");
		}
		else if(gender == 2 || gender == 4) {
			model.addAttribute("gender", "여자");
		}
		else {
			model.addAttribute("gender", "사람아님");
		}
		return "study1/mapping/test04";
	}
	
	@GetMapping("/mapping/test5") // type 형변환 age (String -> int)
	public String test5Get(Model model, String mid, String pwd, String name, String gender, int age) { 
		model.addAttribute("mid", mid);
		model.addAttribute("pwd", pwd);
		model.addAttribute("name", name);
		model.addAttribute("gender", gender);
		model.addAttribute("age", age);
		return "study1/mapping/test05";
	}
	@GetMapping("/mapping/test6") // type 형변환 age (String -> int)
	public String test6Get(Model model, String mid, String pwd, String name, String gender, int age) { 
		HoewonVO vo = new HoewonVO();
		
		vo.setMid(mid);
		vo.setPwd(pwd);
		vo.setName(name);
		vo.setGender(gender);
		vo.setAge(age);
		
		model.addAttribute("vo", vo);
		return "study1/mapping/test06";
	}
	@GetMapping("/mapping/test7") // type 형변환 age (String -> int)
	public String test7Get(Model model, String mid, String pwd, String name, String gender, int age, HoewonVO vo) { 
		/* HoewonVO vo = new HoewonVO(); */
		
		vo.setMid(mid);
		vo.setPwd(pwd);
		vo.setName(name);
		vo.setGender(gender);
		vo.setAge(age);
		
		model.addAttribute("vo", vo);
		return "study1/mapping/test07";
	}
	@GetMapping("/mapping/test8") 
	public String test8Get(Model model, HoewonVO vo) { 
		model.addAttribute("vo", vo);
		return "study1/mapping/test08";
	}
	@GetMapping("/mapping/test9") 
	public ModelAndView test9Get(Model model, HoewonVO vo) { // use modelAndView
		ModelAndView mv = new ModelAndView("study1/mapping/test09");
		mv.addObject("vo",vo);
		return mv;
	}

	/*------------------------ 2.path variable 방식 -----------------------*/
	
	@GetMapping("/mapping/test21/{mid}/{pwd}") 
	public String test21Get(Model model, @PathVariable String mid, @PathVariable String pwd) {
		model.addAttribute("mid", mid);
		model.addAttribute("pwd", pwd);
		return "study1/mapping/test21";
	}
	@GetMapping("/mapping/test22/{id}/{passwd}") 
	public String test22Get(Model model, @PathVariable String id, @PathVariable String passwd) {
		model.addAttribute("mid", id);
		model.addAttribute("pwd", passwd);
		return "study1/mapping/test22";
	}
	@GetMapping("/mapping/{passwd}/test23/{id}") 
	public String test23Get(Model model, @PathVariable String id, @PathVariable String passwd) {
		model.addAttribute("mid", id);
		model.addAttribute("pwd", passwd);
		return "study1/mapping/test23";
	}
	@GetMapping("/mapping/{passwd}/{temp}/test24/{id}") 
	public String test24Get(Model model, @PathVariable String id, @PathVariable String temp, @PathVariable String passwd) {
		model.addAttribute("mid", id);
		model.addAttribute("pwd", passwd);
		return "study1/mapping/test24";
	}
	@GetMapping("/mapping/test25/{mid}/{pwd}/{name}/{temp}/{gender}/{age}") 
	public String test25Get(Model model, HoewonVO vo) {
		model.addAttribute("vo", vo);
		return "study1/mapping/test25";
	}
	
	/*------------------------ 3.post 방식 -----------------------*/
	
//	@RequestMapping(value = "/mapping/test31", method = RequestMethod.POST)
	@PostMapping("/mapping/test31")
	public String test31Post(Model model, HoewonVO vo,
			String mid,
			String pwd,
			String name, 
			String strGender,
			int age,
			String nickName
			) {
		vo.setMid(mid);
		vo.setPwd(pwd);
		vo.setName(name);
		vo.setGender(strGender);
		vo.setAge(age);
		
		model.addAttribute("vo", vo);
		return "study1/mapping/test31";
	}
	@PostMapping("/mapping/test32")
	public String test32Post(Model model, HoewonVO vo) {
		model.addAttribute("vo", vo);
		return "study1/mapping/test32";
	}
	
	@GetMapping("/mapping/test33") // message.jsp에서 넘어옴
	public String test33Get(Model model, String mid, HoewonVO vo) {
		// 아이디로 DB에서 회원정보를 가져와서 VO에 담아 넘겨주게 설계할 예정
		vo.setMid(mid);
		model.addAttribute("vo", vo);
		return "study1/mapping/test33";
	}
	@PostMapping("/mapping/test33")
	public String test33Post(Model model, HoewonVO vo) {
		// DB에 회원정보를 저장할 예정
		model.addAttribute("message", vo.getMid()+ "님 회원가입 승인");
		model.addAttribute("url", "/study1/mapping/test33");		
		model.addAttribute("mid", vo.getMid());		
	// 주의! message는 get 방식이다.
	/* model.addAttribute("url", "/study1/mapping/test33?mid="+vo.getMid()); */ 		
		return "include/message";
	}
	
	@PostMapping("/mapping/test34") // 새로고침시 회원가입이 계속 되는 문제 발생 우려됨..
	public String test34Post(Model model, HoewonVO vo) {
	// DB에 회원정보를 저장할 예정
		System.out.println("1.이곳에 회원 정보를 DB에 저장처리할 예정입니다. ");
		
		model.addAttribute("message", "회원가입 승인");
		model.addAttribute("url", "/study1/mapping/test34");
		
		model.addAttribute("vo", vo);
		return "study1/mapping/test34";
	}
	
	@GetMapping("/mapping/test35") // MessageController 에서 넘어옴
	public String test35Get(Model model, HoewonVO vo) {
		// 아이디로 DB에서 회원정보를 가져와서 VO에 담아 넘겨주게 설계할 예정
//		vo.setMid(mid);
		model.addAttribute("vo", vo);
		
		return "study1/mapping/test35";
	}
	@PostMapping("/mapping/test35") // 해당 방식 사용(새로고침시 중복회원가입 방지)
	public String test35Post(Model model, HoewonVO vo) {
		// [문제]회원아이디의 첫글자가 'a'로 시작하는 회원만 가입하도록 처리

		if(vo.getMid().substring(0,1).equals("a")) {
			// DB에 회원정보를 저장할 예정
			System.out.println("2.이곳에 회원 정보를 DB에 저장처리할 예정입니다. ");
			
			// query string 방식 사용...
			return "redirect:/message/hoewonInputOk?mid="+vo.getMid(); // 컨트롤러로 보내는 명령 redirect
		}
		else {
			return "redirect:/message/hoewonInputNo";
		}
	}
	
	/*========================== aop(service) ===========================*/
	
	@GetMapping("/aop/aopmenu")
	public String aopMenuGet() {
		log.info("study1 컨트롤러의 aopMenu 메소드");
		return "study1/aop/aopMenu";
	}
	
	@GetMapping("/aop/test1")
	public String aopTest1Get() {
		log.info("study1 컨트롤러의 test1 메소드");
		
//		Study1Service service = new Study1Service();
//		service.getAopServiceTest1();
		
		study1Service.getAopServiceTest1();
		
		return "study1/aop/aopMenu";
	}
	@GetMapping("/aop/test2")
	public String aopTest2Get() {
		log.info("study1 컨트롤러의 test2 메소드");
		
		study1Service.getAopServiceTest2();
		
		return "study1/aop/aopMenu";
	}
	@GetMapping("/aop/test3")
	public String aopTest3Get() {
		log.info("study1 컨트롤러의 test3 메소드");
		
		study1Service.getAopServiceTest3();
		
		return "study1/aop/aopMenu";
	}
	@GetMapping("/aop/test4")
	public String aopTest4Get() {
		log.info("study1 컨트롤러의 test4 메소드");
		
		study1Service.getAopServiceTest52();
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		study1Service.getAopServiceTest53();
		
		return "study1/aop/aopMenu";
	}
	
	/*========================== XML 값주입 연습 ===========================*/
	@GetMapping("/xml/xmlMenu")
	public String xmlMenuGet() {
		return "study1/xml/xmlMenu";
	}
	@GetMapping("/xml/xmlTest1")
	public String xmlTest1Get(Model model) { // sungjuk.xml에서 설정한 vo를 가져옴.
		AbstractApplicationContext context = new GenericXmlApplicationContext("xml/sungjuk.xml");
		
//		SungjukVO vo1 = context.getBean("vo1", SungjukVO.class);
//		System.out.println("vo1 : " +vo1);
//		
//		SungjukVO vo2 = context.getBean("vo2", SungjukVO.class);
//		System.out.println("vo2 : " +vo2);
//		
//		SungjukVO vo3 = context.getBean("vo3", SungjukVO.class);
//		System.out.println("vo3 : " +vo3);
		
		List<SungjukVO> vos = new ArrayList<SungjukVO>();
		SungjukVO vo = null;
		for(int i=1; i<=3; i++) {
			String str = "vo" + i;
			vo = context.getBean(str, SungjukVO.class);
			vos.add(vo);
		}
		model.addAttribute("vos", vos);
		
		context.close();
		return "study1/xml/xmlTest1";
	}
	
	// 2번은 숙제로 구현.
	
	@GetMapping("/xml/xmlTest3")
	public String xmlTest3Get(Model model) { 
		AbstractApplicationContext context = new GenericXmlApplicationContext("xml/siteInfor.xml");
		
		SiteInforVO vo = context.getBean("infor", SiteInforVO.class);
		model.addAttribute("vo", vo);
		
		context.close();
		return "study1/xml/xmlTest3";
	}
	
	@GetMapping("/xml/xmlTest4")
	public String xmlTest4Get(Model model) { 
		AbstractApplicationContext context = new GenericXmlApplicationContext("xml/siteInforP.xml");
		
		SiteInfor2VO vo = context.getBean("infor", SiteInfor2VO.class);
		model.addAttribute("vo", vo);
		
		context.close();
		return "study1/xml/xmlTest4";
	}
}
