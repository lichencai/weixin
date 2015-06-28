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
import weixin.dao.jdbc.WxArticleJDBC;

@Controller
@RequestMapping(value = "/web/oauth")
public class OAuthController {
	
	private static Logger logger = Logger.getLogger(OAuthController.class);
	
	@Autowired
	private WxArticleJDBC wxArticleJDBC;
	
	@RequestMapping(value = {"/redirect"}, method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView redirect(HttpServletRequest request, HttpServletResponse response) throws Exception{
		logger.info("=======redirect======");
		
		ModelAndView mav = new ModelAndView("web/oauth/redirect.do/oauth");
		Integer articleId = Integer.parseInt((String)request.getParameter("id"));
		List<WxArticle> articles = wxArticleJDBC.queryArticle(null, null, articleId, null);
		String openid = (String)request.getSession().getAttribute("openid");
		
		mav.addObject("openid",openid);
		mav.addObject("article",articles.get(0));
		
		return mav;
	}
	
}
