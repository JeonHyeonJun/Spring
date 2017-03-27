package dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import model.Student;

public interface IStudentDao {
	@Insert("insert into student values(0, #{name}, #{age}, #{score})")
	public int insertStudent(Student student);
	@Update("update student set name=#{name}, age=#{age}, score=#{score} where s_id={s_id}")
	public int updateStudent(Student student);
	@Delete("delect from student where s_id=#{s_id}")
	public int deleteStudent(int s_id);
	@Select("select * from student where s_id=#{s_id}")
	public Student selectOne(int s_id);
	@Select("select * from student")
	public List<Student> selectAll();
}
