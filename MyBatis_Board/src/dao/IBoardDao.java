package dao;

import java.util.HashMap;
import java.util.List;

public interface IBoardDao {
	public int insertBoard(HashMap<String, Object> params);
	public int updateBoard(HashMap<String, Object> params);
	public int deleteBoard(int num);
	public HashMap<String, Object> selectOne(int num);
	public List<HashMap<String, Object>> selectBoardLimit(HashMap<String, Object> params);
	public int getBoardCount();
	public int selectGroup(int group_code);
//	public List<HashMap<String, Object>> selectAll();
//	public List<HashMap<String, Object>> selectBySearch(HashMap<String, Object> params);
}
