package service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import commons.Constant;
import dao.IRepleDao;

@Service
public class RepleService implements IRepleService{

	@Autowired
	private IRepleDao repleDao;
	
	@Override
	public boolean insertReple(int boardIdx, String content, String writer, int writerIdx, int parent) {
		// TODO Auto-generated method stub
		HashMap<String, Object> params = new HashMap<>();
		params.put(Constant.Reple.BOARDIDX, boardIdx);
		params.put(Constant.Reple.CONTENT, content);
		params.put(Constant.Reple.WRITER, writer);
		params.put(Constant.Reple.WRITERIDX, writerIdx);
		int result = repleDao.insertReple(params);
		
		params.put(Constant.Reple.GROUPCODE, params.get("idx"));
		params.put(Constant.Reple.GROUPSEQ, 0);
		params.put(Constant.Reple.GROUPLV, 0);
		params.put(Constant.Reple.PARENT, 0);
		//댓글의댓글 (혹은 그이상)일때
		if(parent != 0){
			HashMap<String, Object> parentReple = repleDao.selectOne(parent);
			int groupCode = (int)parentReple.get(Constant.Reple.GROUPCODE);
			int groupSeq = repleDao.maxGroupSeq(groupCode);
			int groupLv = (int)parentReple.get(Constant.Reple.GROUPLV);
			params.put(Constant.Reple.GROUPCODE, groupCode);
			params.put(Constant.Reple.GROUPSEQ, groupSeq+1);
			params.put(Constant.Reple.PARENT, parent);
			
			//댓글의 댓글일때
			if(groupLv == 0)
				params.put(Constant.Reple.GROUPLV, groupLv+1);
			//댓글의 댓글의 댓글일때
			else{
				params.put(Constant.Reple.GROUPLV, 2);
				params.put(Constant.Reple.PARENTNAME, parentReple.get(Constant.Reple.WRITER));
			}
			
		}
		result = repleDao.updateGroup(params);
		if(result > 0)
			return true;
		else
			return false;
	}

	@Override
	public boolean updateReple(int idx, String content) {
		// TODO Auto-generated method stub
		HashMap<String, Object> params = new HashMap<>();
		params.put(Constant.Reple.IDX, idx);
		params.put(Constant.Reple.CONTENT, content);
		params.put(Constant.Reple.ISDELETE, "N");
		int result = repleDao.updateReple(params);
		if(result > 0)
			return true;
		else
			return false;
	}

	@Override
	public boolean deleteReple(int idx, int groupCode) {
		// TODO Auto-generated method stub
		HashMap<String, Object> params = repleDao.selectOne(idx);
		params.put(Constant.Reple.IDX, idx);
		params.put(Constant.Reple.CONTENT, params.get(Constant.Reple.CONTENT));
		params.put(Constant.Reple.ISDELETE, "Y");
		int result = repleDao.updateReple(params);
		
		List<HashMap<String, Object>> list = repleDao.selectGroupCode(groupCode);
		boolean checkDeleteAll = true;
		
		for(int i=0; i<list.size(); i++){
			if(list.get(i).get(Constant.Reple.ISDELETE).equals("N"))
				checkDeleteAll = false;
		}
		if(checkDeleteAll)
			repleDao.deleteReple(groupCode);

		if(result > 0)
			return true;
		else
			return false;
	}

	@Override
	public HashMap<String, Object> selectOne(int idx) {
		// TODO Auto-generated method stub
		return repleDao.selectOne(idx);
	}

	@Override
	public List<HashMap<String, Object>> selectList(int boardIdx) {
		// TODO Auto-generated method stub
		return repleDao.selectList(boardIdx);
	}

}
