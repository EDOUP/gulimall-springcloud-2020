package com.edoup.gulimall.eureka.playment.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p></p>
 *
 * @author edoup
 * @date 2020/7/27 23:11
 */
@RestController
@RequestMapping("/eureka/play")
public class PlayController {

    @Value("${server.port}")
    private String port;

    @Resource
    private DiscoveryClient discoveryClient;

    @GetMapping("/test")
    public String test(String id){
        return "success,port:" +port + "  id:" + id;
    }

    @GetMapping("/discovery")
    public Object discovery(){
        List<String> allKnownRegions = discoveryClient.getServices();
        System.out.println("------service ------------");
        allKnownRegions.forEach(System.out::println);
        System.out.println("------service ------------");
        List<ServiceInstance> instanceList = discoveryClient.getInstances("GULIMAIL-EUREKA-CONSUME");
        for (ServiceInstance instance : instanceList) {
            System.out.println(instance.getServiceId() +"\t"+ instance.getHost() +"\t"+  instance.getHost() + "\t"+ instance.getUri());
        }
        System.out.println("------discovery end ------------");
        return allKnownRegions;
    }
}
