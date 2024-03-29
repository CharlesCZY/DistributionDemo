package com.qfedu.vip;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class WxfviphfApplication {

	public static void main(String[] args) {
		SpringApplication.run(WxfviphfApplication.class, args);
	}

}
