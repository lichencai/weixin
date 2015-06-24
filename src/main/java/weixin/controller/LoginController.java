package weixin.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import weixin.resp.user.LoginResp;

@Controller
@RequestMapping(value = "/login")
public class LoginController {
	
	@RequestMapping(value = {"/login"}, method = RequestMethod.POST,produces="application/json;charset=UTF-8")
	@ResponseBody
	public LoginResp login(HttpServletRequest request, HttpServletResponse response){
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		LoginResp resp = new LoginResp();
		resp.setMesg("success");
		return resp;
	}
}
