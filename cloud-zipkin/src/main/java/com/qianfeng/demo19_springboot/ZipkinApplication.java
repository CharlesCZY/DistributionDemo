package com.qianfeng.demo19_springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import zipkin2.server.internal.EnableZipkinServer;

/**
 * 允许当前项目作为Eureka注册中心启动
 */
@EnableZipkinServer
@SpringBootApplication
public class ZipkinApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZipkinApplication.class, args);
	}

}

