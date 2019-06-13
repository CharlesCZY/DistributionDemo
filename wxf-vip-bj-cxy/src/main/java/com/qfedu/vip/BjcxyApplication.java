package com.qfedu.vip;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@EnableHystrix //允许触发熔断机制
@EnableEurekaClient //服务提供者
@EnableDiscoveryClient //服务消费者
@SpringBootApplication
public class BjcxyApplication {

	public static void main(String[] args) {
		SpringApplication.run(BjcxyApplication.class, args);
	}

}
