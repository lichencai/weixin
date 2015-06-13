package weixin.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import weixin.dao.entity.WxArticle;
import weixin.service.IndexService;

@Controller
@RequestMapping(value = "/web/index")
public class IndexController {
	
	@Autowired
	private IndexService indexService;
	
	
	@RequestMapping(value = {"/welcome"}, method = {RequestMethod.POST,RequestMethod.GET})
	public ModelAndView welcome(HttpServletRequest request, HttpServletResponse response){
		ModelAndView mav = new ModelAndView("/index");
		List<WxArticle> list = indexService.welcome();
		mav.addObject("list",list);
		return mav;
	}
	
}
