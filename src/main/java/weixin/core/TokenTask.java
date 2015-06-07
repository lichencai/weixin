package weixin.core;

import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import weixin.util.SystemUtil;
import weixin.util.TokenUtil;

@Component
public class TokenTask {
	
	private static Logger logger = Logger.getLogger(TokenTask.class);
	
	public void job() throws Exception{
		TokenUtil.getToken();
		logger.debug("access_token=" + SystemUtil.TOKEN_ACCESS);
		logger.debug("jsapi_ticket=" + SystemUtil.JSAPI_TICKET);
		logger.debug("time=" + new Date());
	}
}
