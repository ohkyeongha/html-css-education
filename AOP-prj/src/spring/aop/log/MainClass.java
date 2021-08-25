package spring.aop.log;

import org.springframework.context.support.*;

public class MainClass {

	public static void main(String[] args) {
		GenericXmlApplicationContext context = new GenericXmlApplicationContext();
		context.load("spring/aop/config/aop-config.xml");
		context.refresh();
		
		A a = context.getBean("a", A.class);
		a.aMethod();
		a.a1Method();
		
		context.close();
	}

}
