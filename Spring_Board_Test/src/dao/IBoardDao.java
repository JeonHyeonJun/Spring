package dao;

import java.util.HashMap;
import java.util.List;

public interface IBoardDao {
	public int insertBoard(HashMap<String, Object> params);
	public int updateBoard(HashMap<String, Object> params);
	public int deleteBoard(int idx);
	public HashMap<String, Object> selectOne(int idx);
	public List<HashMap<String, Object>> selectList();
	public List<HashMap<String, Object>> selectBoardLimit(HashMap<String, Object> params);
	public int getBoardCount();
}
