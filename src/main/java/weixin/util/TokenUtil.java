package weixin.util;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;

public class TokenUtil {
	
	private static Logger logger = Logger.getLogger(TokenUtil.class);
	
	private static String token_accessURL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=SECRET";
	private static String jsapi_ticketURL = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=ACCESS_TOKEN&type=jsapi";
	
	static{
		token_accessURL = token_accessURL.replace("APPID", SystemUtil.APPID).replace("SECRET", SystemUtil.SECRET);
	}
	
	public static void getToken() throws Exception{
		
		String token_access = httpClientGet(token_accessURL);
		
		JSONObject jsonObj = JSONObject.fromObject(token_access);
		SystemUtil.TOKEN_ACCESS = (String)jsonObj.get("access_token");
		
		jsapi_ticketURL = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=ACCESS_TOKEN&type=jsapi";
		jsapi_ticketURL = jsapi_ticketURL.replace("ACCESS_TOKEN", SystemUtil.TOKEN_ACCESS);
		
		String jsapi_ticket = httpClientGet(jsapi_ticketURL);
		JSONObject jsonObj1 = JSONObject.fromObject(jsapi_ticket);
		SystemUtil.JSAPI_TICKET = (String)jsonObj1.get("ticket");
		
		
		logger.debug("access_token=" + SystemUtil.TOKEN_ACCESS);
		logger.debug("jsapi_ticket=" + SystemUtil.JSAPI_TICKET);
	}
	
	private static String httpClientGet(String url) throws Exception{
		
		URL urlGet = new URL(url);
		HttpURLConnection http = (HttpURLConnection) urlGet.openConnection();
		http.setRequestMethod("GET");
		
		http.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
		http.setDoOutput(true);
		http.setDoInput(true);
		
		System.setProperty("sun.net.client.defaultConnectTimeout", "30000");
		System.setProperty("sun.net.client.defaultReadTimeout", "30000");
		http.connect();
		
		InputStream is = http.getInputStream();
		int size = is.available();
		byte[] jsonBytes = new byte[size];
		is.read(jsonBytes);
		
		String message = new String(jsonBytes, "UTF-8");
		
		return message;
	}
	
	
	public static void main(String[] args) throws Exception{
		getToken();
		System.out.println(SystemUtil.TOKEN_ACCESS);
		System.out.println(SystemUtil.JSAPI_TICKET);
	}
	
	
	
	
}
