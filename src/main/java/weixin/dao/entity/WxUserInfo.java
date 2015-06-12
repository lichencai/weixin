package weixin.dao.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name="wxuserinfo")
public class WxUserInfo implements Serializable{
	private static final long serialVersionUID = -5691123485256666691L;
	private Integer id;  
    private String openid;  
    private Date createtime;
    @Id  
    @GenericGenerator(name = "generator", strategy = "increment")  
    @GeneratedValue(generator = "generator")  
    @Column(name = "id", length=11)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Column(name = "openid", length = 200)
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	@Column(name = "createtime")
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
}
