package service;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import dao.IBoardDao;
import dao.IBoardFileDao;
import model.Board;
import model.BoardFile;

@Service
public class BoardService implements IBoardService{
	@Autowired
	private IBoardDao dao;
	@Autowired
	private IBoardFileDao fdao;

	@Override
	public void writeBoard(Board board, MultipartFile file) {
		// TODO Auto-generated method stub
		String path = "Upload/";
		File folder = new File(path);
		if(!folder.exists())
			folder.mkdirs();
		
		UUID uuid = UUID.randomUUID();
		//원본파일명
		String fileName = file.getOriginalFilename();
		//파일사이즈
		int fileSize = (int)file.getSize();
		//파일경로
//		String fileuri = path + fileName;
		String fileuri = path + uuid;
		
		BoardFile boardFile = new BoardFile();
		boardFile.setOriginFileName(fileName);
		boardFile.setSize(fileSize);
		boardFile.setUri(fileuri);
		
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
		fdao.insertBoardFile(boardFile);
		int fileid = boardFile.getId();
		board.setFileid(fileid);
		
//		board.setFileuri(fileuri);
		dao.insertBoard(board);
		
	}

	@Override
	public void updateBoard(Board board) {
		// TODO Auto-generated method stub
		dao.updateBoard(board);
	}

	@Override
	public boolean deleteBoard(int num, String pass) {
		// TODO Auto-generated method stub
		String originPass = dao.selectOne(num).getPass();
		
		if(pass.equals(originPass)){
			int f_id = dao.selectOne(num).getFileid();
			String fileUri = fdao.selectOne(f_id).getUri();
			File file = new File(fileUri);
			file.delete();
			fdao.deleteBoardFile(f_id);
			dao.deleteBoard(num);
			return true;
		}
		else
			return false;
	}

	@Override
	public HashMap<String, Object> readBoard(int num) {
		// TODO Auto-generated method stub
		Board board = dao.selectOne(num);
		board.setReadcount(board.getReadcount()+1);
		dao.updateBoard(board);
		BoardFile boardFile = fdao.selectOne(board.getFileid());
		HashMap<String, Object> params = new HashMap<>();
		params.put("board", board);
		params.put("boardFile", boardFile);
		return params;
	}
	
	@Override
	public HashMap<String, Object> getBoard(int num) {
		// TODO Auto-generated method stub
		Board board = dao.selectOne(num);
		BoardFile boardFile = fdao.selectOne(board.getFileid());
		HashMap<String, Object> params = new HashMap<>();
		params.put("board", board);
		params.put("boardFile", boardFile);
//		String uri = board.getFileuri();
//		String[] pathArr = uri.split("/");
//		String filename = pathArr[pathArr.length-1];
//		board.setFileuri(filename);
		return params;
	}

	@Override
	public HashMap<String, Object> getBoardList(int page) {
		// TODO Auto-generated method stub
		//첫페이지 -> 맨앞페이지
		int first = 1;
		//시작페이지 -> 현재 보이는 첫페이지
		int start = (page-1) / 10 * 10 + 1;
		//끝페이지 -> 현재 보이는 마지막페이지
		int end = ((page-1) / 10 + 1) *10;
		//마지막페이지 -> 맨마지막페이지
		int last = (dao.getBoardCount()-1)/10 + 1;
		//마지막페이지가 끝페이지보다 작으면 end=last
		end = last < end ? last : end;
		//건너뛸 게시물 개수
		int skip = (page-1) * 10;
		//한페이지에 표시할 게시물 개수
		int count = 10;
				
		HashMap<String, Object> params = new HashMap<>();
		params.put("skip", skip);
		params.put("count", count);
		List<Board> list = dao.selectBoardLimit(params);
		
		HashMap<String, Object> result = new HashMap<>();
		result.put("first", first);
		result.put("start", start);
		result.put("end", end);
		result.put("last", last);
		result.put("current", page);
		result.put("boardList", list);
		
		return result;
	}

	@Override
	public BoardFile getBoardFile(int id) {
		// TODO Auto-generated method stub
		return fdao.selectOne(id);
	}





}
