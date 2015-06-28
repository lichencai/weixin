package weixin.service;

import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import weixin.dao.entity.WxUserInfo;
import weixin.dao.jdbc.WxUserInfoJDBC;
import weixin.resp.TextMessage;
import weixin.util.MsgUtil;
import weixin.util.WxUtil;

@Service("coreService")
public class CoreService {
	
	private static Logger logger = Logger.getLogger(CoreService.class);
	
	@Autowired
	private TextService textService;
	@Autowired
	private SubscribeService subscribeService;
	@Autowired
	private WxUserInfoJDBC wxUserInfoJDBC;
	
	
	/** 
     * ����΢�ŷ��������� 
     *  
     * @param request 
     * @return 
     */  
    public String processRequest(HttpServletRequest request) {
    	String respMessage = null;
        try {
        	
            // xml�������  
            Map<String, String> requestMap = WxUtil.parseXml(request); 
            logger.info("=====================requestMap========================");
            logger.info(requestMap);
            
            // ���ͷ��ʺţ�open_id��  
            String fromUserName = requestMap.get("FromUserName");  
            // �����ʺ�  
            String toUserName = requestMap.get("ToUserName");  
            // ��Ϣ����  
            String msgType = requestMap.get("MsgType");  
            
            // �ı���Ϣ  
            if (msgType.equals(MsgUtil.REQ_MESSAGE_TYPE_TEXT)) {
            	
            	String str = (String)request.getSession().getAttribute("openid");
                if(str != null && fromUserName != null){
                	WxUserInfo user = wxUserInfoJDBC.queryUser(str);
                	if(user == null){
                		user = new WxUserInfo();
                		user.setOpenid(str);
                		user.setCreatetime(new Date());
                		wxUserInfoJDBC.save(user);
                	}
                }else if(str == null  && fromUserName != null){
                	request.getSession().setAttribute("openid", fromUserName);
                	WxUserInfo user = wxUserInfoJDBC.queryUser(fromUserName);
                	if(user == null){
                		user = new WxUserInfo();
                		user.setOpenid(fromUserName);
                		user.setCreatetime(new Date());
                		wxUserInfoJDBC.save(user);
                	}
                }
            	
            	TextMessage textMessage = textService.responseText(requestMap);
            	respMessage = MsgUtil.textMessageToXml(textMessage);
            }else if (msgType.equals(MsgUtil.REQ_MESSAGE_TYPE_EVENT)) {  
                // �¼�����  
                String eventType = requestMap.get("Event");  
                // ����  
                if (eventType.equals(MsgUtil.EVENT_TYPE_SUBSCRIBE)) { 
                	subscribeService.doSubscribe(requestMap);
                }  
                // ȡ������  
                else if (eventType.equals(MsgUtil.EVENT_TYPE_UNSUBSCRIBE)) {
                	subscribeService.unSubscribe(requestMap);
                }  
                // �Զ���˵�����¼�  
                else if (eventType.equals(MsgUtil.EVENT_TYPE_CLICK)) { 
                	// EventKey
                	String eventKey = requestMap.get("EventKey");
                	
                	String str = (String)request.getSession().getAttribute("openid");
                    if(str != null && fromUserName != null){
                    	WxUserInfo user = wxUserInfoJDBC.queryUser(str);
                    	if(user == null){
                    		user = new WxUserInfo();
                    		user.setOpenid(str);
                    		user.setCreatetime(new Date());
                    		wxUserInfoJDBC.save(user);
                    	}
                    }else if(str == null  && fromUserName != null){
                    	request.getSession().setAttribute("openid", fromUserName);
                    	WxUserInfo user = wxUserInfoJDBC.queryUser(fromUserName);
                    	if(user == null){
                    		user = new WxUserInfo();
                    		user.setOpenid(fromUserName);
                    		user.setCreatetime(new Date());
                    		wxUserInfoJDBC.save(user);
                    	}
                    }
                	
                	if("aboutus".equals(eventKey)){
                		
                	}
                }
            }  
            
        } catch (Exception e) {
        	logger.error(e);
        }
  
        return respMessage;  
    }  
}
