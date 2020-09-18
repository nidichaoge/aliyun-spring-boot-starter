package com.mouse.oss.springboot.autoconfigure;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.util.Assert;

/**
 * @author mouse
 * @date 2020/9/18 08:45
 * @description
 */
@ConditionalOnClass({OSS.class})
@EnableConfigurationProperties(OssProperties.class)
public class OssAutoConfiguration implements InitializingBean {

    private final OssProperties ossProperties;

    public OssAutoConfiguration(OssProperties ossProperties) {
        this.ossProperties = ossProperties;
    }

    @Bean
    public OSS oss() {
        return new OSSClientBuilder()
                .build(ossProperties.getEndpoint(), ossProperties.getAccessKeyId(), ossProperties.getAccessKeySecret());
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        check();
    }

    private void check() {
        Assert.notNull(ossProperties, "[ossProperties] can not be null.");
        Assert.hasLength(ossProperties.getEndpoint(), "[endpoint] can not be empty.");
        Assert.hasLength(ossProperties.getAccessKeyId(), "[accessKeyId] can not be empty.");
        Assert.hasLength(ossProperties.getAccessKeySecret(), "[accessKeySecret] can not be empty.");
    }

}
