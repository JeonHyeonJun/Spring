package controller;

import java.io.File;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import commons.Constant;
import service.IBoardService;
import service.IFileService;
import service.IRepleService;

@Controller
public class BoardController {
	@Autowired
	private IBoardService boardService;
	@Autowired
	private IRepleService repleService;
	@Autowired 
	private IFileService fileService;

	
	@RequestMapping("main.do")
	public ModelAndView boardMain(@RequestParam(defaultValue="1")int page){
		HashMap<String, Object> board = boardService.selectList(page);
		ModelAndView mav = new ModelAndView();
		mav.addAllObjects(board);
		mav.setViewName("boardMain");
		return mav;
	}
//	@RequestMapping("main.do")
//	public ModelAndView mainPage(@RequestParam(defaultValue="1")int page){
//		HashMap<String, Object> board = boardService.selectList(page);
//		ModelAndView mav = new ModelAndView();
//		mav.addAllObjects(board);
//		mav.setViewName("main");
//		return mav;
//	}
	
	@RequestMapping("boardWriteForm.do")
	public String boardWriteForm(){
		return "boardWriteForm";
	}
	
	@RequestMapping(value = "boardWrite.do", method = {RequestMethod.POST})
	public String boardWrite(String title, String content, String writer, int writerIdx, @RequestParam("ufile")MultipartFile ufile){
		boardService.insertBoard(title, content, writer, 0, writerIdx, ufile);
		return "redirect:main.do";
	}
	
	@RequestMapping("boardUpdateForm.do")
	public ModelAndView boardUpdateForm(int idx){
		HashMap<String, Object> params = boardService.selectOne(idx);
		ModelAndView mav = new ModelAndView();
		mav.addObject("board", params);
		mav.setViewName("boardUpdateForm");
		return mav;
	}
	
	@RequestMapping(value = "boardUpdate.do", method = {RequestMethod.POST})
	public String boardUpdate(int idx, String title, String content, int readCount, @RequestParam("ufile")MultipartFile ufile){
		boardService.updateBoard(idx, title, content, readCount, ufile);
		return "redirect:main.do";
	}
	
	@RequestMapping(value = "boardDelete.do", method = {RequestMethod.POST})
	public String boardDelete(int idx){
		boardService.deleteBoard(idx);
		return "redirect:main.do";
	}
	
	@RequestMapping("boardView.do")
	public ModelAndView boardView(int idx){
		HashMap<String, Object> params = boardService.getBoard(idx);
		List<HashMap<String, Object>> reple = repleService.selectList(idx);
		HashMap<String, Object> file = new HashMap<>();
		if(boardService.selectOne(idx).get(Constant.Board.FILEID) != null)
			file = fileService.selectOne((int)boardService.selectOne(idx).get(Constant.Board.FILEID));
		ModelAndView mav = new ModelAndView();
		mav.addObject("board", params);
		mav.addObject("reple", reple);
		mav.addObject("boardFile", file);
		mav.setViewName("boardView");
		return mav;
	}

	@RequestMapping("download.do")
	public View download(int fileId){
		HashMap<String, Object> boardFile = fileService.selectOne(fileId);
		File file = new File((String)boardFile.get(Constant.File.URI));
		return new DownloadView(file, (String)boardFile.get(Constant.File.ORIGINFILENAME));
	}
	
}
