package weixin.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import weixin.dao.entity.WxUserInfo;

@Repository
public interface BaseDAO{
	public <T> List<T> getAll(Class<?> type);
	public <T> int count(Class<T> type);
	public void save(WxUserInfo type);
}
