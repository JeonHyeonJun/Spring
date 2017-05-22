package service;

import java.util.HashMap;
import java.util.List;

public interface IRepleService {
	public boolean insertReple(int boardIdx, String content, String writer, int writerIdx, int parent);
	public boolean updateReple(int idx, String content);
	public boolean deleteReple(int idx, int groupCode);
	public HashMap<String, Object> selectOne(int idx);
	public List<HashMap<String, Object>> selectList(int boardIdx);
}
