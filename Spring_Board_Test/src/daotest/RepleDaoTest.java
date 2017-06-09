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
import dao.IRepleDao;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:WebContent/WEB-INF/dispatcher-servlet.xml", 
		"file:WebContent/WEB-INF/rootContext.xml"})
public class RepleDaoTest {
	
	@Autowired
	private IRepleDao repleDao;
	
	public HashMap<String, Object> makeVO(){
		HashMap<String, Object> repleVO = new HashMap<>();
		repleVO.put(Constant.Reple.BOARDIDX, 15);
		repleVO.put(Constant.Reple.CONTENT, "내용");
		repleVO.put(Constant.Reple.WRITER, "글쓴이");
		repleVO.put(Constant.Reple.WRITERIDX, 1);
		return repleVO;
	}
	
	public void checkResult(HashMap<String, Object> vo, HashMap<String, Object> result){
		Assert.assertNotNull(result);
		Assert.assertEquals(vo.get(Constant.Reple.IDX), result.get(Constant.Reple.IDX));
		Assert.assertEquals(vo.get(Constant.Reple.BOARDIDX), result.get(Constant.Reple.BOARDIDX));
		Assert.assertEquals(vo.get(Constant.Reple.CONTENT), result.get(Constant.Reple.CONTENT));
		Assert.assertEquals(vo.get(Constant.Reple.WRITER), result.get(Constant.Reple.WRITER));
		Assert.assertEquals(vo.get(Constant.Reple.WRITERIDX), result.get(Constant.Reple.WRITERIDX));
		Assert.assertEquals(vo.get(Constant.Reple.ISDELETE), result.get(Constant.Reple.ISDELETE));
	}
	
	@Test
	public void RepleTest(){
		HashMap<String, Object> vo = makeVO();
		
		//삽입
		repleDao.insertReple(vo);
		int idx = Integer.parseInt(vo.get(Constant.Reple.IDX).toString());
		HashMap<String, Object> result = repleDao.selectOne(idx);
		vo.put(Constant.Reple.IDX, idx);
		vo.put(Constant.Reple.ISDELETE, result.get(Constant.Reple.ISDELETE));
		checkResult(vo, result);		
		
		//수정
		vo.put(Constant.Reple.CONTENT, "내용2");
		vo.put(Constant.Reple.ISDELETE, "Y");
		repleDao.updateReple(vo);
		HashMap<String, Object> result2 = repleDao.selectOne(idx);
		checkResult(vo, result2);
		
		//삭제
		repleDao.deleteReple(0);
		HashMap<String, Object> result3 = repleDao.selectOne(idx);
		Assert.assertNull(result3);
	}

}
