package weixin.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/pay")
public class PayController {
	
	@RequestMapping(value = {"/pay"}, method = RequestMethod.POST)
	@ResponseBody
	public void pay(HttpServletRequest request, HttpServletResponse response){
		
	}
	
	
	
}
