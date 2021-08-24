package spring.di.car;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Driver {

	public static void main(String[] args) {
	
//		ACar car = new ACar();
//		BCar car = new BCar();
//		Tire t = new Tire1();	//tire1,2 객체
		
		//생성자 이용
//		Car car = new ACar(t);	//Car A,B 객체
		//setter 이용 
//		car.setT(t);
		
		
		
//		----------IoC 컨테이너 사용하여 DI test--------------------
		
		AbstractApplicationContext context = 
				new GenericXmlApplicationContext("config/config.xml");
		
		//new Tire1();
//		Tire tire = context.getBean("t", Tire.class);
		//Car car = acar; //new ACar();
		Car car = context.getBean("ACar", Car.class);
//		car.setT(t);
		
		car.turnOn();
		car.runCar();
		car.breakCar();
		car.turnOff();
		
		context.close();
		
	}

}
