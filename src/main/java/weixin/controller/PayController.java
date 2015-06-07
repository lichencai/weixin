package weixin.controller;

import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import weixin.service.PayService;
import weixin.util.WxUtil;

@Controller
@RequestMapping(value = "/pay")
public class PayController {
	
	private static Logger logger = Logger.getLogger(PayController.class);
	
	/**
	 * 发起微信支付所需要的参数
	 */
	@RequestMapping(value = {"/getPayData"}, method = {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public SortedMap<Object, Object> getPayData(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		String openid = request.getParameter("openid");
		String spbill_create_ip = request.getRemoteAddr();
		Map<String, Object> map = PayService.unifiedorder(openid, spbill_create_ip);
		
		logger.debug("===========[pay] map==========");
		logger.debug(map);
		
		SortedMap<Object, Object> signMap = new TreeMap<Object, Object>();
		signMap.put("appId", map.get("appid"));
		signMap.put("timeStamp", map.get("timeStamp"));
		signMap.put("nonceStr", map.get("nonce_str"));
		signMap.put("package", "prepay_id=" + (String)map.get("prepay_id"));
		signMap.put("signType", map.get("signType"));
		
		signMap.put("paySign", WxUtil.createSign("UTF-8", signMap));
		
		String userAgent = request.getHeader("user-agent");
        char agent = userAgent.charAt(userAgent.indexOf("MicroMessenger")+15);
        signMap.put("agent", new String(new char[]{agent}));//微信版本号，用于前面提到的判断用户手机微信的版本是否是5.0以上版本.
        return signMap;
        
	}
	
	
	
	/**
	 * 支付通知接口
	 */
	@RequestMapping(value = {"/notify_url"}, method = {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public SortedMap<Object, Object> pay(HttpServletRequest request, HttpServletResponse response) throws Exception{
		Map<String, String> requestMap = WxUtil.parseXml(request); 
		logger.debug(requestMap);
		
		
		return null;
	}
	
	
	
}
