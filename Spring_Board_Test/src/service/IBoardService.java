package service;

import java.util.HashMap;

import org.springframework.web.multipart.MultipartFile;

public interface IBoardService {
	public boolean insertBoard(String title, String content, String writer, int fileId, int writerIdx, MultipartFile file);
	public boolean updateBoard(int idx, String title, String content, int readCount, MultipartFile file);
	public boolean deleteBoard(int idx);
	public HashMap<String, Object> selectOne(int idx);
	public HashMap<String, Object> getBoard(int idx);
	public HashMap<String, Object> selectList(int page);
}
