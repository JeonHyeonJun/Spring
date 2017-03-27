package dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import model.Student;

public interface IStudentDao {
	public int insertStudent(Student student);
	public int updateStudent(Student student);
	public int deleteStudent(int s_id);
	public Student selectOne(int s_id);
	public List<Student> selectAll();
}
