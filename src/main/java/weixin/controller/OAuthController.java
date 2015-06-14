package weixin.controller;

import java.util.List;
import java.util.Map;
import java.util.SortedMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import weixin.dao.entity.WxArticle;
import weixin.dao.jdbc.WxArticleJDBC;
import weixin.util.WxUtil;

@Controller
@RequestMapping(value = "/web/oauth")
public class OAuthController {
	
	private static Logger logger = Logger.getLogger(OAuthController.class);
	
	@Autowired
	private WxArticleJDBC wxArticleJDBC;
	
	@RequestMapping(value = {"/redirect"}, method = RequestMethod.GET)
	public ModelAndView redirect(HttpServletRequest request, HttpServletResponse response) throws Exception{
		ModelAndView mav = new ModelAndView("pay/oauth");
		/*String code = request.getParameter("code");
		String state = request.getParameter("state");
		if(code == null){
			response.sendRedirect("/weixin/error/oauthError.html");
			return null;
		}
		logger.debug("redirect OAuthService.oauthCodeUrl : " + OAuthService.oauthCodeUrl);
		String openid = OAuthService.getOauthAccessToke(code);*/
		Integer articleId = (Integer)request.getAttribute("id");
		List<WxArticle> articles = wxArticleJDBC.queryArticle(null, null, articleId);
		String openid = (String)request.getSession().getAttribute("openid");
		mav.addObject("openid",openid);
		mav.addObject("article",articles.get(0));
		return mav;
	}
	
	
	@RequestMapping(value = {"/notify_url"}, method = {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public SortedMap<Object, Object> pay(HttpServletRequest request, HttpServletResponse response) throws Exception{
		Map<String, String> requestMap = WxUtil.parseXml(request); 
		logger.debug(requestMap);
		
		
		return null;
	}
	
}
