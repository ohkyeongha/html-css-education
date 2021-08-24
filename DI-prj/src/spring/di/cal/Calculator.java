package spring.di.cal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Calculator {
	@Autowired
	@Qualifier("a")
	private int a;
	@Autowired
	@Qualifier("b")
	private int b;
	
	public void setA(int a) {
		this.a = a;
	}
	public void setB(int b) {
		this.b = b;
	}
	
	public Calculator() {}
	
	public Calculator(int a, int b) {
		this.a = a;
		this.b = b;
	}
	
	public int add() {
		return a+b;
	}
	public int sub() {
		return a-b;
	}
}
