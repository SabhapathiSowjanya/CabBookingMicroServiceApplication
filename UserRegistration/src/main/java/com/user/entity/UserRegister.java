package com.user.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name="user_registrations")
public class UserRegister {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="user_id")
	private Integer userId;
	
	@Column(name="user_name",unique=true)
	@NotNull(message="611: Name cannot be left blank")
	@Pattern(regexp="^[A-Za-z]*$",message="511: Name cannot contain special characters or numbers")
	private String userName;
	
	@Column(name="password",unique=true)
	@NotNull(message = "Password is required")
	private String userPassword;
	
	@NotNull(message = "Mobile number is required")
	@Size(min = 0, max = 10, message = "Contact length should be between 0 and 10 numbers")
	@Column(name="mobileNo")
	private String mobileNo;
	
	@Column(name="cabId")
	private Integer cabId;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public Integer getCabId() {
		return cabId;
	}

	public void setCabId(Integer cabId) {
		this.cabId = cabId;
	}

	public UserRegister(Integer userId, String userName, String userPassword, String mobileNo, Integer cabId) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPassword = userPassword;
		this.mobileNo = mobileNo;
		this.cabId = cabId;
	}

	public UserRegister() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "UserRegister [userId=" + userId + ", userName=" + userName + ", userPassword=" + userPassword
				+ ", mobileNo=" + mobileNo + ", cabId=" + cabId + "]";
	}
	


	
	

}
