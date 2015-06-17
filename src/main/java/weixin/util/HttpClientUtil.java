package weixin.util;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ConnectException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

import org.apache.log4j.Logger;

public class HttpClientUtil {
	
	private static Logger logger = Logger.getLogger(HttpClientUtil.class);
	
	public static String httpRequest(String requestUrl, String requestMethod, String outputStr){
		logger.info("================HttpClientUtil httpRequest=========================");
		logger.info("requestUrl: " + requestUrl + " requestMethod: " + requestMethod + " outputStr: " + outputStr);
		
		StringBuffer buffer = new StringBuffer();
		try{
			TrustManager[] tm = {new MyX509TrustManager()};
			// System.setProperty("https.protocols", "TLSv1");
			SSLContext sslContext = SSLContext.getInstance("SSL","SunJSSE");
			sslContext.init(null, tm, new java.security.SecureRandom());
			
			SSLSocketFactory ssf= sslContext.getSocketFactory();
			
			URL url = new URL(requestUrl);
			HttpsURLConnection httpsUrlConn = (HttpsURLConnection)url.openConnection();
			
			/*HostnameVerifier hostNameVerify = new HostnameVerifier()  
	        {  
	            *//** 
	             * Always return true 
	             *//*  
	            public boolean verify(String urlHostName, SSLSession session)  
	            {  
	                return true;  
	            }  
	        }; 
	        httpsUrlConn.setHostnameVerifier(hostNameVerify);
	        */
			httpsUrlConn.setSSLSocketFactory(ssf);
			httpsUrlConn.setDoInput(true);
			httpsUrlConn.setDoOutput(true);
			httpsUrlConn.setUseCaches(false);
			httpsUrlConn.setRequestMethod(requestMethod);
			/*httpsUrlConn.setInstanceFollowRedirects(true);     */ 
			httpsUrlConn.setRequestProperty("Content-Type "," application/x-www-form-urlencoded");
			
			/*httpsUrlConn.connect();*/
			
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
			logger.debug(e);
		}catch(Exception e){
			logger.debug(e);
		}
		return buffer.toString();
	}
}
