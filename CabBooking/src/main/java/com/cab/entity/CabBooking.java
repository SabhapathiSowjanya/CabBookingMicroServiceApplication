package com.cab.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="cab_booking")
public class CabBooking {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="cab_id")
	private Integer cabId;
	@Column(name="location")
	@NotNull(message="611: Location cannot be left blank")
	private String location;
	@Column(name="price")
	private Integer price;
	@Column(name="cab_booked")
	private boolean isBooked;
	public Integer getCabId() {
		return cabId;
	}
	public void setCabId(Integer cabId) {
		this.cabId = cabId;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public boolean isBooked() {
		return isBooked;
	}
	public void setBooked(boolean isBooked) {
		this.isBooked = isBooked;
	}
	@Override
	public String toString() {
		return "Cab [cabId=" + cabId + ", location=" + location + ", price=" + price + ", isBooked=" + isBooked + "]";
	}
	
	public CabBooking(Integer cabId, @NotNull(message = "611: Location cannot be left blank") String location,
			Integer price, boolean isBooked) {
		super();
		this.cabId = cabId;
		this.location = location;
		this.price = price;
		this.isBooked = isBooked;
	}
	public CabBooking() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
