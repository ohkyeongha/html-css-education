package spring.aop.log;

import org.aspectj.lang.ProceedingJoinPoint;

public class Log {
	
	//공통기능
	public void logPrint() {
		System.out.println("-------------log 출력-------------");
	}
	
	public Object around(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("----around log 출력----");
		
		Object result = pjp.proceed();
		
		System.out.println("----around log 출력----");
		return result;
	}
}
