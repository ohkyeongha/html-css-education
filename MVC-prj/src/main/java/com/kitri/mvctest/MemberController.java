package com.kitri.mvctest;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Component
@RequestMapping("/member")
public class MemberController {
	@RequestMapping(value = "/form", method = RequestMethod.GET)
	public String form() {
		return "form";
	}

	@RequestMapping(value = "/join")
	public String join(
//	public ModelAndView join(	//3번방식
//			HttpServletRequest req, 	//자동주입이 이뤄지기 때문에 바로 써도 된다	1번방식

//			@RequestParam("id") String id,	//2번방식
//			@RequestParam("pw") String pw

//			@RequestParam String id,	//3번방식
//			@RequestParam(value="pw", required=false) String pw,
//			@RequestParam(defaultValue = "기본사용자") String name,
//			String address,
//			String phone,
//			String email

			@ModelAttribute("vo") MemberVO vo, //5번방식
//			MemberVO vo, 
			Model model, // 2번방식
			ModelAndView mav // 3번방식
	) {
		// 기존방식
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

//		req.setAttribute("id", vo.getId());		//1번방식
//		req.setAttribute("name", vo.getName());

//		model.addAttribute("id", vo.getId());	//2번방식
//		model.addAttribute("name", vo.getName());

//		mav.addObject("id", vo.getId());
//		mav.addObject("name", vo.getName()); // 3번 방식
//		mav.setViewName("join-ok");

//		model.addAttribute("vo",vo);	//4번방식
		
		return "redirect:join-ok";
//		return mav;	//3번방식
	}
	
	@RequestMapping("/join-ok")
	public String joinOk() {
		return "join-ok";
	}
}
