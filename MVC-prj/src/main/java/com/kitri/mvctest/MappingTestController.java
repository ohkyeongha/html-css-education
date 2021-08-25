package com.kitri.mvctest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/mapping")
public class MappingTestController {
	//test
	@RequestMapping(value="/test", method=RequestMethod.GET)
	public String test() {
		
		return "mapping-test";
	}
	
	@RequestMapping({"/test1","/test2"})
	public String test1() {
		
		return "mapping-test12";
	}
	
	@RequestMapping(value="/test/{val}", method=RequestMethod.GET)
	public String testVal(@PathVariable("val") String value) {
		System.out.println("val = "+ value);
		return "mapping-testval";
	}
}
