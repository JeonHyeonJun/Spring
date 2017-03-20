package spring01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
		//여기서 필요한 객체를 전부 new해서 만듦
		ApplicationContext context = new GenericXmlApplicationContext("applicationContext.xml");
		System.out.println("?");
//		((Greeting)context.getBean("gr")).greeting();
		
		//컨테이너로부터 원하는 객체 받아오기
		//Greeting gr = (Greeting)context.getBean("gr");	//컨테이너(applicationContext.xml)에 등록되어있는 bean의 id를 받아옴
															//반환타입은 object이므로 사용하려면 형변환을 해야한다. 
		Greeting gr = context.getBean("gr", Greeting.class);	//이렇게도 형변환 할 수 있음
		gr.greeting();
		Greeting gr2 = (Greeting)context.getBean("gr");	//Greeting선언은 위에서 했으므로 gr과 gr2는 같은 객체를 받음
		System.out.println(gr);
		System.out.println(gr2);
		
		((GenericXmlApplicationContext) context).close();//컨테이너 부수기
	}
}
