package dao;

import java.util.HashMap;

public interface IFileDao {
	public int insertFile(HashMap<String, Object> params);
	public int updateFile(HashMap<String, Object> params);
	public int deleteFile(int fileId);
	public HashMap<String, Object> selectOne(int fileId);
}
