package service;

import java.util.HashMap;

public interface IBoardService {
	public boolean insertBoard(String title, String content, String writer, int fileId, int writerIdx);
	public boolean updateBoard(int idx, String title, String content, int readCount);
	public boolean deleteBoard(int idx);
	public HashMap<String, Object> selectOne(int idx);
	public HashMap<String, Object> getBoard(int idx);
	public HashMap<String, Object> selectList(int page);
}
