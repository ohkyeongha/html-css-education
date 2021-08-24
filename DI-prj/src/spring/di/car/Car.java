package spring.di.car;

public interface Car {
	public void setT(Tire t);	//setter를 아용한 DI 하기 위한 인터페이스
	public void turnOn();
	public void turnOff();
	public void runCar();
	public void breakCar();
}
