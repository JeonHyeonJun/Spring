package di02;

public class Game {
	private Commend commend;
	public Game(){
	}

	public Game(Commend commend){
		this.commend = commend;
		System.out.println("생성자 주입");
	}
	public void setCommend(){
		this.commend = commend;
	}
	public void start(){
		System.out.println(commend.getCommend());
	}
}
