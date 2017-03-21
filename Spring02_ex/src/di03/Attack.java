package di03;

import org.springframework.stereotype.Component;

@Component("commend")
public class Attack implements Commend{
	public String getCommend(){
		return "공격합니다";
	}
}
