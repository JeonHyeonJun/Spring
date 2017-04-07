package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import model.Loan;
import service.LoanService;

@Controller
public class MyController {
	@Autowired
	private LoanService service;
	
	@RequestMapping("result.do")
	public ModelAndView one(double amount, double rate, int period, int type){
		List<Loan> list = service.calculateLoan(amount, rate, period, type);
		ModelAndView mav = new ModelAndView();
		mav.addObject("list", list);
		mav.setViewName("result");
		return mav;
	}
	
	@RequestMapping("input.do")
	public String input(){
		return "input";
	}
}
