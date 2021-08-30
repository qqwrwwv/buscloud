package com.salonbus.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @ClassName PaymentMain8004
 * @Description 呆神出品，必属精品～
 * @Author 一条大菜狗
 * @Date 2021/8/18 8:45 上午
 * @Version 1.0
 */
/**
 * 该注解用于向使用consul或者zookeeper作为注册中心时注册服务
 */
@EnableDiscoveryClient
@SpringBootApplication
public class PaymentMain8004 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8004.class,args);
    }
}

