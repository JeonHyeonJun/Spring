package dao;

import java.util.HashMap;
import java.util.List;

public interface IMemberDao {
	public int insertMember(HashMap<String, Object> params);
	public int updateMember(HashMap<String, Object> params);
	public int deleteMember(int idx);
	public HashMap<String, Object> selectOne(int idx);
	public HashMap<String, Object> selectId(String id);
	public HashMap<String, Object> selectName(String name);
}
