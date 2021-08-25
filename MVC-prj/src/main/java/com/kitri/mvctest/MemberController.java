package com.kitri.mvctest;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@RequestMapping("/member")
public class MemberController {
	@RequestMapping(value="/form", method = RequestMethod.GET)
	public String form() {
		return "form";
	}
	
	@RequestMapping(value="/join")
	public String join(
//			HttpServletRequest req 	//자동주입이 이뤄지기 때문에 바로 써도 된다	1번방식
			
//			@RequestParam("id") String id,	//2번방식
//			@RequestParam("pw") String pw
			
//			@RequestParam String id,	//3번방식
//			@RequestParam(value="pw", required=false) String pw,
//			@RequestParam(defaultValue = "기본사용자") String name,
//			String address,
//			String phone,
//			String email
			
			MemberVO vo
			
			) {
		//기존방식
//		String id = req.getParameter("id");	//1번방식
//		String pw = req.getParameter("pw");
		
		System.out.println("id : " + vo.getId());
		System.out.println("pw : " + vo.getPw());
		System.out.println("name : " + vo.getName());
		System.out.println("address : " + vo.getAddress());
		System.out.println("phone : " + vo.getPhone());
		System.out.println("email : " + vo.getEmail());
		System.out.println("gender : " + vo.getGender());
		System.out.println("hobby : " + vo.getHobby());
		
		return "join-ok";
	}
}
