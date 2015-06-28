package weixin.service;

import java.util.Date;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import weixin.dao.entity.WxUserInfo;
import weixin.dao.jdbc.WxUserInfoJDBC;

@Service("subscribeService")
public class SubscribeService {
	
	private static Logger logger = Logger.getLogger(SubscribeService.class);
	
	@Autowired
	private WxUserInfoJDBC wxUserInfoJDBC;
	
	/**
	 * 用户订阅时,往数据库填入openid
	 * @param requestMap
	 */
	public void doSubscribe(Map<String, String> requestMap){
		WxUserInfo user = new WxUserInfo();
		user.setCreatetime(new Date());
		user.setOpenid(requestMap.get("FromUserName"));
		wxUserInfoJDBC.save(user);
	}

	public void unSubscribe(Map<String, String> requestMap) {
		// TODO Auto-generated method stub
		
	}
	
	
}
