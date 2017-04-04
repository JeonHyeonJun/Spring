package aop01;

import java.util.Random;

//인터페이스 기능구현 클래스
public class Boy implements IPerson{

	@Override
	public String doSomething() {
		// TODO Auto-generated method stub
		System.out.println("콤퓨타로 게임을 한다");
		
		if(new Random().nextBoolean())	//true와 false 중 랜덤 하게 나옴
			throw new FireException("화재발생!");
		
		return "I am a boy";
	}

}
