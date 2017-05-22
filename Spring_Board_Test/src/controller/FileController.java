package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.HashMap;

import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.serial.SerialException;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import service.IFileService;

@Controller
public class FileController {
	@Autowired
	private IFileService fileService;

	//db에 저장된 이미지 출력
	@RequestMapping(value = "/imageShow/{fileId}.do", method = {RequestMethod.GET})
	public void imageShow(@PathVariable("fileId") int fileId, HttpServletResponse response) throws IOException, SerialException, SQLException {
	
		HashMap<String, Object> boardfile = fileService.selectOne(fileId);
		
		response.setContentType("images/jpg; utf-8");
		String originFile = (String)boardfile.get("originFileName");
		String filename = new String(originFile.getBytes("UTF-8"),"ISO-8859-1");
		response.setHeader("Content-Disposition", "inline;filename=\"" + filename + "\";");
		response.setHeader("Content-Transfer-Encoding", "binary");
		
		OutputStream outputStream = response.getOutputStream();
	
		File file = new File((String)boardfile.get("uri"));
	
		FileInputStream inputStream = new FileInputStream(file);
	
		IOUtils.copy(inputStream, outputStream);
	
		outputStream.flush();
		outputStream.close();
	}

	//summernote에 올리는 이미지 db에 저장
	@RequestMapping("image.do")
    public @ResponseBody HashMap<String, Object> handleFileUpload(HttpServletResponse resp, @RequestParam("file") MultipartFile file) {
        try {
            HashMap<String, Object> uploadFile = fileService.writeSummernoteFile(file);
            return uploadFile;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
