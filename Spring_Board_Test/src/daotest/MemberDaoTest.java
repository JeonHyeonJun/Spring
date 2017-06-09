package daotest;

import java.util.HashMap;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import commons.Constant;
import dao.IMemberDao;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:WebContent/WEB-INF/dispatcher-servlet.xml", 
		"file:WebContent/WEB-INF/rootContext.xml"})
public class MemberDaoTest {
	
	@Autowired
	private IMemberDao memberDao;
	
	public HashMap<String, Object> makeVO(){
		HashMap<String, Object> memberVO = new HashMap<>();
		memberVO.put(Constant.Member.ID, "아이디");
		memberVO.put(Constant.Member.PASS, "암호");
		memberVO.put(Constant.Member.NAME, "닉네임");
		return memberVO;
	}
	
	public void checkResult(HashMap<String, Object> vo, HashMap<String, Object> result){
		Assert.assertNotNull(result);
		Assert.assertEquals(vo.get(Constant.Member.ID), result.get(Constant.Member.ID));
		Assert.assertEquals(vo.get(Constant.Member.PASS), result.get(Constant.Member.PASS));
		Assert.assertEquals(vo.get(Constant.Member.NAME), result.get(Constant.Member.NAME));
		Assert.assertEquals(vo.get(Constant.Member.IDX), result.get(Constant.Member.IDX));
	}
	
	@Test
	public void MemberTest(){
		HashMap<String, Object> vo = makeVO();
		
		//삽입
		memberDao.insertMember(vo);
		int idx = Integer.parseInt(vo.get(Constant.Member.IDX).toString());
		HashMap<String, Object> result = memberDao.selectOne(idx);
		vo.put(Constant.Board.IDX, idx);
		checkResult(vo, result);
		
		//수정
		vo.put(Constant.Member.PASS, "제목2");
		vo.put(Constant.Member.NAME, "내용2");
		memberDao.updateMember(vo);
		HashMap<String, Object> result2 = memberDao.selectOne(idx);
		checkResult(vo, result2);
		
		//삭제
		memberDao.deleteMember(idx);
		HashMap<String, Object> result3 = memberDao.selectOne(idx);		
		Assert.assertNull(result3);

	}
	
}
