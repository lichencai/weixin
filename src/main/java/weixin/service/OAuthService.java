package weixin.service;

import org.apache.log4j.Logger;

import weixin.util.HttpClientUtil;
import weixin.util.SystemUtil;

public class OAuthService {
	
	private static Logger logger = Logger.getLogger(OAuthService.class);
	public static String requestUrl = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=APPID"
			+ "&redirect_uri=REDIRECT_URI&response_type=code&scope=SCOPE&state=STATE#wechat_redirect";
	
	
	static{
		requestUrl = requestUrl.replace("APPID", SystemUtil.APPID).replace("SECRET", SystemUtil.SECRET)
				.replace("REDIRECT_URI", "http://lichencai.nat123.net/weixin/web/oauth/redirect")
				.replace("SCOPE", "snsapi_base");
		
		logger.debug("oauthUrl : " + requestUrl);
	}
	
	public static void connOAuth(String redirect_uri, String scope, String state){
		
		String result = HttpClientUtil.httpRequest(requestUrl, "POST", null);
	}
	
}
