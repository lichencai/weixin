package weixin.service;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import weixin.dao.entity.WxArticle;
import weixin.dao.jdbc.WxArticleJDBC;

@Service("dayNewsService")
public class DayNewsService {
	private static Logger logger = Logger.getLogger(DayNewsService.class);
	
	@Autowired
	private WxArticleJDBC wxArticleJDBC;
	
	
	public List<WxArticle> getList(String type){
		return wxArticleJDBC.queryArticle(type, null, null, new Date());
	}
}
