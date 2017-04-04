package aop01_ex;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
		ApplicationContext context = new GenericXmlApplicationContext("aop01_ex/applicationContext.xml");
		IGamble gamble = context.getBean("fail",IGamble.class);
		
		try{
			gamble.result();			
		} catch (PoliceException e) {}
	}
}
