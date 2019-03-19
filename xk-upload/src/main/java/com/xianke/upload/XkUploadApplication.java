package com.xianke.upload;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 图片上传启动类
 */
@SpringBootApplication
@EnableDiscoveryClient
public class XkUploadApplication {

    public static void main(String[] args) {
        SpringApplication.run(XkUploadApplication.class);
    }
}
