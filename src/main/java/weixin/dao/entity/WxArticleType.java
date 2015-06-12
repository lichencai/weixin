package weixin.dao.entity;

import java.io.Serializable;

public class WxArticleType implements Serializable{

	private static final long serialVersionUID = -2172111274289063697L;
	private Integer id;
	private String code;
	private String describer;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getDescriber() {
		return describer;
	}
	public void setDescriber(String describer) {
		this.describer = describer;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
