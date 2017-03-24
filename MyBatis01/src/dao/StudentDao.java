package dao;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import model.Student;

public class StudentDao {
	private SqlSessionFactory sqlSessionFactory;
	public StudentDao(){
		try {
			Reader reader = Resources.getResourceAsReader("configuration.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean insertStudent(Student student){
		SqlSession session = sqlSessionFactory.openSession();
		try{
			int result = session.insert("student.insert",student);
			if(result > 0)
			{
				session.commit();
				return true;
			}
			else
			{
				session.rollback();
				return false;
			}
		}
		finally 
		{
			session.close();
		}
	}
	
	public boolean updateStudent(Student student){
		SqlSession session = sqlSessionFactory.openSession();
		try{
			int result = session.update("student.update", student);
			if(result > 0){
				session.commit();
				return true;
			}
			else{
				session.rollback();
				return false;
			}
		}
		finally {
			session.close();
		}
	}
	
	public boolean deleteStudent(int s_id){
		SqlSession session = sqlSessionFactory.openSession();
		try{
			int result = session.delete("student.delete", s_id);
			if(result > 0){
				session.commit();
				return true;
			}
			else {
				session.rollback();
				return false;
			}
		}
		finally {
			session.close();
		}
	}
	
	public Student selectOne(int s_id){
		SqlSession session = sqlSessionFactory.openSession();
		try{
			return session.selectOne("student.selectOne", s_id);
		}
		finally {
			session.close();
		}
	}
	
	public List<Student> selectAll(){
		SqlSession session = sqlSessionFactory.openSession();
		try{
			return session.selectList("student.selectAll");
		}
		finally {
			session.close();
		}
	}
}
