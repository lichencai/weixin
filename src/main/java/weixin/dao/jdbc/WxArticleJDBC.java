package weixin.dao.jdbc;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import weixin.dao.entity.WxArticle;

@Repository
public class WxArticleJDBC {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<WxArticle> getAll(){
		List<Map<String, Object>> temp = jdbcTemplate.queryForList("select * from wxarticle order by createtime");
		List<WxArticle> list = new ArrayList<WxArticle>();
		for(Map<String, Object> map : temp){
			WxArticle article = new WxArticle();
			for(String str : map.keySet()){
				Object obj = map.get(str);
				System.out.println(obj.toString());
				if("id".equals(str)){
					article.setId((Integer)obj);
				}else if("title".equals(str)){
					article.setTitle((String)obj);
				}else if("type".equals(str)){
					article.setType((String)obj);
				}else if("content".equals(str)){
					article.setContent((String)obj);
				}else if("status".equals(str)){
					article.setStatus((String)obj);
				}else if("price".equals(str)){
					article.setPrice((Integer)obj);
				}else if("createtime".equals(str)){
					article.setCreatetime((Date)obj);
				}
			}
			list.add(article);
		}
		return list;
	}
}
