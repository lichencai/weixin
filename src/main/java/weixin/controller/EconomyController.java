package weixin.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import weixin.dao.entity.WxArticle;
import weixin.service.DayNewsService;

@Controller
@RequestMapping(value = "/web/economy")
public class EconomyController {
	
	private static Logger logger = Logger.getLogger(EconomyController.class);
	
	
	@Autowired
	private DayNewsService dayNewsService;
	
	@RequestMapping(value = {"/getList"}, method = {RequestMethod.POST,RequestMethod.GET})
	public ModelAndView getList(HttpServletRequest request, HttpServletResponse response){
		
		try{
			ModelAndView mav = new ModelAndView("jsp/news");
			
			List<WxArticle> list = dayNewsService.getList("02");
			mav.addObject("list",list);
			
			return mav;
		}catch(Exception e){
			logger.error(e);
		}
		return null;
	}
}
