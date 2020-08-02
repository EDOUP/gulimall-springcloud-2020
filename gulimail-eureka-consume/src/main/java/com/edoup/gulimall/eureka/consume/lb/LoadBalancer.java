package com.edoup.gulimall.eureka.consume.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * <p></p>
 *
 * @author edoup
 * @date 2020/8/2 14:14
 */
public interface LoadBalancer {

    ServiceInstance instances(List<ServiceInstance> serviceInstanceList);



}
