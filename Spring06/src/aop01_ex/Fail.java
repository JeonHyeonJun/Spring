package aop01_ex;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class Fail implements IGamble{

	@Override
	public String result() {
		// TODO Auto-generated method stub
		System.out.println("상대방에 타짜가 있음");
		
		if(new Random().nextBoolean())
			throw new PoliceException("경찰뜸. ");
		
		return "타짜한테 사기치다 걸려서 ";
	}
	
}
