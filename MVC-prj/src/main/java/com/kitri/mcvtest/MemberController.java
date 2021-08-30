package com.kitri.mcvtest;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/member")
public class MemberController {
	
	@RequestMapping(value="/form", method=RequestMethod.GET)
	public String form() {
		
		return "form";
	}
	
	@RequestMapping("/join")
	public String join(
//	public ModelAndView mav(
//			HttpServletRequest req,
//			@RequestParam("id") String id,
//			@RequestParam("pw") String pw	//파라미터 name값, 변수명
//			@RequestParam String id,		//자동 매핑(name값과 변수명이 일치해야함)
//			@RequestParam(value="pwd", required=false) String pwd,		//값이 없을 경우 required에 의해서 null로 들어감
//			@RequestParam(defaultValue="기본사용자") String name, 	//값이 없을 경우 "기본사용자"값이 들어감
//			String address,			//request가 없어도 값이 주입이 됨. 
//			String phone,
//			String email
//			MemberVO mvo,
			@ModelAttribute("mvo") MemberVO mvo, //값을 바로 보낼때 사용하는 어노테이션, return만 사용
			Model model,
			ModelAndView mav
			) {
		//기존 방식
//		String id = req.getParameter("id");
//		String pw = req.getParameter("pw");
		
		System.out.println("id: "+mvo.getId());
		System.out.println("pw: "+mvo.getPw());
		System.out.println("name: "+mvo.getName());
		System.out.println("address: "+mvo.getAddress());
		System.out.println("phone: "+mvo.getPhone());
		System.out.println("email: "+mvo.getEmail());
		System.out.println("gender: "+mvo.getGender());
		System.out.println("hobby: "+mvo.getHobby());
		
		//기존 방식------------------------------------HttpServletRequest req, 주석풀기
		
//		req.setAttribute("id", mvo.getId());
//		req.setAttribute("pw", mvo.getPw());
//		req.setAttribute("name", mvo.getName());
		
//		return "join-ok";
		
		//모델 방식----------------------------------MemberVO mvo, Model model- 이용---(과거 사용한 방식 현재는 많이 사용x)
//		model.addAttribute("id",mvo.getId());
//		model.addAttribute("name",mvo.getName());
		
//		return "join-ok";
		
		//모델 앤드 뷰 방식-------------------------------------------
//		mav.addObject("id",mvo.getId());
//		mav.addObject("name",mvo.getName());
//		mav.setViewName("join-ok"); //값을 실어서 원하는 위치로 보내줌
//		
//		return mav; //public ModelAndView mav( 로 바꿔줘야함
		
		//모델 전체값 보내기(mvo의 모든 값을 보낼 수 있음.)------------------
//		model.addAttribute("mvo",mvo); //mvo의 값이 없으면 빈칸으로 EL값이 뜬다.
//		return "join-ok";
		
		//@ModelAttribute("mvo") MemberVO mvo, 사용
//		return "join-ok";
		
		//redirect는 jsp로 이동시키는 것이 아닌 url로 이동시켜주는 용도, 따라서 RequestMapping을 써줘야함.
		return "redirect:join-ok";
		
		
	}
	@RequestMapping("/join-ok")
	public String joinOk(@ModelAttribute("mvo") MemberVO mvo) {
		
		return "join-ok";
	}
	
}
