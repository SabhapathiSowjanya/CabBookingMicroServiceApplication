package com.admin.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cabAdmin")
public class CabAdmin {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="admin_id")
	private Integer adminId;
	@Column(name="location")
	private String location;
	@Column(name="type")
	private String type;
	@Column(name="price")
	private Integer price;
	public Integer getAdminId() {
		return adminId;
	}
	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "CabSearch [adminId=" + adminId + ", location=" + location + ", type=" + type + ", price=" + price + "]";
	}
	public CabAdmin(Integer adminId, String location, String type, Integer price) {
		super();
		this.adminId = adminId;
		this.location = location;
		this.type = type;
		this.price = price;
	}
	public CabAdmin() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
