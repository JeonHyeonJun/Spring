package daotest;

import java.util.HashMap;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import commons.Constant;
import dao.IBoardDao;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:WebContent/WEB-INF/dispatcher-servlet.xml", 
		"file:WebContent/WEB-INF/rootContext.xml"})
public class BoardDaoTest {
	
	@Autowired
	private IBoardDao boardDao;
	
	public HashMap<String, Object> makeVO(){
		HashMap<String, Object> boardVO = new HashMap<>();
		boardVO.put(Constant.Board.TITLE, "제목");
		boardVO.put(Constant.Board.CONTENT, "내용");
		boardVO.put(Constant.Board.WRITER, "글쓴이");
		boardVO.put(Constant.Board.FILEID, 0);
		boardVO.put(Constant.Board.WRITERIDX, 1);
		return boardVO;
	}
	
	public void checkResult(HashMap<String, Object> vo, HashMap<String, Object> result){
		
		Assert.assertNotNull(result);
		Assert.assertEquals(vo.get(Constant.Board.IDX), result.get(Constant.Board.IDX));
		Assert.assertEquals(vo.get(Constant.Board.TITLE), result.get(Constant.Board.TITLE));
		Assert.assertEquals(vo.get(Constant.Board.CONTENT), result.get(Constant.Board.CONTENT));
		Assert.assertEquals(vo.get(Constant.Board.WRITER), result.get(Constant.Board.WRITER));
		Assert.assertEquals(vo.get(Constant.Board.READCOUNT), result.get(Constant.Board.READCOUNT));
		Assert.assertEquals(vo.get(Constant.Board.FILEID), result.get(Constant.Board.FILEID));
		Assert.assertEquals(vo.get(Constant.Board.WRITERIDX), result.get(Constant.Board.WRITERIDX));
	}
	
	@Test
	public void BoardTest(){
		HashMap<String, Object> vo = makeVO();
		int cnt = boardDao.selectList().size();
		//삽입
		boardDao.insertBoard(vo);
		int idx = Integer.parseInt(vo.get(Constant.Board.IDX).toString());
		HashMap<String, Object> result = boardDao.selectOne(idx);
		vo.put(Constant.Board.IDX, idx);
		vo.put(Constant.Board.READCOUNT, result.get(Constant.Board.READCOUNT));
		checkResult(vo, result);
		
		//리스트
		int cnt2 = boardDao.selectList().size();
		Assert.assertEquals(cnt+1, cnt2);
		
		//수정
		vo.put(Constant.Board.TITLE, "제목2");
		vo.put(Constant.Board.CONTENT, "내용2");
		vo.put(Constant.Board.READCOUNT, 3);
		vo.put(Constant.Board.FILEID, 1);
		boardDao.updateBoard(vo);
		HashMap<String, Object> result2 = boardDao.selectOne(idx);
		checkResult(vo, result2);
		
		//삭제
		boardDao.deleteBoard(idx);
		HashMap<String, Object> result3 = boardDao.selectOne(idx);		
		Assert.assertNull(result3);
		
	}
	
	

}
