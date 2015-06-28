package weixin.dao.jdbc;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import weixin.dao.entity.WxUserInfo;

@Repository
public class WxUserInfoJDBC {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void save(WxUserInfo obj){
		jdbcTemplate.update("insert into wxuserinfo(openid, createtime) values(?,?)", new Object[]{obj.getOpenid(),obj.getCreatetime()});
	}
	
	public void del(String openid){
		String sql = "delete from wxuserinfo where openid='" + openid + "'";
		jdbcTemplate.execute(sql);
		String aticleSql = "delete from wxuserarticle where user='" + openid + "'";
		jdbcTemplate.execute(aticleSql);
	}
	
	public WxUserInfo queryUser(String openid){
		String sql = "select * from wxuserinfo where openid='" + openid + "'";
		List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
		
		List<WxUserInfo> users = new ArrayList<WxUserInfo>();
		for(Map<String, Object> map : list){
			WxUserInfo user = new WxUserInfo();
			for(String str : map.keySet()){
				Object obj = map.get(str);
				if("id".equals(str)){
					user.setId((Integer)obj);
				}else if("openid".equals(str)){
					user.setOpenid((String)obj);
				}else if("createtime".equals(str)){
					user.setCreatetime((Date)obj);
				}
			}
			users.add(user);
		}
		
		if(users.isEmpty()){
			return null;
		}else{
			return users.get(0);
		}
		
		
	}
	
	
}
