package com.edoup.gulimall.eureka.consume.controller;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * <p></p>
 *
 * @author edoup
 * @date 2020/7/27 23:11
 */
@RestController
@RequestMapping("/eureka/consume")
public class ConsumeController {

    @GetMapping("/test")
    public String test(String id) {
        return "success:" + id;
    }

    @Bean
    @LoadBalanced
    private RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/play")
    public String consumer(String id) {
        return restTemplate.getForObject("http://GULIMAIL-EUREKA-PAYMENT/eureka/play/test?id=" + id, String.class);
    }
}
