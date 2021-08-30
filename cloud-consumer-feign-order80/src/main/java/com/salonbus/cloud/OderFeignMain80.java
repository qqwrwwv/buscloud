package com.salonbus.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @ClassName OderFeignMain80
 * @Description 呆神出品，必属精品～
 * @Author 一条大菜狗
 * @Date 2021/8/23 7:50 下午
 * @Version 1.0
 */
@SpringBootApplication
@EnableFeignClients
public class OderFeignMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OderFeignMain80.class,args);
    }
}
