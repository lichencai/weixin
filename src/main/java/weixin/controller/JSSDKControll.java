package weixin.controller;

import java.util.Date;
import java.util.SortedMap;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import weixin.util.SystemUtil;
import weixin.util.TokenUtil;
import weixin.wxap.util.Sha1Util;

@Controller
@RequestMapping(value = "/web/jssdk")
public class JSSDKControll {
	private static Logger logger = Logger.getLogger(JSSDKControll.class);
	
	@RequestMapping(value = {"/getConfigData"}, method = {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public SortedMap<String, String> getConfigData(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		TokenUtil.getToken();
		
		String url = request.getParameter("jssdkURL");
		
		SortedMap<String, String> map = new TreeMap<String, String>();
		String noncestr = Sha1Util.getNonceStr();
		String jsapi_ticket = SystemUtil.JSAPI_TICKET;
		String timestamp = new Date().getTime() / 1000 + "";
		map.put("noncestr", noncestr);map.put("jsapi_ticket", jsapi_ticket);
		map.put("timestamp", timestamp);map.put("url", url);
		String sign = Sha1Util.createSHA1Sign(map);
		map.put("signature", sign);
		map.put("appid", SystemUtil.APPID);
		logger.debug(map);
		return map;
	}
	
}
