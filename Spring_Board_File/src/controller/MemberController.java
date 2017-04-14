package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import model.Member;
import service.IMemberService;

@Controller
public class MemberController {
	@Autowired
	private IMemberService service;
	
	@RequestMapping("mainPage.do")
	public String mainPage(){
		return "memberMain";
	}
	@RequestMapping("createForm.do")
	public String createForm(){
		return "createForm";
	}
	@RequestMapping("loginForm.do")
	public String loginForm(){
		return "loginForm";
	}
	@RequestMapping("create.do")
	public String createMember(Member member){
		boolean result = service.insertMember(member);
		if(result)
			return "memberMain";
		else
			return "createForm";
	}
	@RequestMapping("login.do")
	public ModelAndView login(String id, String pw, HttpSession session){
		boolean result = service.checkPw(id, pw);
		ModelAndView mav = new ModelAndView();
		if(result){
			session.setAttribute("id", id);
			mav.setViewName("redirect:mainPage.do");
		}
		else
			mav.setViewName("loginForm");
		
		return mav;
	}
	@RequestMapping("logout.do")
	public String logout(HttpSession session){
		session.removeAttribute("id");
		return "redirect:mainPage.do";
	}
}
