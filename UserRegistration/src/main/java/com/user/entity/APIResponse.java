package com.user.entity;

public class APIResponse {
	
	private CabBooking cabBooking;
	private UserRegister userRegister;
	public CabBooking getCabBooking() {
		return cabBooking;
	}
	public void setCabBooking(CabBooking cabBooking) {
		this.cabBooking = cabBooking;
	}
	public UserRegister getUserRegister() {
		return userRegister;
	}
	public void setUserRegister(UserRegister userRegister) {
		this.userRegister = userRegister;
	}
	public APIResponse(UserRegister userRegister, CabBooking cabBooking) {
		super();
		this.cabBooking = cabBooking;
		this.userRegister = userRegister;
	}
	
	


}
