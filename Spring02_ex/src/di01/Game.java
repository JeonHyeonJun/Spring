package di01;

public class Game {
	private Commend commend;
	public Game(){
	}
	
	public void setCommend(Commend commend){
		this.commend = commend;
		System.out.println("설정자주입");
	}
	public void start(){
		System.out.println(commend.getCommend());
	}
}
