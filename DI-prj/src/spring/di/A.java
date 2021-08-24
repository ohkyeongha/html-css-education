package spring.di;

public class A implements Interface{

	private Interface i;
	
	public void setI(Interface i) {
		this.i = i;
	}
	
	public A(Interface i) {
		this.i = i;
	}

	@Override
	public void print() {
		System.out.println("A");
		i.print();
	}
//	public void printA() {
//		System.out.println("A");
//	}
}
