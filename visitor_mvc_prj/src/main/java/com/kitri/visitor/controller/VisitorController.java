package com.kitri.visitor.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kitri.visitor.service.VisitorService;
import com.kitri.visitor.vo.VisitorVO;

@Controller
public class VisitorController {
	
	@Autowired
	private VisitorService vservice;
	
	@RequestMapping("/")
	public String index() {
		
		return "index";
	}
	
	@RequestMapping("/session")  //매개변수에 들어와있는 값을 자동으로 session처리
	public String session(HttpSession session, String nickname) {
		
		session.setAttribute("nickname", nickname);
		return "redirect:/visitor";
	}
	
	
	@RequestMapping("/visitor")
	public String visitor(
			String nickname,
			Model model) {
		
//		VisitorService vservice = new VisitorServiceImpl();
		List<VisitorVO> vlist = vservice.searchVisitors(); //서비스 호출
		model.addAttribute("vlist",vlist);
		
		
//		System.out.println("nick: " +nickname);
		
		return "visitor";
	}
	//글 등록을 위한 기능
	@RequestMapping("/regist")
	public String regist(VisitorVO vvo) {
		//비동기가 아니고 서버로 바로 넘어오기 때문에 수정이 가능하지가 않다. 나중에 에이쟉스를 이용해 결과값을 변경할 것임.
		//다시 visitor로 넘겼을 때 문제는 session의 nickname이 문제이기에 해당기능을 따로 만든다.
		int result = vservice.registVisitor(vvo);
		
		return "redirect:/visitor";
	}
	
	@RequestMapping("/update")
	public String update(VisitorVO vvo) {
		
		int result = vservice.updateVisitor(vvo);
		
		//업데이트 완료후 새로고침이 되어야하기에 /visitor로 넘긴다
		return "redirect:/visitor";
	}
	
	@RequestMapping("/delete")
	public String delete(int vno) {
		
		int result = vservice.deleteVisitor(vno);
		return "redirect:/visitor";
	}
	
	
	
	
	
}
