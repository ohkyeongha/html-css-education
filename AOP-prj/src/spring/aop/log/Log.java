package spring.aop.log;

import org.aspectj.lang.ProceedingJoinPoint;

public class Log {
	
	//������
	public void logPrint() {
		System.out.println("-------------log ���-------------");
	}
	
	public Object around(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("----around log ���----");
		
		Object result = pjp.proceed();
		
		System.out.println("----around log ���----");
		return result;
	}
}
