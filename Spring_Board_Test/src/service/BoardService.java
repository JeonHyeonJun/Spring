package service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import commons.Constant;
import dao.IBoardDao;

@Service
public class BoardService implements IBoardService{

	@Autowired
	private IBoardDao boardDao;
	@Override
	public boolean insertBoard(String title, String content, String writer, int fileId, int writerIdx) {
		// TODO Auto-generated method stub
		HashMap<String, Object> params = new HashMap<>();
		params.put(Constant.Board.TITLE, title);
		params.put(Constant.Board.CONTENT, content);
		params.put(Constant.Board.WRITER, writer);
		params.put(Constant.Board.FILEID, fileId);
		params.put(Constant.Board.WRITERIDX, writerIdx);
		int result = boardDao.insertBoard(params);
		if(result > 0)
			return true;
		else
			return false;
	}

	@Override
	public boolean updateBoard(int idx, String title, String content, int readCount) {
		// TODO Auto-generated method stub
		HashMap<String, Object> params = new HashMap<>();
		params.put(Constant.Board.IDX, idx);
		params.put(Constant.Board.TITLE, title);
		params.put(Constant.Board.CONTENT, content);
		params.put(Constant.Board.READCOUNT, readCount);
		int result = boardDao.updateBoard(params);
		if(result > 0)
			return true;
		else
			return false;
	}

	@Override
	public boolean deleteBoard(int idx) {
		// TODO Auto-generated method stub
		int result = boardDao.deleteBoard(idx);
		if(result > 0)
			return true;
		else
			return false;
	}

	@Override
	public HashMap<String, Object> selectOne(int idx) {
		// TODO Auto-generated method stub
		return boardDao.selectOne(idx);
	}

	@Override
	public HashMap<String, Object> getBoard(int idx) {
		// TODO Auto-generated method stub
		HashMap<String, Object> params = boardDao.selectOne(idx);
		params.put(Constant.Board.READCOUNT, (int)params.get(Constant.Board.READCOUNT)+1);
		boardDao.updateBoard(params);
		return params;
	}
	
	@Override
	public HashMap<String, Object> selectList(int page) {
		// TODO Auto-generated method stub

		int count = 10;	
		int skip = (page-1) * count;	
		
		
		int first = 1;
		
		int start = (page-1) / 10 * 10 + 1;
		
		int end = ((page-1) / 10 + 1) *10;
		
		int last = (boardDao.getBoardCount()-1)/count + 1;
		
		end = last < end ? last : end;
		
		HashMap<String, Object> params = new HashMap<>();
		params.put("skip", skip);
		params.put("count", count);
		List<HashMap<String, Object>> list = boardDao.selectBoardLimit(params);
		
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
