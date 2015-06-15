package weixin.dao.jdbc;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.taglibs.standard.tag.rt.sql.DateParamTag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import weixin.dao.entity.WxUserArticle;

@Repository
public class WxUserArticleJDBC {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<WxUserArticle> queryWxUserArticle(Integer article, String user){
		String sql = "select * from wxuserarticle where 1=1";
		if(article != null){
			sql += " and article=" + article;
		}
		if(user != null){
			sql += " and user=\'" + user + "\'";
		}
		List<Map<String, Object>> temp = jdbcTemplate.queryForList(sql);
		return getUserArticle(temp);
	}
	
	public void save(WxUserArticle article){
		Date date = article.getCreatetime();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String sql = "insert into wxuserarticle(article,user,createtime) values("
				+ article.getArticle() 
				+ ",\'" + article.getUser() + "\',"
				+ "\'" + sdf.format(date) + "\'"
				+ ")";
		jdbcTemplate.execute(sql);
	}
	
	
	private List<WxUserArticle> getUserArticle(List<Map<String, Object>> result){
		List<WxUserArticle> list = new ArrayList<WxUserArticle>();
		for(Map<String, Object> map : result){
			WxUserArticle userArticle = new WxUserArticle();
			for(String str : map.keySet()){
				Object obj = map.get(str);
				System.out.println(obj.toString());
				if("id".equals(str)){
					userArticle.setId((Integer)obj);
				}else if("article".equals(str)){
					userArticle.setArticle((Integer)obj);
				}else if("user".equals(str)){
					userArticle.setUser((String)obj);
				}else if("createtime".equals(str)){
					userArticle.setCreatetime((Date)obj);
				}
			}
			list.add(userArticle);
		}
		return list;
	}
	
}
