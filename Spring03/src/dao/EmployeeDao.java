package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import commons.EmpDept;

public class EmployeeDao {
	private Connection conn;
	private static EmployeeDao instance;
	private EmployeeDao(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/empdept_db","root","mysql");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			System.out.println("클래스 적재 실패");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			System.out.println("커넥션 연결 실패");
		}
	}
	public static EmployeeDao getInstance() {
		if(instance == null)
			instance = new EmployeeDao();
		return instance;
	}
	
	public boolean insertEmp(HashMap<String, Object> params){
		PreparedStatement pstmt = null;
		String sql = "insert into emp values(?,?,?,?,?,?,?,?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, (int)params.get(EmpDept.EMPNO));
			pstmt.setString(2, (String)params.get(EmpDept.ENAME));
			pstmt.setString(3, (String)params.get(EmpDept.JOB));
			pstmt.setString(4, (String)params.get(EmpDept.MGR));
			pstmt.setString(5, (String)params.get(EmpDept.HIREDATE));
			pstmt.setString(6, (String)params.get(EmpDept.SAL));
			pstmt.setString(7, (String)params.get(EmpDept.COMM));
			pstmt.setString(8, (String)params.get(EmpDept.DEPTNO));
			
			int result = pstmt.executeUpdate();
			if(result > 0)
				return true;
			else
				return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public boolean insertDept(HashMap<String, Object> params){
		PreparedStatement pstmt = null;
		String sql = "insert into dept values(?,?,?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, (String)params.get(EmpDept.DEPTNO));
			pstmt.setString(2, (String)params.get(EmpDept.DNAME));
			pstmt.setString(3, (String)params.get(EmpDept.LOC));
			
			int result = pstmt.executeUpdate();
			if(result > 0)
				return true;
			else
				return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public List<HashMap<String, Object>> selectEmpByDeptno(int deptno){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from emp e, dept d where e.deptno = d.deptno and e.deptno=?";
		List<HashMap<String, Object>> list = new ArrayList<>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, deptno);
			rs = pstmt.executeQuery();
			while(rs.next()){
				HashMap<String, Object> emp = new HashMap<String, Object>();
				emp.put(EmpDept.EMPNO, rs.getInt(EmpDept.EMPNO));
				list.add(emp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
}
