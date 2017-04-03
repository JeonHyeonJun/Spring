package aop01;

//인터페이스 기능구현 클래스
public class Boy implements IPerson{

	@Override
	public void doSomething() {
		// TODO Auto-generated method stub
		System.out.println("콤퓨타로 게임을 한다");
	}

}
