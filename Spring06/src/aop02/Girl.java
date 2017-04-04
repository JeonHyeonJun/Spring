package aop02;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class Girl implements IPerson{

	@Override
	public String doSomething() {
		// TODO Auto-generated method stub
		System.out.println("드라마로 TV를 본다");
		
		if(new Random().nextBoolean())
			throw new FireException("화재방생");
		
		return "여자";
	}
	
}
