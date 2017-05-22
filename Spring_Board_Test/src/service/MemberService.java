package service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import commons.Constant;
import dao.IMemberDao;

@Service
public class MemberService implements IMemberService{
	@Autowired
	private IMemberDao memberDao;

	@Override
	public boolean insertMember(String id, String pass, String name) {
		// TODO Auto-generated method stub
		HashMap<String, Object> params = new HashMap<>();
		params.put(Constant.Member.ID, id);
		params.put(Constant.Member.PASS, pass);
		params.put(Constant.Member.NAME, name);
		int result = memberDao.insertMember(params);
		if(result > 0)
			return true;
		else
			return false;
	}

	@Override
	public boolean updateMember(String pass, String name) {
		// TODO Auto-generated method stub
		HashMap<String, Object> params = new HashMap<>();
		params.put(Constant.Member.PASS, pass);
		params.put(Constant.Member.NAME, name);
		int result = memberDao.updateMember(params);
		if(result > 0)
			return true;
		else
			return false;
	}

	@Override
	public boolean deleteMember(int idx) {
		// TODO Auto-generated method stub
		int result = memberDao.deleteMember(idx);
		if(result > 0)
			return true;
		else
			return false;
	}

	@Override
	public HashMap<String, Object> selectOne(int idx) {
		// TODO Auto-generated method stub
		return memberDao.selectOne(idx);
	}

	@Override
	public HashMap<String, Object> selectId(String id) {
		// TODO Auto-generated method stub
		return memberDao.selectId(id);
	}

	@Override
	public HashMap<String, Object> selectName(String name) {
		// TODO Auto-generated method stub
		return memberDao.selectName(name);
	}

}
