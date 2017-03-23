package test;

import java.util.HashMap;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import studentDao.StudentDao;

public class StudentDaoTest {
	public static void main(String[] args) {
		ApplicationContext context = new GenericXmlApplicationContext("applicationContext.xml");
		StudentDao dao = context.getBean("StudentDao", StudentDao.class);
		for(HashMap<String, Object> h : dao.selectAll())
			System.out.println(h);
	}
}
