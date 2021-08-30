package com.kitri.mvctest2;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RestAPIController {

	@RequestMapping("/")
	public String indext() {
		
		return "index";
	}
	
	//데이터 전송용
	@RequestMapping("/reqbody")	
	@ResponseBody             //string으로 body를 꺼내게 되면 필요데이터를 잘라야하므로 json형태로 변환해서 보내주기 위해 ajax를 사용
	public UserVO reqBody(@RequestBody UserVO vo) {
		
		System.out.println("id;"+vo.getId());
		System.out.println("pw:"+vo.getPw());
		System.out.println("name:"+vo.getName());
		System.out.println("email:"+vo.getEmail());
	
		return vo;
	}
	
	@RequestMapping("/resbody")
	@ResponseBody
	public UserVO resBody() throws IOException{
		UserVO uvo = new UserVO();
		uvo.setId("user");
		uvo.setPw("1234");
		uvo.setName("사용자");
		uvo.setEmail("user@email.com");
		
		return uvo; //이 데이터를 자동으로 json으로 넘겨주는 것이 @ResponseBody 이다
	}
	

	
	
	
}
