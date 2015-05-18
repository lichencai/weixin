package weixin.service;

import java.util.Calendar;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import weixin.resp.TextMessage;
import weixin.util.MsgUtil;

public class CoreService {
	/** 
     * 处理微信发来的请求 
     *  
     * @param request 
     * @return 
     */  
    public static String processRequest(HttpServletRequest request) {  
        String respMessage = null;  
        try {  
        	
        	
            // 默认返回的文本消息内容  
            String respContent = "请求处理异常，请稍候尝试！";  
  
            // xml请求解析  
            Map<String, String> requestMap = MsgUtil.parseXml(request);  
            
            System.out.println(requestMap);
            
            // 发送方帐号（open_id）  
            String fromUserName = requestMap.get("FromUserName");  
            // 公众帐号  
            String toUserName = requestMap.get("ToUserName");  
            // 消息类型  
            String msgType = requestMap.get("MsgType");  
  
            // 回复文本消息  
            TextMessage textMessage = new TextMessage();  
            textMessage.setToUserName(fromUserName);  
            textMessage.setFromUserName(toUserName);  
            textMessage.setCreateTime(new Date().getTime());  
            textMessage.setMsgType(MsgUtil.RESP_MESSAGE_TYPE_TEXT);  
            textMessage.setFuncFlag(0);  
  
            
            
            // 文本消息  
            if (msgType.equals(MsgUtil.REQ_MESSAGE_TYPE_TEXT)) {
            	String urlTemp = request.getContextPath() + "/demo.html";
                respContent = "您发送的是文本消息！" + "<a href=\"http://haoyunlai158.com/weixin/demo.html\">html5</a>";  
                System.out.println(respContent);
            }else if (msgType.equals(MsgUtil.REQ_MESSAGE_TYPE_EVENT)) {  
                // 事件类型  
                String eventType = requestMap.get("Event");  
                // 订阅  
                if (eventType.equals(MsgUtil.EVENT_TYPE_SUBSCRIBE)) {  
                    respContent = "谢谢您的关注！";  
                }  
                // 取消订阅  
                else if (eventType.equals(MsgUtil.EVENT_TYPE_UNSUBSCRIBE)) {  
                    // TODO 取消订阅后用户再收不到公众号发送的消息，因此不需要回复消息  
                }  
                // 自定义菜单点击事件  
                else if (eventType.equals(MsgUtil.EVENT_TYPE_CLICK)) {  
                    // TODO 自定义菜单权没有开放，暂不处理该类消息  
                }  
            }  
            
            textMessage.setContent(respContent);
            respMessage = MsgUtil.textMessageToXml(textMessage);  
        } catch (Exception e) {  
        	System.out.println(e.getMessage());
            e.printStackTrace();  
        }  
  
        return respMessage;  
    }  
}
