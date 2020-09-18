package com.mouse.oss.springboot.autoconfigure;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author mouse
 * @date 2020/9/18 08:45
 * @description
 */
@ConfigurationProperties(prefix = OssProperties.OSS_PREFIX)
public class OssProperties {

    public static final String OSS_PREFIX = "oss";

    private String accessKeyId;

    private String accessKeySecret;

    private String endpoint;

//    private String bucketName;


    public String getAccessKeyId() {
        return accessKeyId;
    }

    public void setAccessKeyId(String accessKeyId) {
        this.accessKeyId = accessKeyId;
    }

    public String getAccessKeySecret() {
        return accessKeySecret;
    }

    public void setAccessKeySecret(String accessKeySecret) {
        this.accessKeySecret = accessKeySecret;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

}
