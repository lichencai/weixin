package weixin.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import weixin.service.OAuthService;

@Controller
@RequestMapping(value = "/oauth")
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
	
}
