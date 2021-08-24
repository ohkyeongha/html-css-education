package spring.di.cal;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {

//		Calculator cal = new Calculator();
		
		//IoC컨테이너
		AbstractApplicationContext context = new GenericXmlApplicationContext("config/cal-config.xml");
		Calculator cal = context.getBean("cal", Calculator.class);
//		cal.setA(a);
//		cal.setB(b);
		
		int result1 = cal.add();
		int result2 = cal.sub();
		
		System.out.println("출력 1: " + result1);
		System.out.println("출력 2: " + result2);
		
		context.close();
		
	}

}
