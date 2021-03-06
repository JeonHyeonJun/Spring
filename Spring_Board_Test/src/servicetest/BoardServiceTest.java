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
import service.IBoardService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:WebContent/WEB-INF/dispatcher-servlet.xml", 
		"file:WebContent/WEB-INF/rootContext.xml"})
public class BoardServiceTest {
	
	@Autowired
	private IBoardService boardService;

	final int IDX = 1;

	
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
	public void boardTest(){
		//삽입
		String title = "제목";
		String content = "내용";
		String writer = "글쓴이";
		int fileId = 0;
		int writerIdx = 1;
		MockMultipartFile file = new MockMultipartFile("file", "orig", null, "bar".getBytes());

		boolean result = boardService.insertBoard(title, content, writer, fileId, writerIdx, file);
		Assert.assertTrue(result);
		
		//수정
		title = "제목변경";
		content = "내용변경";
		int readCount = 1;
		boolean result2 = boardService.updateBoard(IDX, title, content, readCount, file);
		Assert.assertTrue(result2);
		
		//삭제
//		boolean result3 = boardService.deleteBoard(1);
//		Assert.assertTrue(result3);
		
		//getBoard
		int rcnt1= Integer.parseInt(boardService.selectOne(IDX).get(Constant.Board.READCOUNT).toString());
		int rcnt2 = Integer.parseInt(boardService.getBoard(IDX).get(Constant.Board.READCOUNT).toString());
		Assert.assertEquals(rcnt1+1, rcnt2);
	}

}
