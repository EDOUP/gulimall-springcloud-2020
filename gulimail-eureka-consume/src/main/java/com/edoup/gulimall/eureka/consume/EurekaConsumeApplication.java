package com.edoup.gulimall.eureka.consume;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * <p></p>
 *
 * @author edoup
 * @date 2020/7/27 23:09
 */
@SpringBootApplication
@EnableEurekaClient
public class EurekaConsumeApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaConsumeApplication.class);
    }
}
