package spring.di;

public class MainClass {
	public static void main(String[] args) {
//		A a = new A();
//		B b = new B();
//		C c = new C();
//		a.printA();
//		b.printB();
//		c.printC();
		
		//생성자를 통한 의존성 주입
		A a = new A(new C());	//다형성
		
		//setter를 이용한 DI (의존성 주입)
//		a.setI(new C());
		
		a.print();
		
		
	}
}
