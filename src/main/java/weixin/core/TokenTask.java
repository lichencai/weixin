package weixin.core;

import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import weixin.util.TokenUtil;

@Component
public class TokenTask {
	
	private static Logger logger = Logger.getLogger(TokenTask.class);
	
	public void job(){
		TokenUtil.getToken();
		logger.debug("access_token=" + TokenUtil.access_token);
		logger.debug("time=" + new Date());
	}
}
