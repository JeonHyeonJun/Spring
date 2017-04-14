package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.IMemberDao;
import model.Member;

@Service
public class MemberService implements IMemberService{

	@Autowired
	private IMemberDao dao;
	
	@Override
	public boolean insertMember(Member member) {
		// TODO Auto-generated method stub
		Member idcheck = dao.selectOne(member.getId());
		if(idcheck == null){
			dao.insertMember(member);
			return true;
		}
		else
			return false;
	}

	@Override
	public boolean updatePass(Member member) {
		// TODO Auto-generated method stub
		int result = dao.updateMember(member);
		if(result > 0)
			return true;
		else
			return false;
	}

	@Override
	public boolean deleteMember(String id, String pw) {
		// TODO Auto-generated method stub
		Member member = dao.selectOne(id);
		if(member.getPw().equals(pw)){
			dao.deleteMember(id);
			return true;
		}
		else
			return false;
	}

	@Override
	public boolean checkPw(String id, String pw) {
		// TODO Auto-generated method stub
		Member member = dao.selectOne(id);
		if(member != null){
			if(pw.equals(member.getPw()))
				return true;
			else
				return false;
		}
		else
			return false;
	}

	@Override
	public boolean checkId(String id) {
		// TODO Auto-generated method stub
		Member member = dao.selectOne(id);
		if(member == null)
			return true;
		else
			return false;
	}

}
