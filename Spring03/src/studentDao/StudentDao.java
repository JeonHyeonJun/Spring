package studentDao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import student.Student;

public class StudentDao {
	private JdbcTemplate jdbcTemplate;
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate){
		this.jdbcTemplate = jdbcTemplate;
	}
	public boolean insertStudent(HashMap<String, Object> params){
		int result = jdbcTemplate.update("insert into student values(0,?,?,?)",
				params.get(Student.NAME),
				params.get(Student.AGE),
				params.get(Student.SCORE));
		if(result > 0)
			return true;
		else
			return false;
	}
	
	public List<HashMap<String, Object>> selectAll(){
		return jdbcTemplate.query("select * from student", mapper);
	}
	public HashMap<String, Object> selectOne(int s_id){
		return jdbcTemplate.queryForObject("select * from student where s_id = ?", mapper, s_id);
	}
	
	private RowMapper<HashMap<String, Object>> mapper = new StudentMapper();
	class StudentMapper implements RowMapper<HashMap<String, Object>>{

		@Override
		public HashMap<String, Object> mapRow(ResultSet arg0, int arg1) throws SQLException {
			// TODO Auto-generated method stub
			HashMap<String, Object> result = new HashMap<String,Object>();
			result.put(Student.S_ID, arg0.getInt(Student.S_ID));
			result.put(Student.NAME, arg0.getString(Student.NAME));
			result.put(Student.AGE, arg0.getInt(Student.AGE));
			result.put(Student.SCORE, arg0.getInt(Student.SCORE));
			return result;
		}
		
	}
}
