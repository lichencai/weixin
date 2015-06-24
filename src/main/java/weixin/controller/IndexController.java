package weixin.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import weixin.dao.entity.WxArticle;
import weixin.service.IndexService;
import weixin.service.OAuthService;

@Controller
@RequestMapping(value = "/index")
public class IndexController {
	
	@Autowired
	private IndexService indexService;
	
	private static Logger logger = Logger.getLogger(IndexController.class);
	
	@RequestMapping(value = {"/welcome"}, method = {RequestMethod.POST,RequestMethod.GET})
	public ModelAndView welcome(HttpServletRequest request, HttpServletResponse response) throws IOException{
		
		String openid = (String)request.getSession().getAttribute("openid");
		if(StringUtils.isEmpty(openid)){
			String code = request.getParameter("code");
			String state = request.getParameter("state");
			if(code == null){
				response.sendRedirect("/weixin/error/oauthError.html");
				return null;
			}
			logger.debug("redirect OAuthService.oauthCodeUrl : " + OAuthService.oauthCodeUrl);
			openid = OAuthService.getOauthAccessToke(code);
			if(!StringUtils.isEmpty(openid)){
				HttpSession session = request.getSession();
				session.setAttribute("openid", openid);
			}
		}
		ModelAndView mav = null;
		mav = new ModelAndView("jsp/index");
		List<WxArticle> list = indexService.welcome();
		mav.addObject("list",list);
		return mav;
	}
	
}
