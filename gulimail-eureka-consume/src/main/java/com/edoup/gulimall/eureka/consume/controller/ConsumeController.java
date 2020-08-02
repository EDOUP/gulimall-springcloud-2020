package com.edoup.gulimall.eureka.consume.controller;


import com.edoup.gulimall.eureka.consume.lb.LoadBalancer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

/**
 * <p></p>
 *
 * @author edoup
 * @date 2020/7/27 23:11
 */
@RestController
@RequestMapping("/eureka/consume")
public class ConsumeController {

    public static final String PLAYMENT_SERVICE_NAME = "GULIMAIL-EUREKA-PAYMENT";
    public static final String CONSUME_SERVICE_NAME = "GULIMAIL-EUREKA-CONSUME";

    @GetMapping("/test")

    public String test(String id) {
        return "success:" + id;
    }

    @Bean
    //@LoadBalanced
    private RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private DiscoveryClient discoveryClient;

    @Autowired
    private LoadBalancer loadBalancer;

    @GetMapping("/play")
    public String consumer(String id) {
        ResponseEntity<String> entity = restTemplate.getForEntity("http://GULIMAIL-EUREKA-PAYMENT/eureka/play/test?id=" + id, String.class);
        if (entity.getStatusCode().is2xxSuccessful()) {
            return entity.getBody();
        } else {
            return "fail";
        }
    }

    @GetMapping("/mylbtest")
    public String lbTest() {
        List<ServiceInstance> serviceInstanceList = discoveryClient.getInstances(PLAYMENT_SERVICE_NAME);
        if (CollectionUtils.isEmpty(serviceInstanceList) || serviceInstanceList.size() <= 0) {
            return null;
        }
        ServiceInstance instances = loadBalancer.instances(serviceInstanceList);
        URI uri = instances.getUri();
        return restTemplate.getForObject(uri + "/eureka/play/test?id=1", String.class);
    }
}
