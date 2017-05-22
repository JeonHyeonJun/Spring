package service;

import java.util.HashMap;
import java.util.List;

public interface IMemberService {
	public boolean insertMember(String id, String pass, String name);
	public boolean updateMember(String pass, String name);
	public boolean deleteMember(int idx);
	public HashMap<String, Object> selectOne(int idx);
	public HashMap<String, Object> selectId(String id);
	public HashMap<String, Object> selectName(String name);
}
