package spring.aop.log;

import org.springframework.stereotype.Component;

@Component
public class A {
	
	//핵심기능
	public void aMethod() {
		System.out.println("A Method 출력");
	}
	public void a1Method() {
		System.out.println("A1 Method 출력");
		
	}
}
