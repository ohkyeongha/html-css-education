package com.kitri.mini.user;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kitri.mini.user.service.ImgUserService;
import com.kitri.mini.user.service.NaverUserService;
import com.kitri.mini.user.vo.ImgUserVO;
import com.kitri.mini.user.vo.NaverUserVO;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private NaverUserService naverUserService;
	@Autowired
	private ImgUserService imgUserService;
	
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	@RequestMapping("/naverlogin")
	public String naverlogin() {
		return "naverlogin";
	}
	
	@RequestMapping("/logincheck")
	@ResponseBody
	public boolean logincheck(ImgUserVO iuvo, HttpSession session) {
		boolean loginFlag = imgUserService.loginCheckImgUser(iuvo);
		
//		String path="";
//		
//		if(loginFlag) {
//			session.setAttribute("id", iuvo.getId());
//			path = "redirect:/main";
//		} else {
//			path = "redirect:/login";
//		}
		
		return loginFlag;
	}
	
	@RequestMapping("/naverlogincheck")
	@ResponseBody
	public NaverUserVO naverLoginCheck(@RequestBody NaverUserVO nuvo, HttpSession session) {
		
		NaverUserVO vo = naverUserService.registNaverUser(nuvo);
		session.setAttribute("id", vo.getEmail());
		
		return vo;
	}
	
	
}
