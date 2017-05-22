package controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import commons.Constant;
import service.IMemberService;

@Controller
public class MemberController {
	@Autowired
	private IMemberService memberService;
	
	@RequestMapping("joinForm.do")
	public String joinForm(){
		return "joinForm";
	}
	
	@RequestMapping(value = "join.do", method = {RequestMethod.POST})
	public String join(String id, String pass, String pass2, String name){
		if(!pass.equals(pass2)){}
		else if(memberService.selectId(id) != null){}
		else if(memberService.selectName(name) != null){}
		else
			memberService.insertMember(id, pass, name);
		return "redirect:main.do";
	}
	
	@RequestMapping("loginForm.do")
	public String loginForm(){
		return "loginForm";
	}
	
	@RequestMapping(value = "login.do", method = {RequestMethod.POST})
	public ModelAndView login(String id, String pass, HttpSession session){
		ModelAndView mav = new ModelAndView();
		HashMap<String, Object> params = memberService.selectId(id);
		if(params != null){
			if(params.get(Constant.Member.PASS).equals(pass)){
				session.setAttribute("idx", params.get(Constant.Member.IDX));
				session.setAttribute("id", id);
				session.setAttribute("name", params.get(Constant.Member.NAME));
				mav.setViewName("redirect:main.do");
			}
			else
				mav.setViewName("redirect:loginForm.do");
		}
		else
			mav.setViewName("redirect:loginForm.do");
		
		return mav;
	}
	
	@RequestMapping("logout.do")
	public String logout(HttpSession session){
		session.invalidate();
		return "redirect:main.do";
	}
	
	@RequestMapping("idCheck.do")
	public @ResponseBody HashMap<String, Object> idCheck(HttpServletResponse resp, String id) {
		HashMap<String, Object> result = new HashMap<>();
		if(memberService.selectId(id) == null)
			result.put("result", true);
		else
			result.put("result", false);
		return result;
	}
	
	@RequestMapping("nameCheck.do")
	public @ResponseBody HashMap<String, Object> nameCheck(HttpServletResponse resp, String name) {
		HashMap<String, Object> result = new HashMap<>();
		if(memberService.selectName(name) == null)
			result.put("result", true);
		else
			result.put("result", false);
		return result;
	}

}
