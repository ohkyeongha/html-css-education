package spring.aop.board;

import org.aspectj.lang.ProceedingJoinPoint;

public class Log {
	// ������
	public void beforeLog() {
		System.out.println("----BEFORE LOG----");
	}
	public void afterLog() {
		System.out.println("----AFTER LOG----");
	}
	
	public Object around(ProceedingJoinPoint pjp) throws Throwable {
		//ProceedingJoinPoint�� import �� �ȴٸ� pom.xml���� <scope>runtime</scope> �ּ�ó���ϱ�
		System.out.println("----AROUND BEFORE LOG----");
		
		Object result = pjp.proceed();
		
		System.out.println("----AROUND AFTER LOG----\n");
		return result;
	}
}
