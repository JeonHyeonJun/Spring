package service;

import model.Member;

public interface IMemberService {
	public boolean insertMember(Member member);
	public boolean checkId(String id);
	public boolean checkPw(String id, String pw);
	
	public boolean updatePass(Member member);
	public boolean deleteMember(String id, String pw);
//	public boolean loginMember(String id, String pw);
}
