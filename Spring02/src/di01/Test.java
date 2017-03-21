package di01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
//		Car c = new Car();
//		KoreaTire tire = new KoreaTire();
//		c.setTire(tire);
//		c.drive();
		ApplicationContext context = new GenericXmlApplicationContext("di01/applicationContext.xml");
		Car c = (Car)context.getBean("car");
		Tire tire = (Tire)context.getBean("tire");
//		c.setTire(tire);
		c.drive();
	}
}
