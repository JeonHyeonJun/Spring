package di02;

import org.springframework.stereotype.Component;

@Component("tire")
public class KoreaTire implements Tire{
	public String getTire(){
		return "한국타이어";
	}
}
