package com.edoup.gulimall.eureka.rule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <p></p>
 *
 * @author edoup
 * @date 2020/8/2 13:08
 */
@Configuration
public class MyRibbonRule {

    @Bean
    public IRule myRule(){
        return new RandomRule();
    }
}
