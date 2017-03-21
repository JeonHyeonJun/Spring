package di03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Game {
	private Commend commend;
	public Game(){
	}
	@Autowired
//	@Qualifier("defense")
	public void setCommend(Commend commend){
		this.commend = commend;
		System.out.println("설정자주입");
	}
	public void start(){
		System.out.println(commend.getCommend());
	}
}
