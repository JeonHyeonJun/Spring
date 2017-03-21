package di02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
		ApplicationContext context = new GenericXmlApplicationContext("di02/applicationContext.xml");
		
		Car c = context.getBean("oppaCha", Car.class);
//		System.out.println(c);
		c.drive();
		((GenericXmlApplicationContext)context).close();
	}
}
