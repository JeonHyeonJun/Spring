package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import service.IRepleService;

@Controller
public class RepleController {
	@Autowired
	private IRepleService repleService;
	
	@RequestMapping("repleWrite.do")
	public String repleWrite(int boardIdx, String content, String writer, int writerIdx, @RequestParam(defaultValue="0")int parent){
		repleService.insertReple(boardIdx, content, writer, writerIdx, parent);
		return "redirect:boardView.do?idx="+boardIdx;
	}
	
	

}
