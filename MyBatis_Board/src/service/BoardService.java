package service;

import java.util.HashMap;
import java.util.List;

import commons.Constant;
import dao.BoardDao;
import dao.IBoardDao;

public class BoardService implements IBoardService{

	private IBoardDao dao = new BoardDao();
	@Override
	public boolean writeBoard(String pass, String title, String content, String name, String email, int parent) {
		// TODO Auto-generated method stub
		HashMap<String, Object> params = new HashMap<>();
		params.put(Constant.PASS, pass);
		params.put(Constant.TITLE, title);
		params.put(Constant.CONTENT, content);
		params.put(Constant.NAME, name);
		params.put(Constant.EMAIL, email);
		int result = dao.insertBoard(params);
		if(parent == 0 ){
			params.put(Constant.GROUP_CODE, params.get("num"));
			params.put(Constant.GROUP_SEQ, 0);
			params.put(Constant.GROUP_LV, 0);
			result = dao.updateBoard(params);
		}
		else{
			HashMap<String, Object> parentBoard = dao.selectOne(parent);
			int group_code = (int)parentBoard.get(Constant.GROUP_CODE);
			int group_seq = (int)parentBoard.get(Constant.GROUP_SEQ);
			int group_lv = (int)parentBoard.get(Constant.GROUP_LV);
			HashMap<String, Object> params2 = new HashMap<>();
			params2.put(Constant.GROUP_CODE, group_code);
			params2.put(Constant.GROUP_SEQ, group_seq);
			dao.increaseGroupSeq(params2);
//			List<HashMap<String, Object>> group = dao.selectGroup((int)parentBoard.get("group_code"));
//			for(int i=0; i<group.size(); i++){
//				if((int)group.get(i).get("group_code") == (int)parentBoard.get("group_code")
//					&& (int)group.get(i).get("group_seq") > (int)parentBoard.get("group_seq") ){
//					group.get(i).put("num", group.get(i).get("num"));
//					group.get(i).put("group_seq", (int)group.get(i).get("group_seq")+1);
//					dao.updateGroup(group.get(i));
//				}
//			}
			
//			int max_seq = dao.selectGroup((int)parentBoard.get("group_code"));
			params.put("group_code", parentBoard.get(Constant.GROUP_CODE));
			params.put("group_seq", (int)parentBoard.get(Constant.GROUP_SEQ)+1);
			params.put("group_lv", (int)parentBoard.get(Constant.GROUP_LV)+1);
			result = dao.updateBoard(params);
		}
		if(result > 0)
			return true;
		else
			return false;
	}

	@Override
	public boolean modifyBoard(int num, String title, String content) {
		// TODO Auto-generated method stub
		HashMap<String, Object> board = dao.selectOne(num);
		board.put(Constant.TITLE, title);
		board.put(Constant.CONTENT, content);
		int result = dao.updateBoard(board);
		if(result > 0)
			return true;
		else
			return false;
	}

	@Override
	public boolean deleteBoard(int num) {
		// TODO Auto-generated method stub
		int result = dao.deleteBoard(num);
		if(result > 0)
			return true;
		else
			return false;
	}

	@Override
	public HashMap<String, Object> readBoard(int num) {
		// TODO Auto-generated method stub
		HashMap<String, Object> board = dao.selectOne(num);
		board.put(Constant.READCOUNT, (int)board.get(Constant.READCOUNT) +1);
		dao.updateBoard(board);
		return board;
	}

	@Override
	public List<HashMap<String, Object>> getBoardList(int page) {
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
		List<HashMap<String, Object>> list = dao.selectBoardLimit(params);
		
		HashMap<String, Object> result = new HashMap<>();
		result.put("first", first);
		result.put("start", start);
		result.put("end", end);
		result.put("last", last);
		result.put("current", page);
		result.put("boardList", list);
		
		return (List<HashMap<String, Object>>) result.get("boardList");
	}

	@Override
	public List<HashMap<String, Object>> getBoardReple() {
		// TODO Auto-generated method stub
		List<HashMap<String, Object>> list = dao.selectReple();
		return list;
	}



}
