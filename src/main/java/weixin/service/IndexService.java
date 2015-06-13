package weixin.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import weixin.dao.entity.WxArticle;
import weixin.dao.jdbc.WxArticleJDBC;

@Service("indexService")
public class IndexService {
	
	private static Logger logger = Logger.getLogger(IndexService.class);
	
	@Autowired
	private WxArticleJDBC wxArticleJDBC;
	
	
	public List<WxArticle> welcome(){
		return wxArticleJDBC.getAll();
	}
	
	
}
