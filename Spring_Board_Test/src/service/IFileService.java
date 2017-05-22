package service;

import java.util.HashMap;

import org.springframework.web.multipart.MultipartFile;

public interface IFileService {
	public HashMap<String, Object> writeSummernoteFile(MultipartFile file);
	public HashMap<String, Object> selectOne(int fileId);
}
