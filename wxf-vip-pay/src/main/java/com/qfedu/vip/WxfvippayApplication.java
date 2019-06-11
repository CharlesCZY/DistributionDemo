package com.qfedu.vip;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class WxfvippayApplication {

	public static void main(String[] args) {
		SpringApplication.run(WxfvippayApplication.class, args);
	}

}
