package weixin.service;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;

import weixin.util.HttpClientUtil;
import weixin.util.SystemUtil;

public class OAuthService {
	
	private static Logger logger = Logger.getLogger(OAuthService.class);
	/*在微信内置浏览器中打开，获取code*/
	public static String oauthCodeUrl = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=APPID"
			+ "&redirect_uri=REDIRECT_URI&response_type=code&scope=SCOPE&state=STATE#wechat_redirect";
	/*根据code获取用户的信息*/
	public static String oauthAccessTokenUrl = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE"
			+ "&grant_type=authorization_code";
	
	static{
		oauthCodeUrl = oauthCodeUrl.replace("APPID", SystemUtil.APPID).replace("SECRET", SystemUtil.SECRET)
				.replace("REDIRECT_URI", "http://lichencai.nat123.net/weixin/web/oauth/redirect")
				.replace("SCOPE", "snsapi_base");
		
		oauthAccessTokenUrl = oauthAccessTokenUrl.replace("APPID", SystemUtil.APPID).replace("SECRET", SystemUtil.SECRET);
		
		logger.debug("oauthCodeUrl : " + oauthCodeUrl);
	}
	
	//  根据CODE获取openid
	public static String getOauthAccessToke(String code){
		String openid = null;
		oauthAccessTokenUrl = oauthAccessTokenUrl.replace("CODE", code);
		String result = HttpClientUtil.httpRequest(oauthAccessTokenUrl, "POST", null);
		JSONObject jsonObj = JSONObject.fromObject(result);
		openid = jsonObj.getString("openid");
		return openid;
	}
	
}
