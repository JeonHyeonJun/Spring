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
import service.IRepleService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:WebContent/WEB-INF/dispatcher-servlet.xml", 
		"file:WebContent/WEB-INF/rootContext.xml"})
public class RepleServiceTest {
	
	@Autowired
	private IRepleService repleService;

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
	public void repleTest(){
		//삽입
		int boardIdx = 2;
		String content = "내용";
		String writer = "글쓴이";
		int fileId = 0;
		int writerIdx = 1;
		int parent = 0;
		
		int cnt = repleService.selectList(boardIdx).size();

		boolean result = repleService.insertReple(boardIdx, content, writer, writerIdx, parent);
		Assert.assertTrue(result);
		
		//리스트
		int cnt2 = repleService.selectList(boardIdx).size();
		Assert.assertEquals(cnt+1, cnt2);
		
		//수정
		content = "내용변경";
		boolean result2 = repleService.updateReple(IDX, content);
		Assert.assertTrue(result2);
		
		//삭제
		int groupCode = 0;
		boolean result3 = repleService.deleteReple(IDX, groupCode);
		Assert.assertTrue(result3);
		

	}

}
