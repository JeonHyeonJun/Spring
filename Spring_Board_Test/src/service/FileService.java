package service;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import commons.Constant;
import dao.IFileDao;

@Service
public class FileService implements IFileService{

	@Autowired
	private IFileDao fileDao;
	
	@Override
	public HashMap<String, Object> writeSummernoteFile(MultipartFile file) {
		// TODO Auto-generated method stub
		String path = "Summernote/";
		File folder = new File(path);
		if(!folder.exists())
			folder.mkdirs();
		
		UUID uuid = UUID.randomUUID();
		//원본파일명
		String fileName = file.getOriginalFilename();
		//파일경로
		String fileuri = path + uuid;
		
		HashMap<String, Object> boardFile = new HashMap<>();
		boardFile.put(Constant.File.ORIGINFILENAME, fileName);
		boardFile.put(Constant.File.URI, fileuri);
		
		File localFile = new File(fileuri);
		try {
			file.transferTo(localFile);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		fileDao.insertFile(boardFile);
		boardFile.put(Constant.File.FILEID, boardFile.get("fileId"));
		return boardFile;
	}
	
	@Override
	public HashMap<String, Object> selectOne(int fileId) {
		// TODO Auto-generated method stub
		return fileDao.selectOne(fileId);
	}

}
