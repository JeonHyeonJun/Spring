package service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.IBoardDao;
import model.Board;

@Service
public class BoardService implements IBoardService{
	@Autowired
	private IBoardDao dao;

	@Override
	public void writeBoard(Board board) {
		// TODO Auto-generated method stub
		dao.insertBoard(board);
	}

	@Override
	public void updateBoard(Board board) {
		// TODO Auto-generated method stub
		dao.updateBoard(board);
	}

	@Override
	public boolean deleteBoard(int num, String pass) {
		// TODO Auto-generated method stub
		String originPass = dao.selectOne(num).getPass();
		
		if(pass.equals(originPass)){
			dao.deleteBoard(num);
			return true;
		}
		else
			return false;
	}

	@Override
	public Board readBoard(int num) {
		// TODO Auto-generated method stub
		Board board = dao.selectOne(num);
		board.setReadcount(board.getReadcount()+1);
		dao.updateBoard(board);
		return board;
	}
	
	@Override
	public Board getBoard(int num) {
		// TODO Auto-generated method stub
		return dao.selectOne(num);
	}

	@Override
	public HashMap<String, Object> getBoardList(int page) {
		// TODO Auto-generated method stub
		//첫페이지 -> 맨앞페이지
		int first = 1;
		//시작페이지 -> 현재 보이는 첫페이지
		int start = (page-1) / 10 * 10 + 1;
		//끝페이지 -> 현재 보이는 마지막페이지
		int end = ((page-1) / 10 + 1) *10;
		//마지막페이지 -> 맨마지막페이지
		int last = (dao.getBoardCount()-1)/10 + 1;
		//마지막페이지가 끝페이지보다 작으면 end=last
		end = last < end ? last : end;
		//건너뛸 게시물 개수
		int skip = (page-1) * 10;
		//한페이지에 표시할 게시물 개수
		int count = 10;
				
		HashMap<String, Object> params = new HashMap<>();
		params.put("skip", skip);
		params.put("count", count);
		List<Board> list = dao.selectBoardLimit(params);
		
		HashMap<String, Object> result = new HashMap<>();
		result.put("first", first);
		result.put("start", start);
		result.put("end", end);
		result.put("last", last);
		result.put("current", page);
		result.put("boardList", list);
		
		return result;
	}





}
