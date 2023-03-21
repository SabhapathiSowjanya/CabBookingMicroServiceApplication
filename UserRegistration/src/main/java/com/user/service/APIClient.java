package com.user.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.user.entity.CabBooking;

@FeignClient("CABBOOKINGMICROSERVICE")
public interface APIClient{
	@GetMapping("/cabBooking/getByCabId/{cabId}")
	CabBooking getUserId(@PathVariable("cabId") Integer cabId);


}
