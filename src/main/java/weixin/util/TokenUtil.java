package weixin.util;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import net.sf.json.JSONObject;

public class TokenUtil {
	public final static String appID = "wx769fdfe12773b6be";
	public final static String secret = "5a95b580c0b32d33cf66b6e16baedf5b";
	public static String access_token = null;
	
	public static void getToken(){
		
		String token = null;
		String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="
				+"wx769fdfe12773b6be"
				+"&secret="+"5a95b580c0b32d33cf66b6e16baedf5b";
		try {
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
			
			token = message;
			
		} catch (MalformedURLException e) {
			System.out.println("====MalformedURLException====");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("====IOException====");
			e.printStackTrace();
		}
		
		
		JSONObject jsonObj = JSONObject.fromObject(token);
		
		access_token = (String)jsonObj.get("access_token");
	}
	
	public static void main(String[] args){
		TokenUtil.getToken();
		System.out.println(TokenUtil.access_token);
	}
	
	
	
	
}
