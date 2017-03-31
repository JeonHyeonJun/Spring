package service;

import java.util.HashMap;
import java.util.List;

public interface IBoardService {
	public boolean insertBoard(String name, String pass, String content, String email, String title);
	public boolean updateBoard(int num, String name, String pass, String content, String email, String title);
	public boolean deleteBoard(int num);
	public HashMap<String, Object> readBoard(int num);
	public List<HashMap<String, Object>> getBoardList(int page);
}
