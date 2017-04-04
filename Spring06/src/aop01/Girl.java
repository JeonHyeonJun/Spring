package aop01;

import java.util.Random;

public class Girl implements IPerson{

	@Override
	public String doSomething() {
		// TODO Auto-generated method stub
		System.out.println("드라마로 TV를 본다");
		
		if(new Random().nextBoolean())	//true와 false 중 랜덤 하게 나옴
			throw new FireException("화재발생!");
		
		return "Hey yougo girl";
	}
	
}
