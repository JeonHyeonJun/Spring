package dao;

import java.util.List;

import model.Board;

public interface IBoardDao {
	public void insertBoard(Board board);
	public void updateBoard(Board board);
	public void deleteBoard(int num);
	public Board selectOne(int num);
	public List<Board> selectAll();
}
