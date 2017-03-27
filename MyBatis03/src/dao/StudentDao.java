package dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import model.Student;

public class StudentDao implements IStudentDao{
	
	private SqlSessionFactory sqlSessionFactory;
	public StudentDao() {
		// TODO Auto-generated constructor stub
		InputStream is = null;
		try{
			is = Resources.getResourceAsStream("configuration.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
		}
		catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			if(is!=null){
				try {
					is.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	@Override
	public int insertStudent(Student student) {
		// TODO Auto-generated method stub
		
		SqlSession session = sqlSessionFactory.openSession();
		try{
			//둘다 된다!
//			return session.getMapper(IStudentDao.class).insertStudent(student);
			return session.insert("dao.IStudentDao.insertStudent", student);
		}
		finally {
			session.close();
		}
	}

	@Override
	public int updateStudent(Student student) {
		// TODO Auto-generated method stub
		SqlSession session = sqlSessionFactory.openSession();
		try{
			return session.getMapper(IStudentDao.class).updateStudent(student);
		}
		finally {
			session.close();
		}
	}

	@Override
	public int deleteStudent(int s_id) {
		// TODO Auto-generated method stub
		SqlSession session = sqlSessionFactory.openSession();
		try{
			return session.getMapper(IStudentDao.class).deleteStudent(s_id);
		}
		finally {
			session.close();
		}
	}

	@Override
	public Student selectOne(int s_id) {
		// TODO Auto-generated method stub
		SqlSession session = sqlSessionFactory.openSession();
		try{
			return session.getMapper(IStudentDao.class).selectOne(s_id);
		}
		finally {
			session.close();
		}
	}

	@Override
	public List<Student> selectAll() {
		// TODO Auto-generated method stub
		SqlSession session = sqlSessionFactory.openSession();
		try{
//			return session.getMapper(IStudentDao.class).selectAll();
			return session.selectList("dao.IStudentDao.selectAll");
		}
		finally {
			session.close();
		}
	}

}
