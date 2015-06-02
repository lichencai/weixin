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
     * ����΢�ŷ��������� 
     *  
     * @param request 
     * @return 
     */  
    public static String processRequest(HttpServletRequest request) {
    	String respMessage = null;
        try {
        	
            // xml�������  
            Map<String, String> requestMap = MsgUtil.parseXml(request); 
            logger.debug("=====================requestMap========================");
            logger.debug(requestMap);
            
            // ���ͷ��ʺţ�open_id��  
            String fromUserName = requestMap.get("FromUserName");  
            // �����ʺ�  
            String toUserName = requestMap.get("ToUserName");  
            // ��Ϣ����  
            String msgType = requestMap.get("MsgType");  
            
            // �ı���Ϣ  
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
                // �¼�����  
                String eventType = requestMap.get("Event");  
                // ����  
                if (eventType.equals(MsgUtil.EVENT_TYPE_SUBSCRIBE)) { 
                	
                }  
                // ȡ������  
                else if (eventType.equals(MsgUtil.EVENT_TYPE_UNSUBSCRIBE)) {  
                    // TODO ȡ�����ĺ��û����ղ������ںŷ��͵���Ϣ����˲���Ҫ�ظ���Ϣ  
                }  
                // �Զ���˵�����¼�  
                else if (eventType.equals(MsgUtil.EVENT_TYPE_CLICK)) { 
                	// EventKey
                	String eventKey = requestMap.get("EventKey");
                	if("aboutus".equals(eventKey)){
                		NewsMessage mesg = ClickEvent.getAboutUs();
                		
                		List<Article> articleList = new ArrayList<Article>();
                		Article article = new Article();
    					article.setTitle("������Ѷ");
    					article.setDescription("�������������Ƽ����޹�˾������2014�꣬�ǹ��������з����ݿ���ϵͳ�ĿƼ�ƽ̨���������������������Ϣϵͳ���ɷ�����Ϣ������ѯ�������ݴ���ʹ洢���񣬻�������Ϣ������ѯ����飬�����ϵͳ���򿪷���Ӧ�õ�һϵ�еĽ��ڿƼ�����");
    					article.setPicUrl("http://bbs.unpcn.com/attachment.aspx?attachmentid=4235777");
    					article.setUrl("");
    					articleList.add(article);
    					// ����ͼ����Ϣ����
    					mesg.setArticleCount(articleList.size());
    					// ����ͼ����Ϣ������ͼ�ļ���
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
