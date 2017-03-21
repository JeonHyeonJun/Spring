package di03;

import org.springframework.stereotype.Component;

@Component("defense")
public class Defense implements Commend{
	public String getCommend(){
		return "방어합니다";
	}
}
