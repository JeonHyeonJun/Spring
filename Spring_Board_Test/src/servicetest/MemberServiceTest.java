package servicetest;

import java.util.HashMap;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import commons.Constant;
import dao.IBoardDao;
import service.IBoardService;
import service.IMemberService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:WebContent/WEB-INF/dispatcher-servlet.xml", 
		"file:WebContent/WEB-INF/rootContext.xml"})
public class MemberServiceTest {
	
	@Autowired
	private IMemberService memberService;
		
	final int IDX = 1;

	
//	public void checkResult(HashMap<String, Object> vo, HashMap<String, Object> result){
//		Assert.assertNotNull(result);
//		Assert.assertEquals(vo.get(Constant.Board.IDX), result.get(Constant.Board.IDX));
//		Assert.assertEquals(vo.get(Constant.Board.TITLE), result.get(Constant.Board.TITLE));
//		Assert.assertEquals(vo.get(Constant.Board.CONTENT), result.get(Constant.Board.CONTENT));
//		Assert.assertEquals(vo.get(Constant.Board.WRITER), result.get(Constant.Board.WRITER));
//		Assert.assertEquals(vo.get(Constant.Board.READCOUNT), result.get(Constant.Board.READCOUNT));
//		Assert.assertEquals(vo.get(Constant.Board.FILEID), result.get(Constant.Board.FILEID));
//		Assert.assertEquals(vo.get(Constant.Board.WRITERIDX), result.get(Constant.Board.WRITERIDX));
//	}
	
	@Test
	public void memberTest(){
		//삽입
		String id = "아이디";
		String pass = "asdasd";
		String name = "이름";

		boolean result = memberService.insertMember(id, pass, name);
		Assert.assertTrue(result);
		

	}

}
