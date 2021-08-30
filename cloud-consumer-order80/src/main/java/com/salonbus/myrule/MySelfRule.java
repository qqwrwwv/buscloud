package com.salonbus.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName myrule
 * @Description 呆神出品，必属精品～
 * @Author 一条大菜狗
 * @Date 2021/8/21 10:01 上午
 * @Version 1.0
 */
@Configuration
public class MySelfRule {
    @Bean
    public IRule getIRule(){
        return new RandomRule();
    }
}
