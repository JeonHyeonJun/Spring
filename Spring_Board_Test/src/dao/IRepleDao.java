package dao;

import java.util.HashMap;
import java.util.List;

public interface IRepleDao {
	public int insertReple(HashMap<String, Object> params);
	public int updateReple(HashMap<String, Object> params);
	public int deleteReple(int idx);
	public HashMap<String, Object> selectOne(int idx);
	public List<HashMap<String, Object>> selectList(int boardIdx);
	public int updateGroup(HashMap<String, Object> params);
	public int maxGroupSeq(int groupCode);
	public List<HashMap<String, Object>> selectGroupCode(int groupCode);
}
