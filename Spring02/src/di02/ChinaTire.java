package di02;

import org.springframework.stereotype.Component;

@Component("chinaTire")
public class ChinaTire implements Tire{
	public String getTire(){
		return "대륙타이어";
	}
}
