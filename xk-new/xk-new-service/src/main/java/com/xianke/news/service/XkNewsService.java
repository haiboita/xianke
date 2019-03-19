package com.xianke.news.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.xianke.news.service.mapper")
public class XkNewsService {
    public static void main(String[] args) {
        SpringApplication.run(XkNewsService.class);
    }
}
