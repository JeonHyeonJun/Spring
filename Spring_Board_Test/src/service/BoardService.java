package service;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import commons.Constant;
import dao.IBoardDao;
import dao.IFileDao;

@Service
public class BoardService implements IBoardService{

	@Autowired
	private IBoardDao boardDao;
	@Autowired
	private IFileDao fileDao;
	
	@Override
	public boolean insertBoard(String title, String content, String writer, @RequestParam(defaultValue="0")int fileId, 
			int writerIdx, MultipartFile file) {
		// TODO Auto-generated method stub
		String path = "Upload/";
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
		if(fileName != ""){
			fileDao.insertFile(boardFile);
		}
		
		HashMap<String, Object> params = new HashMap<>();
		params.put(Constant.Board.TITLE, title);
		params.put(Constant.Board.CONTENT, content);
		params.put(Constant.Board.WRITER, writer);
		if(fileName != "")
			params.put(Constant.Board.FILEID, boardFile.get("fileId"));
		else
			params.put(Constant.Board.FILEID, fileId);
		params.put(Constant.Board.WRITERIDX, writerIdx);
		int result = boardDao.insertBoard(params);
		if(result > 0)
			return true;
		else
			return false;
	}

	@Override
	public boolean updateBoard(int idx, String title, String content, int readCount, MultipartFile file) {
		// TODO Auto-generated method stub
		String path = "Upload/";
		File folder = new File(path);
		if(!folder.exists())
			folder.mkdirs();
		
		UUID uuid = UUID.randomUUID();
		//원본파일명
		String fileName = file.getOriginalFilename();
		//파일경로
		String fileuri = path + uuid;
		
		int fileid = (int)boardDao.selectOne(idx).get(Constant.Board.FILEID);
		if(fileid != 0){
			fileid = (int)boardDao.selectOne(idx).get(Constant.Board.FILEID);
			fileuri = (String)fileDao.selectOne(fileid).get(Constant.File.URI);	
		}
		
		HashMap<String, Object> boardFile = new HashMap<>();
		boardFile.put(Constant.File.FILEID, fileid);
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
		if(!fileName.equals("")){
			if(fileid != 0)
				fileDao.updateFile(boardFile);
			else{
				fileDao.insertFile(boardFile);
				fileid = (int)boardFile.get("fileId");
			}
		}
		

		
		HashMap<String, Object> params = new HashMap<>();
		params.put(Constant.Board.IDX, idx);
		params.put(Constant.Board.TITLE, title);
		params.put(Constant.Board.CONTENT, content);
		params.put(Constant.Board.READCOUNT, readCount);
		params.put(Constant.Board.FILEID, fileid);
		int result = boardDao.updateBoard(params);
		if(result > 0)
			return true;
		else
			return false;
	}

	@Override
	public boolean deleteBoard(int idx) {
		// TODO Auto-generated method stub
		HashMap<String, Object> board = boardDao.selectOne(idx);
		if(board.get(Constant.Board.FILEID) != null)
		fileDao.deleteFile((int)board.get(Constant.Board.FILEID));
		int result = boardDao.deleteBoard(idx);
		if(result > 0)
			return true;
		else
			return false;
	}

	@Override
	public HashMap<String, Object> selectOne(int idx) {
		// TODO Auto-generated method stub
		return boardDao.selectOne(idx);
	}

	@Override
	public HashMap<String, Object> getBoard(int idx) {
		// TODO Auto-generated method stub
		HashMap<String, Object> params = boardDao.selectOne(idx);
		params.put(Constant.Board.READCOUNT, (int)params.get(Constant.Board.READCOUNT)+1);
		boardDao.updateBoard(params);
		return params;
	}
	
	@Override
	public HashMap<String, Object> selectList(int page) {
		// TODO Auto-generated method stub

		int count = 10;	
		int skip = (page-1) * count;	
		
		
		int first = 1;
		
		int start = (page-1) / 10 * 10 + 1;
		
		int end = ((page-1) / 10 + 1) *10;
		
		int last = (boardDao.getBoardCount()-1)/count + 1;
		
		end = last < end ? last : end;
		
		HashMap<String, Object> params = new HashMap<>();
		params.put("skip", skip);
		params.put("count", count);
		List<HashMap<String, Object>> list = boardDao.selectBoardLimit(params);
		
		HashMap<String, Object> result = new HashMap<>();
		result.put("first", first);
		result.put("start", start);
		result.put("end", end);
		result.put("last", last);
		result.put("current", page);
		result.put("boardList", list);
		
		return result;
	}



}
