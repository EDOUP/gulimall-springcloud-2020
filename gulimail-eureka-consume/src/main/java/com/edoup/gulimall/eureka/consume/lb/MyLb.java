package com.edoup.gulimall.eureka.consume.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * <p></p>
 *
 * @author edoup
 * @date 2020/8/2 14:16
 */
@Component
public class MyLb implements LoadBalancer {

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    @Override
    public ServiceInstance instances(List<ServiceInstance> serviceInstanceList) {
        int index = atomicInteger.incrementAndGet() % serviceInstanceList.size();
        return serviceInstanceList.get(index);
    }

}
