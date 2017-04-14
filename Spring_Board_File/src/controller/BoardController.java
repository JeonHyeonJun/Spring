package controller;



import java.sql.Date;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import model.Board;
import service.IBoardService;

@Controller
public class BoardController {

	@Autowired
	private IBoardService service;
	
	@RequestMapping("list.do")
	public ModelAndView boardList(@RequestParam(defaultValue="1")int page){
		ModelAndView mav = new ModelAndView();
		mav.addAllObjects(service.getBoardList(page));
		mav.setViewName("list");
		return mav;
	}
	@RequestMapping("write.do")
	public String writeBoardMain(){
		return "write";
	}
	
	@RequestMapping("insert.do")
	public ModelAndView writeBoard(Board board){
		service.writeBoard(board);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:view.do?num="+board.getNum()+"");
		return mav;
	}
	@RequestMapping("update.do")
	public ModelAndView updateBoard(Board board){
		service.updateBoard(board);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:list.do");
		return mav;
	}
	@RequestMapping("updateForm.do")
	public ModelAndView updateFormBoard(int num, String pass){
		Board board = service.getBoard(num);
		ModelAndView mav = new ModelAndView();
		if(board.getPass().equals(pass)){
			mav.addObject("command", "update");
			mav.addObject("board", board);
			mav.setViewName("checkSuccess");			
		}
		else{
			mav.addObject("command","updateForm");
			mav.addObject("num",num);
			mav.setViewName("check");
		}
		return mav;
	}
	@RequestMapping("updatePage.do")
	public ModelAndView updatePage(int num){
		Board board = service.getBoard(num);
		ModelAndView mav = new ModelAndView();
		mav.addObject("board", board);
		mav.setViewName("updateForm");
		return mav;
	}
	@RequestMapping("checkForm.do")
	public ModelAndView deleteFormBoard(String command, int num){
		ModelAndView mav = new ModelAndView();
		mav.addObject("command", command);
		mav.addObject("num", num);
		mav.setViewName("check");
		return mav;
	}
	@RequestMapping("delete.do")
	public ModelAndView deleteBoard(int num, String pass){
		boolean result = service.deleteBoard(num, pass);
		ModelAndView mav = new ModelAndView();
		if(result){
			mav.addObject("command", "delete");
			mav.setViewName("checkSuccess");
		}
		else{
			mav.addObject("command","delete");
			mav.addObject("num",num);
			mav.setViewName("check");
		}
		return mav;
	}
	@RequestMapping("view.do")
	public ModelAndView selectBoard(int num){
		Board board = service.readBoard(num);
		ModelAndView mav = new ModelAndView();
		mav.addObject("board", board);
		mav.setViewName("view");
		return mav;
	}
	
	//yyyy-MM-dd형식으로 넘어오는 데이타는 Date클래스로 바까줌
	@InitBinder
	public void initBinder(WebDataBinder binder){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
	}
}
