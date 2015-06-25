package weixin.dao.jdbc;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import weixin.dao.entity.WxArticle;
import weixin.util.DateUtil;

@Repository
public class WxArticleJDBC {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<WxArticle> getAll(){
		List<Map<String, Object>> temp = jdbcTemplate.queryForList("select * from wxarticle order by createtime");
		List<WxArticle> list = getArticle(temp);
		return list;
	}
	
	
	public List<WxArticle> queryArticle(String type, Integer number, Integer id, Date date){
		String sql = "select * from wxarticle where 1=1";
		if(type != null){
			sql += " and type=" + type;
		}
		if(id != null){
			sql += " and id=" + id;
		}
		if(date != null){
			String dateStr = DateUtil.dateToString(date, "yyyy-MM-dd");
			String begin = dateStr + " 00:00:00";
			String end = dateStr + " 23:59:59";
			sql += " and createtime>=" + "\'" + begin + "\'";
			sql += " and createtime<=" + "\'" + end + "\'";
		}
		sql += " order by createtime desc";
		if(number != null){
			sql += " LIMIT " + number;
		}
		List<Map<String, Object>> temp = jdbcTemplate.queryForList(sql);
		return getArticle(temp);
	}
	
	
	private List<WxArticle> getArticle(List<Map<String, Object>> result){
		List<WxArticle> list = new ArrayList<WxArticle>();
		for(Map<String, Object> map : result){
			WxArticle article = new WxArticle();
			for(String str : map.keySet()){
				Object obj = map.get(str);
				if("id".equals(str)){
					article.setId((Integer)obj);
				}else if("title".equals(str)){
					article.setTitle((String)obj);
				}else if("summary".equals(str)){
					article.setSummary((String)obj);
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
