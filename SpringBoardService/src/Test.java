import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.dao.DataAccessException;

import service.MemberService;

public class Test {
	public static void main(String[] args) {
		ApplicationContext context = new GenericXmlApplicationContext("applicationContext.xml");
		MemberService service = context.getBean("memberService", MemberService.class);
		
		try{
			service.join("아이디다요", "123", "이름이다요", "뭐지이건");
		}
		catch (DataAccessException e) {
			// TODO: handle exception
			System.out.println("중복");
		}
		System.out.println("이 칠판의 단어를 읽을수 있나요?");			
	}
}
