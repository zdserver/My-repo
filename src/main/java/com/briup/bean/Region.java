package com.briup.bean;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
@Entity
@Table(name="region")
public class Region {
	@Id
	@GeneratedValue
	private Integer id;
	private String hisname;
	private String hisregion;
	private String histype;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date hisdate;
	
	public Region() {
		super();
	}
	public Region(Integer id, String hisname, String hisregion, String histype, Date hisdate) {
		super();
		this.id = id;
		this.hisname = hisname;
		this.hisregion = hisregion;
		this.histype = histype;
		this.hisdate = hisdate;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getHisname() {
		return hisname;
	}
	public void setHisname(String hisname) {
		this.hisname = hisname;
	}
	public String getHisregion() {
		return hisregion;
	}
	public void setHisregion(String hisregion) {
		this.hisregion = hisregion;
	}
	public String getHistype() {
		return histype;
	}
	public void setHistype(String histype) {
		this.histype = histype;
	}
	public Date getHisdate() {
		return hisdate;
	}
	public void setHisdate(Date hisdate) {
		this.hisdate = hisdate;
	}
	@Override
	public String toString() {
		return "region [id=" + id + ", hisname=" + hisname + ", hisregion=" + hisregion + ", histype=" + histype
				+ ", hisdate=" + hisdate + "]";
	}
	

}
