package spring01;

public class Greeting {
//	public Greeting(){
//		System.out.println("생성");
//	}
	public void greeting(){
		System.out.println("Hello World!");
	}
	
	public void initObj(){
		System.out.println("객체생성");
	}
	
	public void destroyObj(){
		System.out.println("객체파괴");
	}
}
