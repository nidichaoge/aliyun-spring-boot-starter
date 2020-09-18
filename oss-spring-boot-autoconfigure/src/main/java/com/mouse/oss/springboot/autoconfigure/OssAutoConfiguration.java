package com.mouse.oss.springboot.autoconfigure;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

/**
 * @author mouse
 * @date 2020/9/18 08:45
 * @description
 */
@EnableConfigurationProperties(OssProperties.class)
public class OssAutoConfiguration implements InitializingBean {

    private final OssProperties ossProperties;

    public OssAutoConfiguration(OssProperties ossProperties){
        this.ossProperties = ossProperties;
    }

    @Bean
    public OSS oss(){
        return new OSSClientBuilder().build(ossProperties.getEndpoint(),ossProperties.getAccessKeyId(),ossProperties.getAccessKeySecret());
    }

    @Override
    public void afterPropertiesSet() throws Exception {

    }

}
