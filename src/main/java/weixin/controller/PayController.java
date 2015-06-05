package weixin.controller;

import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import weixin.service.PayService;
import weixin.util.WxUtil;

@Controller
@RequestMapping(value = "/pay")
public class PayController {
	
	@RequestMapping(value = {"/notify_url"}, method = RequestMethod.POST)
	@ResponseBody
	public SortedMap<Object, Object> pay(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String openid = request.getParameter("openid");
		String spbill_create_ip = request.getRemoteAddr();
		Map<String, Object> map = PayService.unifiedorder(openid, spbill_create_ip);
		
		SortedMap<Object, Object> signMap = new TreeMap<Object, Object>();
		signMap.put("appid", map.get("appid"));
		signMap.put("timeStamp", map.get("timeStamp"));
		signMap.put("nonce_str", map.get("nonce_str"));
		signMap.put("package", map.get("package"));
		signMap.put("package", (String)map.get("prepay_id"));
		signMap.put("signType", map.get("signType"));
		signMap.put("sign", WxUtil.createSign("UTF-8", signMap));
		
		
		String userAgent = request.getHeader("user-agent");
        char agent = userAgent.charAt(userAgent.indexOf("MicroMessenger")+15);
        signMap.put("agent", new String(new char[]{agent}));//微信版本号，用于前面提到的判断用户手机微信的版本是否是5.0以上版本.
        return signMap;
	}
	
	
	
}
