package weixin.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import weixin.dao.BaseDAO;
import weixin.dao.entity.WxUserInfo;

@Repository
public class BaseDAOImpl implements BaseDAO{
	
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	private Session getSession(){
		return sessionFactory.getCurrentSession();
	}

	
	public <T> List<T> getAll(Class<?> type) {
		String table = type.getName();
		String sql = "from " + table;
		List list = getSession().createQuery(sql).list();
		
		return list;
	}


	public <T> int count(Class<T> type) {
		String table = type.getName();
		String sql = "select count(*) from " + table;
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}

	
	public void save(WxUserInfo type) {
		Session session = sessionFactory.openSession();
		if(session.isOpen()){
			System.out.println("save....");
		}
		session.save(type);
		session.close();
	}

}

