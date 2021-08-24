package spring.di.car;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class ACar implements Car {
	@Autowired
	@Qualifier("tire1")
	private Tire t;
	
	public ACar() {}
	
	//생성자를 이용한 DI
	public ACar(Tire t) {
		this.t = t;
	}
	
	//setter를 이용한 DI
	public void setT(Tire t) {
		this.t = t;
	}
	
	@Override
	public void turnOn() {
		System.out.println("A 시동");
	}

	@Override
	public void turnOff() {
		System.out.println("A 시동 정지");
	}
	@Override
	public void runCar() {
//		System.out.println("A 자동차가 달린다");
//		Tire t = new Tire1();
		t.run();
	}
	@Override
	public void breakCar() {
//		System.out.println("A 자동차가 멈춘다");
//		Tire t = new Tire1();
		t.stop();
	}
}
