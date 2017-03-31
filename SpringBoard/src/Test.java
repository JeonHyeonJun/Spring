

import java.util.HashMap;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import dao.IBoardDao;
import service.IBoardService;

public class Test {
	public static void main(String[] args) {
		ApplicationContext context = new GenericXmlApplicationContext("applicationContext.xml");
		IBoardDao dao = context.getBean("boardDao", IBoardDao.class);
		
		IBoardService service = context.getBean("boardService", IBoardService.class);
		
//		service.insertBoard("되나", "123", "될까", "naver", "되라");
		System.out.println(service.readBoard(3));
	}
}
