package weixin.service;

import org.apache.log4j.Logger;

public class OAuthService {
	
	private static Logger logger = Logger.getLogger(OAuthService.class);
	private static String requestUrl = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=APPID"
			+ "&redirect_uri=REDIRECT_URI&response_type=code&scope=SCOPE&state=STATE#wechat_redirect";
	
	public static void connOAuth(String redirect_uri, String scope, String state){
		
	}
	
}
