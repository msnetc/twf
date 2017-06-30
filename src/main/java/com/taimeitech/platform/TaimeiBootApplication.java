package com.taimeitech.platform;

import com.taimeitech.framework.common.RestExceptionHandler;
import com.taimeitech.framework.common.TaimeiRestTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

//TaimeiBootApplication类名需要根据项目修改
@EnableCircuitBreaker
@EnableDiscoveryClient
@SpringBootApplication
@MapperScan("com.taimeitech.platform.dao")
@Import(RestExceptionHandler.class)
public class TaimeiBootApplication  extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(TaimeiBootApplication.class, args);
    }
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(TaimeiBootApplication.class);
    }
    //定义RestTemplate实例并开启负载均衡
    @Bean
    @LoadBalanced
    TaimeiRestTemplate restTemplate() {
        return new TaimeiRestTemplate();
    }
}
