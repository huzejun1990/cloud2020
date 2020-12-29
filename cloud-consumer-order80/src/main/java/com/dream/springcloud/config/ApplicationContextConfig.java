package com.dream.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Created by huzejun
 * on 2020/5/13 15:34
 */
@Configuration
public class ApplicationContextConfig {

    @Bean
//    @LoadBalanced//开启负载均衡?
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}