package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import commons.Constant;
import service.IRepleService;

@Controller
public class RepleController {
	@Autowired
	private IRepleService repleService;
	
	@RequestMapping(value = "repleWrite.do", method = {RequestMethod.POST})
	public String repleWrite(int boardIdx, String content, String writer, int writerIdx, @RequestParam(defaultValue="0")int parent){
		repleService.insertReple(boardIdx, content, writer, writerIdx, parent);
		return "redirect:boardView.do?idx="+boardIdx;
	}
	
	@RequestMapping(value = "repleUpdate.do", method = {RequestMethod.POST})
	public String repleUpdate(int idx, int boardIdx, String content){
		repleService.updateReple(idx, content);
		return "redirect:boardView.do?idx="+boardIdx;
	}
	
	@RequestMapping("repleDelete.do")
	public String repleDelete(int idx, int boardIdx){
		int groupCode = (int)repleService.selectOne(idx).get(Constant.Reple.GROUPCODE);
		repleService.deleteReple(idx, groupCode);
		return "redirect:boardView.do?idx="+boardIdx;
	}
	

}
