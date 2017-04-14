package service;

import java.util.HashMap;

import model.Board;

public interface IBoardService {
	public void writeBoard(Board board);
	public void updateBoard(Board board);
	public boolean deleteBoard(int num, String pass);
	public Board readBoard(int num);
	public Board getBoard(int num);
	public HashMap<String, Object> getBoardList(int page);	
}
