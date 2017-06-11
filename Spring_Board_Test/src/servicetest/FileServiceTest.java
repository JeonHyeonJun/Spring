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
import service.IFileService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:WebContent/WEB-INF/dispatcher-servlet.xml", 
		"file:WebContent/WEB-INF/rootContext.xml"})
public class FileServiceTest {
	
	@Autowired
	private IFileService fileService;

	final int IDX = 1;

	
	public void checkResult(HashMap<String, Object> vo, HashMap<String, Object> result){
		Assert.assertNotNull(result);
		Assert.assertEquals(vo.get(Constant.File.FILEID), result.get(Constant.File.FILEID));
		Assert.assertEquals(vo.get(Constant.File.ORIGINFILENAME), result.get(Constant.File.ORIGINFILENAME));
		Assert.assertEquals(vo.get(Constant.File.URI), result.get(Constant.File.URI));
	}
	
	@Test
	public void fileTest(){
		//삽입
		MockMultipartFile file = new MockMultipartFile("file", "orig", null, "bar".getBytes());

		HashMap<String, Object> vo = fileService.writeSummernoteFile(file);
		
		int fileId = Integer.parseInt(vo.get(Constant.File.FILEID).toString());
		vo.put(Constant.File.FILEID, fileId);
		HashMap<String, Object> result = fileService.selectOne(fileId);
		
		checkResult(vo, result);
		
		

	}

}
