package weixin.service;

import java.util.Date;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import weixin.resp.TextMessage;
import weixin.util.MsgUtil;
import weixin.util.SystemUtil;

@Service("textService")
public class TextService {
	
	private static Logger logger = Logger.getLogger(TextService.class);
	
	
	public TextMessage responseText(Map<String, String> requestMap){
		
		TextMessage textMessage = new TextMessage();
    	textMessage.setMsgType(MsgUtil.RESP_MESSAGE_TYPE_TEXT);
    	
    	textMessage.setToUserName(requestMap.get("FromUserName"));  
    	textMessage.setFromUserName(requestMap.get("ToUserName"));  
    	textMessage.setCreateTime(new Date().getTime());  
    	textMessage.setFuncFlag(0);
    	
    	String content = requestMap.get("Content");
    	if("page1".equals(content)){
    		textMessage.setContent("<a href=\"https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx70e836323253f6ac&redirect_uri=http://lichencai.nat123.net/weixin/web/index/welcome.do&response_type=code&scope=snsapi_base&state=STATE#wechat_redirect\">page1</a>");
    	}
        
    	return textMessage;
	}
	
}
