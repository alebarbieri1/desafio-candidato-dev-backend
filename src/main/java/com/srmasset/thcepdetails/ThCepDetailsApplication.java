package com.srmasset.thcepdetails;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients("com.srmasset.thcepdetails.proxy")
@EnableCaching
@EnableDiscoveryClient
@SpringBootApplication
public class ThCepDetailsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ThCepDetailsApplication.class, args);
	}

}