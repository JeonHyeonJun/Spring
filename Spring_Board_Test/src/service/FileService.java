package service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.IFileDao;

@Service
public class FileService implements IFileService{

	@Autowired
	private IFileDao fileDao;
	
	@Override
	public HashMap<String, Object> selectOne(int fileId) {
		// TODO Auto-generated method stub
		return fileDao.selectOne(fileId);
	}

}
