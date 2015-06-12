package weixin.dao.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import weixin.dao.entity.WxUserInfo;

@Repository
public class WxUserInfoJDBC {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void save(WxUserInfo obj){
		System.out.println(obj.getOpenid());
		jdbcTemplate.update("insert into wxuserinfo(openid, createtime) values(?,?)", new Object[]{obj.getOpenid(),obj.getCreatetime()});
	}
}
