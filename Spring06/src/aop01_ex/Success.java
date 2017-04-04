package aop01_ex;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class Success implements IGamble{

	@Override
	public String result() {
		// TODO Auto-generated method stub
		System.out.println("전문적인 도박 솜씨로 흥함");
		if(new Random().nextBoolean())
			throw new PoliceException("경찰뜸");
		
		return "사기치다걸려서 ";
		
		
	}
	
}
