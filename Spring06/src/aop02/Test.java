package aop02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
		ApplicationContext context = new GenericXmlApplicationContext("aop02/applicationContext.xml");
		IPerson person = context.getBean("boy", IPerson.class);
		
		try{
			person.doSomething();			
		}
		catch (FireException e) {
			// TODO: handle exception
		}
	}
}
