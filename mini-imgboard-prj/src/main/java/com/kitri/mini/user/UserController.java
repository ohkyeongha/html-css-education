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
	@RequestMapping("/signup")
	public String signup() {
		return "signup";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		if(session.getAttribute("id")!=null) {
			session.removeAttribute("id");
		}
		
		return "redirect:/user/login";
	}
	
	@RequestMapping("/signup-regist")
	public String signupRegist(ImgUserVO iuvo) {
		//가입
		boolean registCheckFlag = imgUserService.registImgUser(iuvo);
		
		String path = "";
		
		if(registCheckFlag) {
			path="redirect:/user/login";
		} else {
			path="redirect:/user/signup";
		}
		
		return path;
	}
	
	@RequestMapping("idcheck")
	@ResponseBody
	public boolean idCheck(String id) {
		//id가 있는지 조회
		boolean idCheckFlag = imgUserService.idCheck(id);
		
		//id 존재 : 결과값 false, id 사용가능 : 결과값 true
		return idCheckFlag;
	}
	
	@RequestMapping("/logincheck")
	@ResponseBody
	public boolean logincheck(ImgUserVO iuvo, HttpSession session) {
		boolean loginFlag = imgUserService.loginCheckImgUser(iuvo);
		
		if(loginFlag) {
			session.setAttribute("id", iuvo.getId());
		}		
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
