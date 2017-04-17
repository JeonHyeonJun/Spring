package service;

import java.util.HashMap;

import org.springframework.web.multipart.MultipartFile;

import model.Board;

public interface IBoardService {
	public void writeBoard(Board board, MultipartFile file);
	public void updateBoard(Board board);
	public boolean deleteBoard(int num, String pass);
	public Board readBoard(int num);
	public Board getBoard(int num);
	public HashMap<String, Object> getBoardList(int page);
	public String getFileUri(int num);
}
