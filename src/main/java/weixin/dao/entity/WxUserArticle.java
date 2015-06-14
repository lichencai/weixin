package weixin.dao.entity;

import java.io.Serializable;
import java.util.Date;

public class WxUserArticle implements Serializable{

	private static final long serialVersionUID = 6336661186881634768L;
	private Integer id;
	private Integer article;
	private String user;
	private Date createtime;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getArticle() {
		return article;
	}
	public void setArticle(Integer article) {
		this.article = article;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
