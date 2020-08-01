package com.edoup.gulimall.member;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 开启nacos注册 与fenign远程调用
 */
//开启nacos注册
@EnableDiscoveryClient
//开启远程调用fenign
@EnableFeignClients(basePackages = "com.edoup.gulimall.member.feign")
@SpringBootApplication
public class GuliMallMemberApplication {

    public static void main(String[] args) {
        SpringApplication.run(GuliMallMemberApplication.class, args);
    }

}
