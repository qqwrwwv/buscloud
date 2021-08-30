package com.salonbus.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @ClassName OderZkMain80
 * @Description 呆神出品，必属精品～
 * @Author 一条大菜狗
 * @Date 2021/8/18 10:48 上午
 * @Version 1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
public class OderZkMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OderZkMain80.class,args);
    }
}
