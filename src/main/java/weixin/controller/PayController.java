package weixin.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import weixin.service.PayService;

@Controller
@RequestMapping(value = "/pay")
public class PayController {
	
	@RequestMapping(value = {"/notify_url"}, method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> pay(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String openid = request.getParameter("openid");
		String spbill_create_ip = request.getRemoteAddr();
		Map<String, Object> map = PayService.unifiedorder(openid, spbill_create_ip);
		
		
		String userAgent = request.getHeader("user-agent");
        char agent = userAgent.charAt(userAgent.indexOf("MicroMessenger")+15);
        map.put("agent", new String(new char[]{agent}));//΢�Ű汾�ţ�����ǰ���ᵽ���ж��û��ֻ�΢�ŵİ汾�Ƿ���5.0���ϰ汾.
        return map;
	}
	
	
	
}
