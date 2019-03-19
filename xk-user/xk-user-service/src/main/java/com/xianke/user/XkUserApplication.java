package com.xianke.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * 启动类
 */
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.xianke.user.mapper")
public class XkUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(XkUserApplication.class);
	}
}
