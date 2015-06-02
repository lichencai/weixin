package weixin.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import weixin.core.ClickEvent;
import weixin.obj.Article;
import weixin.resp.NewsMessage;
import weixin.resp.TextMessage;
import weixin.util.MsgUtil;

public class CoreService {
	
	private static Logger logger = Logger.getLogger(CoreService.class);
	/** 
     * 处理微信发来的请求 
     *  
     * @param request 
     * @return 
     */  
    public static String processRequest(HttpServletRequest request) {
    	String respMessage = null;
        try {
        	
            // xml请求解析  
            Map<String, String> requestMap = MsgUtil.parseXml(request); 
            logger.debug("=====================requestMap========================");
            logger.debug(requestMap);
            
            // 发送方帐号（open_id）  
            String fromUserName = requestMap.get("FromUserName");  
            // 公众帐号  
            String toUserName = requestMap.get("ToUserName");  
            // 消息类型  
            String msgType = requestMap.get("MsgType");  
            
            // 文本消息  
            if (msgType.equals(MsgUtil.REQ_MESSAGE_TYPE_TEXT)) {
            	
            	TextMessage textMessage = new TextMessage();
            	textMessage.setMsgType(MsgUtil.RESP_MESSAGE_TYPE_TEXT);
            	textMessage.setToUserName(fromUserName);  
            	textMessage.setFromUserName(toUserName);  
            	textMessage.setCreateTime(new Date().getTime());  
            	textMessage.setFuncFlag(0);
            	
            	textMessage.setContent("<a href=\"http://lichencai.nat123.net/weixin/html/jssdk.html\">jssdk</a>");
            	
            	respMessage = MsgUtil.textMessageToXml(textMessage);
            }else if (msgType.equals(MsgUtil.REQ_MESSAGE_TYPE_EVENT)) {  
                // 事件类型  
                String eventType = requestMap.get("Event");  
                // 订阅  
                if (eventType.equals(MsgUtil.EVENT_TYPE_SUBSCRIBE)) { 
                	
                }  
                // 取消订阅  
                else if (eventType.equals(MsgUtil.EVENT_TYPE_UNSUBSCRIBE)) {  
                    // TODO 取消订阅后用户再收不到公众号发送的消息，因此不需要回复消息  
                }  
                // 自定义菜单点击事件  
                else if (eventType.equals(MsgUtil.EVENT_TYPE_CLICK)) { 
                	// EventKey
                	String eventKey = requestMap.get("EventKey");
                	if("aboutus".equals(eventKey)){
                		NewsMessage mesg = ClickEvent.getAboutUs();
                		
                		List<Article> articleList = new ArrayList<Article>();
                		Article article = new Article();
    					article.setTitle("和悦资讯");
    					article.setDescription("北京和悦龙川科技有限公司成立于2014年，是国内自主研发数据开发系统的科技平台，并且掌握软件开发，信息系统集成服务，信息技术咨询服务，数据处理和存储服务，互联网信息服务，咨询与调查，计算机系统程序开发与应用等一系列的金融科技服务。");
    					article.setPicUrl("http://bbs.unpcn.com/attachment.aspx?attachmentid=4235777");
    					article.setUrl("");
    					articleList.add(article);
    					// 设置图文消息个数
    					mesg.setArticleCount(articleList.size());
    					// 设置图文消息包含的图文集合
    					mesg.setArticles(articleList);
                		
                		mesg.setMsgType(MsgUtil.RESP_MESSAGE_TYPE_NEWS);
                		mesg.setToUserName(fromUserName);  
                		mesg.setFromUserName(toUserName);  
                		mesg.setCreateTime(new Date().getTime());  
                		mesg.setFuncFlag(0);  
                		
                		respMessage = MsgUtil.newsMessageToXml(mesg);
                		logger.debug("aboutus Return");
                	}
                }
            }  
            
        } catch (Exception e) {
        	logger.error(e);
        }
  
        return respMessage;  
    }  
}
