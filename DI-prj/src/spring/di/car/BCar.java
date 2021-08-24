package spring.di.car;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.stereotype.Component;

@Component
public class BCar implements Car{
	
//	@Resource
//	@Inject @Named("t2")
	private Tire t;
	
	public BCar() {}
	
	public BCar(Tire t) {
		this.t = t;
	}
	@Override
	public void setT(Tire t) {
		this.t = t;
	}

	@Override
	public void turnOn() {
		System.out.println("B 시동");
	}
	@Override
	public void turnOff() {
		System.out.println("B 시동 정지");
	}
	@Override
	public void runCar() {
		t.run();
	}
	@Override
	public void breakCar() {
		t.stop();
	}
}
