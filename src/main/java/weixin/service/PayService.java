package weixin.service;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import org.apache.log4j.Logger;

import weixin.util.HttpClientUtil;
import weixin.util.SystemUtil;
import weixin.util.WxUtil;
import weixin.wxap.util.Sha1Util;

public class PayService {
	//  统一支付接口
	private static String unifiedorderUrl = "https://api.mch.weixin.qq.com/pay/unifiedorder";
	
	private static Logger logger = Logger.getLogger(CoreService.class);
	
	/**
	 * 统一支付接口
	 * @throws IOException 
	 * @throws JDOMException 
	 */
	public static Map<String, Object> unifiedorder(String openid,String spbill_create_ip) throws Exception{
		logger.debug("openid:" + openid + " spbill_create_ip:" + spbill_create_ip);
		Map<String, Object> result = new HashMap<String, Object>(); 
		
		SortedMap<Object,Object> parameters = new TreeMap<Object,Object>();
		parameters.put("appid", SystemUtil.APPID);
		parameters.put("mch_id", SystemUtil.MCH_ID);
		//  parameters.put("device_info", SystemUtil.MCH_ID);
		parameters.put("nonce_str", Sha1Util.getNonceStr());
		parameters.put("body", URLEncoder.encode(new String("商品描述"), "UTF-8"));   //  商品描述 attach
		//  parameters.put("attach", "");   //  附加数据，原样返回 
		parameters.put("out_trade_no", WxUtil.getOut_trade_no());
		parameters.put("total_fee", "1");
		parameters.put("spbill_create_ip", spbill_create_ip);
		//parameters.put("time_start", SystemUtil.NOTIFY_URL);
		//parameters.put("time_expire", SystemUtil.NOTIFY_URL);
		//parameters.put("goods_tag", SystemUtil.NOTIFY_URL);
		parameters.put("notify_url", SystemUtil.NOTIFY_URL);
		parameters.put("trade_type", "JSAPI");
		parameters.put("openid", openid);
		//parameters.put("product_id", );
		parameters.put("sign", WxUtil.createSign("UTF-8", parameters));
		
		String reqXML = WxUtil.getRequestXml(parameters);
		
		//  调用统一支付接口
		String respXML = HttpClientUtil.httpRequest(unifiedorderUrl, "POST", reqXML);
		Map respMap = WxUtil.doXMLParse(respXML);
		
		String return_code = (String)respMap.get("return_code");
		String result_code = (String)respMap.get("result_code");
		if(SystemUtil.SUCCESS.equals(return_code)){
			result.put("return_code", return_code);
			result.put("return_msg", respMap.get("return_msg"));
			if(SystemUtil.SUCCESS.equals(result_code)){
				result.put("appid", (String)respMap.get("appid"));
				result.put("mch_id", (String)respMap.get("mch_id"));
				result.put("nonce_str", (String)respMap.get("nonce_str"));
				result.put("sign", (String)respMap.get("sign"));
				result.put("result_code", (String)respMap.get("result_code"));
				result.put("trade_type", (String)respMap.get("trade_type"));
				result.put("prepay_id", (String)respMap.get("prepay_id"));
				
				//  增加的字段
				result.put("timeStamp", new Date().getTime());
				result.put("signType", "MD5");
			}
		}else{
			result.put("return_code", return_code);
			result.put("return_msg", respMap.get("return_msg"));
		}
		
		return result;
	}
}
