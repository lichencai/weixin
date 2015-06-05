package weixin.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/oauth")
public class OAuthController {
	
	private static Logger logger = Logger.getLogger(OAuthController.class);
	
	@RequestMapping(value = {"/redirect"}, method = RequestMethod.GET)
	@ResponseBody
	public void redirect(HttpServletRequest request, HttpServletResponse response){
		String code = request.getParameter("code");
		String state = request.getParameter("state");
		
		
		
		
		logger.debug("code:" + code + " state:" + state);
	}
	
}
