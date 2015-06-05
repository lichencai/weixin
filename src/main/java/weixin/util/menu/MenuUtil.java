package weixin.util.menu;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import weixin.util.HttpClientUtil;

public class MenuUtil {
	
	/*private static Logger logger = Logger.getLogger(MenuUtil.class);*/
	
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
	    
	    String result = HttpClientUtil.httpRequest(url, "POST", content);
	    System.out.println(result);
	    //logger.debug("createMenu result : " + result);
	}
	
	public static void delMenu(){
		String url = "https://api.weixin.qq.com/cgi-bin/menu/delete?access_token=ACCESS_TOKEN";
		url = url.replace("ACCESS_TOKEN", "QkLFRQH3dLymvvAMrYwTkKr8CwhW2AZXr-SOU8mcra8LqBCFtrcMes_dEFPiv-3dNuIPqd8O5_FeICDhSjP37UwuHg3QpmqPGRYWpm9g7jk");
		String result = HttpClientUtil.httpRequest(url, "GET", null);
	    System.out.println(result);
	}
	
	
	
	public static void main(String[] args) throws IOException{
		/*MenuUtil.delMenu();*/
		new MenuUtil().createMenu();
	}
	
}
