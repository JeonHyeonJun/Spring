package test;

import java.util.HashMap;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import dao.StudentDao;

public class StudentDaoTest {
	public static void main(String[] args) {
		ApplicationContext context = new GenericXmlApplicationContext("applicationContext.xml");
		StudentDao dao = context.getBean("studentDao", StudentDao.class);
		HashMap<String, Object> params = new HashMap<>();
		params.put("s_id",1);
		params.put("name", "접니다");
		params.put("age", 33);
		params.put("score", 1);
		dao.deleteStudent(params);
	}
}
