package com.admin;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CabAdminApplication {

	public static void main(String[] args) {
		SpringApplication.run(CabAdminApplication.class, args);
	}

}
