package controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {
	
	@RequestMapping("hello.do")
	public ModelAndView hello(HttpServletRequest req, HttpServletResponse resp, 
			@RequestParam(required=false, value="name")String myName, //hello.do?name=얍  하면 name값에 얍이 알아서 들어간다, required=false면 값이 없으면 없는대로 진행
			@RequestParam(defaultValue="0")int age){	//값을 안주면 기본값 0으로 줌 
		ModelAndView mav = new ModelAndView();
		mav.addObject("greeting", "안녕 스프링 엠브이씨<br>");
		mav.addObject("image", "<img src='good.jpg'><br>");
//		mav.addObject("yourIP", req.getRemoteAddr());
		mav.addObject("yourname", myName);
		mav.addObject("yourAge", age - 1);
		mav.setViewName("hello.jsp");
		return mav;
	}
	
	@RequestMapping("whatTime.do")
	public ModelAndView whatTime(){
		ModelAndView mav = new ModelAndView();
		mav.addObject("time", new Date());
		mav.setViewName("whatTime.jsp");
		mav.addObject("image", "<br><img src='digital.GIF'>");
		return mav;
	}
	
	//redirect 사용하기
	@RequestMapping("naver.do")
	public ModelAndView goToHell(){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:http://naver.com");
		return mav;
	}
}
