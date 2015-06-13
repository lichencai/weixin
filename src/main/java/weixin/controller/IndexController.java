package weixin.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/web/index")
public class IndexController {
	
	
	@RequestMapping(value = {"/welcome"}, method = {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public ModelAndView welcome(HttpServletRequest request, HttpServletResponse response){
		ModelAndView mav = new ModelAndView("/index");
		List<String> list = new ArrayList<String>();
		list.add("1");
		list.add("2");
		mav.addObject("list",list);
		return mav;
	}
	
}
