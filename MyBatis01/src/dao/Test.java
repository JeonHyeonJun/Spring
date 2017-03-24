package dao;

import model.Student;

public class Test {
	public static void main(String[] args) {
		StudentDao dao = new StudentDao();
		Student st = new Student();
		for(Student s : dao.selectAll())
			System.out.println(s);
		st.setName("고길동");
		st.setAge(30);
		st.setScore(99);
		dao.insertStudent(st);
	}
}
