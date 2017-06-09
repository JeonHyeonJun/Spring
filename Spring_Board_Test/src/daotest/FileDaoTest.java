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
import dao.IFileDao;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:WebContent/WEB-INF/dispatcher-servlet.xml", 
		"file:WebContent/WEB-INF/rootContext.xml"})
public class FileDaoTest {
	
	@Autowired
	private IFileDao fileDao;
	
	public HashMap<String, Object> makeVO(){
		HashMap<String, Object> repleVO = new HashMap<>();
		repleVO.put(Constant.File.ORIGINFILENAME, "원본파일명");
		repleVO.put(Constant.File.URI, "파일경로");
		return repleVO;
	}
	
	public void checkResult(HashMap<String, Object> vo, HashMap<String, Object> result){
		Assert.assertNotNull(result);
		Assert.assertEquals(vo.get(Constant.File.FILEID), result.get(Constant.File.FILEID));
		Assert.assertEquals(vo.get(Constant.File.ORIGINFILENAME), result.get(Constant.File.ORIGINFILENAME));
		Assert.assertEquals(vo.get(Constant.File.URI), result.get(Constant.File.URI));
	}
	
	@Test
	public void a_insertFileTest(){
		HashMap<String, Object> vo = makeVO();
		
		//삽입
		fileDao.insertFile(vo);
		int fileId = Integer.parseInt(vo.get(Constant.File.FILEID).toString());
		HashMap<String, Object> result = fileDao.selectOne(fileId);
		vo.put(Constant.File.FILEID, fileId);
		checkResult(vo, result);	
		
		//수정
		vo.put(Constant.File.ORIGINFILENAME, "내용2");
		vo.put(Constant.File.URI, "경로2");
		fileDao.updateFile(vo);
		HashMap<String, Object> result2 = fileDao.selectOne(fileId);
		checkResult(vo, result2);
		
		//삭제
		fileDao.deleteFile(fileId);
		HashMap<String, Object> result3 = fileDao.selectOne(fileId);
		Assert.assertNull(result3);
	}
	
}
