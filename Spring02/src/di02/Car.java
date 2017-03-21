package di02;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component	//컨테이너가 이걸 발견하면 bean으로 등록해달라는 표식, 등록된 이름은 클래스명 소문자가 기본
("oppaCha")	//bean의 id설정
public class Car implements InitializingBean, DisposableBean{
	@Autowired
	@Qualifier("chinaTire")	//setter없어도 되긴하지만 setter는 만드는게 좋다.
	private Tire tire;
	public Car(){
	}
	
	//컨테이너에 있는 bean중에서 매개변수와 같은타입의 bean을 여기에 넣어줌. 하지만 해당되는게 두개라면 어떨까?! 그냥안됨
	//Type이 겹치면 이름이라도 같은지 검사한다. 이름이 겹치면 출력. 그것도 안되면 fail
//	@Autowired	
//	(required=false) //의존관계설정 실패시 null넣고 진행하라는 의미
//	public Car(Tire tire){
//		this.tire = tire;
//		System.out.println("생성자를 통한 타이어 주입");
//	}
	
//	@Autowired
//	@Qualifier("chinaTire")	//id로 찾기
//	public void setTire(Tire tire){
//		this.tire = tire;
//	}
	
	public void drive(){
		System.out.println(tire.getTire() + "로 굴러갑니당");
	}
	
	//인터페이스방식 객체생성,삭제
	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("객체생성ㅎ");
	}
	@Override
	public void destroy() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("객체파괴");
	}
	
	//에노테이션방식 객체생성,삭제
	@PostConstruct
	public void init(){
		System.out.println("생성");
	}
	@PreDestroy
	public void dest(){
		System.out.println("삭제");
	}
}
