package aop02;

import java.util.Random;

import org.springframework.stereotype.Component;

//인터페이스 기능구현 클래스
@Component
public class Boy implements IPerson{

	@Override
	public String doSomething() {
		// TODO Auto-generated method stub
		System.out.println("콤퓨타로 게임을 한다");
		
		if(new Random().nextBoolean())
			throw new FireException("화재발생");
		
		return "남자";
	}

}
