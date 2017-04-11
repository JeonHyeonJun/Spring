package controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import service.IProductService;

@Controller
public class ProductController {

	@Autowired
	private IProductService service;
	
	@RequestMapping("input.do")
	public String input(String name, int price, String pictureurl, String description){
		service.insertProduct(name, price, pictureurl, description);
		return "redirect:main.do";
	}
	
	@RequestMapping("main.do")
	public ModelAndView main(){
		ModelAndView mav = new ModelAndView();
		List<HashMap<String, Object>> list = service.ProudctList();
		mav.addObject("list",list);
		mav.setViewName("list");
		return mav;
	}
	
	
	@RequestMapping("update.do")
	public ModelAndView update(int code, int price){
		ModelAndView mav = new ModelAndView();
		boolean result = service.updateProduct(code, price);
		if(result){
			mav.setViewName("redirect:main.do");
		}
		else
			System.out.println("자살");
//		mav.setViewName("list");
		return mav;
	}
	
	@RequestMapping("suicide.do")
	public ModelAndView suicide(int code){
		ModelAndView mav = new ModelAndView();
		boolean result = service.deleteProduct(code);
		if(result){
			mav.setViewName("redirect:main.do");
		}
		else
			System.out.println("자살");
//		mav.setViewName("list");
		return mav;
	}
	
	@RequestMapping("search.do")
	public ModelAndView search(String type, String keyword){
		ModelAndView mav = new ModelAndView();
		List<HashMap<String, Object>> list = service.selectSearch(type, keyword);
		mav.addObject("list", list);
//		if(type == 1){
//			List<HashMap<String, Object>> list = service.selectName(keyword);
//			mav.addObject("list", list);
//		}
//		else if(type == 2){
//			List<HashMap<String, Object>> list = service.selectCode(Integer.parseInt(keyword));
//			mav.addObject("list", list);
//		}
		mav.setViewName("list");
		return mav;
	}
}
