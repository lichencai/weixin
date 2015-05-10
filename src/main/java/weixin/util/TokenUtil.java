package weixin.util;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class TokenUtil {
	public final static String appID = "wxc6cd1d4aa70a7dfc";
	public final static String appSecret = "af9a8822ca985681b5c171bf6f979790";
	
	public static String getToken(){
		String token = null;
		String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="
				+"wxc6cd1d4aa70a7dfc"
				+"&appSecret"+"af9a8822ca985681b5c171bf6f979790";
		System.out.println(url);
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
		
		return token;
	}
	
	public static void main(String[] args){
		String token = TokenUtil.getToken();
		System.out.println(token);
	}
	
	
	
	
}
