package di01;

public class Car {
	private Tire tire; //= new KoreaTire();
//	public Car(){
//		tire = new KoreaTire();
//	}//의존성이 Car에있음
	public Car(){
	}
	public Car(Tire tire){
		this.tire = tire;
		System.out.println("생성자를 통한 타이어 주입");
	}
	public void setTire(Tire tire){//참조변수를 부모를 참조함. 느슨한결합
		this.tire = tire;
	}//의존성이 여기에 생성할때 있음, 의존관계역전
	
	public void drive(){
		//tire = new KoreaTire();
		System.out.println(tire.getTire() + "로 굴러갑니당");
	}
}
