package spring.di;

public class MainClass {
	public static void main(String[] args) {
//		A a = new A();
//		B b = new B();
//		C c = new C();
//		a.printA();
//		b.printB();
//		c.printC();
		
		//�����ڸ� ���� ������ ����
		A a = new A(new C());	//������
		
		//setter�� �̿��� DI (������ ����)
//		a.setI(new C());
		
		a.print();
		
		
	}
}
