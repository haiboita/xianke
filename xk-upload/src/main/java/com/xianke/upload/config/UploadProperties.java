package com.xianke.upload.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 配置
 */
@Data
@ConfigurationProperties(prefix = "xk.upload")
@Component
public class UploadProperties {

    private String baseUrl;
    private List<String> allowTypes;
}
