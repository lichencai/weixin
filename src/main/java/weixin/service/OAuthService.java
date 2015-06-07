package weixin.service;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;

import weixin.util.HttpClientUtil;
import weixin.util.SystemUtil;

public class OAuthService {
	
	private static Logger logger = Logger.getLogger(OAuthService.class);
	/*��΢������������д򿪣���ȡcode*/
	public static String oauthCodeUrl = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=APPID"
			+ "&redirect_uri=REDIRECT_URI&response_type=code&scope=SCOPE&state=STATE#wechat_redirect";
	/*����code��ȡ�û�����Ϣ*/
	public static String oauthAccessTokenUrl = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE"
			+ "&grant_type=authorization_code";
	
	static{
		oauthCodeUrl = oauthCodeUrl.replace("APPID", SystemUtil.APPID).replace("SECRET", SystemUtil.SECRET)
				.replace("REDIRECT_URI", SystemUtil.OAUTH_REDIRECT)
				.replace("SCOPE", "snsapi_base");
		
		oauthAccessTokenUrl = oauthAccessTokenUrl.replace("APPID", SystemUtil.APPID).replace("SECRET", SystemUtil.SECRET);
	}
	
	//  ����CODE��ȡopenid
	public static String getOauthAccessToke(String code){
		logger.debug("getOauthAccessToke ==> code:" + code);
		String openid = null;
		oauthAccessTokenUrl = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE"
				+ "&grant_type=authorization_code";
		oauthAccessTokenUrl = oauthAccessTokenUrl.replace("APPID", SystemUtil.APPID).
				replace("SECRET", SystemUtil.SECRET).replace("CODE", code);;
		String result = HttpClientUtil.httpRequest(oauthAccessTokenUrl, "POST", null);
		logger.debug("getOauthAccessToke ==> result:" + result);
		JSONObject jsonObj = JSONObject.fromObject(result);
		openid = jsonObj.getString("openid");
		return openid;
	}
	
}
