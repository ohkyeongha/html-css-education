package com.kitri.mcvtest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//가장 상위의 mapping <http://localhost:8080/mcvtest/mapping/test2> 로 입력해야함. 묶어주는 경우에 사용한다.
@Controller
@RequestMapping("/mapping")
public class MappingTestController {
	
	//test
	@RequestMapping(value="/test", method=RequestMethod.GET) //post든 get이든 requestmapping은 수용.value,method를 통해서 get, post 지정가능
	public String test() {
		
		return "mapping-test";
	}
	
	//두개의 url을 이용해서 넣고 싶을 때 배열방식으로 사용가능하다.
	@RequestMapping({"/test1","/test2"})
	public String test12() {
		
		return "mapping-test12";
	}
	
	@RequestMapping("/test/{val}")
	public String testVal(@PathVariable("val") String value) {
		System.out.println("val : "+value);
		
		return "mapping-testVal";
	}
	
	
}
