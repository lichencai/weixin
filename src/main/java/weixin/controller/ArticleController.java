package weixin.controller;

import java.io.IOException;
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
import weixin.dao.entity.WxUserArticle;
import weixin.dao.jdbc.WxArticleJDBC;
import weixin.dao.jdbc.WxUserArticleJDBC;

@Controller
@RequestMapping(value = "/article")
public class ArticleController {

	@Autowired
	private WxArticleJDBC wxArticleJDBC;
	
	@Autowired
	private WxUserArticleJDBC wxUserArticleJDBC;
	
	private static Logger logger = Logger.getLogger(ArticleController.class);
	
	@RequestMapping(value = {"/show"}, method = {RequestMethod.POST,RequestMethod.GET})
	public ModelAndView show(HttpServletRequest request, HttpServletResponse response) throws IOException{
		logger.debug("=================ArticleController  show=====================================");
		Integer articleId = Integer.parseInt(request.getParameter("id"));
		String openid = (String)request.getSession().getAttribute("openid");
		
		if(openid == null){
			response.sendRedirect("/weixin/error/oauthError.html");
			return null;
		}
		
		
		List<WxArticle> articles = wxArticleJDBC.queryArticle(null, null, articleId);
		if(articles.isEmpty()){
			logger.error("can not find article by id");
			return null;
		}
		WxArticle article = articles.get(0);
		ModelAndView mav = null;
		if(article.getPrice() != 0){
			List<WxUserArticle> userArticles = wxUserArticleJDBC.queryWxUserArticle(articleId, openid);
			logger.debug(userArticles);
			if(userArticles.isEmpty()){
				mav = new ModelAndView("jsp/goPay");
				mav.addObject("article", article);
			}else{
				mav = new ModelAndView("jsp/article");
				mav.addObject("article", article);
			}
		}else{
			mav = new ModelAndView("jsp/article");
			mav.addObject("article", article);
		}
		
		logger.debug(article.getId());
		return mav;
	}
	
}
