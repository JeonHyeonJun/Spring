package dao;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class StudentDao {
	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
//	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate jdbcTemplate){
//		this.jdbcTemplate = jdbcTemplate;
//	}
	
	public boolean insertStudent(HashMap<String, Object> params){
		//NamedParameterJdbcTemplate은 이름으로 찾아서 넣는다
		int result = jdbcTemplate.update("insert into student values(0, :name, :age, :score)", params);
		if(result > 0)
			return true;
		else
			return false;
	}
	
	public boolean deleteStudent(HashMap<String, Object> params){
		int result = jdbcTemplate.update("delete from student where s_id = :s_id;", params);
		if(result > 0)
			return true;
		else
			return false;
	}
	
	public boolean updateStudent(HashMap<String, Object> params){
		int result = jdbcTemplate.update("update student set name=:name, age=:age where s_id=:s_id", params);
		if(result > 0)
			return true;
		else
			return false;
	}
	
	
}
