package spring.aop.board;

import org.aspectj.lang.ProceedingJoinPoint;

public class Log {
	// 공통기능
	public void beforeLog() {
		System.out.println("----BEFORE LOG----");
	}
	public void afterLog() {
		System.out.println("----AFTER LOG----");
	}
	
	public Object around(ProceedingJoinPoint pjp) throws Throwable {
		//ProceedingJoinPoint가 import 안 된다면 pom.xml에서 <scope>runtime</scope> 주석처리하기
		System.out.println("----AROUND BEFORE LOG----");
		
		Object result = pjp.proceed();
		
		System.out.println("----AROUND AFTER LOG----\n");
		return result;
	}
}
