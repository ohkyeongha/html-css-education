package com.kitri.visitor.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	
	@RequestMapping("/visitor")
	public String visitor(String nickname, HttpSession session) {
		
		session.setAttribute("nickname", nickname);
		List<VisitorVO> vlist = vservice.searchVisitor();
			
		
		return "visitor";
	}
	
}
