package di02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

//생성자를 통한 주입방식
public class GameStart {
	public static void main(String[] args) {
		ApplicationContext context = new GenericXmlApplicationContext("di02/applicationContext.xml");
		Game game = context.getBean("start", Game.class);
		Commend commend = context.getBean("commend", Commend.class);
		game.start();
	}
}