package weixin.controller;

import java.util.Map;
import java.util.SortedMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import weixin.service.OAuthService;
import weixin.util.WxUtil;

@Controller
@RequestMapping(value = "/web/oauth")
public class OAuthController {
	
	private static Logger logger = Logger.getLogger(OAuthController.class);
	
	@RequestMapping(value = {"/redirect"}, method = RequestMethod.GET)
	public ModelAndView redirect(HttpServletRequest request, HttpServletResponse response) throws Exception{
		ModelAndView mav = new ModelAndView("oauth");
		String code = request.getParameter("code");
		String state = request.getParameter("state");
		if(code == null){
			response.sendRedirect("/error/oauthError.html");
			return null;
		}
		logger.debug("redirect OAuthService.oauthCodeUrl : " + OAuthService.oauthCodeUrl);
		String openid = OAuthService.getOauthAccessToke(code);
		mav.addObject("openid",openid);
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
