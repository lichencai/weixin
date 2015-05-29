package weixin.util.menu;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ConnectException;
import java.net.URL;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

public class MenuUtil {
	
	/*private static Logger logger = Logger.getLogger(MenuUtil.class);*/
	
	public static String httpRequest(String requestUrl, String requestMethod, String outputStr){
		
		StringBuffer buffer = new StringBuffer();
		
		try{
			TrustManager[] tm = {new MyX509TrustManager()};
			System.setProperty("https.protocols", "TLSv1");
			SSLContext sslContext = SSLContext.getInstance("SSL","SunJSSE");
			sslContext.init(null, tm, new java.security.SecureRandom());
			
			SSLSocketFactory ssf= sslContext.getSocketFactory();
			
			URL url = new URL(requestUrl);
			HttpsURLConnection httpsUrlConn = (HttpsURLConnection)url.openConnection();
			
			HostnameVerifier hostNameVerify = new HostnameVerifier()  
	        {  
	            /** 
	             * Always return true 
	             */  
	            public boolean verify(String urlHostName, SSLSession session)  
	            {  
	                return true;  
	            }  
	        }; 
	        httpsUrlConn.setHostnameVerifier(hostNameVerify);
	        
			httpsUrlConn.setSSLSocketFactory(ssf);
			httpsUrlConn.setDoInput(true);
			httpsUrlConn.setDoInput(true);
			httpsUrlConn.setUseCaches(false);
			httpsUrlConn.setRequestMethod(requestMethod);
			httpsUrlConn.setInstanceFollowRedirects(true);      
			httpsUrlConn.setRequestProperty("Content-Type "," application/x-www-form-urlencoded ");
			
			httpsUrlConn.connect();
			
			if(null != outputStr){
				DataOutputStream out = new DataOutputStream(httpsUrlConn.getOutputStream());
				out.writeBytes(outputStr);
				out.close();
			}
			
			InputStream is = httpsUrlConn.getInputStream();
			InputStreamReader isr = new InputStreamReader(is,"utf-8");
			BufferedReader br = new BufferedReader(isr);
			String str = null;
			while((str = br.readLine()) != null){
				buffer.append(str);
			}
			br.close();
			is.close();
			is = null;
			httpsUrlConn.disconnect();
		}catch(ConnectException e){
			//logger.debug(e);
		}catch(Exception e){
			//logger.debug(e);
		}
		System.out.print("end....");
		return buffer.toString();
	}
	
	
	public void createMenu() throws IOException{
		String url = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";
		url = url.replace("ACCESS_TOKEN", "QkLFRQH3dLymvvAMrYwTkKr8CwhW2AZXr-SOU8mcra8LqBCFtrcMes_dEFPiv-3dNuIPqd8O5_FeICDhSjP37UwuHg3QpmqPGRYWpm9g7jk");
		//logger.debug("createMenu url : " + url);
		String fileName = "config/menu.file";
		String content = null;
		
		ClassLoader classLoader = getClass().getClassLoader();  
	    File file = new File(classLoader.getResource(fileName).getFile());  
	    if(file.exists()){
	    	FileInputStream fis = new FileInputStream(file);
	    	byte b[]=new byte[(int)file.length()];
	    	fis.read(b);
	    	fis.close();
	    	content = new String(b);
	    }
	    
	    String result = MenuUtil.httpRequest(url, "POST", content);
	    System.out.println(result);
	    //logger.debug("createMenu result : " + result);
	}
	
	public static void delMenu(){
		String url = "https://api.weixin.qq.com/cgi-bin/menu/delete?access_token=ACCESS_TOKEN";
		url = url.replace("ACCESS_TOKEN", "QkLFRQH3dLymvvAMrYwTkKr8CwhW2AZXr-SOU8mcra8LqBCFtrcMes_dEFPiv-3dNuIPqd8O5_FeICDhSjP37UwuHg3QpmqPGRYWpm9g7jk");
		String result = MenuUtil.httpRequest(url, "GET", null);
	    System.out.println(result);
	}
	
	
	
	public static void main(String[] args) throws IOException{
		/*MenuUtil.delMenu();*/
		new MenuUtil().createMenu();
	}
	
}
