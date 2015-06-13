package weixin.service;

import java.util.Date;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import weixin.resp.TextMessage;
import weixin.util.MsgUtil;

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
    	
    	//  textMessage.setContent("<a href=\"" + OAuthService.oauthCodeUrl + "\">页面授权</a>");
        textMessage.setContent("<a href=\"" + "http://lichencai.nat123.net/weixin/web/index/welcome" + "\">页面授权</a>");
    	return textMessage;
	}
	
}
